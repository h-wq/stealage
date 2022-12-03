package com.xupt.stealage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@MapperScan(basePackages = "com.xupt.stealage.mapper")
public class StealageApplication {

	public static void main(String[] args) {
		SpringApplication.run(StealageApplication.class, args);
	}

}
