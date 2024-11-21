package com.breadflow.app.common.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.breadflow.app.common.service.FileUploadUtil;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class AjaxUploadController {
	
	//업로드 디렉토리
	@Value("${uploadPath}")
	String uploadPath;
	
	@GetMapping
	public String uploadAjax() {
		return "upload/uploadAjax";
	}
	
	@ResponseBody // 객체를 json 형식으로 데이터 리번 ( 서버 -> 클라이언트)\
	@PostMapping("uploadFile") //한글이 깨지지 않도록 처리	
	// ResponseEntity : 업로드한 파일 정보와 Http 상태 코드를 함깨 리턴
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception{
		return new ResponseEntity<String>(FileUploadUtil.uploadFile(uploadPath, file.getOriginalFilename(),	file.getBytes()), HttpStatus.OK);
	}
	
	
	
}
