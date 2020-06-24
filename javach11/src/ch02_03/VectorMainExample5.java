package ch02_03;

import java.util.Vector;

public class VectorMainExample5 {

	public static void main(String[] args) {
		VectorTest vt = new VectorTest();
		//백터 객체 생성
		Vector<Integer> v = new Vector<>();
		//값 저장
		v.add(10); v.add(20); v.add(30);
		//메소드의 매개변수로 전달
		vt.printVector(v);
	}
}
class VectorTest{
	//메소드의 매개변수가 콜렉션인 경우
	public void printVector(Vector<Integer> v) {
		for(int i=0;i<v.size();i++) {
			int n=v.get(i);
			System.out.println(n);
		}
	}
}