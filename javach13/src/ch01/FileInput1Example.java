package ch01;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInput1Example {

	public static void main(String[] args) throws IOException {
		BufferedReader br 
		     = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("파일명?");
		String fileName = br.readLine();
		System.out.println("저장 할 내용>");
		String content = br.readLine();
		
		FileWriter fw = new FileWriter(fileName);
		fw.write(content);
		fw.close();
		br.close();
		System.out.println("저장성공");
	}
}
