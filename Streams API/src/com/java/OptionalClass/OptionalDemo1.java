package com.java.OptionalClass;

import java.util.Arrays;
import java.util.Optional;

import com.java.Objects.Customer;

public class OptionalDemo1 {

	public static void main(String[] args) {
		
		Customer customer = new Customer(25, "Baban", null, Arrays.asList(989646433113L,7979646653L));
		
		//Ways to create Optional class
		//empty()
		//of()
		//ofNullable()
		
		Optional<Customer> optionalEmpty = Optional.empty();
		System.out.println(optionalEmpty);
		
//		Optional<String> optionalOf = Optional.of(customer.getCustomerEmails());
//		if(optionalOf.isPresent()) {
//			System.out.println(optionalOf.get());
//		}
		
		Optional<String> optionalOfNullable = Optional.ofNullable(customer.getCustomerEmails());
		System.out.println(optionalOfNullable.orElseGet(()->"default value"));
		System.out.println(optionalOfNullable.map(String::toUpperCase).orElse("myemail.com"));
	}

}
