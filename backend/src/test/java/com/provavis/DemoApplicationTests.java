package com.provavis;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.provavis.entities.Anagrama;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void generateAnagrama() {
		
		Anagrama anagrama = Mockito.mock(Anagrama.class);
		String palavra = "arara";
		String prefixo = "";
		Stream<String> anagramaResult = Stream.of("");
		anagrama.generateAnagrama(prefixo, palavra);
		
		
	
		
	}

}
