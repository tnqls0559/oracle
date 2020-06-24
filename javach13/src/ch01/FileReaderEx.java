package ch01;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {

	public static void main(String[] args) {
		FileReader fin = null;
		try {
			/*fin = new FileReader("c:\\windows\\System.ini");*/
			fin = new FileReader("c:\\tmp\\test2.txt");
			int c;
			while((c = fin.read())!=-1) {//한 문자씩 파일 끝까지
				System.out.print((char)c);//casting출력
			}
		  fin.close();
		}
		catch(IOException e) {
			System.out.println("입출력 오류");
		}
	}
}
