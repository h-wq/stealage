package com.xupt.read.controller;

import com.xupt.read.common.result.JsonResult;
import com.xupt.read.service.HelloWorldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/helloWorld")
@Slf4j
public class HelloWorldController {

    private HelloWorldService helloWorldService;

    @RequestMapping(method = RequestMethod.GET)
    public JsonResult<String> hello() {

        String hello = helloWorldService.helloWorld();
        return JsonResult.success(hello);
    }
}
