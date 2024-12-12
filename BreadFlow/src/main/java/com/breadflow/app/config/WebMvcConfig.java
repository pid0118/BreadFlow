package com.breadflow.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	@Value("${uploadPath}")
	private String uploadPath;
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/imgs/**")		// URL
				.addResourceLocations("file://" + uploadPath + "/");	// 실제 경로
	}
	//외부 파일 시스템의 특정 디렉토리(uploadPath)에 있는 이미지 파일들을 "/imgs/" URL 경로를 통해 웹 애플리케이션에서 접근할 수 있게 하는코드
}
