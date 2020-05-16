package com.xupt.read.controller;

import com.xupt.read.common.result.JsonResult;
import com.xupt.read.controller.req.CircleLikeReq;
import com.xupt.read.service.LikesService;
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
public class LikesController {

    @Autowired
    private LikesService likesService;

    /**
     * 点赞
     */
    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addCircleLike(@RequestBody @Valid CircleLikeReq circleLikeReq) {

        Integer result = likesService.addCircleLike(CircleLikeReq.convert(circleLikeReq));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "点赞失败！");
    }

    /**
     * 删除点赞
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public JsonResult deleteCircleLike(@PathVariable Integer id) {

        Integer result = likesService.deleteCircleLike(id);
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "删除点赞失败！");
    }
}
