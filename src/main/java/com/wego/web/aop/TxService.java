package com.wego.web.aop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wego.web.pxy.Proxy;
import com.wego.web.usr.User;
import com.wego.web.usr.UserMapper;


@Service
public class TxService {
	@Autowired TxMapper txmapper;
	//@Autowired HashMap<String, Object> map;
	@Autowired Proxy proxy;
	@Autowired UserMapper userMapper;
//	@Autowired List<String> txServicelist;
	
	@SuppressWarnings("unchecked")
	public List<?> crawling(Map<?,?> paramMap){
		HashMap<String, Object> map = new HashMap<>();
		List<String> txServicelist = new ArrayList<>();
		txServicelist.clear();
		txServicelist = (List<String>)proxy.crawl(paramMap);
		
		return txServicelist; 
	}
	@Transactional
	public int registerUsers(){
		List<User> list = new ArrayList<>();
		for(User u: list) {
			txmapper.insertUser(u);
		}	
		return userMapper.countUsers();
		
		
	}
}