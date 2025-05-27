package com.provavis.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="conta")
public class Conta implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	@Nonnull
	private Integer numeroConta;
	@Nonnull
	private String titular;
	
	public Conta(){};
	
	public Conta(Long id, Integer numeroConta,String titular) {
		super();
		this.id = id;
		this.numeroConta = numeroConta;
		this.titular = titular;
	}
	
	public Long getId() {
		return id;
	}
	
	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
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
