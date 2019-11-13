package com.wego.web.commu;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wego.web.pxy.PageProxy;
@Repository
public interface CommunityMapper {

	public void insertCommunity(Community param);
	public String countArticle();
	public List<Community> selectAll(PageProxy pxy);
	public void createCommunity(HashMap<String, String> o);
	public void dropCommunity(HashMap<String, String> o);
	public int countCommuities();
}
