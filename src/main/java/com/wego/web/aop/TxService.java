package com.wego.web.aop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wego.web.pxy.Box;
import com.wego.web.pxy.CommuProxy;
import com.wego.web.pxy.CrawlingProxy;
import com.wego.web.pxy.PageProxy;
import com.wego.web.pxy.UserProxy;

@Transactional
@Service
public class TxService {
	@Autowired TxMapper mapper;
	//@Autowired HashMap<String, Object> map;
	@Autowired CrawlingProxy proxy;
//	@Autowired List<String> txServicelist;
	@Autowired UserProxy manager;
	@Autowired CommuProxy Commu;
	@Autowired Box<String> box;
	
	@SuppressWarnings("unchecked")
	public Box<String> crawling(Map<?,?> paramMap){
		return proxy.choose(paramMap); 
	}
	
	public int registerUsers() {
		manager.insertUsers();
		return 0;
	}
   public void registerCommuniy() {
	   Commu.insertCommunity();
   }
}