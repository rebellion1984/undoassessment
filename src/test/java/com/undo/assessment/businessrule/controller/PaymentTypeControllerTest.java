package com.undo.assessment.businessrule.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.undo.assessment.businessrule.service.PaymentTypeService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PaymentTypeController.class)
class PaymentTypeControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentTypeService service;
	
	@Test
	void valid_api_call_returns_200_ok() throws Exception {
		String inputValue = "book";
		mockMvc.perform(MockMvcRequestBuilders.get("/businessrule/" + inputValue)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
	void empty_param_api_call_returns_404_error() throws Exception {
		String inputValue = "";
		mockMvc.perform(MockMvcRequestBuilders.get("/businessrule/" + inputValue)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
	
	@Disabled
	@Test
	void invalid_value_api_call_returns_404_error() throws Exception {
		String inputValue = "x";
		mockMvc.perform(MockMvcRequestBuilders.get("/businessrule/" + inputValue)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}

}
