package ch06;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class ConsumerExample {

	public static void main(String[] args) {
		Consumer<String> consumer = new Consumer<String>() {

			@Override
			public void accept(String t) {
			    System.out.println(t+8);	
			}
		};
		consumer.accept("자바");
		consumer= t->System.out.println(t+8);
		consumer.accept("자바");
		
		BiConsumer<String, String> bigConsumer = (t,u)-> System.out.println(t+u);
		bigConsumer.accept("자바","8");
		
		DoubleConsumer doubleConsumer 
		= (x)-> System.out.println("java"+x);
		doubleConsumer.accept(8.0);
			
		/*ObjIntConsumer<String> objIntConsumer 
		= (t,i)-> System.out.println(t+i);
			ObjIntConsumer.accept("Java",8);*/
	
		}
	
	}
