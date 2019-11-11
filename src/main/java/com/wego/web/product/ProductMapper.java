package com.wego.web.product;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {
	public void createProduct(HashMap<String, String> paramMap);
}
