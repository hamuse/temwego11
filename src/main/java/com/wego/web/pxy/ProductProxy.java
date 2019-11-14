package com.wego.web.pxy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wego.web.community.Community;
import com.wego.web.product.Product;
import com.wego.web.product.ProductMapper;

import lombok.Data;

@Lazy
@Component("pdt")
public class ProductProxy extends Proxy{
	@Autowired Product product;
	@Autowired ProductMapper productMapper;
	@Autowired CrawlingProxy crawlingProxy;
	@Autowired Trunk<String> trunk;
	@Autowired Box<String> box;
	
	public String makePdtName() {
        List<String> fpdtName = Arrays.asList("또와유", "다시와유", "두번와유", "좋은", "기분좋은");
        List<String> pdtName = Arrays.asList("호텔", "맛집", "관광지", "교통");
        Collections.shuffle(fpdtName);
        Collections.shuffle(pdtName);
        String fullpdtName = fpdtName.get(0)+pdtName.get(0);
     return fullpdtName;
   }
	public String makeHid() {
		List<String> hids = Arrays.asList("01qmz8","03vqrs","08eri3","08hcyu","09o7jl","0eqwpv","0fimpb","0gpeqz","0h279b","0hfnt9");
		Collections.shuffle(hids);
		String hid = hids.get(0);
		return hid;
	}
    public String makePrice() {
        int a = 11111,b = 99999;
           BiFunction<Integer,Integer,Integer> f = (t,u)->(int)(Math.random()*(u-t))+t;
           int pre = f.apply(a,b);
           int af= f.apply(a,b);
           String price = String.valueOf(pre)+String.valueOf(af)+"WON";
               return price;
   }
   public String makeHostType() {
       List<String> companytypes = Arrays.asList("택시", "호텔", "음식점","관광");
       Collections.shuffle(companytypes);
       String companytype = companytypes.get(0);
    return companytype;
   }
   public String makeType() {
        List<String> makeType = Arrays.asList("p", "r");
        Collections.shuffle(makeType);
        String makeTypes = makeType.get(0);
     return makeTypes;
   }
	public String makeOdnum() {
		int a = 11111,b = 99999;
        BiFunction<Integer,Integer,Integer> f = (t,u)->(int)(Math.random()*(u-t))+t;
        int pre = f.apply(a,b);
        int af= f.apply(a,b);
        String odnum = String.valueOf(pre)+String.valueOf(af);
		return odnum;		
	}
	public String makeRedate() {
		List<String> fReDates = Arrays.asList("1", "2", "3", "4", "5", "6","7","8","9","10","11","12");
		List<String> lReDates = Arrays.asList("1", "2", "3", "4", "5", "6","7","8","9","10","11","12","13","14","15","16","17","18","19",
				"20","21","22","23","24","25","26","27","28","29","30","31");
		Collections.shuffle(fReDates);
		Collections.shuffle(lReDates);
		String reDate = fReDates.get(0)+"/" + lReDates.get(0);
		return reDate;		
	}
	public String makePayType() {
		List<String> payTypes = Arrays.asList("카드", "현금", "카카오페이", "삼성페이");
		Collections.shuffle(payTypes);
	       String payType = payTypes.get(0);
		return payType;		
	}
	public String makeCancel() {
		return null;		
	}
	public String makeUid() {
		List<String> uids = Arrays.asList("01dxv6","01ftjh","01ikor","01laqi","01zr2h","026x1m","032j6d","035e4k","03n2xe","03zr6i");
		Collections.shuffle(uids);
		String uid = uids.get(0);
		return uid;
		
	}
//pdtname, hid, price, hosttype, type, odnum, redate, paytype, cancel, uid;
		
		 public Product makeProduct() {
		        return new Product(makePdtName(), makeHid(), makePrice(), makeHostType(), makeType(), makeOdnum(), makeRedate(), makePayType(),
		        		makeCancel(), makeUid () );
		    }
		 
		        @Transactional
		        public void insertProduct() {
		            for(int i = 1; i <=100; i++) {
		            	productMapper.insertProduct(makeProduct());
		            }
		        }
        
}


