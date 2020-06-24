package ch01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress ia1 = InetAddress.getByName("www.choongang.co.kr");//이름
		System.out.println(ia1.getHostAddress());//주소
		
		InetAddress ia2 = InetAddress.getByName("172.30.1.9");//주소//35.213.149.53
		System.out.println(ia2.getHostName());//이름
	}
}
