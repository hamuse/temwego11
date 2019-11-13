package com.wego.web.pxy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wego.web.admin.AdminMapper;

@Component("garam")
public class AdminProxy extends Proxy{
	@Autowired AdminMapper adminMapper;
//	eid,pwd,aname,addr,tel,pos,dep,privilege
	public String makeEid() {
		List<String> eidText = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "n", "m", "o",
                "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "0");
		Collections.shuffle(eidText);
		String eids = "";
		for(int i = 0; i <6; i++) {
		 eids += eidText.get(i);
		}
		return eids;
	}
	public String makePwd() {
		return "1";
	}
	public String makeAname() {
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
		    String sName = "";
		    for(int i = 0; i<2;i++) {
		    	sName += name.get(i);	
		    }
		    String fullname = fname.get(0)+sName;
		return fullname;
	}
	public String makeAddr() {
		List<String> fAddr = Arrays.asList("서울시","인천시","일산시","대구시","창원시","마산시","광주시","순천시","이천시");
	    List<String> sAddr = Arrays.asList("중앙동","화곡동","평일동","미진동","사립동");
	    List<String> tAddr = Arrays.asList("0","1","2","3","4","5","6","7","8","9");
		Collections.shuffle(fAddr);
		Collections.shuffle(sAddr);
		Collections.shuffle(tAddr);
	    String tAddr1 = "";
	    String tAddr2 = "";
		for(int i = 0 ; i < 2;i++) {
			tAddr1 += tAddr.get(i);
			tAddr2 += tAddr.get(i+1); 
		}
		String tAddr3 = tAddr1 + tAddr2;
		String addrText = fAddr.get(0)+sAddr.get(0)+tAddr3;
	    return addrText;
	}
	public String makeTel() {
		return "";
	}
	public String makePos() {
		return "";
	}
	public String makeDep() {
		return "";
	}
	public String makePrivilege() {
		return "";
	}
}
