package com.wego.web.community;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wego.web.enums.SQL;
import com.wego.web.pxy.CommProxy;
import com.wego.web.utl.Printer;
import lombok.extern.log4j.Log4j;
@RestController
@RequestMapping("/community")
@Log4j
public class CommunityCtrl {
     private static final Logger logger = LoggerFactory.getLogger(CommunityCtrl.class);
     @Autowired Community community;
     @Autowired CommunityMapper communityMapper;
     @Autowired Printer printer;
     @Autowired CommProxy cpxy;
     
     @GetMapping("/create/table")
     public Map<?, ?> createCommunity() {
         HashMap<String, String> paramMap = new HashMap<>();
         paramMap.put("CREATE_COMMUNITY", SQL.CREATE_COMMUNITY.toString());
         printer.accept("테이블 생성 쿼리"+paramMap.get("CREATE_COMMUNITY"));
         Consumer<HashMap<String, String>> c = o-> communityMapper.createCommunity(o);
         c.accept(paramMap);
         paramMap.clear();
         paramMap.put("msg", "SUCCESS");
         return paramMap;
     }
     
     @GetMapping("/drop/table")
     public Map<?, ?> dropCommunity() {
         HashMap<String, String> paramMap = new HashMap<>();
         paramMap.put("DROP_COMMUNITY", SQL.DROP_COMMUNITY.toString());
         printer.accept("테이블 생성 쿼리"+paramMap.get("DROP_COMMUNITY"));
         Consumer<HashMap<String, String>> c = o-> communityMapper.dropCommunity(o);
         c.accept(paramMap);
         paramMap.clear();
         paramMap.put("msg", "SUCCESS");
         return paramMap;
     }
     
     @GetMapping("/insert/table")
     public Map<?, ?> insertCommunity() {
         HashMap<String, String> paramMap = new HashMap<>();
         cpxy.insertCommunity();
         paramMap.clear();
         paramMap.put("msg", "SUCCESS");
         return paramMap;
     }
     ///community/write/texts
     
     
}
