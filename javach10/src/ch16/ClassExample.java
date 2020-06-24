package ch16;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassExample {

	public static void main(String[] args) {
		Car car = new Car();
		//클래스 정보 얻기
		Class clazz = car.getClass();
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getPackage().getName());
		
		try {
			Class clazz2 = Class.forName("ch16.Car");
			System.out.println(clazz2.getName());
			System.out.println(clazz2.getSimpleName());
			System.out.println(clazz2.getPackage().getName());
			//reflection
			Constructor[] constructors = clazz.getDeclaredConstructors();
			for(int i=0;i<constructors.length;i++) {
			System.out.println(constructors[i].getName());
			System.out.println(constructors[i].getParameterCount());
			Class[] parameters = constructors[i].getParameterTypes();
		    for(int j=0;j<parameters.length;j++)
		    	System.out.println(parameters[j]);
			}
			//메소드
			Method[] methods = clazz.getDeclaredMethods();
			for(int i=0;i<methods.length;i++) {
				System.out.println(methods[i].getName());
				System.out.println(methods[i].getParameterCount());
				Class[] parameter = methods[i].getParameterTypes();
				for(int j=0;j<parameter.length;j++)
					System.out.println(methods[j]);
				System.out.println("------------------------------------");
			}
			//필드
			Field[] fields = clazz.getDeclaredFields();
			for(int i=0;i<fields.length;i++)
				System.out.println(fields[i].getType().getSimpleName()+","+fields[i].getName());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
class Car{
	//필드
	String model;
	//생성자
	public Car() {}
	public Car(String model) {
		this.model = model;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
}