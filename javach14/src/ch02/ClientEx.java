package ch02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		try {
			//소켓생성
			socket = new Socket("172.30.1.37",9999);
			//스트림 생성
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			//대화작업
			while(true) {
				System.out.println("보내기>>");
				String outputMessage = scanner.nextLine();//한 줄 단위로 입력받기
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage+"\n");//서버로 종료메세지 보내고
					out.flush();//버퍼비우기
					break;//종료
				}
				out.write(outputMessage+"\n");//한 줄 읽어들이도록 전송
				out.flush();//버퍼비우기 
				String inputMessage = in.readLine();//서버로부터 전달되어 메세지를 한 줄씩 읽기
				System.out.println("서버:"+inputMessage);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				scanner.close();
				if(socket!=null) socket.close();//클라이언트 소켓해제
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}