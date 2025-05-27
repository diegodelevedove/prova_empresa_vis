package com.provavis;

import static org.assertj.core.api.Assertions.assertThat;
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
		//when(anagrama.generateAnagrama(prefixo, palavra)).thenReturn(anagramaResult);
		verify(anagrama).generateAnagrama(prefixo, palavra);
		assertThat(anagrama.generateAnagrama(prefixo, palavra).equals(anagramaResult));
		
		
		
	
		
	}

}
