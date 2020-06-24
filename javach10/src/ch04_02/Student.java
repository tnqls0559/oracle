package ch04_02;

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
		Student cloned = (Student)super.clone();
		cloned.scores=new int[this.scores.length];
		for(int i=0;i<this.scores.length;i++) {
			cloned.scores[i]=this.scores[i];
		}
		return cloned;
	}
	public Student getStudent(){
		Student original=null;
		try {
		original=(Student) this.clone();
	  }catch(CloneNotSupportedException e) {
		  e.getStackTrace();
	  }
		return original;
	}
}
