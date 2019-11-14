package com.wego.web.enums;

public enum SQL {
	CREATE_USER, DROP_PRODUCT, CREATE_DB, CREATE_PRODUCT, TRUNCATE_USER, DROP_COMMUNITY, CREATE_COMMUNITY;
	@Override
	public String toString() {
		String result = "";
		switch(this) {
		case CREATE_USER:
	           result = "CREATE TABLE USER(UID VARCHAR(20)PRIMARY KEY,"
	                   + " PWD VARCHAR(30) ," +
	                   "  UNAME VARCHAR(30) ," +
	                   "  BIRTH VARCHAR(30) ," +
	                   "  GENDER VARCHAR(30) ," +
	                   "  TEL VARCHAR(30)," +
	                   "  PETTYPE VARCHAR(30))";
	           break;
		case DROP_PRODUCT : 
			result = "DROP TABLE PRODUCT";
			break;
		case CREATE_PRODUCT : 
			result = "CREATE TABLE PRODUCT("
					+ "PDTNAME VARCHAR(30) PRIMARY KEY,"
					+ "HID VARCHAR(30) REFERENCES HOST,"
					+ "PRICE VARCHAR(30),"
					+ "HOSTTYPE VARCHAR(30),"
					+ "TYPE VARCHAR(30),"
					+ "ODNUM VARCHAR(30),"
					+ "REDATE VARCHAR(30),"
					+ "PAYTYPE VARCHAR(30),"
					+ "CANCEL VARCHAR(30),"
					+ "UID VARCHAR(30) REFERENCES USER)";
			break;
		case TRUNCATE_USER : 
			result = "TRUNCATE TABLE USER";
		break;
		 case DROP_COMMUNITY :
	            result = "DROP TABLE COMMUNITY";
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
		}
		return result;
	}
}
