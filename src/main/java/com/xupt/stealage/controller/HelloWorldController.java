package com.xupt.stealage.controller;

import com.xupt.stealage.common.result.JsonResult;
import com.xupt.stealage.service.HelloWorldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/helloWorld")
@Slf4j
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping(method = RequestMethod.GET)
    public JsonResult<String> hello() {

        String hello = helloWorldService.helloWorld();
        return JsonResult.success(hello);
    }
}
