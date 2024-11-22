package com.breadflow.app.infer.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class InferAnswerVO {
	private String inferAnswerNo;
	private String disposalWhether;
	private String answer;
	private String manager;
	private String answerer;
	@DateTimeFormat(pattern = "yy/MM/dd")
	@JsonFormat(pattern = "yy/MM/dd")
	private Date answerDate;
	private String inferNo;
	
	@DateTimeFormat(pattern = "yy/MM/dd")
	@JsonFormat(pattern = "yy/MM/dd")
	private String inferApplicationDate;
	private String confrimLocation;
	private String confirmWhether;
}
