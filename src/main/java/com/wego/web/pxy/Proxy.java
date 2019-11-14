package com.wego.web.pxy;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.springframework.stereotype.Component;

@Component
public class Proxy {
	public int integer(String param) {
		Function<String, Integer> f =  Integer :: parseInt;
		return f. apply(param);
	}
	public String string(Object param) {
		Function<Object, String> f =  String :: valueOf;
		return f. apply(param);
	}
	public boolean equal(String p1, String p2) {
		BiFunction<String, String, Boolean> f = String :: equals;
		return f.apply(p1, p2);
	}
	public int random(int x,int y) {
		BiFunction<Integer, Integer, Integer> s = (t,u)->(int)(Math.random()*(u-t))+t;
		return s.apply(x,y);
	}
	public int[] intArray(int size) {
		Function<Integer, int[]> f = int[] :: new;
		return f.apply(size);
	}
	public String currentDate() {
		return new SimpleDateFormat("yyy-MM-dd").format(new Date());
	}
	public String currentTime() {
		return new SimpleDateFormat("yyy-MM-dd hh:mm:ss").format(new Date());
	}
	
}


