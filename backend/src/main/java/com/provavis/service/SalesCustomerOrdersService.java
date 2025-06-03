package com.provavis.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.provavis.entities.Customer;
import com.provavis.entities.Orders;
import com.provavis.entities.SalesPerson;
import com.provavis.repository.CustomerRepository;
import com.provavis.repository.OrdersRepository;
import com.provavis.repository.SalesPersonRepository;

import jakarta.transaction.Transactional;

@Service
public class SalesCustomerOrdersService {
	

	@Autowired
	SalesPersonRepository salesPersonRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	OrdersRepository ordersRepository;
	
	
	@Transactional
	public SalesPerson insertSales(SalesPerson salesPerson) {
		salesPerson.setId(null);		
		return salesPersonRepository.save(salesPerson);
	}
	
	public Optional<SalesPerson> findById_sales(Long id) {
		return salesPersonRepository.findById(id);
	}
	
	public List<Customer> insertCustomer(List<Customer> customer) {
		//customer.setId(null);
		return customerRepository.saveAll(customer);
		
	}
	
	public Optional<Customer> findById_customer(Long id){
		return customerRepository.findById(id);
	}
	
	public Orders insertOrder(Orders orders) {
		orders.setId(null);
		return ordersRepository.save(orders);
	}
	
	public Optional<Customer> findById_orders(Long id){
		return customerRepository.findById(id);
	}
	
	
	
	
	
}
