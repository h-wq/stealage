//package com.xupt.stealage.controller;
//
//import com.xupt.stealage.common.result.JsonResult;
//import com.xupt.stealage.common.result.PageResult;
//import com.xupt.stealage.controller.req.BookshelfReq;
//import com.xupt.stealage.controller.resp.BookResp;
//import com.xupt.stealage.service.BookService;
//import com.xupt.stealage.service.BookTypeService;
//import com.xupt.stealage.service.BookshelfService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.CollectionUtils;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * 书架相关接口
// */
//@RestController
//@RequestMapping(value = "/bookshelves")
//@Slf4j
//public class BookshelfController {
//
//    @Autowired
//    private BookshelfService bookshelfService;
//
//    @Autowired
//    private BookService bookService;
//
//    @Autowired
//    private BookTypeService bookTypeService;
//
//    /**
//     * 加入书架
//     * @param bookshelfReq bookshelfReq
//     * @return
//     */
//    @RequestMapping(method = RequestMethod.POST)
//    public JsonResult addBookshelf(@RequestBody @Valid BookshelfReq bookshelfReq) {
//
//        Integer result = bookshelfService.addBookshelf(BookshelfReq.convert(bookshelfReq));
//        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "添加书架失败！");
//    }
//
//    /**
//     * 获取我的书架
//     * @param userId userId
//     * @param pageNum pageNum
//     * @param pageSize pageSize
//     * @return
//     */
//    @RequestMapping(method = RequestMethod.GET)
//    public JsonResult query(@RequestParam(name = "user_id") Integer userId,
//                            @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
//                            @RequestParam(name = "page_size", defaultValue = "20") int pageSize) {
//
//        PageResult<Bookshelf> pageResult = bookshelfService.getByUserId(userId, (pageNum - 1) * pageSize, pageSize);
//        List<Integer> bookIds = pageResult.getItems().stream().map(Bookshelf::getBookId).collect(Collectors.toList());
//        if (CollectionUtils.isEmpty(bookIds)) {
//            return JsonResult.success(new PageResult<>());
//        }
//        List<Book> books = bookService.getByIds(bookIds);
//        List<Integer> bookTypeIds = books.stream().map(Book::getTypeId).distinct().collect(Collectors.toList());
//        List<BookType> bookTypes = bookTypeService.getByIds(bookTypeIds);
//
//        List<BookResp> bookResps = pageResult.getItems().stream().map(bookshelf -> BookResp.convert(books, bookshelf, bookTypes)).collect(Collectors.toList());
//        PageResult<BookResp> respPageResult = PageResult.fromPageResult(bookResps, pageResult);
//        return JsonResult.success(respPageResult);
//    }
//
//    /**
//     * 删除书架
//     */
//    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
//    public JsonResult deleteBookshelf(@PathVariable Integer id) {
//
//        Integer result = bookshelfService.deleteBookshelf(id);
//        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "删除书架失败！");
//    }
//
//    /**
//     * 是否加入书架
//     */
//    @RequestMapping(value = "/{book_id}/is_have", method = RequestMethod.GET)
//    public JsonResult deleteBookshelf(@PathVariable Integer book_id, @RequestParam(name = "user_id") Integer userId) {
//        userId = 1;
//        Boolean isHave = bookshelfService.isHave(book_id, userId);
//        return JsonResult.success(isHave);
//    }
//
//    /**
//     * 获取笔记
//     * @param bookshelf_id bookshelf_id
//     * @return
//     */
//    @RequestMapping(value = "/{bookshelf_id}/notes", method = RequestMethod.GET)
//    public JsonResult queryNotes(@PathVariable("bookshelf_id") Integer bookshelf_id) {
//
//        List<String> notes = bookshelfService.getNotes(bookshelf_id).stream().map(Note::getNote).collect(Collectors.toList());
//        return JsonResult.success(notes);
//    }
//}
