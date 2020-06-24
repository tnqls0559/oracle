package ch02_03;

import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class VectorMainExample3 {

	public static void main(String[] args) {
		List<Board> list = new Vector<Board>();
		list.add(new Board("제목1","내용1","글쓴이1"));
		Board b = new Board("제목2","내용2","글쓴이2");
		list.add(b);
		list.add(new Board("제목3","내용3","글쓴이3"));
		list.add(new Board("제목4","내용4","글쓴이4"));
		b = new Board("제목5","내용5","글쓴이5");
		list.add(b);
		
		for(int i=0;i<list.size();i++) {
			Board b1 = list.get(i);
			System.out.println(b1);
		}
		System.out.println(list.contains(new Board("제목3","내용3","글쓴이3")));
	}
}
class Board{
	String subject;
	String content;
	String writer;
	
	public Board(String subject, String content, String writer) {
		super();
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "Board [subject=" + subject + ", content=" + content + ", writer=" + writer + "]";
	}
	@Override
	public int hashCode() {
		//return subject.hashCode()+content.hashCode()+writer.hashCode();
		return Objects.hash(subject,content,writer);
	}
	@Override
	public boolean equals(Object obj) {
		return subject.equals(((Board)obj).subject)&
			   content.equals(((Board)obj).content)&
			   writer.equals(((Board)obj).writer);
	}
}