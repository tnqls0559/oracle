package ch08_01;

public interface MyInterface {
  void method1();
  default void method2() {}//default메소드
  default void method3() {}//default메소드
  static void staticMethod() {}//static 실체메소드 -자바8추가
}

