package com.undo.assessment.businessrule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.undo.assessment.businessrule.model.PackingSlip;
import com.undo.assessment.businessrule.service.PaymentTypeService;

@RestController
@RequestMapping(value = "/businessrule")
//@Validated
public class PaymentTypeController {

	@Autowired
	private PaymentTypeService service;

	@GetMapping(value = "/{paymentType}")
	public String getBusinessRule(@PathVariable String paymentType) {
			return service.resolvePaymentType(paymentType);
	}
}
