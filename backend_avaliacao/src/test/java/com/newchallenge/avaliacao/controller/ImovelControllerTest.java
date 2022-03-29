package com.newchallenge.avaliacao.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ImovelControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testCidadeIgualSaoPauloAndValorMaiorQue1000000() throws JSONException {
		String response = this.restTemplate.getForObject("/imoveis/search?cidade=São&valor=1000000&criteria=>=&size=3&page=0", String.class);
		
		System.out.println("RESPONS [" + response + "]");
				
		assertThat(response)
			.contains("São Paulo")
			.contains("2500000");
	}

}
