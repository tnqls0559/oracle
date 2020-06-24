package ch09;

import java.util.function.BinaryOperator;

public class OperatorMinByMaxByExample {

	public static void main(String[] args) {
		BinaryOperator<Fruit> binaryOperator;
		Fruit fruit;
		binaryOperator = BinaryOperator.minBy((o1, o2)->Integer.compare(o1.getPrice(),o2.getPrice()));
		
		fruit = binaryOperator.apply(new Fruit("사과",6000), new Fruit("수박",10000));
		System.out.println("결과:"+fruit.getName()+","+fruit.getPrice());
		
		binaryOperator = BinaryOperator.maxBy((o1, o2)-> o1.getPrice()-o2.getPrice());
		                // o1.getPrice()<o2.getPrice()?-1:o1.getPrice()>o2.getPrice()?1:0);
		fruit = binaryOperator.apply(new Fruit("사과",6000), new Fruit("수박",10000));
		System.out.println("결과:"+fruit.getName()+","+fruit.getPrice());
	}
}
class Fruit{
	String name;
	int price;
	
	public Fruit(String name, int price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
}