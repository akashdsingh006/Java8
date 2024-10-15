package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.Objects.Customer;

public class Streams_Map_FlatMap {

	public static void main(String[] args) {

		List<Customer> customers = Stream
				.of(new Customer(1, "Ronny", "rony@test.com", Arrays.asList(789632145035L, 369751215586L)),
						new Customer(16, "Tonny", "tonny@nasa.org",Arrays.asList(32655987845132L, 9965653223234L, 785612123463L)),
						new Customer(71, "Monny", "monny@google.com", Arrays.asList(8965327845213265L, 789845561232L)),
						new Customer(12, "Gonny", "Gonny@kookle.com", Arrays.asList(7845213265L, 7979541232L)))
				.collect(Collectors.toList());
		
		//Using map method to get emails of customers
		//Maps the data only having emails
		//customer -> customer.getCustomerEmails()
		List<String> emailsList = customers.stream().map(customer -> customer.getCustomerEmails()).collect(Collectors.toList());
		System.out.println(emailsList);
		
		//Using map to get List of phone numbers but returns a List of List<Long>
		//Non-flattered map
		List<List<Long>> phoneNumbers = customers.stream().map(customer -> customer.getPhoneNumber()).collect(Collectors.toList());
		System.out.println(phoneNumbers);
		
		//Using flatMap to get List of phone numbers
		//flatMap accepts a stream type data so have to pass stream of list
		//customer -> customer.getPhoneNumber().stream()
		List<Long> phoneNumbersFlatMap = customers.stream().flatMap(customer -> customer.getPhoneNumber().stream()).collect(Collectors.toList());
		System.out.println(phoneNumbersFlatMap);
	}

}
