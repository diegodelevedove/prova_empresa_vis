package com.provavis.entities;

import java.io.Serializable;
import java.util.Objects;

import com.provavis.enums.INDUSTRY_TYPE_ENUM;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="customer")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String name;
	private String city;
	private INDUSTRY_TYPE_ENUM industry_type;
	
	public Customer() {}

	public Customer(Long id, String name, String city, INDUSTRY_TYPE_ENUM industry_type) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.industry_type = industry_type;
	}

	
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public INDUSTRY_TYPE_ENUM getIndustry_type() {
		return industry_type;
	}

	public void setIndustry_type(INDUSTRY_TYPE_ENUM industry_type) {
		this.industry_type = industry_type;
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
		Customer other = (Customer) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
