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
@Component("crawling")
public class CrawlingProxy extends Proxy {
	@Autowired Printer printer;
	@Autowired Box box;
	public Box<String> choose(Map<?, ?> paramMap) {
		printer.accept("키값:"+ paramMap.get("site"));
		printer.accept("값:"+ paramMap.get("srch"));
		String url = "";
		switch(String(paramMap.get("srch"))) {
		case "스톤애견풀빌라" : 
			crawling(Path.CRAWLING_TAGET.toString()+"1"); //
			break;
		default :
			crawling( "http://" + paramMap.get("site") + "/");
			break;
		}
	/*	String url = "http://" + paramMap.get("site") + "/";*/
		/*printer.accept("넘어온 URL \n" + url);*/
		return box;
	}
	private void crawling(String url) {
		printer.accept("넘어온 URL \n" + url);
		box.clear();
		
		try {
			/*Connection.Response response = Jsoup.connect(url).method(Connection.Method.GET).execute();*/
//			Document document = response.parse();
			/*String text = document.html();*/
			Document rawData = Jsoup.connect(url).timeout(10*1000).get();
			Elements artist = rawData.select("div[class=review_txt]");
			for(Element e : artist) {
				box.add(e.text()+"\n***********************\n");
				printer.accept(box.toString());
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
}
