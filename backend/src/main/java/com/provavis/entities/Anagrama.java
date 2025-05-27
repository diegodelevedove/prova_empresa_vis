package com.provavis.entities;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagrama {
	
	
	public static void main(String[] args) {
		//Entrada de dados
		System.out.println("Digite uma palavra: ");
        Scanner sc = new Scanner(System.in);
        String palavra = sc.next();       
        
        //Criar uma lista que recebe as palavras(nesse caso uma lista
        //preenche o prefixo e outra o anagrama
        List<List<String>> anagramaLists = generateAnagrama("", palavra)
            .map(List::of)
            .collect(Collectors.toList());

        anagramaLists.forEach(System.out::println);
    }

	//método que gera a lista
    public static Stream<String> generateAnagrama(String letra, String palavra) {    	
        return palavra.isEmpty() || palavra.isBlank() ? Stream.of(letra) :
        	palavra.chars()
                .mapToObj(i -> (char) i)
                .distinct()
                .flatMap(c -> generateAnagrama(letra + c, palavra.replaceFirst(c.toString(), "")));
    }
	
}
