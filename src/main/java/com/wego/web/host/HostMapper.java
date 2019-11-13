package com.wego.web.host;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.wego.web.usr.User;

@Repository
public interface HostMapper {
	public void createHost(HashMap<String,String> paramMap);
	public void dropHost(HashMap<String,String> paramMap);
	public int countHosts();
	public void insertHost(Host host);
	
}
