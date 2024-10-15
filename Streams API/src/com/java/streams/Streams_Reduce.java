package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.Objects.Employee;

public class Streams_Reduce {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(5,8,6,3,4,7,9,2,41,10);
		List<String> words = Arrays.asList("India","Austrailia","New Zealand","USA");
		
		//Using reduce in stream to perform add
		Integer reduceSum = numbers.stream().reduce(0,(a,b)->a+b);
		System.out.println(reduceSum);
		
		
		//Using method reference to perform add which returns an Optional
		Integer reduceUsingMethodReference = numbers.stream().reduce(Integer::sum).orElseGet(()->0);
		System.out.println(reduceUsingMethodReference);
		
		
		//Using method reference to maximum number in list which returns Optional
		Integer reduceGetMax = numbers.stream().reduce(Integer::max).orElseGet(()->Integer.MIN_VALUE);
		System.out.println(reduceGetMax);
		
		
		//Using reduce to find largest string which returns Optional
		String longerString = words.stream().reduce((w1,w2)->w1.length() > w2.length()? w1:w2).get();
		System.out.println(longerString);
		
		
		//Filtering employee of Grade A and finding their avg salary
		//using multiple methods
		List<Employee> employees = getEmployeesList();
		double averageSalary = employees.stream().filter(employee -> employee.getEmployeeName().equals("A"))
				.map(emp -> emp.getEmployeeSalary()).mapToDouble(sal -> sal).average().getAsDouble();
		
		System.out.println(averageSalary);
	}
	
	private static List<Employee> getEmployeesList(){
		return Stream.of(new Employee(1, "A", 892.2), new Employee(2, "B", 2165.54),new Employee(6, "C", 871.5),
				new Employee(5, "A", 552.29),new Employee(9, "A", 482.89),new Employee(7, "A", 278.65)).collect(Collectors.toList());
	}

}
