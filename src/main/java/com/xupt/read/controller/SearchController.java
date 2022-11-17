package com.xupt.read.controller;

import com.xupt.read.common.result.JsonResult;
import com.xupt.read.common.result.PageResult;
import com.xupt.read.controller.resp.BookResp;
import com.xupt.read.pageCapture.CapturePage;
import com.xupt.read.parseManger.BookInfo;
import com.xupt.read.service.BookTypeService;
import com.xupt.read.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 搜索相关接口
 */
@RestController
@RequestMapping(value = "/search")
@Slf4j
public class SearchController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private BookTypeService bookTypeService;

    private ExecutorService executorService = Executors.newFixedThreadPool(4);

    private ExecutorCompletionService<BookInfo> completionService = new ExecutorCompletionService<>(executorService);

    /**
     * 根据书名或者作者名搜索图书
     */
    @RequestMapping(value = "getBooks",method = RequestMethod.GET)
    public JsonResult getBooks(@RequestParam(name = "name") String name,
                               @RequestParam(name = "book_type") String bookType) {
        Integer typeId = bookTypeService.isHasBookType(bookType);
        if (typeId == null) {
            return JsonResult.fail(400, String.format("book_type %s does not exit.", bookType));
        }

        PageResult<BookResp> pageResult = new PageResult<>();
        try {
            String url = "https://www.douban.com/search?cat=1001&q=" + URLEncoder.encode(name, "utf-8");
            //获取页面
            String html = CapturePage.getHtml(url);

            //根据按book name搜索获取的html解析书籍url和picture
            //只获取第一个书, 默认是最好的一个
            List<String> urls = searchService.parseUrlBookName(html, name);

//            urls.forEach(bookUrl -> completionService.submit(() -> searchService.getBookInfo(bookUrl, name, bookType)));
//            List<BookResp> bookResps = new ArrayList<>(urls.size());
//            for (int i = 0; i < urls.size(); i++) {
//                try{
//                    BookInfo bookInfo = completionService.take().get();
//                    if (bookInfo != null) {
//                        bookResps.add(BookResp.convert(bookInfo));
//                    }
//                } catch (Exception e) {
//                    log.error("getBookInfo error is ", e);
//                }
//            }
            List<BookResp> bookResps = new ArrayList<>(1);
            for (String bookUrl : urls) {
                BookInfo bookInfo;
                try {
                    bookInfo = searchService.getBookInfo(bookUrl, name, bookType);
                } catch (Exception e) {
                    log.error("getBookInfo error is ", e);
                    bookInfo = null;
                }

                if (bookInfo != null) {
                    bookResps.add(BookResp.convert(bookInfo));
                    break;
                }
            }
            pageResult.setItems(bookResps);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.success(pageResult);
    }
}
