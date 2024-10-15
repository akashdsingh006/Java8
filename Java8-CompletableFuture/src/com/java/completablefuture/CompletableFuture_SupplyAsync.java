package com.java.completablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import com.java.Objects.Employee;

public class CompletableFuture_SupplyAsync {

	public static void main(String[] args) {

		
		try {
			fetchEmployeeList();
			fetchEmployeeListWithCustomExecutor();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Runs on Thread :ForkJoinPool.commonPool
	private static List<Employee> fetchEmployeeList() throws InterruptedException, ExecutionException {

		CompletableFuture<List<Employee>> supplyAsync = CompletableFuture.supplyAsync(new Supplier() {
			public List<Employee> get() {
				System.out.println("Thread :" + Thread.currentThread().getName());
				return getEmployees();
			}
		});

		return supplyAsync.get();
	}

	//Runs on Custom Thread Pool
	private static List<Employee> fetchEmployeeListWithCustomExecutor() throws InterruptedException, ExecutionException {

		Executor executor = Executors.newFixedThreadPool(5);
		CompletableFuture<List<Employee>> supplyAsyncLambda = CompletableFuture.supplyAsync(() -> {
			System.out.println("Thread :" + Thread.currentThread().getName());
			return getEmployees();

		}, executor);

		return supplyAsyncLambda.get();
	}

	protected static List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			employees.add(new Employee(i, "employee" + i, i * 900.0));
		}
		return employees;
	}
}
