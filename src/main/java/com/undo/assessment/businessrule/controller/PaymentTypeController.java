package com.undo.assessment.businessrule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.undo.assessment.businessrule.domain.Membership;
import com.undo.assessment.businessrule.domain.PackingSlip;
import com.undo.assessment.businessrule.service.PaymentTypeServiceImpl;

@RestController
@RequestMapping(value = "/businessrule")
//@Validated
public class PaymentTypeController {

	@Autowired
	private PaymentTypeServiceImpl service;

	@GetMapping(value = "/product/{paymentReceived}")
	public PackingSlip getProductDetails(@PathVariable String paymentReceived) {
			return service.paymentForProduct(paymentReceived);
	}
	
	@GetMapping(value = "/membership/{paymentReceived}")
	public Membership getMembershipDetails(@PathVariable String paymentReceived) {
			return service.paymentForMembership(paymentReceived);
	}
}
