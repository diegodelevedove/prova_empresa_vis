package com.provavis.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Conta implements Serializable {
	
	@Id
	private Long id;
	private Integer numeroConta;
	
	public Conta(){};
	
	public Conta(Long id, Integer numeroConta) {
		super();
		this.id = id;
		this.numeroConta = numeroConta;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Long getId() {
		return id;
	}

	
	//Declaramos um hashCode e um equals
	//para diferenciar um objeto do outro, tanto no contéudo quando na memoria heap
	
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
		Conta other = (Conta) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	

}
