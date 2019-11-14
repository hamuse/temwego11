package com.wego.web.product;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {
	public void createProduct(HashMap<String, String> paramMap);
	public void dropProduct(HashMap<String, String> paramMap);
	public void insertProduct(Product product);
	public int countProducts();
}
