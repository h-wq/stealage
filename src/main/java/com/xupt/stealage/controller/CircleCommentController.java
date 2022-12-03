package com.xupt.stealage.controller;

import com.xupt.stealage.common.result.JsonResult;
import com.xupt.stealage.controller.req.CircleCommentReq;
import com.xupt.stealage.service.CircleCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 朋友圈评论相关接口
 */
@RestController
@RequestMapping(value = "/circle_comments")
@Slf4j
public class CircleCommentController {

    @Autowired
    private CircleCommentService circleCommentService;

    /**
     * 发表评论
     */
    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addCircleComment(@RequestBody @Valid CircleCommentReq circleCommentReq) {
        Integer result = circleCommentService.addCircleComment(CircleCommentReq.convert(circleCommentReq));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "发表评论失败！");
    }

    /**
     * 删除评论
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public JsonResult deleteCircleComment(@PathVariable Integer id) {
        Integer result = circleCommentService.deleteCircleComment(id);
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "删除评论失败！");
    }
}
