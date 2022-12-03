package com.xupt.stealage.controller;

import com.xupt.stealage.common.result.JsonResult;
import com.xupt.stealage.controller.req.CircleLikeReq;
import com.xupt.stealage.service.CircleLikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 朋友圈点赞相关接口
 */
@RestController
@RequestMapping(value = "/circle_likes")
@Slf4j
public class CircleLikeController {

    @Autowired
    private CircleLikeService circleLikeService;

    /**
     * 点赞
     */
    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addCircleLike(@RequestBody @Valid CircleLikeReq circleLikeReq) {
        Integer result = circleLikeService.addCircleLike(CircleLikeReq.convert(circleLikeReq));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "点赞失败！");
    }

    /**
     * 删除点赞
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public JsonResult deleteCircleLike(@PathVariable Integer id) {
        Integer result = circleLikeService.deleteCircleLike(id);
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "删除点赞失败！");
    }
}
