package verify;

import java.util.HashMap;

public class EX03MainExample {
	public static void main(String[] args) {
		HashMap<Student,String> hashMap = new HashMap<Student,String>();
		hashMap.put(new Student("1"), "95");
		String score = hashMap.get(new Student("1"));
		System.out.println("1번 학생의 총 점:"+score
				);
		
		
		
	}
}
class Student{
	private String studentNum;

	public Student(String studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	//논리적 동등,hashCode,equals()
	@Override
	public int hashCode() {
		return studentNum.hashCode();//String의 hashCode는 내용이 같으면 같은 hashCode
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			return studentNum.equals(((Student)obj).getStudentNum());
		}else
			return false;
	}
}