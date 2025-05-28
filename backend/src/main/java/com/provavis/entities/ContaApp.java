package com.provavis.entities;

//Exemplificando o hashCode e equals
public class ContaApp {

	public static void main(String args[]) {
		
		Conta conta = new Conta();
		Conta outraConta = new Conta(1L,1010,"Maria");
		//Retorna Falso porque cada objeto tem um próprio hash
		System.out.println(conta.equals(outraConta));
		//Retorna true porque são iguais em conteúdo e hash no heap
		System.out.println(conta.equals(conta));
		//Retorna falso porque declaramos um método na classe para comparar classes
		System.out.println(conta == outraConta);
		
		
		
	}
	
	
	
}
