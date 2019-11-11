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
	@Autowired TxMapper mapper;
	//@Autowired HashMap<String, Object> map;
	@Autowired Proxy proxy;
//	@Autowired List<String> txServicelist;
	@Autowired UserMapper userMapper;
	
	@SuppressWarnings("unchecked")
	public List<?> crawling(Map<?,?> paramMap){
		HashMap<String, Object> map = new HashMap<>();
		List<String> txServicelist = new ArrayList<>();
		txServicelist.clear();
		txServicelist = (List<String>)proxy.crawl(paramMap);
		
		return txServicelist; 
	}
	
	@Transactional// 여기서 룹 돌리는거니까 트렌잭셔널 어기다 거는거 맞음 매퍼 ㄴㄴㄴ
	public int registerUsers(){
		List<User> list = new ArrayList<>();
		for(User u : list) {
			mapper.InsertUser(u);
		}
		int userCount = userMapper.countUsers();
		return userCount ;

	}
}