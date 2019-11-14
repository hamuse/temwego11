package com.wego.web.pxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wego.web.enums.Path;
import com.wego.web.utl.Printer;
@Component("crawler")
public class CrawlingProxy extends Proxy{
	@Autowired Printer p;
	@Autowired Box<String> box;
	public Box<String> choose(Map<?,?> paramMap){
		p.accept("키 값"+paramMap.get("site"));
		p.accept("키 값"+paramMap.get("srch"));
		switch (string(paramMap.get("srch"))) {
		case "스톤애견풀빌라":
			for(int i=0; i<37; i++) {
				box=crawling(Path.CRAWLING_TARGET.toString());
			}
			break;
		default: 
			crawling("https://"+paramMap.get("site")+"/");
			break;
		}
		
		return box; 
	}
	private Box<String> crawling(String url) {
		p.accept("넘어온 URL \n" + url);
		box.clear();
		try {
			Document rawData = Jsoup.connect(url).timeout(10*1000).get();
			  Elements artist = rawData.select("div[class=review_txt]"); 
			 
			  for(Element e : artist) {
				  box.add(e.text()+"\n  ****************************************************  \n");
			  }
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return box;

	}	
    	
	}

