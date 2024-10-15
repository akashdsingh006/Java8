package com.java.streams;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import com.java.Objects.Employee;

public class Streams_SortMap2_Object {

	public static void main(String[] args) {

		Map<Employee, Integer> map = new TreeMap<>((e1,e2)->e2.getEmployeeName().compareTo(e1.getEmployeeName()));//Sorting descending

		map.put(new Employee(1, "Akash", 720.55), 24);
		map.put(new Employee(2, "Karan", 853.25), 13);
		map.put(new Employee(3, "Ballu", 475.93), 33);
		map.put(new Employee(0, "Gopal", 780.235), 73);

		//System.out.println(map);
		
		//Sorting map using Comparator of Employee on salary - descending
		//map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getEmployeeSalary).reversed())).forEach(System.out::println);
		
		
		//Sorting map using Comparator of Value reverse order - descending
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);
	}

}
