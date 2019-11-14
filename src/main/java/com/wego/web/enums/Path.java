package com.wego.web.enums;

public enum Path {
	UPLOAD_PATH,CRAWLING_TAGET;
	@Override
	public String toString() {
		String result = "";
		switch(this){
		case UPLOAD_PATH :
			result = "C:\\Users\\hamuse\\Desktop\\hhh\\eGovFrameDev-3.8.0-64bit\\workspace\\wego\\src\\main\\webapp\\resources\\upload\\";
			break;
		case CRAWLING_TAGET :
			result = "https://store.naver.com/accommodations/detail?entry=plt&id=1285629759&tab=bookingReview&tabPage=";
			break;	
		}
		return result;
	}
}
