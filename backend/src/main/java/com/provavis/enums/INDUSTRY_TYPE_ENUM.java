package com.provavis.enums;



public enum INDUSTRY_TYPE_ENUM {

	J(0,"J"),
	B(1,"B");	
	
	private Integer codigo;
	private String descricao;
	
	
	private INDUSTRY_TYPE_ENUM(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public static INDUSTRY_TYPE_ENUM valueOfCode(Integer code) {
		for(INDUSTRY_TYPE_ENUM value : INDUSTRY_TYPE_ENUM.values()) {
			if(value.getCodigo() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid EnumStatus code");	
	}
	
	public static INDUSTRY_TYPE_ENUM valueOfDescricao(String descricao) {
		for(INDUSTRY_TYPE_ENUM value : INDUSTRY_TYPE_ENUM.values()) {
			if(value.getDescricao() == descricao) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid EnumStatus description");
	}
}
