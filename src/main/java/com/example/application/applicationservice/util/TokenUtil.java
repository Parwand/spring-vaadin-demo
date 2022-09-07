package com.example.application.applicationservice.util;

import java.util.UUID;

public class TokenUtil {

	public static String generateRandomToken() {
		return UUID.randomUUID().toString();
	}

}
