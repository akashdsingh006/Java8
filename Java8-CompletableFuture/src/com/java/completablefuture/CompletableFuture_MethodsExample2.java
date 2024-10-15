package com.java.completablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/*
 * 1. combine dependent future (2)
 * 2. combine independent future (2)
 * 3. combine multiple futures
 * 4. combine multiple future (no need to wait for all to finish)
 */
public class CompletableFuture_MethodsExample2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 1. combine dependent future (2) -thenCompose()
		
		CompletableFuture<Integer> thenComposeAsync = findEmployee().thenComposeAsync(CompletableFuture_MethodsExample2::getRatings);
		System.out.println(thenComposeAsync.get());
		
/*-------------------------------------------------------------------------------------------------------------------------------------*/
		
		// 2. combine independent future (2) - thenCombine()
		CompletableFuture<Map<String, Long>> genderMapAsync = CompletableFuture.supplyAsync(()->{
			return getEmployees().stream().collect(Collectors.groupingBy(Employee::getGender , Collectors.counting()));
		});
		CompletableFuture<List<String>> emailListAsync = CompletableFuture.supplyAsync(()->{
			return getEmployees().stream().map(emp->emp.getEmail()).collect(Collectors.toList());
		});
		
		CompletableFuture<String> thenCombineAsync = genderMapAsync.thenCombineAsync(emailListAsync, (empGender, emailList)->empGender+" "+emailList,Executors.newFixedThreadPool(5));
		System.out.println(thenCombineAsync.get());

/*--------------------------------------------------------------------------------------------------------------------------------------*/	
		
		//3. combine multiple futures -allOf() waits for all futures to complete 
		combineMultipleFutures();
		
/*--------------------------------------------------------------------------------------------------------------------------------------*/	
		
		//4. combine multiple future (no need to wait for all to finish)
		combineMultipleFuturesWithoutWait();
	}

	private static List<Employee> getEmployees(){
		List<Employee> employeeList= new ArrayList<>();
		for(int i=0;i<1000;i++) {
			employeeList.add(new Employee((long)i+1, "Employee"+i,"email"+i+"@gmail.com",(i&1)!=0?"Male":"Female",i, "Somewhere"+i*5.1, i%2==0?true:false, i%5==0?false:true));
		}
		return employeeList;
	}
	private static CompletableFuture<Employee> findEmployee() {
		return CompletableFuture.supplyAsync(()->{
			System.out.println("Thread :"+ Thread.currentThread().getName());
			return getEmployees().stream().filter(employee->employee.getEmployeeName().equals("Employee12")).findFirst().get();
		},Executors.newFixedThreadPool(10));
	}
	
	private static CompletableFuture<Integer> getRatings(Employee employee) {
		return CompletableFuture.supplyAsync(()->{
			System.out.println("Thread :"+ Thread.currentThread().getName());
			return employee.getRating();
		},Executors.newFixedThreadPool(10));
	}
	
	
	//3. combine multiple futures -allOf() waits for all futures to complete
	private static void combineMultipleFutures() {
		
		//Weather future to get future result of weather
		CompletableFuture<String> weatherFuture = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
			System.out.println("Thread :"+ Thread.currentThread().getName());
			return "Weather : Delhi - 25'C";
		},Executors.newFixedThreadPool(10));
		
		//Live Cricket score futre
		CompletableFuture<String> liveScoreFuture = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
			System.out.println("Thread :"+ Thread.currentThread().getName());
			return "IND : 136/1, 12.3overs";
		},Executors.newFixedThreadPool(10));
		
		//Stock Price Future
		CompletableFuture<String> stockPriceFuture = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
			System.out.println("Thread :"+ Thread.currentThread().getName());
			return "APPL :$135.33 , GOGL :$78.96";
		},Executors.newFixedThreadPool(10));
		
		CompletableFuture<Void> allOfCompletableFuture = CompletableFuture.allOf(weatherFuture, liveScoreFuture, stockPriceFuture);
		
		allOfCompletableFuture.thenRun(()->{
			String weather = weatherFuture.join();
			String liveScore = liveScoreFuture.join();
			String stockPrice = stockPriceFuture.join();
			
			System.out.println("Thread :"+ Thread.currentThread().getName());
			System.out.println("Data Set");
			System.out.println(weather);
			System.out.println(liveScore);
			System.out.println(stockPrice);
		}).join();
		
		return;
	}
	
	
	//combine multiple future (no need to wait for all to finish)
	private static void combineMultipleFuturesWithoutWait() {
		
		CompletableFuture<Double> apiResponse1 = CompletableFuture.supplyAsync(()->{
			System.out.println("Thread :"+ Thread.currentThread().getName());
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 150.35;
		});
		
		CompletableFuture<Double> apiResponse2 = CompletableFuture.supplyAsync(()->{
			System.out.println("Thread :"+ Thread.currentThread().getName());
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 169.75;
		});
		
		CompletableFuture<Double> apiResponse3 = CompletableFuture.supplyAsync(()->{
			System.out.println("Thread :"+ Thread.currentThread().getName());
			try {
				Thread.sleep(1900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 180.96;
		});
		
		CompletableFuture<Object> anyOfCompletableFuture = CompletableFuture.anyOf(apiResponse1, apiResponse2, apiResponse3);
		
		anyOfCompletableFuture.thenAcceptAsync(price->{
			System.out.println("Share Price: APPL "+price);
		}).join();
	}
}
