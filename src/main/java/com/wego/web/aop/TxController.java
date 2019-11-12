package com.wego.web.aop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wego.web.cmm.IFunction;
import com.wego.web.pxy.PageProxy;
import com.wego.web.pxy.Box;
import com.wego.web.utl.Printer;

@RestController
@Transactional
@RequestMapping("/tx")
public class TxController {
//	System.out.println(text);
	@Autowired Printer p;
	@Autowired TxService txservice;
//	@Autowired HashMap<String,String> map;
	@Autowired Box map;
	
	 @GetMapping("/crawling/{site}/{srch}")
	 public void crawl(@PathVariable String site, @PathVariable String srch) {
		 p.accept(site+", srch "+ srch);
		 HashMap<String,Object>txMap= new HashMap<>();
		 txMap.clear();
		 txMap.put("site", site);
		 txMap.put("srch",srch);
		 txservice.crawling(txMap);
//		 map.clear();
	 } 
	 @GetMapping("/register/users")
	 public Map<?,?> registerUsers() {
		 int userCount = txservice.registerUsers();
		 p.accept("서비스 카운팅"+userCount);
		 map.accept(Arrays.asList("userCount"), Arrays.asList(userCount));
		 return map.get();
	 }
}