package com.java.completablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFuture_MethodsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			sendEmailService();
		} catch (InterruptedException | ExecutionException e) {
			
		}
	}
	
	private static List<Employee> getEmployees(){
		List<Employee> employeeList= new ArrayList<>();
		for(int i=0;i<1000;i++) {
			employeeList.add(new Employee((long)i+1, "Employee"+i,"email"+i+"@gmail.com", "Somewhere"+i*5.1, i%2==0?true:false, i%5==0?false:true));
		}
		return employeeList;
	}
	
	private static void sendEmailService() throws InterruptedException, ExecutionException {
		Executor executor = Executors.newFixedThreadPool(10);
		CompletableFuture<Void> employeeResult = CompletableFuture.supplyAsync(() -> {
			System.out.println("Fetching Employees :" + Thread.currentThread().getName());
			return CompletableFuture_MethodsExample.getEmployees();
		}, executor).thenApplyAsync(employees -> {
			System.out.println("Filtering based on New Joinee:" +Thread.currentThread().getName());
			return employees.stream().filter(emp -> emp.getIsNewJoinee()).collect(Collectors.toList());
		}, executor).thenApplyAsync(newJoinedEmployees -> {
			System.out.println("Filtering based on Trainings Completed :" +Thread.currentThread().getName());
			return newJoinedEmployees.stream().filter(employee -> !employee.getCompletedTrainings())
					.collect(Collectors.toList());
		}, executor).thenApplyAsync(stillPendingTrainingEmployees -> {
			System.out.println("Getting emails on employees :" +Thread.currentThread().getName());
			return stillPendingTrainingEmployees.stream().map(employee -> employee.getEmail())
					.collect(Collectors.toList());
		}, executor).thenAcceptAsync(employeesToBeNotified ->{ 
			System.out.println("Sending emails :" +Thread.currentThread().getName());
			employeesToBeNotified
				.forEach(employeeEmail -> System.out.println("Sending email :" + employeeEmail));
		});

		employeeResult.get();
		((ExecutorService)executor).shutdown();
	}
}
