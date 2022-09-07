package com.example.application.infrastructure.security;

public class Role {

	public static final String OMNIADMIN = "omniadmin";
	public static final String ADMIN = "admin";
	public static final String CHIEFEDITOR = "chiefeditor";
	public static final String EDITOR = "editor";

	private Role() {
		// Static methods and fields only
	}

	public static String[] getAllUserRoles() {
		return new String[] { ADMIN, CHIEFEDITOR, EDITOR};
	}
}
