package com.learning.app.ws.ui.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	/*
	 * private final int ITERATIONS = 10000; private final int KEY_LENGTH = 256;
	 */	
	public String generateUserId(int length) {
		return generateRandomString(length);
	}

	private String generateRandomString(int length) {

		StringBuilder returnValue = new StringBuilder(length);	
		
		for(int pos = 0; pos<length; pos++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));	
		}        	
		
        return new String(returnValue);
	}
}
