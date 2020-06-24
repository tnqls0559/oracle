package ch18;

import java.io.IOException;

public class KeyboardToStringExample {
	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[100];
		
		System.out.println("입력:");
		//read(배열)의 리턴값은 저장된 배열의 길이, byte값들은 bytes배열에 저장
		int readByteNo = System.in.read(bytes);
		String str = new String(bytes,0,readByteNo-2);
		System.out.println(str);
	}
}
