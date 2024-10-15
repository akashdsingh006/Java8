package com.java.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.java.Objects.Employee;

public class Stream_SortList2_Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> list = Arrays.asList(new Employee(1, "Akash", 720.55), new Employee(2, "Karan", 853.25),
				new Employee(3, "Ballu", 475.93), new Employee(0, "Gopal", 780.235));
		
		//Sorting using stream and method referencing with Comparator - ascending
		//list.stream().sorted(Comparator.comparing(Employee::getEmployeeSalary)).forEach(emp->System.out.println(emp));
		
		//Sorting using stream and method referencing with Comparator - descending
		//list.stream().sorted(Comparator.comparing(Employee::getEmployeeName).reversed()).forEach(emp->System.out.println(emp));
		
		
		//Sorting using Collections and comparator
		//Collections.sort(list, (a,b)->b.getEmployeeId()-a.getEmployeeId());
		
		//Sorting using Collection and comparator method ref
		//Collections.sort(list, Comparator.comparing(Employee::getEmployeeSalary).reversed());
		
		
		list.forEach(emp->System.out.println(emp));
	}

}
