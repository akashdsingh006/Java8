package com.akash.functionalinterfaces;

/*
 * Functional returns a value
 */
@FunctionalInterface
public interface MyInterface2{
	public abstract double divide(double a, double b);
}
public class FunctionalInterface2 {

	public static void main(String[] args) {
		
		MyInterface2 mi = new MyInterface2() {
			@Override
			public double divide(double a, double b) {
				return (double)a/b;
			}
		};
		
		System.out.println(mi.divide(12.5, 3.78));
	}

}
