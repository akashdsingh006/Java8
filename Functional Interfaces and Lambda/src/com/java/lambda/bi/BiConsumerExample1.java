package com.java.lambda.bi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerExample1 implements BiConsumer<List<Integer>, String> {

	@Override
	public void accept(List<Integer> t, String u) {
		
		System.out.println(u+"--"+ t );
	}
	
	public static void main(String[] args) {
		
		//Traditional Approach
		BiConsumer biConsumer = new BiConsumerExample1();
		biConsumer.accept(Arrays.asList("Virat,Gayle"), "Cricketer");
		
		
		//Using anonymous approach
		BiConsumer biConsumer2 = new BiConsumer<String, String>() {
			public void accept(String s1,String s2) {
				System.out.println(s1+"-"+s2);
			}
		};
		biConsumer2.accept("Akash", "Jatt");

		
		//Using Lambda expression
		BiConsumer<List<String>,String> biconsumerLambda = ((list,val)->{long count= list.stream().filter(lival -> lival.equalsIgnoreCase(val)).count();
		System.out.println(count);
		});
		biconsumerLambda.accept(Arrays.asList("A","B","C","A","C","D","a"), "A");
		
		
		//Real Life Example
		
		Map<String,String> map = new HashMap<>();
		map.put("Virat", "Kohli"); map.put("Chris", "Gayle");
		
		map.forEach(biConsumer2);
	}

	

}
