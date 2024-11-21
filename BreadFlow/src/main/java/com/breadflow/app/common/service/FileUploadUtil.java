package com.breadflow.app.common.service;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class FileUploadUtil {
	
	//로깅  -- 프로그램이 실행되는 동안 중간 결과나 오류를 기록하는 것
	
	public static String uploadFile(String uploadPath, String originalName, byte[] fileDate) throws Exception{
		
		// uuid 발급 --해당 타입의 다른 모든 리소스 중에서 리소스를 고유하게 식별하는 데 사용되는 레이블
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalName;
		
		// 업로드 디렉토리 생성
		String savePath = calcPath(uploadPath);
		File target = new File(uploadPath+savePath,savedName);
		
		// 임시디렉토리에 업로드된 파일을 지정된 디렉토리로 복사
		FileCopyUtils.copy(fileDate, target);
		
		//파일의 확장자 검사(ex : a.jpg/ aaa.bbb.ccc.jpg)
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		String uploadedFileName = savePath + "/" + savedName ;
		
		return uploadedFileName;
	}
	
	//날짜 처리 (2023년 폴더 / 00월 폴더 / 00일 폴더 생성)
	
	public static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = "/" + cal.get(Calendar.YEAR);
		String monthPath = yearPath + "/"
						   + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		
		String datePath = monthPath + "/" + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		log.info(datePath);
		
		return datePath;
	}
	// 디렉토리 생성 
		private static void makeDir(String uploadPath, String... paths) {
			// String... 은 가변 사이즈 매개변수(배열의 요소가 몇개든 상관없이 처리)
			// 디렉토리가 존재하면 skip
			if(new File(paths[paths.length -1]).exists()) {	// 존재하면
				return;
			}
			for(String path : paths) {
				File dirPath = new File(uploadPath + path);
				if(!dirPath.exists()) {
					dirPath.mkdir(); // 디렉토리 생성
				}
			}
			
		}
	
}	
	
	

