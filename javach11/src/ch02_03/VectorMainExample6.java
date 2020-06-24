package ch02_03;

import java.util.Vector;

public class VectorMainExample6 {

	public static void main(String[] args) {
		BoardTest vt = new BoardTest();
		//백터 객체 생성
		Vector<Board> v = new Vector<>();
		//값 저장
		v.add(new Board("제목1","내용1","글쓴이1"));
		v.add(new Board("제목2","내용2","글쓴이2"));
		v.add(new Board("제목3","내용3","글쓴이3"));
		//메소드의 매개변수로 전달
		vt.printVector(v);
	}
}
class BoardTest{
	//메소드의 매개변수가 콜렉션인 경우
	public void printVector(Vector<Board> v) {//[Board][Board][Board]
		for(int i=0;i<v.size();i++) {
			Board b=v.get(i);
			System.out.println(b);
		}
	}
}