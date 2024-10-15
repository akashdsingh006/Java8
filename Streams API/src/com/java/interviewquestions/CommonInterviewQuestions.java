package com.java.interviewquestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CommonInterviewQuestions {

	public static void main(String[] args) {

		// Print count of each character in a string
		String str = "ilovemyindia";
		Map<String, Long> charMap = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		System.out.println(charMap);

		// Print duplicate characters
		String str2 = "chalchaljindiyeey";
		List<String> dupList = Arrays.stream(str2.split(""))
				.collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream()
				.filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(dupList);

		
		// First non-repeating element
		String s1 = "indiaismycountry";
		String noRepeatingElement = Arrays.stream(s1.split(""))
				.collect(Collectors.groupingBy(s -> s,LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() == 1).findFirst().get().getKey();
		
		System.out.println(noRepeatingElement);

		
		//Second highest number
		int[] arr= {15,6,9,78,21,5,81,87,23,45,697};
		
		int secondHighest = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(secondHighest);
		
		
		//Find longest string in given array:
		String[] s= {"hello","this","is","stream","from","java8"};
		//String longestString = Arrays.stream(s).sorted((st1,st2)->st2.length() - st1.length()).findFirst().get();
		String longestString = Arrays.stream(s).reduce((w1,w2)->w1.length() > w2.length()? w1:w2).get();
		System.out.println(longestString);
		
		
		//To find element who starts with 1
		long numbers[]= {141,38,66,119,41,88,15,21,16,35,48,11,53,78,49,18,47,99};
		List<Long> startsWith1 = Arrays.stream(numbers).boxed().filter(num-> num.toString().startsWith("1")).collect(Collectors.toList());
		System.out.println(startsWith1);
	
	}

}
