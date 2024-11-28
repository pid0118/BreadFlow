package com.breadflow.app.account.service;

public interface Encryptor {
	String encrypt(String password);
	
	boolean isMatch(String password, String hashed);
}
