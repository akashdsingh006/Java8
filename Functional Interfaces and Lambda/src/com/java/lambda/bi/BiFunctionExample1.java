package com.java.lambda.bi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiFunctionExample1 implements BiFunction<List<Integer>, List<Integer>, List<Integer>>{
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Traditional Approach - implementing Interface
		BiFunction biFunction = new BiFunctionExample1();
		System.out.println(biFunction.apply(Arrays.asList(1,2,3,6,4,9,9,4,6,4,54,6,5), Arrays.asList(87,45,12,21,65,9,2,2,6)));
		
		
		//Using anonymous class approach
		 BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction2 = new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {
			
			@Override
			public List<Integer> apply(List<Integer> list1, List<Integer> list2) {
				return Stream.of(list1,list2)
						.flatMap(List::stream)
						.distinct()
						.sorted(Comparator.reverseOrder())
						.collect(Collectors.toList());			}
		};
		
		
		//Using Lambda expression
		 BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunctionLambda = ((l1,l2)->Stream.of(l1,l2)
						.flatMap(List::stream)
						.distinct()
						.sorted(Comparator.reverseOrder())
						.collect(Collectors.toList()));
				
		
		 
		//Real Life Example......................
		Map<String,Integer> map =new HashMap<>();
		map.put("Akash", 5000); map.put("Raman", 7000); map.put("Kailash", 3600);
		
		BiFunction<String, Integer, Integer> biMap = ((key,val)->val+500);
		//Accepts BiFunction
		map.replaceAll(biMap); 
		System.out.println(map);
		
	}

	@Override
	public List<Integer> apply(List<Integer> list1, List<Integer> list2) {
		return Stream.of(list1,list2)
		.flatMap(List::stream)
		.distinct()
		.sorted(Comparator.reverseOrder())
		.collect(Collectors.toList());
	}

}
