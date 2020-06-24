package ch03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class CalcServerEx {
	public static String calc(String exp) {
		StringTokenizer st = new StringTokenizer(exp," ");
		if(st.countTokens()!=3) return "error";
		int op1 = Integer.parseInt(st.nextToken());
		String opcode = st.nextToken();
		int op2 = Integer.parseInt(st.nextToken());
		String res="";
		switch(opcode) {
		case "+": res = Integer.toString(op1+op2);
			break;
		case "-": res = Integer.toString(op1-op2);
			break;
		case "*":res = Integer.toString(op1*op2);
			break;
		default: res = "error";
		}
		return res;
	}

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		try {
			listener = new ServerSocket(9998);
			System.out.println("연결을 기다립니다.");
			socket = listener.accept();
			//통신
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				String inputMessage = in.readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트에서 종료 메세지...");
					break;
				}
				System.out.println(inputMessage);
				String res=calc(inputMessage);
				out.write(res+"\n");//연산결과
				out.flush();
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(socket!=null) socket.close();
				if(listener!=null) listener.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
