package ch01_06;

public class A {
    int field1;
    static int field2;
    void method1() {}
    static void method2() {}
    
    static class C{//static멤버로 선언된 클래스 내부에서 바깥쪽 멤버에 접근시 
    	void method() {
    		//field1=2;//인스턴스 멤버는 접근불가
    		field2=10;//static멤버는 접근가능
    		//method1();
    		method2();
    	}
    }
}
