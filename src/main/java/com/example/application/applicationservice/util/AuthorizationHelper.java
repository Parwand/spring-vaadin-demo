package com.example.application.applicationservice.util;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthorizationHelper {

	public static boolean isAuthorized(String... roles) {
		for (String role : roles) {
			if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority(role))) {
				return true;
			}
		}
		return false;
	}

}
