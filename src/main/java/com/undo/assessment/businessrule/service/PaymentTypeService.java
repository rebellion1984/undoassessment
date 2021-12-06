package com.undo.assessment.businessrule.service;

import com.undo.assessment.businessrule.domain.Membership;
import com.undo.assessment.businessrule.domain.PackingSlip;

public interface PaymentTypeService {
	
	PackingSlip paymentForProduct (String paymentType);
	Membership paymentForMembership (String paymentType);
}
