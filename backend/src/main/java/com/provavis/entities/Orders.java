package com.provavis.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	private Date orderDate;
	private Integer amount;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "salesPerson_id")
	private SalesPerson salesPerson;
	
	@JsonIgnore
	@ManyToOne	
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public Orders() {}	

	public Orders(Long id, 
			Date orderDate,
			Customer customer,
			SalesPerson salesPerson,
			Integer amount) 
	{
		super();
		this.id = id;
		this.orderDate = orderDate;	
		this.customer = customer;
		this.salesPerson = salesPerson;		
		this.amount = amount;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
