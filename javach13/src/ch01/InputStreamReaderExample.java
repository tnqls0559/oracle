package ch01;

import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderExample {

	public static void main(String[] args) throws IOException {
		//byte단위의 스트림을 2byte 단위의 Reader로 변환
		InputStreamReader reader = new InputStreamReader(System.in);
		//read()리턴타입 int, 더이산 입력된 문자가 없으면 -1을 리턴
		int c;
		while((c=reader.read())!=-1) {	
		//int c = reader.read();
		System.out.println((char)c);
	  }
	}
}
