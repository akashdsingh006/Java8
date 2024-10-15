package com.java.OptionalClass;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.Objects.Customer;

public class OptionalDemoObject {

	static List<Customer> customerList;
	private static List<Customer> getCustomerList(){
		return Stream
				.of(new Customer(1, "Ronny", "rony@test.com", Arrays.asList(789632145035L, 369751215586L)),
						new Customer(16, "Tonny", null,Arrays.asList(32655987845132L, 9965653223234L, 785612123463L)),
						new Customer(71, "Monny", "monny@google.com", Arrays.asList(8965327845213265L, 789845561232L)),
						new Customer(12, "Gonny", "Gonny@kookle.com", Arrays.asList(7845213265L, 7979541232L)))
				.collect(Collectors.toList());
		
	}
	
	private Customer getCustomerByEmail(String email) throws Exception {
		return customerList.stream().filter(customer -> Objects.equals(customer.getCustomerEmails(), email)).findFirst()
				.orElseThrow(() -> new Exception("email not found"));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		customerList= getCustomerList();
		OptionalDemoObject demoObject =new OptionalDemoObject();
		try {
			System.out.println(demoObject.getCustomerByEmail("monny@google.com"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
