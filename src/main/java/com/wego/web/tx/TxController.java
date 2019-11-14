package com.wego.web.tx;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wego.web.cmm.IFunction;
import com.wego.web.community.CommunityMapper;
import com.wego.web.pxy.Box;
import com.wego.web.pxy.CrawlingProxy;
import com.wego.web.pxy.Trunk;
import com.wego.web.utl.Printer;

@RestController
@Transactional
@RequestMapping("/tx")
public class TxController {
//	System.out.println(text);
	@Autowired Printer p;
	@Autowired TxService txService;
//	@Autowired HashMap<String,String> map;
	@Autowired Trunk<String> trunk;
	@Autowired CrawlingProxy crawler;
	@Autowired CommunityMapper sil;
	@Autowired Box<String> box;
	
	@GetMapping("/crawling/{site}/{srch}")
	public void bringUrl(@PathVariable String site,
			@PathVariable String srch) {
		p.accept(site +", srch "+srch);
		trunk.put(Arrays.asList("site","srch"),
				Arrays.asList(site, srch) );
		box = txService.crawling(trunk.get());
	}
		@GetMapping("/write/communities")
		public Map<?,?> writeCommunities() {			
			int userCount = txService.writeCommunities();
			p.accept("서비스 카운팅: "+ userCount);
			trunk.put(Arrays.asList("userCount"), Arrays.asList(crawler.string(userCount)));
			return trunk.get();
		}
		@GetMapping("/register/users")
		public Map<?,?> registerUsers() {
			
			int userCount = txService.registerUsers();
			p.accept("서비스 카운팅: "+ userCount);
			trunk.put(Arrays.asList("userCount"), Arrays.asList(crawler.string(userCount)));
			return trunk.get();
		}
		@GetMapping("/register/products")
		public Map<?,?> registerProducts() {
			
			int pdtCount = txService.registerProducts();
			p.accept("서비스 카운팅: "+ pdtCount);
			trunk.put(Arrays.asList("pdtCount"), Arrays.asList(crawler.string(pdtCount)));
			return trunk.get();
		}
	 @GetMapping("/truncate/users")
		public Map<?,?> truncateUsers() {
			
			int userCount = txService.trucateUsers();
			p.accept("서비스 카운팅: "+ userCount);
			trunk.put(Arrays.asList("userCount"), Arrays.asList(crawler.string(userCount)));
			return trunk.get();
		}

}