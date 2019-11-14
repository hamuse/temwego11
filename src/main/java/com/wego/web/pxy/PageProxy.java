package com.wego.web.pxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.wego.web.brd.ArticleMapper;
import com.wego.web.cmm.ISupplier;
import com.wego.web.usr.User;
import com.wego.web.utl.Printer;
import lombok.Data;
@Component("page")
@Data
@Lazy
public class PageProxy extends Proxy{
    private int totalCount, startRow, endRow, pageCount, pageNum, pageSize, startPage, endPage, blockCount, blockNum,
            nextBlock, prevBlock;
    private boolean existPrev, existNext;
    private String search;
    private final int BLOCK_SIZE = 5;
    @Autowired
    Printer p;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    Box map;
    @SuppressWarnings("unused")
    public void paging() {
        ISupplier<String> s = () -> articleMapper.countArticle();
        totalCount = Integer.parseInt(s.get());
        System.out.println("프록시 안에서 찍은 전체글 갯수: " + totalCount);
        pageCount = (totalCount % pageSize != 0) ? (totalCount / pageSize) + 1 : totalCount / pageSize;
        startRow = (pageNum - 1) * pageSize;
        endRow = (pageNum == pageCount) ? totalCount - 1 : startRow + pageSize - 1;
        blockCount = (pageCount % BLOCK_SIZE != 0) ? (pageCount / BLOCK_SIZE) + 1 : pageCount / BLOCK_SIZE;
        blockNum = (pageNum - 1) / BLOCK_SIZE;
        startPage = blockNum * BLOCK_SIZE + 1;
        endPage = ((blockNum + 1) != blockCount) ? startPage + (BLOCK_SIZE - 1) : pageCount;
        existPrev = blockNum != 0;
        existNext = (blockNum + 1) != blockCount;
        nextBlock = startPage + BLOCK_SIZE;
        prevBlock = startPage - BLOCK_SIZE;
    }

	
	public List<?> crawl(Map<?,?> paramMap){
		String url = "https://"+paramMap.get("site")+"/";
		List<String> proxylist = new ArrayList<>();
		proxylist.clear();
    	try {
			Connection.Response response = Jsoup.connect(url)
					  .method(Connection.Method.GET)
					  .execute();
			Document document = response.parse();
			String text = document.html();
//			String text = document.text();
			p.accept("크롤링한 텍스트 \n"+text);
			proxylist.add(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proxylist; 
	}

	public int parseInt(String param) {
        Function<String, Integer> f = s -> Integer.parseInt(s);
        return f.apply(param);
    }
	
	
	
}
	