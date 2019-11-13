package com.wego.web.pxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component @Data @Lazy
public class Box<T> {
	private ArrayList<T> list;
	public Box() {list =new ArrayList<T>();}
	public void add(T item) {list.add(item);}
	public T get(int i) {return list.get(i);}
	public ArrayList<T> getList() {return list;}
	public int size() {return list.size();}
	public String toString() {return list.toString();}
	public void clear() {list.clear();}

//	public void accept(List<String>x, List<?>y) {
//		map = new HashMap<>();
//		for(int i =0 ; i < x.size(); i++) {
//			map.put(x.get(i), y.get(i));
//		}
//		map.forEach((k,v)-> System.out.print(String.format("%s : %s", k,v)));
//	}
	
	

}