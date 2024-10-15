package com.java.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Streams_SortList1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(9,3,64,46,9,35,31,46,46,31,9,65,26,56,-8,46,56,41,64);
		
		list.stream().sorted().forEach(a->System.out.print(a+ " ,"));
		
		
		System.out.println();
		list.stream().sorted(new Comparator<Object>() {
			public int compare(Object a, Object b) {
				return (Integer)a - (Integer)b;
			}
		}).forEach(a->System.out.print(a+ " ,"));
		
		System.out.println();
		list.stream().sorted((a,b)->Integer.compare(b, a)).forEach(a->System.out.print(a+ " ,"));
		
		//Collections.sort(list,(a,b)->Integer.compare(b, a));
		System.out.println();
		list.stream().sorted(Comparator.reverseOrder()).forEach(a->System.out.print(a+ " ,"));
	}

}
