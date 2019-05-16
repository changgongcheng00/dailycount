package com.dailycount;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.dailycount.dao")
@EnableCaching
@ComponentScan(basePackages = { "com.dailycount","generator" })
public class DailycountApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailycountApplication.class, args);
	}

}

