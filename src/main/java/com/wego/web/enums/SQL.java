package com.wego.web.enums;

public enum SQL {
	CREATE_USER,DROP_USER,CREATE_DB,CREATE_HOST,DROP_HOST,TRUNCATE_USER,
	CREATE_COMMUNITY,DROP_COMMUNITY;
	@Override
	public String toString() {
		String result = "";
		switch (this) {
		case CREATE_USER:
			result = "CREATE TABLE USER(UID VARCHAR(30)PRIMARY KEY,"
					+ " PWD VARCHAR(30) ," + 
					"  UNAME VARCHAR(30) ," + 
					"  BIRTH VARCHAR(30) ," + 
					"  GENDER VARCHAR(30) ," + 
					"  TEL VARCHAR(30)," + 
					"  PETTYPE VARCHAR(30))";
			break;
		case DROP_USER:
			result = "DROP TABLE USER";
			break;
		case CREATE_DB :
			result = "CREATE DATABASE WEGODB";
			break;
		case CREATE_HOST :
			result = "CREATE TABLE HOST(HID VARCHAR(30) PRIMARY KEY,"
			+"PWD VARCHAR(30),"+
			"HNAME VARCHAR(30),"+
			"CEONAME VARCHAR(30),"+
			"COMPANYTYPE VARCHAR(30),"+
			"TEL VARCHAR(30),"+
			"ADDR VARCHAR(30),"+
			"LICENSENUM VARCHAR(30))";
			break;
		case DROP_HOST:
			result = "DROP TABLE HOST";
			break;
		case TRUNCATE_USER :
			result = "TRUNCATE TABLE COMMU";
			result = "CREATE TABLE ITEM()";
			break;
		case CREATE_COMMUNITY :
            result = "CREATE TABLE COMMUNITY("
                    + "ARTSEQ INT AUTO_INCREMENT PRIMARY KEY,"
                    + "IMG VARCHAR(30)  REFERENCES IMG,"
                    + "UID VARCHAR(30)  REFERENCES USER,"
                    + "COMMENTS VARCHAR(100),"
                    + "MSG VARCHAR(50),"
                    + "RATING VARCHAR(50), "
                    + "BOARDTYPE VARCHAR(50),"
                    + "TITLE VARCHAR(100),"
                    + "CONTENT VARCHAR(200))";
            break;
		case DROP_COMMUNITY :
			result = "DROP TABLE COMMUNITY";
			break;
		}
		return result;
	}
	
}
