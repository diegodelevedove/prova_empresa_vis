package com.provavis.resource;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200") // essa configuração serve apenas para teste e não produção
public class ConsultaBackendAngular {

	@GetMapping(value = "/backend")
	public String retorno() {
		return JSONObject.quote("Esta mensagem vem do backend");
	}
	
}
