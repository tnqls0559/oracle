package ch01;

import java.io.FileReader;
import java.util.Scanner;

public class FileOutputExample {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("읽을 파일은?");
		String fileName = scanner.nextLine();
		try {
			int i=0;
			FileReader fr = new FileReader(fileName);
			while((i=fr.read())!=-1) {
				System.out.print((char)i);
			}
			fr.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
