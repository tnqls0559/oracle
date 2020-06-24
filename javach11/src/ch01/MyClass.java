package ch01;

//객체 저장용
public class MyClass<T> {//제네릭클래스 타입매개변수 T
   T val;//val의 타입 T
   void set(T a) {//T타입의 값 저장
	   val = a;
   }
   T get() {//리턴타입 T
	   return val;
   }
}
