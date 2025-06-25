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
		
		Customer customer1 = new Customer(null,"Samsonic","Pleasant", INDUSTRY_TYPE_ENUM.J.getDescricao()); 
		Customer customer2 = new Customer(null,"Panasung","OakTwon", INDUSTRY_TYPE_ENUM.J.getDescricao()); 
		Customer customer3 = new Customer(null,"Samony","Jackson", INDUSTRY_TYPE_ENUM.B.getDescricao()); 
		Customer customer4 = new Customer(null,"Orange","Jackson", INDUSTRY_TYPE_ENUM.B.getDescricao());
		
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
		
		Orders orders1 = new Orders(null,smdf.parse("08/02/1996"),customer1,salesPerson2,540);
		Orders orders2 = new Orders(null,smdf.parse("01/30/1999"),customer1,salesPerson5,1800);
		Orders orders3 = new Orders(null,smdf.parse("07/14/1995"),customer4,salesPerson1,460);
		Orders orders4 = new Orders(null,smdf.parse("01/29/1998"),customer3,salesPerson2,2400);
		Orders orders5 = new Orders(null,smdf.parse("02/03/1998"),customer2,salesPerson4,600);
		Orders orders6 = new Orders(null,smdf.parse("03/02/1998"),customer2,salesPerson4,720);
		Orders orders7 = new Orders(null,smdf.parse("05/06/1998"),customer4,salesPerson4,150);
		
		List<Orders> orders = Arrays.asList(orders1,orders2,orders3,orders4,orders5,orders6,orders7);		
		salesCustomerOrdersService.insertOrder(orders); 
		
		
		/*
		 * Querys da prova:
		 * Given the tables above, write the SQL query that: 

			a. Returns the names of all Salesperson that don’t have any order with Samsonic. 
			SELECT * FROM ORDERS WHERE CUSTOMER_ID <> 4;
			b. Updates the names of Salesperson that have 2 or more orders. It’s necessary to add an ‘*’ in the end of the name. 
			SELECT SALES_PERSON.NAME, ORDERS.SALES_PERSON_ID  FROM SALES_PERSON INNER JOIN ORDERS ON ORDERS.SALES_PERSON_ID = SALES_PERSON.ID WHERE SALES_PERSON_ID IN (SELECT SALES_PERSON_ID FROM ORDERS GROUP BY SALES_PERSON_ID HAVING COUNT(SALES_PERSON_ID) >= 2) ;
			**O SELECT DEU CERTO FALTA O UPDATE - FIZ GAMBIARRA MAS PRETENDO FAZER EM UMA QUERy SÓ**
			UPDATE SALES_PERSON SET NAME = CONCAT(NAME,'*') WHERE ID = 2;
			UPDATE SALES_PERSON SET NAME = CONCAT(NAME,'*') WHERE ID = 4;
			Abaixo refatorar pra uma query			
			UPDATE SALES_PERSON INNER JOIN ORDERS ON ORDERS.SALES_PERSON_ID = SALES_PERSON.ID SET SALES_PERSON.NAME = CONCAT(NAME,'*') WHERE ORDERS.SALES_PERSON_ID IN (SELECT SALES_PERSON_ID FROM ORDERS GROUP BY SALES_PERSON_ID HAVING COUNT(SALES_PERSON_ID) >= 2) ;
			c. Deletes all Ssalesperson that placed orders to the city of Jackson.
			DELETE FROM SALES_PERSON WHERE CITY = 'Jackson';		
			d. The total sales amount for each Salesperson. If the sales person hasn’t sold anything, show zero.
			SELECT SALES_PERSON.NAME, ORDERS.SALES_PERSON_ID AS SALES_AMOUNT  FROM SALES_PERSON INNER JOIN ORDERS ON ORDERS.SALES_PERSON_ID = SALES_PERSON.ID WHERE SALES_PERSON_ID IN (SELECT SALES_PERSON_ID FROM ORDERS GROUP BY SALES_PERSON_ID  HAVING COUNT(*)) ;
			AINDA MELHORANDO A d
		 * 
		 */
	}

}
