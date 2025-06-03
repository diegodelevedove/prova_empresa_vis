package com.provavis;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.provavis.entities.Customer;
import com.provavis.enums.INDUSTRY_TYPE_ENUM;
import com.provavis.service.SalesCustomerOrdersService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
		
	@Autowired
	SalesCustomerOrdersService salesCustomerOrdersService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Customer customer1 = new Customer(null,"Samsonic","Pleasant", INDUSTRY_TYPE_ENUM.J); 
		Customer customer2 = new Customer(null,"Panasung","OakTwon", INDUSTRY_TYPE_ENUM.J); 
		Customer customer3 = new Customer(null,"Samony","Jackson", INDUSTRY_TYPE_ENUM.B); 
		Customer customer4 = new Customer(null,"Orange","Jackson", INDUSTRY_TYPE_ENUM.B);
		
		List<Customer> customers = Arrays.asList(customer1,customer2,customer3,customer4);		
		salesCustomerOrdersService.insertCustomer(customers);
		
		
		
		
		
	}

}
