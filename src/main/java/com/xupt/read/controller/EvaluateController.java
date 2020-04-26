package com.xupt.read.controller;

import com.xupt.read.common.result.JsonResult;
import com.xupt.read.common.result.PageResult;
import com.xupt.read.controller.req.EvaluateReq;
import com.xupt.read.controller.resp.EvaluateResp;
import com.xupt.read.model.Book;
import com.xupt.read.model.Evaluate;
import com.xupt.read.model.User;
import com.xupt.read.service.BookService;
import com.xupt.read.service.EvaluateService;
import com.xupt.read.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/evaluates")
@Slf4j
public class EvaluateController {

    @Autowired
    private EvaluateService evaluateService;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addEvaluate(@RequestBody @Valid EvaluateReq evaluateReq) {

        Integer result = evaluateService.addEvaluate(EvaluateReq.convert(evaluateReq));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "评论失败！");
    }

    @RequestMapping(method = RequestMethod.GET)
    public JsonResult queryByBookId(@RequestParam(name = "book_id") Integer bookId,
                                    @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                    @RequestParam(name = "page_size", defaultValue = "20") int pageSize) {

        PageResult<Evaluate> pageResult = evaluateService.getByBookId(bookId, (pageNum - 1) * pageSize, pageSize);
        List<Integer> userIds = pageResult.getItems().stream().map(Evaluate::getUserId).collect(Collectors.toList());
        List<User> users = userService.getByIds(userIds);
        List<EvaluateResp> evaluateResps = pageResult.getItems().stream().map(evaluate -> EvaluateResp.convert(users, evaluate)).collect(Collectors.toList());
        PageResult<EvaluateResp> respPageResult = PageResult.fromPageResult(evaluateResps, pageResult);
        return JsonResult.success(respPageResult);
    }
}
