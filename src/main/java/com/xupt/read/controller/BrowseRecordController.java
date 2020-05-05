package com.xupt.read.controller;

import com.xupt.read.common.result.JsonResult;
import com.xupt.read.common.result.PageResult;
import com.xupt.read.controller.req.BrowseRecordReq;
import com.xupt.read.controller.resp.BrowseRecordResp;
import com.xupt.read.model.Book;
import com.xupt.read.model.BrowseRecord;
import com.xupt.read.service.BookService;
import com.xupt.read.service.BrowseRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户浏览记录相关接口
 */
@RestController
@RequestMapping(value = "/browse_records")
@Slf4j
public class BrowseRecordController {

    @Autowired
    private BrowseRecordService browseRecordService;

    @Autowired
    private BookService bookService;

    /**
     * 添加浏览记录
     */
    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addBrowseRecord(@RequestBody @Valid BrowseRecordReq browseRecordReq) {

        Integer result = browseRecordService.addBrowseRecord(BrowseRecordReq.convert(browseRecordReq));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "添加浏览记录失败！");
    }

    /**
     * 获取浏览记录
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public JsonResult queryByUserId(@RequestParam(name = "user_id") Integer userId,
                                    @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                    @RequestParam(name = "page_size", defaultValue = "20") int pageSize) {

        PageResult<BrowseRecord> pageResult = browseRecordService.getByUserId(userId, (pageNum - 1) * pageSize, pageSize);

        List<Integer> bookIds = pageResult.getItems().stream().map(BrowseRecord::getBookId).collect(Collectors.toList());
        List<Book> books = bookService.getByIds(bookIds);
        List<BrowseRecordResp> browseRecordResps = pageResult.getItems().stream().map(browseRecord -> BrowseRecordResp.convert(books, browseRecord)).collect(Collectors.toList());
        PageResult<BrowseRecordResp> respPageResult = PageResult.fromPageResult(browseRecordResps, pageResult);
        return JsonResult.success(respPageResult);
    }
}
