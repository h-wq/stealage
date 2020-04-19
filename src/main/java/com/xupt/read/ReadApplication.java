package com.xupt.read;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@MapperScan(basePackages = "com.xupt.read.mapper")
public class ReadApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadApplication.class, args);
	}

}
