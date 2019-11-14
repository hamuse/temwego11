package com.wego.web.tx;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wego.web.community.CommunityMapper;
import com.wego.web.product.ProductMapper;
import com.wego.web.pxy.Box;
import com.wego.web.pxy.CommProxy;
import com.wego.web.pxy.CrawlingProxy;
import com.wego.web.pxy.ProductProxy;
import com.wego.web.pxy.UserProxy;
import com.wego.web.usr.UserMapper;


@Service
public class TxService {
	@Autowired TxMapper txmapper;
	@Autowired CrawlingProxy crawler;
	@Autowired UserMapper userMapper;
	@Autowired UserProxy manager;
	@Autowired Box<String> box;
	@Autowired CommunityMapper communityMapper;
	@Autowired CommProxy sil;
	@Autowired ProductProxy pdPxy;
	@Autowired ProductMapper pdMapper;
	

	public Box<String> crawling(Map<?,?> paramMap){
		return crawler.choose(paramMap);
	}
	@Transactional
	public int registerUsers(){
		manager.insertUsers();
		return userMapper.countUsers();
	}
	public int trucateUsers() {
		manager.truncateUsers();
		return userMapper.countUsers();
	}
	public int writeCommunities() {
		sil.insertCommunity();
		return communityMapper.countCommunities();
	}
	public int registerProducts() {
		pdPxy.insertProduct();
		return pdMapper.countProducts();
	}
}