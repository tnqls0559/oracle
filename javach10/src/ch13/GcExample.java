package ch13;

public class GcExample {
	public static void main(String[] args) {
		Employee emp;
		emp = new Employee(1);
		emp=null;
		emp = new Employee(2);//2번 객체가 연결이 끊어지고
		emp = new Employee(3);//3번 객체와 연결
		
		System.out.println("emp가 최종적으로 참조하는 사원번호:");
		System.out.println(emp.eno);
		System.gc();//쓰레기 수집기 실행 요청 -보통때보다는 빠를 수 있을걸.
	}
}
class Employee{
	public int eno;
	public Employee(int eno) {
		this.eno = eno;
		System.out.println("Employee("+eno+") 가 메모리에서 생성됨");
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Employee("+eno+") 이 메모리에서 제거됨");
	}
}