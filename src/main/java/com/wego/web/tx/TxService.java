package com.wego.web.tx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wego.web.host.HostMapper;
import com.wego.web.pxy.Box;
import com.wego.web.pxy.CrawlingProxy;
import com.wego.web.pxy.HostProxy;
import com.wego.web.pxy.PageProxy;
import com.wego.web.pxy.Proxy;
import com.wego.web.pxy.UserProxy;
import com.wego.web.usr.User;
import com.wego.web.usr.UserMapper;
@Transactional
@Service
public class TxService {
	@Autowired TxMapper txMapper;
	@Autowired UserMapper userMapper;
	@Autowired HostMapper hostMapper;
	@Autowired CrawlingProxy crawler;
	//@Autowired List<String> txServicelist;
	@Autowired HostProxy hostproxy;
	@Autowired UserProxy manager;
	@Autowired Box<String> box;
	
	public Box<String> crawling(Map<?,?> paramMap){
		return crawler.choose(paramMap);
	}
	@Transactional
	public int registerUsers(){
		manager.insertUsers();
		return userMapper.countUsers();
	}
	@Transactional
	public int registerHosts(){
		hostproxy.insertHost();
		return hostMapper.countHosts();
	}
	public int trucateUsers() {
		manager.truncateUsers();
		return userMapper.countUsers();
	}
	
	
}