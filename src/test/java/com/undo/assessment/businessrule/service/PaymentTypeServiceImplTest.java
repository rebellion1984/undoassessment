package com.undo.assessment.businessrule.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.undo.assessment.businessrule.domain.Membership;
import com.undo.assessment.businessrule.domain.PackingSlip;

@SpringBootTest
class PaymentTypeServiceImplTest {
	
	@Autowired
	PaymentTypeServiceImpl service;

	@Test
	void valid_product_paymentType_param_returns_ok() {
		String paymentFor = "book";
		
		PackingSlip output = service.paymentForProduct(paymentFor);
		
		assertNotNull(output);
		assertEquals(1, output.getSlipId());
		
	}

//	@Disabled
//	@Test
//	void empty_paymentType_param_returns_error() {
//		String pType = "";
//		
//		PackingSlip apiCallResult = service.paymentForProduct(pType);
//		assertNull(apiCallResult);
//	}
	
	@Test
	void valid_membership_paymentType_param_returns_ok() {
		String paymentFor = "membership";
		
		Membership output = service.paymentForMembership(paymentFor);
		
		//assertNotNull(output);
		assertEquals("ACTIVATE_MEMBERSHIP", output.toString());
	}
}
