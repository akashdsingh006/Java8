package com.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_ForEach_Filter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,89,8,69);
		
		list.stream().forEach((t)-> System.out.println(t)); //Consumer
		list.stream().forEach(t->{t=t/2; System.out.print(t+" ,");});
		
		list.stream().filter(i-> i>5).collect(Collectors.toList()).forEach(System.out::println);
	}

}
