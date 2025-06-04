package com.provavis;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.provavis.entities.Customer;
import com.provavis.entities.Orders;
import com.provavis.entities.SalesPerson;
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
		
		SalesPerson salesPerson1 = new SalesPerson("Abe",61,1400.00);
		SalesPerson salesPerson2 = new SalesPerson("Bob",34,4400.00);
		SalesPerson salesPerson3 = new SalesPerson("Chris",34,4000.00);
		SalesPerson salesPerson4 = new SalesPerson("Dan",41,5200.00);
		SalesPerson salesPerson5 = new SalesPerson("Ken",57,11500.00);
		SalesPerson salesPerson6 = new SalesPerson("Joe",38,3800.00);
		
		List<SalesPerson> salesPerson = 
				Arrays.asList(salesPerson1,
				salesPerson2,
				salesPerson3,
				salesPerson4,
				salesPerson5,
				salesPerson6);
		
		salesCustomerOrdersService.insertSales(salesPerson);	
		SimpleDateFormat smdf = new SimpleDateFormat("MM/dd/yyyy");	
		
		Orders orders1 = new Orders(null,smdf.parse("8/2/96"),customer1,salesPerson2,540);
		Orders orders2 = new Orders(null,smdf.parse("1/30/99"),customer1,salesPerson5,540);
		Orders orders3 = new Orders(null,smdf.parse("7/14/95"),customer4,salesPerson1,540);
		Orders orders4 = new Orders(null,smdf.parse("1/29/98"),customer3,salesPerson1,540);
		Orders orders5 = new Orders(null,smdf.parse("2/3/98"),customer1,salesPerson1,540);
		Orders orders6 = new Orders(null,smdf.parse("3/2/98"),customer1,salesPerson1,540);
		Orders orders7 = new Orders(null,smdf.parse("5/6/98"),customer1,salesPerson1,540);
		
		List<Orders> orders = Arrays.asList(orders1,orders2,orders3,orders4,orders5,orders6,orders7);		
		salesCustomerOrdersService.insertOrder(orders); 
		
	}

}
