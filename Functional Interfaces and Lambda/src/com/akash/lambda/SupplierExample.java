package com.akash.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SupplierExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Supplier supplier = new Supplier() {
			public Object get(){
				return 1;
			}
		};
//		
//		System.out.println(supplier.get());
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,9,8);
		
		System.out.println(list.stream().filter(a-> a>10).findAny().orElseGet(()-> -1));
	}

}
