package com.wego.web.enums;

public enum SQL {
	CREATE_USER,DROP_USER,CREATE_DB,CREATE_HOST,DROP_HOST;
	@Override
	public String toString() {
		String result = "";
		switch (this) {
		case CREATE_USER:
			result = "CREATE TABLE USER(UID VARCHAR(20)PRIMARY KEY,"
					+ " PWD VARCHAR(10) ," + 
					"  UNAME VARCHAR(20) ," + 
					"  BIRTH VARCHAR(10) ," + 
					"  GENDER VARCHAR(10) ," + 
					"  TEL INT," + 
					"  PETTYPE VARCHAR(20))";
			break;
		case DROP_USER:
			result = "DROP TABLE USER";
			break;
		case CREATE_DB :
			result = "CREATE DATABASE WEGODB";
			break;
		case CREATE_HOST :
			result = "CREATE TABLE HOST(HID VARCHAR(10) PRIMARY KEY,"
			+"PWD VARCHAR(20),"+
			"HNAME VARCHAR(20),"+
			"CEONAME VARCHAR(20),"+
			"VOMPNTTYPE VARCHAR(10),"+
			"TEL INT,"+
			"ADDR VARCHAR(50),"+
			"LICENSENUM INT)";
			break;
		case DROP_HOST:
			result = "DROP TABLE HOST";
			break;
			
		}
		return result;
	}
	
}
