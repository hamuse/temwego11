package wego;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public class TestAlgorithm {

	public static void main(String[] args) {
		List<String> fAddr = Arrays.asList("서울시","인천시","일산시","대구시","창원시","마산시","광주시","순천시","이천시");
	    List<String> sAddr = Arrays.asList("중앙동","화곡동","평일동","미진동","사립동");
	    List<String> tAddr = Arrays.asList("0","1","2","3","4","5","6","7","8","9");
		Collections.shuffle(fAddr);
		Collections.shuffle(sAddr);
		Collections.shuffle(tAddr);
	    String tAddr1 = "";
	    String tAddr2 = "";
		for(int i = 0 ; i < 3;i++) {
			tAddr1 += tAddr.get(i);
			tAddr2 += tAddr.get(i+1); 
		}
		String tAddr3 = tAddr1 +"-"+ tAddr2;
		String addrText = fAddr.get(0)+sAddr.get(0)+tAddr3;
	    System.out.println(addrText);
	}

}
