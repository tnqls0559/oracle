package ch01;

import java.io.FileReader;
import java.io.IOException;

//문자단위 입력 Reader - FileReader
public class FileReaderExample {

	public static void main(String[] args) throws IOException {
		try(FileReader reader = new FileReader("c:\\tmp\\test.txt");){
		int c;
		while((c=reader.read())!=-1) {//reader.read() 리턴타입 정수, 입력된 값의 아스키 코드값
			System.out.println((char)c);
		}
	  }catch(Exception e) {}
	}
}
