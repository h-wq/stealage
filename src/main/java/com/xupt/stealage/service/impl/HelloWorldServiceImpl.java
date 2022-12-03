package com.xupt.stealage.service.impl;

import com.xupt.stealage.service.HelloWorldService;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String helloWorld() {
        return "success, helloWorld";
    }
}
