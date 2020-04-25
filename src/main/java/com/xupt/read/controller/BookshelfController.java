package com.xupt.read.controller;

import com.xupt.read.common.result.JsonResult;
import com.xupt.read.common.result.PageResult;
import com.xupt.read.controller.req.BookshelfReq;
import com.xupt.read.controller.resp.BookResp;
import com.xupt.read.model.Book;
import com.xupt.read.model.Bookshelf;
import com.xupt.read.model.Note;
import com.xupt.read.service.BookService;
import com.xupt.read.service.BookshelfService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookshelves")
@Slf4j
public class BookshelfController {

    @Autowired
    private BookshelfService bookshelfService;

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addBookshelf(@RequestBody @Valid BookshelfReq bookshelfReq) {

        Integer result = bookshelfService.addBookshelf(BookshelfReq.convert(bookshelfReq));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "添加书架失败！");
    }

    @RequestMapping(method = RequestMethod.GET)
    public JsonResult query(@RequestParam(name = "user_id") Integer userId,
                            @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                            @RequestParam(name = "page_size", defaultValue = "20") int pageSize) {

        PageResult<Bookshelf> pageResult = bookshelfService.getByUserId(userId, (pageNum - 1) * pageSize, pageSize);
        List<Integer> bookIds = pageResult.getItems().stream().map(Bookshelf::getBookId).collect(Collectors.toList());
        List<Book> books = bookService.getByIds(bookIds);
        List<BookResp> bookResps = pageResult.getItems().stream().map(bookshelf -> BookResp.convert(books, bookshelf)).collect(Collectors.toList());
        PageResult<BookResp> respPageResult = PageResult.fromPageResult(bookResps, pageResult);
        return JsonResult.success(respPageResult);
    }

    @RequestMapping(value = "/{id}/notes", method = RequestMethod.GET)
    public JsonResult queryNotes(@PathVariable("id") Integer id) {

        List<String> notes = bookshelfService.getNotes(id).stream().map(Note::getNote).collect(Collectors.toList());
        return JsonResult.success(notes);
    }
}
