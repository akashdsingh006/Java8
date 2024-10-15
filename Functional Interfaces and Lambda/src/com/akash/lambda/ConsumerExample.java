package com.akash.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//USing anonymous example
//		Consumer consumer = new Consumer() {
//			public void accept(Object ob) {
//				System.out.println("Accepted" + ob);
//			}
//		};
//		
//		consumer.accept(10);
		
		
		Consumer consumer = (obj)->System.out.println("accepted" +obj);
		consumer.accept(1201);
		
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		//list.stream().forEach(consumer);
		list.stream().forEach((obj)->System.out.print(" Accepted....."+obj));
	}

}
