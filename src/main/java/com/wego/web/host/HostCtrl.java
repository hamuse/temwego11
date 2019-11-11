package com.wego.web.host;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wego.web.cmm.IConsumer;
import com.wego.web.enums.SQL;
import com.wego.web.utl.Printer;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/hosts")
@Log4j
public class HostCtrl {
	private static final Logger logger = LoggerFactory.getLogger(HostCtrl.class);
	 @Autowired Map<String, Object> map;
	 @Autowired Printer printer;
	 @Autowired HostMapper hostmapper;
	 @Autowired Host host;
	 
	 
	 @GetMapping("/create/table")
	    public Map<?,?> createHost(){
	    	HashMap<String,String> paramMap = new HashMap();
	    	paramMap.put("CREATE_TABLE", SQL.CREATE_HOST.toString());
	    	printer.accept("테이블 생성 쿼리 : \n"+ paramMap.get("CREATE_TABLE"));
	    	Consumer<HashMap<String,String>>  c = o -> hostmapper.createHost(o);
	        c.accept(paramMap);
	        paramMap.clear();
	        paramMap.put("msg","SUCCESS");
	        return paramMap;
	    }
	 @GetMapping("/drop/table")
	    public Map<?,?> dropUser(){
	    	HashMap<String,String> paramMap = new HashMap();
	    	paramMap.put("DROP_TABLE", SQL.DROP_HOST.toString());
	    	printer.accept("테이블 제거 쿼리 : \n"+ paramMap.get("DROP_TABLE"));
	    	Consumer<HashMap<String,String>>  c = o -> hostmapper.dropHost(o);
	        c.accept(paramMap);
	        paramMap.clear();
	        paramMap.put("msg","SUCCESS");
	        return paramMap;
	    }
}
