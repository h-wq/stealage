package com.xupt.read.backend.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xupt.read.backend.common.result.JsonResult;
import com.xupt.read.sdk.service.HelloWorldDubboService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/helloWorld")
@Slf4j
public class HelloWorldController {

    @Reference
    private HelloWorldDubboService helloWorldDubboService;

    @RequestMapping(method = RequestMethod.GET)
    public JsonResult<String> hello() {

        String hello = helloWorldDubboService.helloWorld();
        return JsonResult.success(hello);
    }
}
