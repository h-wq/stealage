package com.xupt.read.controller;

import com.xupt.read.common.result.JsonResult;
import com.xupt.read.common.result.PageResult;
import com.xupt.read.controller.req.BookReq;
import com.xupt.read.controller.resp.BookResp;
import com.xupt.read.model.Book;
import com.xupt.read.model.BookType;
import com.xupt.read.service.BookService;
import com.xupt.read.service.BookTypeService;
import com.xupt.read.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/books")
@Slf4j
public class BookController {

    @Value("${file.upload.path}")
    private String fileUploadPath;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookTypeService bookTypeService;

    @RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
    public JsonResult addBook(@Valid BookReq bookReq, @RequestParam("file") MultipartFile file) {

        // 图片上传
        String path = FileUtils.uploadFile(fileUploadPath, file);
        Integer result = bookService.addBook(BookReq.convert(bookReq, path));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "添加书失败！");
    }

    /**
     * 全部
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public JsonResult query(@RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                            @RequestParam(name = "page_size", defaultValue = "20") int pageSize) {

        PageResult<Book> pageResult = bookService.getBooks((pageNum - 1) * pageSize, pageSize);
        List<BookResp> bookResps = pageResult.getItems().stream().map(BookResp::convert).collect(Collectors.toList());
        PageResult<BookResp> respPageResult = PageResult.fromPageResult(bookResps, pageResult);
        return JsonResult.success(respPageResult);
    }

    /**
     * 首页面
     */
    @RequestMapping(value = "/type_books", method = RequestMethod.GET)
    public JsonResult query() {

        List<Book> books = bookService.getBooks();
        List<BookType> bookTypes = bookTypeService.getBookTypes();
        List<Map<String, Object>> bookMaps = bookTypes.stream().map(bookType -> {
            Map<String, Object> bookMap = new HashMap<>();
            bookMap.put("typeId", bookType.getId());
            bookMap.put("typeName", bookType.getName());
            List<Book> list = books.stream().filter(book -> bookType.getId().equals(book.getTypeId())).collect(Collectors.toList());
            bookMap.put("list", list);
            return bookMap;
        }).collect(Collectors.toList());
        return JsonResult.success(bookMaps);
    }

    /**
     * 图书列表
     * @param bookTypeId 图书类型id
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return
     */
    @RequestMapping(value = "/book_type", method = RequestMethod.GET)
    public JsonResult queryByBookTypeId(@RequestParam(name = "book_type_id") Integer bookTypeId,
                                        @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                        @RequestParam(name = "page_size", defaultValue = "20") int pageSize) {

        PageResult<Book> pageResult = bookService.getByBookTypeId(bookTypeId, (pageNum - 1) * pageSize, pageSize);
        List<BookResp> bookResps = pageResult.getItems().stream().map(BookResp::convert).collect(Collectors.toList());
        PageResult<BookResp> respPageResult = PageResult.fromPageResult(bookResps, pageResult);
        return JsonResult.success(respPageResult);
    }

    /**
     * 排行---按人气排行
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return
     */
    @RequestMapping(value = "/ranking", method = RequestMethod.GET)
    public JsonResult queryByPopularity(@RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                        @RequestParam(name = "page_size", defaultValue = "20") int pageSize) {

        PageResult<Book> pageResult = bookService.getByPopularity((pageNum - 1) * pageSize, pageSize);
        List<BookResp> bookResps = pageResult.getItems().stream().map(BookResp::convert).collect(Collectors.toList());
        PageResult<BookResp> respPageResult = PageResult.fromPageResult(bookResps, pageResult);
        return JsonResult.success(respPageResult);
    }

    /**
     * 最新图书
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return
     */
    @RequestMapping(value = "/newest", method = RequestMethod.GET)
    public JsonResult queryByNewest(@RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                    @RequestParam(name = "page_size", defaultValue = "20") int pageSize) {

        PageResult<Book> pageResult = bookService.getByNewest((pageNum - 1) * pageSize, pageSize);
        List<BookResp> bookResps = pageResult.getItems().stream().map(BookResp::convert).collect(Collectors.toList());
        PageResult<BookResp> respPageResult = PageResult.fromPageResult(bookResps, pageResult);
        return JsonResult.success(respPageResult);
    }

    /**
     * 完结图书
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return
     */
    @RequestMapping(value = "/end", method = RequestMethod.GET)
    public JsonResult queryByEnd(@RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                 @RequestParam(name = "page_size", defaultValue = "20") int pageSize) {

        PageResult<Book> pageResult = bookService.getByEnd((pageNum - 1) * pageSize, pageSize);
        List<BookResp> bookResps = pageResult.getItems().stream().map(BookResp::convert).collect(Collectors.toList());
        PageResult<BookResp> respPageResult = PageResult.fromPageResult(bookResps, pageResult);
        return JsonResult.success(respPageResult);
    }
}
