package com.xupt.read.controller;

import com.xupt.read.common.result.JsonResult;
import com.xupt.read.common.result.PageResult;
import com.xupt.read.controller.req.BookshelfReq;
import com.xupt.read.controller.resp.BookResp;
import com.xupt.read.model.Book;
import com.xupt.read.model.BookType;
import com.xupt.read.model.Bookshelf;
import com.xupt.read.model.Note;
import com.xupt.read.service.BookService;
import com.xupt.read.service.BookTypeService;
import com.xupt.read.service.BookshelfService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 书架相关接口
 */
@RestController
@RequestMapping(value = "/bookshelves")
@Slf4j
public class BookshelfController {

    @Autowired
    private BookshelfService bookshelfService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookTypeService bookTypeService;

    /**
     * 加入书架
     * @param bookshelfReq bookshelfReq
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addBookshelf(@RequestBody @Valid BookshelfReq bookshelfReq) {

        Integer result = bookshelfService.addBookshelf(BookshelfReq.convert(bookshelfReq));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "添加书架失败！");
    }

    /**
     * 获取我的书架
     * @param userId userId
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public JsonResult query(@RequestParam(name = "user_id") Integer userId,
                            @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                            @RequestParam(name = "page_size", defaultValue = "20") int pageSize) {

        PageResult<Bookshelf> pageResult = bookshelfService.getByUserId(userId, (pageNum - 1) * pageSize, pageSize);
        List<Integer> bookIds = pageResult.getItems().stream().map(Bookshelf::getBookId).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(bookIds)) {
            return JsonResult.success(new PageResult<>());
        }
        List<Book> books = bookService.getByIds(bookIds);
        List<Integer> bookTypeIds = books.stream().map(Book::getTypeId).distinct().collect(Collectors.toList());
        List<BookType> bookTypes = bookTypeService.getByIds(bookTypeIds);

        List<BookResp> bookResps = pageResult.getItems().stream().map(bookshelf -> BookResp.convert(books, bookshelf, bookTypes)).collect(Collectors.toList());
        PageResult<BookResp> respPageResult = PageResult.fromPageResult(bookResps, pageResult);
        return JsonResult.success(respPageResult);
    }

    /**
     * 获取笔记
     * @param bookshelf_id bookshelf_id
     * @return
     */
    @RequestMapping(value = "/{bookshelf_id}/notes", method = RequestMethod.GET)
    public JsonResult queryNotes(@PathVariable("bookshelf_id") Integer bookshelf_id) {

        List<String> notes = bookshelfService.getNotes(bookshelf_id).stream().map(Note::getNote).collect(Collectors.toList());
        return JsonResult.success(notes);
    }
}
