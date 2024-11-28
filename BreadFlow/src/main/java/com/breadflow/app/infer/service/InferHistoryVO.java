package com.breadflow.app.infer.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class InferHistoryVO {
	private String inferNo;
	@DateTimeFormat(pattern = "yy/MM/dd")
	@JsonFormat(pattern = "yy/MM/dd")
	private Date inferApplicationDate;
	private String confirmLocation;
	private String inferItem;
	private Integer inferQuantity;
	private String confirmWhether;
	private String disposalWhether;
	private String inferManager;
}
