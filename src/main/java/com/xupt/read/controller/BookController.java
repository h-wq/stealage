package com.xupt.read.controller;

import com.google.common.collect.Lists;
import com.xupt.read.common.result.JsonResult;
import com.xupt.read.common.result.PageResult;
import com.xupt.read.controller.req.BookReq;
import com.xupt.read.controller.resp.BookInfoResp;
import com.xupt.read.controller.resp.BookResp;
import com.xupt.read.model.Book;
import com.xupt.read.model.BookType;
import com.xupt.read.service.BookService;
import com.xupt.read.service.BookTypeService;
import com.xupt.read.service.EvaluateService;
import com.xupt.read.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 图书相关接口
 */
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

    @Autowired
    private SearchController searchController;

    /**
     * 添加图书
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
    public JsonResult addBook(@Valid BookReq bookReq, @RequestParam("file") MultipartFile file) {

        // 图片上传
        String path = FileUtils.uploadFile(fileUploadPath, file);
        Integer result = bookService.addBook(BookReq.convert(bookReq, path));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "添加书失败！");
    }

    /**
     * 根据书名和作者搜索
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public JsonResult query(@RequestParam(name = "name") String name,
                            @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                            @RequestParam(name = "page_size", defaultValue = "20") int pageSize) {
        PageResult<Book> pageResult = bookService.getByName(name, (pageNum - 1) * pageSize, pageSize);
        JsonResult<PageResult<BookResp>> jsonResult = query(pageResult);
        return CollectionUtils.isEmpty(jsonResult.getData().getItems()) ? searchController.getBooks(name) : jsonResult;
    }

    /**
     * 根据书名批量搜索
     * @return
     */
    @RequestMapping(value = "/search/batch", method = RequestMethod.GET)
    public JsonResult<List<List<BookResp>>> query(@RequestParam(name = "names") String names,
                                            @RequestParam(name = "split") int split) {
        List<String> queryNames = Arrays.asList(names.split(","));
        List<Book> books = bookService.getByNames(queryNames);
        List<Integer> bookTypeIds = books.stream().map(Book::getTypeId).distinct().collect(Collectors.toList());
        List<BookType> bookTypes = bookTypeService.getByIds(bookTypeIds);
        List<BookResp> bookRespList = books.stream()
                .map(book -> BookResp.convert(book, bookTypes))
                .collect(Collectors.toList());
        return JsonResult.success(Lists.partition(bookRespList, split));
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
        return query(pageResult);
    }

    /**
     * 首页面
     */
    @RequestMapping(value = "/type_books", method = RequestMethod.GET)
    public JsonResult query() {
        List<BookType> bookTypes = bookTypeService.getBookTypes();
        List<Map<String, Object>> bookMaps = bookTypes.stream().map(bookType -> {
            Map<String, Object> bookMap = new HashMap<>();
            bookMap.put("typeId", bookType.getId());
            bookMap.put("typeName", bookType.getName());
            List<Book> list = bookService.getByBookTypeId(bookType.getId(), 0, 20).getItems();
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
        return query(pageResult);
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
        return query(pageResult);
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
        return query(pageResult);
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
        return query(pageResult);
    }

    /**
     * 详情
     * @return
     */
    @RequestMapping(value = "/{id}/get_info", method = RequestMethod.GET)
    public JsonResult getBookInfo(@PathVariable Integer id) {

        Book book = bookService.getById(id);
        if (book == null) {
            return JsonResult.fail(-1, "获取书详情失败，无对应" + id + "的书");
        }
        BookType bookType = bookTypeService.getById(book.getTypeId());
        return JsonResult.success(BookInfoResp.convert(book, bookType));
    }

    private JsonResult query(PageResult<Book> pageResult) {
        List<Integer> bookTypeIds = pageResult.getItems().stream().map(Book::getTypeId).distinct().collect(Collectors.toList());
        List<BookType> bookTypes = bookTypeService.getByIds(bookTypeIds);

        List<BookResp> bookResps = pageResult.getItems().stream().map(book -> BookResp.convert(book, bookTypes)).collect(Collectors.toList());
        PageResult<BookResp> respPageResult = PageResult.fromPageResult(bookResps, pageResult);
        return JsonResult.success(respPageResult);
    }
}
