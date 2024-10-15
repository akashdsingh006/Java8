package com.java.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Streams_SortMap1 {

	public static void main(String[] args) {
		
		Map<String, Integer> map =new HashMap<>();
		map.put("Virat", 87);
		map.put("Rohit" ,36);
		map.put("Gambhir", 91);
		map.put("Yuvraj", 52);
		
		//Creating a list of entry set
		List<Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
		
		//Using basic version of Comparator i.e. anonymous class
		//Collections.sort(entryList, new Comparator<>() {
		//	public int compare(Entry<String, Integer> e1 , Entry<String, Integer> e2) {
		//		//return (int)e1.getKey().compareTo(e2.getKey()); // sorting using key
		//		return (int)e1.getValue()-e2.getValue();
		//	}
		//});

		//Sorting map using entry set and comparator with lambda - descending
		//Collections.sort(entryList, (e1,e2)->e2.getValue() - e1.getValue()); 
//		System.out.println(entryList);
		
		//Using streams to sort map by key - ascending   
		//map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		
		//Using streams to sort map by key - descending
		map.entrySet().stream().sorted(Map.Entry.comparingByKey((e1,e2)->e2.compareTo(e1))).forEach(System.out::println);
		
	}

}
