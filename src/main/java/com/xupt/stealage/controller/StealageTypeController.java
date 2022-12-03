package com.xupt.stealage.controller;

import com.xupt.stealage.common.result.JsonResult;
import com.xupt.stealage.controller.resp.StealageTypeResp;
import com.xupt.stealage.service.StealageTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 失物招领类型相关接口
 */
@RestController
@RequestMapping(value = "/stealage_types")
@Slf4j
public class StealageTypeController {

    @Autowired
    private StealageTypeService stealageTypeService;

    /**
     * 添加失物招领类型
     * @param name name
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addStealageType(@RequestParam(name = "name") String name) {
        Integer result = stealageTypeService.addStealageType(name);
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "添加类型失败！");
    }

    /**
     * 获取所有失物招领类型
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public JsonResult<List<StealageTypeResp>> query() {
        List<StealageTypeResp> stealageTypeResps = stealageTypeService.getStealageTypes().stream().map(StealageTypeResp::convert).collect(Collectors.toList());
        return JsonResult.success(stealageTypeResps);
    }
}
