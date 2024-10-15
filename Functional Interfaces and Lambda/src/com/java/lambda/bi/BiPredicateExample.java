package com.java.lambda.bi;

import java.util.function.BiPredicate;

public class BiPredicateExample {

	public static void main(String[] args) {
		
		
		BiPredicate biPredicate = ((s1,s2)->s1.equals(s2));
		
		System.out.println(biPredicate.test("akash", "akash"));
		
		BiPredicate<String,String> biPredicateLength = (s1,s2) -> s1.length()==s2.length();
		boolean output = biPredicateLength.and(biPredicate).test("raman", "naman");
		System.out.println(output);
	}

}
