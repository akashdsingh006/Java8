package com.akash.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Predicate<Integer> predicate = new Predicate<Integer>() {
//			public boolean test(Integer t) {
//				return t>10?true:false;
//			}
//		}; 
		
		Predicate predicate =( i)->{return(Integer) i>5 ? true:false ;};
		
		//System.out.println(predicate.test(9));
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		list.stream().filter(predicate).forEach(System.out::println);
		
	}

}
