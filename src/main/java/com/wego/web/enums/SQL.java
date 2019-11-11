package com.wego.web.enums;

public enum SQL {
	CREATE_USER,CREATE_ADMIN,DROP_USER, CREATE_DB,CREATE_IMG,DROP_ADMIN;
	@Override
	public String toString() {
		String result = "";
		switch (this) {
		case CREATE_DB:
			result = "CREATE DATABASE WEGODB";
			break;
		case CREATE_USER:
			result = "CREATE TABLE MYSQL.USER"
					+ "(UID VARCHAR(10) PRIMARY KEY,"
					+ "PWD VARCHAR(10) NOT NULL, "
					+ "UNAME VARCHAR(20),  "
					+ "BIRTH VARCHAR(10,)  "
					+ "GENDER VARCHAR(10), "
					+ "TEL VARCHAR(10), "
					+ "PETTYPE VARCHAR(20))";
			break;
		case DROP_USER:
			result = "drop table mysql.user";
			break;
		case CREATE_ADMIN:
			result = "CREATE TABLE ADMIN"
					+ "(EID VARCHAR(10) PRIMARY KEY,"
					+ "PWD VARCHAR(10) NOT NULL, "
					+ "ANAME VARCHAR(20), "
					+ "ADDR VARCHAR(50), "
					+ "TEL INT,"
					+ "POS VARCHAR(10),"
					+ "DEP VARCHAR(20),"
					+ "PRIVILEGE VARCHAR(10))";
			break;
		case CREATE_IMG:
			result = "CREATE TABLE IMG"
					+ "(IMG VARCHAR(20) PRIMARY KEY)";
			break;
		case DROP_ADMIN:
			result = "DROP TABLE ADMIN";
			break;
		default:
			break;
		}
		return result;
	}

}
