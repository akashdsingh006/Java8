package com.java.interviewquestions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class NthHighestSalary {

	public static void main(String[] args) {
		 Map<String, Integer> salaryMap = new HashMap<>();
		 salaryMap.put("Akash",1500);
		 salaryMap.put("Manan",1450);
		 salaryMap.put("Rohit",1700);
		 salaryMap.put("Rahul",1500);
		 salaryMap.put("Komal",1500);
		 salaryMap.put("Ganesh",1400);
		 salaryMap.put("Himesh",1700);
		 salaryMap.put("Jagan",1700);
		 salaryMap.put("Kanun",1400);
		 
		 //Employees having salaries and Nth salary
		 
			Entry<Integer, List<String>> nthSalary = salaryMap.entrySet().stream()
					.collect(Collectors.groupingBy(Map.Entry::getValue,
							Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
					.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey, Comparator.reverseOrder()))
					.collect(Collectors.toList()).get(2);
		 
			System.out.println(nthSalary);
		 
	}

}
