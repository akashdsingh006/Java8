package com.java.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WhyNotFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		//using execute method which accepts Runnable
		//		executorService.execute(()->{
		//			List<Object> list =Arrays.asList(1,2,3,4);
		//			System.out.println(Thread.currentThread().getName());
		//			System.out.println(list);
		//		});
		
		
		//
		//using submit method which accepts Callable interface and returns future
		Future<List<Integer>> future = executorService.submit(()->{
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName());
			return Arrays.asList(1,2,6,5,6,45,6,5,6,5,65,6,89);
		});
		
		//It cannot be manually completed
		future.get().forEach(i->System.out.print(i+" ,"));
		
		
		
		//Multiple futures cannot be chained together
		Future<List<Integer>> future1 = executorService.submit(()-> Arrays.asList(1,2,6,5,6,45,6,5,6,5,65,6,89));
		Future<List<Integer>> future2 = executorService.submit(()-> Arrays.asList(8,9,6,1,12,56,2,5,2,4,5,2,5,7,8));
		Future<List<Integer>> future3 = executorService.submit(()-> Arrays.asList(9,5,6,13,26,2,9,89,8,66));
		
		//This is not possible - as futures cannot be combined together
		//future1+future2+future3;
		
		
		//No proper exception handling for Future
		
		Future<List<Integer>> exceptionFuture = executorService.submit(()->{
			//Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName());
			System.out.println(10/0);
			return Arrays.asList(1,2,6,5,6,45,6,5,6,5,65,6,89);
		});
		
		exceptionFuture.get();
	}

}
