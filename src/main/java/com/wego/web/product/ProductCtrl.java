package com.wego.web.product;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wego.web.cmm.IConsumer;
import com.wego.web.enums.SQL;
import com.wego.web.usr.UserCtrl;
import com.wego.web.utl.Printer;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/products")
@Log4j
public class ProductCtrl {
	@Autowired Printer printer;
	@Autowired Product product;
	@Autowired ProductMapper productMapper;
	
	@GetMapping("/create/table")
	public Map<?,?> createProduct(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("CREATE_PRODUCT", SQL.CREATE_PRODUCT.toString());
		printer.accept("생성된 프로덕트 : \n" + paramMap.get("CREATE_PRODUCT"));
		Consumer<HashMap<String, String>> c = o -> productMapper.createProduct(o);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
		
	}
    @GetMapping("/drop/table")
    public Map<?,?> dropProduct(){
    	HashMap<String, String> paramMap = new HashMap<>();
    	paramMap.put("DROP_PRODUCT", SQL.DROP_PRODUCT.toString());
    	printer.accept("테이블 삭제 쿼리 : \n" +paramMap.get("DROP_PRODUCT"));
    	IConsumer<HashMap<String, String>> c =o -> productMapper.dropProduct(o);
    	c.accept(paramMap);
    	paramMap.clear();
    	paramMap.put("msg", "SUCCESS");
    	return paramMap;
    }
}
