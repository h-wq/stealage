package com.xupt.read.controller;

import com.xupt.read.common.result.JsonResult;
import com.xupt.read.common.result.PageResult;
import com.xupt.read.controller.req.BookReq;
import com.xupt.read.controller.resp.BookResp;
import com.xupt.read.model.Book;
import com.xupt.read.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/books")
@Slf4j
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addBook(@RequestBody @Valid BookReq bookReq) {

        //todo 图片上传
        Integer result = bookService.addBook(BookReq.convert(bookReq));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "添加书失败！");
    }

    @RequestMapping(method = RequestMethod.GET)
    public JsonResult query(@RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                            @RequestParam(name = "page_size", defaultValue = "20") int pageSize) {

        PageResult<Book> pageResult = bookService.getBooks((pageNum - 1) * pageSize, pageSize);
        List<BookResp> bookResps = pageResult.getItems().stream().map(BookResp::convert).collect(Collectors.toList());
        PageResult<BookResp> respPageResult = PageResult.fromPageResult(bookResps, pageResult);
        return JsonResult.success(respPageResult);
    }

    @RequestMapping(name = "/book_type", method = RequestMethod.GET)
    public JsonResult queryByBookTypeId(@RequestParam(name = "book_type_id") Integer bookTypeId,
                                        @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                        @RequestParam(name = "page_size", defaultValue = "20") int pageSize) {

        PageResult<Book> pageResult = bookService.getByBookTypeId(bookTypeId, (pageNum - 1) * pageSize, pageSize);
        List<BookResp> bookResps = pageResult.getItems().stream().map(BookResp::convert).collect(Collectors.toList());
        PageResult<BookResp> respPageResult = PageResult.fromPageResult(bookResps, pageResult);
        return JsonResult.success(respPageResult);
    }

    @RequestMapping(name = "/ranking", method = RequestMethod.GET)
    public JsonResult queryByPopularity(@RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                        @RequestParam(name = "page_size", defaultValue = "20") int pageSize) {

        PageResult<Book> pageResult = bookService.getByPopularity((pageNum - 1) * pageSize, pageSize);
        List<BookResp> bookResps = pageResult.getItems().stream().map(BookResp::convert).collect(Collectors.toList());
        PageResult<BookResp> respPageResult = PageResult.fromPageResult(bookResps, pageResult);
        return JsonResult.success(respPageResult);
    }

    @RequestMapping(name = "/newest", method = RequestMethod.GET)
    public JsonResult queryByNewest(@RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                    @RequestParam(name = "page_size", defaultValue = "20") int pageSize) {

        PageResult<Book> pageResult = bookService.getByNewest((pageNum - 1) * pageSize, pageSize);
        List<BookResp> bookResps = pageResult.getItems().stream().map(BookResp::convert).collect(Collectors.toList());
        PageResult<BookResp> respPageResult = PageResult.fromPageResult(bookResps, pageResult);
        return JsonResult.success(respPageResult);
    }

    @RequestMapping(name = "/end", method = RequestMethod.GET)
    public JsonResult queryByEnd(@RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                 @RequestParam(name = "page_size", defaultValue = "20") int pageSize) {

        PageResult<Book> pageResult = bookService.getByEnd((pageNum - 1) * pageSize, pageSize);
        List<BookResp> bookResps = pageResult.getItems().stream().map(BookResp::convert).collect(Collectors.toList());
        PageResult<BookResp> respPageResult = PageResult.fromPageResult(bookResps, pageResult);
        return JsonResult.success(respPageResult);
    }
}
