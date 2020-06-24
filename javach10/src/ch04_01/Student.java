package ch04_01;

import java.util.Arrays;

public class Student implements Cloneable{
	String name;
	int[] scores;
	public Student(String name, int[] scores) {
		super();
		this.name = name;
		this.scores = scores;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", scores=" + Arrays.toString(scores) + "]";
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	public Student getStudent() {
		Student original=null;
		try {
		original=(Student) this.clone();
	  }catch(CloneNotSupportedException e) {
		  e.getStackTrace();
	  }
		return original;
	}
}
