package com.xupt.stealage.controller;

import com.google.common.collect.Lists;
import com.xupt.stealage.common.result.JsonResult;
import com.xupt.stealage.controller.req.StealageProcessContentReq;
import com.xupt.stealage.controller.resp.StealageProcessContentResp;
import com.xupt.stealage.model.StealageProcessContent;
import com.xupt.stealage.model.User;
import com.xupt.stealage.service.StealageProcessContentService;
import com.xupt.stealage.service.StealageService;
import com.xupt.stealage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 失物招领处理内容相关接口
 */
@RestController
@RequestMapping(value = "/stealage_process_content")
@Slf4j
public class StealageProcessContentController {

    @Autowired
    private StealageProcessContentService stealageProcessContentService;

    @Autowired
    private StealageService stealageService;

    @Autowired
    private UserService userService;

    /**
     * 失物招领处理内容
     * @param stealageId stealageId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public JsonResult<List<StealageProcessContentResp>> queryContents(@RequestParam(name = "stealage_id") Integer stealageId,
                                                                      @RequestParam(name = "user_id") Integer userId) {
        List<StealageProcessContent> stealageProcessContents = stealageProcessContentService.getContents(stealageId);
        int selfUserId = stealageService.getById(stealageId).getUserId();
        if (!stealageProcessContents.stream().map(StealageProcessContent::getUserId).collect(Collectors.toList()).contains(userId) && !userId.equals(selfUserId)) {
            return JsonResult.success(Lists.newArrayList());
        }
        List<Integer> userIds = stealageProcessContents.stream().map(StealageProcessContent::getUserId).distinct().collect(Collectors.toList());
        Map<Integer, User> userMap = userService.getByIds(userIds).stream().collect(Collectors.toMap(User::getId, Function.identity()));

        List<StealageProcessContentResp> stealageProcessContentRespList = stealageProcessContents.stream()
                .map(stealageProcessContent -> StealageProcessContentResp.convert(stealageProcessContent, userMap.get(stealageProcessContent.getUserId())))
                .collect(Collectors.toList());
        return JsonResult.success(stealageProcessContentRespList);
    }

    /**
     * 添加失物招领处理内容
     */
    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addStealageProcessContent(@RequestBody @Valid StealageProcessContentReq stealageProcessContentReq) {
        Integer result = stealageProcessContentService.addStealageProcessContent(StealageProcessContentReq.convert(stealageProcessContentReq));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "添加失败！");
    }
}
