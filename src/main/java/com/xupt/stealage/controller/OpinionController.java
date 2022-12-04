package com.xupt.stealage.controller;

import com.xupt.stealage.common.result.JsonResult;
import com.xupt.stealage.common.result.PageResult;
import com.xupt.stealage.controller.req.OpinionReq;
import com.xupt.stealage.controller.resp.OpinionResp;
import com.xupt.stealage.model.Opinion;
import com.xupt.stealage.model.User;
import com.xupt.stealage.service.OpinionService;
import com.xupt.stealage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 意见反馈相关接口
 */
@RestController
@RequestMapping(value = "/opinions")
@Slf4j
public class OpinionController {

    @Autowired
    private OpinionService opinionService;

    @Autowired
    private UserService userService;

    /**
     * 意见反馈
     */
    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addOpinion(@RequestBody @Valid OpinionReq opinionReq) {
        Integer result = opinionService.addOpinion(OpinionReq.convert(opinionReq));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "意见反馈失败！");
    }

    /**
     * 查询意见反馈
     */
    @RequestMapping(method = RequestMethod.GET)
    public JsonResult query(@RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                            @RequestParam(name = "page_size", defaultValue = "2147483647") int pageSize) {
        PageResult<Opinion> pageResult = opinionService.getOpinions((pageNum - 1) * pageSize, pageSize);
        List<Integer> userIds = pageResult.getItems().stream().map(Opinion::getUserId).collect(Collectors.toList());
        List<User> users = userService.getByIds(userIds);
        List<OpinionResp> opinionResps = pageResult.getItems().stream().map(opinion -> OpinionResp.convert(users, opinion)).collect(Collectors.toList());
        PageResult<OpinionResp> respPageResult = PageResult.fromPageResult(opinionResps, pageResult);
        return JsonResult.success(respPageResult);
    }
}
