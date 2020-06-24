package ch01;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InetAddressExample2 {

	public static void main(String[] args) throws UnknownHostException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("ip를 확인할 도메인?");
		String url = scanner.nextLine();
		//상대 ip 도메인과 주소 매칭정보 얻기 InetAddress
		InetAddress ia = InetAddress.getByName(url);
		System.out.println(url+": "+ia.getHostAddress());
	}
}
