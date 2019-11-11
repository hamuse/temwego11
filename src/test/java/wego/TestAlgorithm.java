package wego;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public class TestAlgorithm {

	public static void main(String[] args) {
		 String birthday = "";
	        int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	        
	        int iMinMonth = 1;
	        int iMaxMonth = 12;
	        
	        int iRandomMonth = (int)(Math.random() * iMaxMonth - iMinMonth + 1) + iMinMonth;
	        int iRandomDay = (int)(Math.random() * (maxDays[iRandomMonth-1] -2) + 1);
	        birthday= String.valueOf(iRandomMonth)+"월"+String.valueOf(iRandomDay)+"일";
	       System.out.println(birthday);
	}

}
