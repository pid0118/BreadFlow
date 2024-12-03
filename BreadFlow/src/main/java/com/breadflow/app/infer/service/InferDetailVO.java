package com.breadflow.app.infer.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class InferDetailVO {
	private String inferDetailCode;
	private String inferItem;
	private Integer totalQuantity;
	private Integer inferQuantity;
	private String inferType;
	private String inferImage;
	private String inferNo;
	private String instoreNo;
	private String inferManager;
	private String managerName;
	
	@DateTimeFormat(pattern = "yy/MM/dd")
	@JsonFormat(pattern = "yy/MM/dd")
	private Date inferApplicationDate;
	private String confirmLocation;
	private String confirmWhether;
	private String disposalWhether;
	private String answerer;
	private String manager;
	private String answer;
	
	@DateTimeFormat(pattern = "yy/MM/dd")
	@JsonFormat(pattern = "yy/MM/dd")
	private Date instoreDate;
}
