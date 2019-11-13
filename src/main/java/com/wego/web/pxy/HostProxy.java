package com.wego.web.pxy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wego.web.host.Host;
import com.wego.web.host.HostMapper;
import com.wego.web.usr.User;

@Component("hostproxy")
public class HostProxy extends Proxy{
	@Autowired HostMapper hostMapper;
	public String makeHostid() {
		List<String> uidText = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "n", "m", "o",
                "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "0");
     Collections.shuffle(uidText);
     String hids = uidText.get(0)+uidText.get(1)+uidText.get(2)+uidText.get(3)+uidText.get(4)+uidText.get(5);
		return hids;
	}
	public String makeHostname() {
		 List<String> fname = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
			        "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
			        "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양",
			        "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금",
			        "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용");
			    List<String> name = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다",
			        "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
			        "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
			        "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
			        "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
			        "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
			        "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비",
			        "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼",
			        "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠",
			        "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");
			    Collections.shuffle(fname);
			    Collections.shuffle(name);
			    String fullname = fname.get(0) + name.get(0) + name.get(1);
			    return fullname;
	 }
	public String makeCeoname() {
		 List<String> fname = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
			        "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
			        "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양",
			        "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금",
			        "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용");
			    List<String> name = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다",
			        "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
			        "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
			        "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
			        "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
			        "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
			        "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비",
			        "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼",
			        "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠",
			        "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");
			    Collections.shuffle(fname);
			    Collections.shuffle(name);
			    String fullname = fname.get(0) + name.get(0) + name.get(1);
			    return fullname;
	 }
	public String makeCompanytype() {
        List<String> companytypes = Arrays.asList("택시", "호텔", "음식점");
           Collections.shuffle(companytypes);
           String companytype = companytypes.get(0);
        return companytype;
    }
	public String makeTelephone() {
        int a = 1111,b = 9999;
       BiFunction<Integer,Integer,Integer> f = (t,u)->(int)(Math.random()*(u-t))+t;
       int pre = f.apply(a,b);
       int af= f.apply(a,b);
       String tel = "010-"+String.valueOf(pre)+"-"+String.valueOf(af);
           return tel;
    }
	public String makeAddr() {
      List<String> faddr = Arrays.asList("서울시", "경기도", "대전광역시", "부산광역시", "강원도", "인천광역시");
      List<String> addr = Arrays.asList("XX동","XXXXX동","XXX동");
      BiFunction<Integer,Integer,Integer> f = (t,u)->(int)(Math.random()*(u-t))+t;
         Collections.shuffle(faddr);
         Collections.shuffle(addr);
         int a = 1111,b = 9999;
         int af= f.apply(a,b);
         String fulladdr = faddr.get(0)+addr.get(0)+String.valueOf(af);
      return fulladdr;
  }
	public String makeLicensenum() {
        int a = 11111,b = 99999;
       BiFunction<Integer,Integer,Integer> f = (t,u)->(int)(Math.random()*(u-t))+t;
       int pre = f.apply(a,b);
       int af= f.apply(a,b);
       String tel = String.valueOf(pre)+"-"+String.valueOf(af);
           return tel;
    }
	public Host makeHost(){
		 // uid,pwd,uname,birth,gender,tel,pettype;
		return new Host(makeHostid(),"1",makeHostname(),makeCeoname(),makeCompanytype(),makeTelephone(),makeAddr(),makeLicensenum());
	}
	@Transactional
	public void insertHost() {
		for(int i=0;i< 500;i++) {
			
			hostMapper.insertHost(makeHost());
		}
	}
//	public String makePdtName() {
//		List<String> fpdtName = Arrays.asList("또와유", "다시와유", "두번와유", "좋은", "기분좋은");
//		List<String> pdtName = Arrays.asList("호텔", "맛집", "관광지", "교통");
//         Collections.shuffle(fpdtName);
//         Collections.shuffle(pdtName);
//         String fullpdtName = fpdtName.get(0)+pdtName.get(0);
//      return fullpdtName;        
//    }
//	public String makePrice() {
//		int a = 11111,b = 99999;
//	       BiFunction<Integer,Integer,Integer> f = (t,u)->(int)(Math.random()*(u-t))+t;
//	       int pre = f.apply(a,b);
//	       int af= f.apply(a,b);
//	       String price = String.valueOf(pre)+String.valueOf(af)+"WON";
//	           return price;       
//    }
//    public String makeHostType() {
//    	List<String> companytypes = Arrays.asList("택시", "호텔", "음식점","관광");
//        Collections.shuffle(companytypes);
//        String companytype = companytypes.get(0);
//     return companytype;     
//    }
//    public String makeType() {
//		List<String> makeType = Arrays.asList("p", "r");
//         Collections.shuffle(makeType);
//         String makeTypes = makeType.get(0);
//      return makeTypes;         
//    }
    

}
