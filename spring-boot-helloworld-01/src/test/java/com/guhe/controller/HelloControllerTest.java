package com.guhe.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author njl
 * @date 2023/2/7
 */
@WebMvcTest(HelloController.class)
class HelloControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testIndex() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
						.get("/index")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andExpect(content().string(equalTo("Hello Spring Boot!")));
	}
}