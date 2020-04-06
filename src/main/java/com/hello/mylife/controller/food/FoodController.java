package com.hello.mylife.controller.food;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hello.micro.sdk.entity.food.FoodEntity;
import com.hello.micro.sdk.service.food.FoodDubboService;
import com.hello.mylife.common.result.JsonResult;
import com.hello.mylife.controller.resp.FoodResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/food/foods")
@Slf4j
public class FoodController {

    @Reference
    private FoodDubboService foodDubboService;

    @RequestMapping(method = RequestMethod.GET)
    public JsonResult<List<FoodResp>> query() {

        List<FoodEntity> foodEntityList = foodDubboService.getAllFoods();
        List<FoodResp> foodRespList = foodEntityList.stream().map(FoodResp::convert).collect(Collectors.toList());
        return JsonResult.success(foodRespList);
    }
}
