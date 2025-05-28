package com.provavis.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	@JsonFormat(pattern = "dd/MM/yyyy : HH/mm")
	private Date order_date;
	private Integer amount;
	private SalesPerson salesPerson;
	private Orders orders;
	
	public Orders() {}	

	public Orders(Long id, Date order_date, Integer amount, SalesPerson salesPerson, Orders orders) {
		super();
		this.id = id;
		this.order_date = order_date;
		this.amount = amount;
		this.salesPerson = salesPerson;
		this.orders = orders;
	}


	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
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
