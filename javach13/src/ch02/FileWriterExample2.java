package ch02;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileWriterExample2 {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in);
			FileWriter writer = new FileWriter("c:\\tmp\\test3.txt")) {
			while(true) {
				String line = scanner.nextLine();
				if(line.length()==0)break;
				writer.write(line, 0, line.length());
				writer.write("\r\n", 0, 2);
			}
			writer.close();
		//저장된 내용을 FileReader로 출력
			FileReader fr = new FileReader("c:\\tmp\\test3.txt");
			int c;
			while((c=fr.read())!=-1) {
				System.out.print((char)c);
			}
			fr.close();
		}catch (Exception e) {
			
		}
	}
}