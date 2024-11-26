package com.breadflow.app;

import java.util.TimeZone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@MapperScan(basePackages = "com.breadflow.app.**.mapper")
public class BreadFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BreadFlowApplication.class, args);
	}
	
    @PostConstruct
    public void init() {
        // timezone 설정
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }

}