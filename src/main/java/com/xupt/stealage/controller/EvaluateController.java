package com.xupt.stealage.controller;

import com.xupt.stealage.common.result.JsonResult;
import com.xupt.stealage.common.result.PageResult;
import com.xupt.stealage.controller.req.EvaluateReq;
import com.xupt.stealage.controller.resp.EvaluateResp;
import com.xupt.stealage.model.Evaluate;
import com.xupt.stealage.model.User;
import com.xupt.stealage.service.EvaluateService;
import com.xupt.stealage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 失物招领评论相关接口
 */
@RestController
@RequestMapping(value = "/evaluates")
@Slf4j
public class EvaluateController {

    @Autowired
    private EvaluateService evaluateService;

    @Autowired
    private UserService userService;

    /**
     * 发表评论
     */
    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addEvaluate(@RequestBody @Valid EvaluateReq evaluateReq) {
        Integer result = evaluateService.addEvaluate(EvaluateReq.convert(evaluateReq));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "评论失败！");
    }

    /**
     * 获评论
     */
    @RequestMapping(method = RequestMethod.GET)
    public JsonResult queryByStealage(@RequestParam(name = "stealage_id") Integer stealageId,
                                      @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                      @RequestParam(name = "page_size", defaultValue = "2147483647") int pageSize) {

        PageResult<Evaluate> pageResult = evaluateService.getByStealageId(stealageId, (pageNum - 1) * pageSize, pageSize);
        if (CollectionUtils.isEmpty(pageResult.getItems())) {
            return JsonResult.success();
        }
        List<Integer> userIds = pageResult.getItems().stream().map(Evaluate::getUserId).collect(Collectors.toList());
        List<User> users = userService.getByIds(userIds);
        List<EvaluateResp> evaluateResps = pageResult.getItems().stream().map(evaluate -> EvaluateResp.convert(users, evaluate)).collect(Collectors.toList());
        PageResult<EvaluateResp> respPageResult = PageResult.fromPageResult(evaluateResps, pageResult);
        return JsonResult.success(respPageResult);
    }
}
