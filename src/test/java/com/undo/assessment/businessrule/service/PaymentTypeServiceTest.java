package com.undo.assessment.businessrule.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentTypeServiceTest {
	
	@Autowired
	PaymentTypeService service;

	@Test
	void valid_paymentType_param_returns_ok() {
		String pType = "book";
		
		String output = service.resolvePaymentType(pType);
		
		assertNotNull(output);
	}

	@Disabled
	@Test
	void empty_paymentType_param_returns_error() {
		String pType = "";
		
		String apiCallResult = service.resolvePaymentType(pType);
		assertNull(apiCallResult);
	}
}
