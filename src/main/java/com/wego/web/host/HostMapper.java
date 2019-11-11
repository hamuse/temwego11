package com.wego.web.host;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public interface HostMapper {
	public void createHost(HashMap<String,String> paramMap);
	public void dropHost(HashMap<String,String> paramMap);
}
