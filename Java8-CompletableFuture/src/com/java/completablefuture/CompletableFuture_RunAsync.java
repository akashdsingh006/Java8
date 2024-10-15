package com.java.completablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.java.Objects.Employee;

public class CompletableFuture_RunAsync {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		CompletableFuture_RunAsync runAsync = new CompletableFuture_RunAsync();
		
		runAsync.saveEmployees();
		runAsync.saveEmployeesWithCustomExecutor();
	}
	
	//Runs on ForkJoinPool.commonPool
	private Void saveEmployees() throws InterruptedException, ExecutionException {
		
		List<Employee> employees = new ArrayList<>();
		
		CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(new Runnable() {
			public void run() {
				for(int i=0;i<1000;i++) {
					employees.add(new Employee(i, "employee"+i, i*900.0));
				}
				
				System.out.println(Thread.currentThread().getName());
				//do something to persist the employee data
				System.out.println(employees.size());
			}
		});
		
		//returning Void type CompletableFuture
		return runAsyncFuture.get();
	}
	
	//Runs on Custom Thread Pool
	private Void saveEmployeesWithCustomExecutor() throws InterruptedException, ExecutionException {
		List<Employee> employees = new ArrayList<>();
		Executor executor = Executors.newFixedThreadPool(10);
		
		CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
			for(int i=0;i<1000;i++) {
				employees.add(new Employee(i, "employee"+i, i*900.0));
			}
			
			//do something to persist the employee data
			System.out.println(Thread.currentThread().getName());
			System.out.println(employees.size());
		}, executor);
		
		
		return future.get();
	}
}
