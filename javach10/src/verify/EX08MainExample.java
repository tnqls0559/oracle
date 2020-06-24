package verify;

import java.util.StringTokenizer;

public class EX08MainExample {

	public static void main(String[] args) {
		String str = "아이디,이름,패스워드";
		//String[] 변수 = str.split("구분자");
		String[] strs = str.split(",");
		for(int i=0;i<strs.length;i++)
			System.out.println(strs[i]);
		
		StringTokenizer stk = new StringTokenizer(str,",");
		while(stk.hasMoreElements()){
			System.out.println(stk.nextElement());
		}
	}
}
