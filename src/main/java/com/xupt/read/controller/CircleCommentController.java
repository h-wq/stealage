package com.xupt.read.controller;

import com.xupt.read.common.result.JsonResult;
import com.xupt.read.controller.req.CircleCommentReq;
import com.xupt.read.service.CircleCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/circle_comments")
@Slf4j
public class CircleCommentController {

    @Autowired
    private CircleCommentService circleCommentService;

    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addCircleComment(@RequestBody @Valid CircleCommentReq circleCommentReq) {

        Integer result = circleCommentService.addCircleComment(CircleCommentReq.convert(circleCommentReq));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "发表评论失败！");
    }
}
