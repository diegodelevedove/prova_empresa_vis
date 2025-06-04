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
	public List<SalesPerson> insertSales(List<SalesPerson> salesPerson) {				
		return salesPersonRepository.saveAll(salesPerson);
	}
	
	public Optional<SalesPerson> findById_sales(Long id) {
		return salesPersonRepository.findById(id);
	}
	
	@Transactional
	public List<Customer> insertCustomer(List<Customer> customer) {
		//customer.setId(null); verificar depois se deu problema no update
		return customerRepository.saveAll(customer);
		
	}
	
	public Optional<Customer> findById_customer(Long id){
		return customerRepository.findById(id);
	}
	
	@Transactional
	public List<Orders> insertOrder(List<Orders> orders) {
		//orders.setId(null);
		return ordersRepository.saveAll(orders);
	}
	
	public Optional<Customer> findById_orders(Long id){
		return customerRepository.findById(id);
	}
	
	
	
	
	
}
