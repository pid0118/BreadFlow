package com.breadflow.app.account.service;

public interface EncryptHelper {
	String encrypt(String password);
	
	boolean isMatch(String password, String hashed);
}
