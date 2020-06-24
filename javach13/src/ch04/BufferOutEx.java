package ch04;

import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.util.Scanner;

public class BufferOutEx {

	public static void main(String[] args) {
		try(FileReader fr = new FileReader("c:\\tmp\\test5.txt");
				BufferedOutputStream bos = new BufferedOutputStream(System.out,5)){
			Scanner scanner = new Scanner(System.in);
			int c;
			while((c=fr.read())!=-1) {//read() 리턴값은 읽은 값을 그대로 리턴
				bos.write(c);
			}
			System.out.println(scanner.nextLine());
			bos.flush();//BufferedStream에 남아있는 데이터를 밀어내기처리
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
