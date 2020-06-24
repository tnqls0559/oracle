package ch08;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue<Message> messageQue = new LinkedList<>();
		//queue에 객체 저장 offer(객체)
		messageQue.offer(new Message("sendMail","홍길동"));
		messageQue.offer(new Message("sendSMS","일지매"));
		messageQue.offer(new Message("sendKaTok","임꺽정"));
		//객체 꺼낼때 poll();
		while(!messageQue.isEmpty()) {
			Message message = messageQue.poll();//제일 앞의 객체얻기
			switch(message.commend) {
			case "sendMail":
				System.out.println(message.to+"님에게 메일 전송");
			   break;
			case "sendSMS":
				System.out.println(message.to+"님에게 SMS 전송");
			   break;
			case "sendKaTok":
				System.out.println(message.to+"님에게 카톡 전송");
			   break;
			
			}
		}
	}
}
class Message{
	public String commend;
	public String to;
	
	public Message(String commend, String to) {
		this.commend = commend;
		this.to = to;
	}
}