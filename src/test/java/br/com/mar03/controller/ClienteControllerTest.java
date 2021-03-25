package br.com.mar03.controller;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ClienteControllerTest {
	
	@Autowired MockMvc mockMvc;

	@Test
	void test() throws Exception {
	
		URI uri = new URI("/cliente");
		String json = "\"nome\":\"invalido@log.com\",\"senha\":\"123\"";
		
		mockMvc.perform(MockMvcRequestBuilders.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(403));
		
	}
	
	@Test
	void test2() throws Exception {
	
		URI uri = new URI("/cliente");
		String json = "\"nome\":\"log@log.com\",\"senha\":\"123\"";
		
		mockMvc.perform(MockMvcRequestBuilders.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
		
	}

}
