package com.xupt.read.backend;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class ReadBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadBackendApplication.class, args);
	}

}
