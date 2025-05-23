package com.provavis.entities;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagrama {
	
	
	public static void main(String[] args) {
		
		System.out.println("Digite uma palavra: ");
        Scanner sc = new Scanner(System.in);
        String palavra = sc.next();       
        
        List<List<String>> anagramaLists = generateAnagrama("", palavra)
            .map(List::of)
            .collect(Collectors.toList());

        anagramaLists.forEach(System.out::println);
    }

    public static Stream<String> generateAnagrama(String letra, String palavra) {
        return palavra.isEmpty() || palavra.isBlank() ? Stream.of(letra) :
        	palavra.chars()
                .mapToObj(i -> (char) i)
                .distinct()
                .flatMap(c -> generateAnagrama(letra + c, palavra.replaceFirst(c.toString(), "")));
    }
	
}
