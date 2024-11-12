package com.breadflow.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.breadflow.app.**.mapper")
public class BreadFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BreadFlowApplication.class, args);
	}

}
