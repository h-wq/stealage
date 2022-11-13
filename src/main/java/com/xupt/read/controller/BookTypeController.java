package com.xupt.read.controller;

import com.xupt.read.common.result.JsonResult;
import com.xupt.read.controller.resp.BookTypeResp;
import com.xupt.read.service.BookTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 书类型相关接口
 */
@RestController
@RequestMapping(value = "/book_types")
@Slf4j
public class BookTypeController {

    @Autowired
    private BookTypeService bookTypeService;

    /**
     * 添加书类型
     * @param name name
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addBookType(@RequestParam(name = "name") String name) {
        Integer result = bookTypeService.addBookType(name);
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "添加类型失败！");
    }

    /**
     * 获取所有书类型
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public JsonResult query() {
        List<BookTypeResp> bookTypeResps = bookTypeService.getBookTypes().stream().map(BookTypeResp::convert).collect(Collectors.toList());
        return JsonResult.success(bookTypeResps);
    }
}
