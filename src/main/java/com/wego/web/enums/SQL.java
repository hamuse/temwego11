package com.wego.web.enums;

public enum SQL {
	CREATE_USER, DROP_USER, CREATE_DB, CREATE_PRODUCT;
	@Override
	public String toString() {
		String result = "";
		switch(this) {
		case CREATE_DB : 
			result = "CREATE DATABASE WEGODB";
			break;
		case CREATE_USER : 
			result = "CREATE TABLE MYSQL.USER()";
			break;
		case DROP_USER : 
			result = "DROP TABLE MYSQL.USER()";
			break;
		case CREATE_PRODUCT : 
			result = "CREATE TABLE PRODUCT("
					+ "PDNAME VARCHAR(20) PRIMARY KEY,"
					+ "HID VARCHAR(10) REFERENCES HOST,"
					+ "PRICE INT,"
					+ "HOSTTYPE VARCHAR(10),"
					+ "TYPE VARCHAR(10),"
					+ "ODNUM INT,"
					+ "REDATE DATE,"
					+ "PAYTYPE VARCHAR(10),"
					+ "CANCEL VARCHAR(10),"
					+ "UID VARCHAR(20) REFERENCES USER)";
			break;
		}
		return result;
	}
}
