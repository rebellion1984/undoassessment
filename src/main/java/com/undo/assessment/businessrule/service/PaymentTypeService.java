package com.undo.assessment.businessrule.service;

import com.undo.assessment.businessrule.domain.Membership;
import com.undo.assessment.businessrule.domain.PackingSlip;

public interface PaymentTypeService {
	
	PackingSlip paymentForProduct (String paymentReceived);
	Membership paymentForMembership (String paymentReceived);
}
