package com.longzheng.spring.boot.zhoujun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描:该包下的持久化类，主要是muybatis的持久化类;
@MapperScan("com.longzheng.spring.boot.zhoujun.dao")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
