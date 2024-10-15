package com.akash.functionalinterfaces;

/*
 * Functional interface where the method does  not return any value
 */
@FunctionalInterface
public interface MyInterface{
	void sum(int a,int b);
}

public class FunctionalInterface1 {

	public static void main(String[] args) {
		
		//Normal way using Anonymous Class
		MyInterface mi = new MyInterface() {
			
			@Override
			public void sum(int a, int b) {
				System.out.println(a+b);
			}
		};
		
		mi.sum(10, 20);
	}

}
