package com.wego.web.enums;

public enum SQL {
	CREATE_DB,
	CREATE_USER,DROP_USER,TRUNCATE_USER,
	CREATE_HOST,DROP_HOST,
	CREATE_COMMUNITY, DROP_COMMUNITY,
	CREATE_ADMIN, DROP_ADMIN,
	CREATE_IMG, DROP_IMG,
	CREATE_LOCATION, DROP_LOCATION,
	CRATE_PRODUCT, DROP_PRODUCT;
    @Override
    public String toString() {
        String result = "";
        switch (this) {
        
        case CREATE_DB :
            result = "CREATE DATABASE WEGODB";
            break;
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
        case CREATE_HOST :
            result = "CREATE TABLE HOST(HID VARCHAR(30) PRIMARY KEY,"
            +"PWD VARCHAR(30),"+
            "HNAME VARCHAR(30),"+
            "CEONAME VARCHAR(30),"+
            "COMPANYTYPE VARCHAR(30),"+
            "TEL VARCHAR(30),"+
            "ADDR VARCHAR(50),"+
            "LICENSENUM INT)";
            break;
        case DROP_HOST:
            result = "DROP TABLE HOST";
            break;
        case TRUNCATE_USER :
        	//데이터만 지울때 사용하는거
            result = "TRUNCATE TABLE COMMU";
            result = "CREATE TABLE ITEM()";
            break;
        case CREATE_COMMUNITY :
        	result =  "CREATE TABLE COMMUNITY("
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
        case DROP_COMMUNITY:
            result = "DROP TABLE COMMUNITY";
            break;
        case CREATE_ADMIN :
        	result="CREATE TABLE ADMIN("
		        	+"EID VARCHAR(30) PRIMARY KEY,"
		        	+"PWD VARCHAR(30),"
		        	+"ANAME VARCHAR(30),"
		        	+"ADDR VARCHAR(30),"
		        	+"TEL VARCHAR(30),"
		        	+"POS VARCHAR(30),"
		        	+"DEP VARCHAR(30),"
		        	+"PRIVILEGE VARCHAR(10))";
        	break;
        case DROP_ADMIN:
            result = "DROP TABLE ADMIN";
            break;
        case CREATE_IMG :
        	 result="CREATE TABLE IMG("
        	 		+ "IMG VARCHAR(30) PRIMARY KEY)";
        	break;
        case DROP_IMG:
            result = "DROP TABLE IMG";
            break;
        case CREATE_LOCATION :
        	 result="CREATE TABLE LOCATION("
        	 		+ "ADDR VARCHAR(50) PRIMARY KEY"
        			+ "UID VARCHAR(30) REFERENCES USER"
        	 		+ "SPOT VARCHAR(50) "
        			+ "PLACE VARCHAR(50))";
        	break;
        case DROP_LOCATION:
            result = "DROP TABLE LOCATION";
            break;
        case CRATE_PRODUCT :
        	result="CREATE TABLE LOCATION("
        	 		+ "PDTNAME VARCHAR(50) PRIMARY KEY"
        			+ "HID VARCHAR(30) REFERENCES HOST"
        	 		+ "PRICE VARCHAR(50) "
        			+ "HOSTTYPE VARCHAR(50)"
        			+ "TYPE VARCHAR(10)"
        			+ "ODNUM VARCHAR(30)"
        			+ "REDATE VARCHAR(30)"
        			+ "PAYTYPE VARCHAR(30)"
        			+ "CANCEL VARCHAR(10)"
        			+ "UID VARCHAR(30) REFERENCES USER)";
        	break;
        case DROP_PRODUCT:
            result = "DROP TABLE PRODUCT";
            break;
        }
        return result;
    }
    
}
