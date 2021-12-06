package com.undo.assessment.businessrule.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.undo.assessment.businessrule.domain.Agent;
import com.undo.assessment.businessrule.domain.CommissionPercentage;
import com.undo.assessment.businessrule.domain.Email;
import com.undo.assessment.businessrule.domain.Membership;
import com.undo.assessment.businessrule.domain.PackingSlip;
import com.undo.assessment.businessrule.domain.Product;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

	private Membership processMembership = null;
	private PackingSlip processPackingSlip = null;
	private String physicalProduct = "PHYSICAL_PRODUCT";
	private String book = "BOOK";
	private String learningToSkiVideo = "LEARNING_TO_SKI_VIDEO";
	private String membership = "MEMBERSHIP";
	private String upgrade = "UPGRADE";

	@Override
	public PackingSlip paymentForProduct(String paymentType) {
		return determinePaymentType(paymentType);
	}

	@Override
	public Membership paymentForMembership(String paymentType) {

		if (paymentType.equalsIgnoreCase(membership)) {
			processMembership = Membership.ACTIVATE_MEMBERSHIP;
			
			//email to owner	
			Email emailToOwner = new Email();
			emailToOwner.setRecipent("owner");
			emailToOwner.setSubject("Membershit Activated");
			emailToOwner.setBody("Dear customer, this is to inform you that your membership has been activated");
		}

		if (paymentType.equalsIgnoreCase(upgrade)) {
			processMembership = Membership.UPGRADE_MEMBERSHIP;
			//email functionality to be implemented, like in the above
		}
		
		return processMembership;

	}

	private PackingSlip determinePaymentType(String paymentType) {

			if (paymentType.equalsIgnoreCase(physicalProduct) || paymentType.equalsIgnoreCase(book)) {
				processPackingSlip = generatePackingSlip(paymentType);
				
				// generate commission to agent
				CommissionPercentage commission = new CommissionPercentage();
				double com = commission.generateCommission(10, 200);
				Agent agent = new Agent();
				agent.setCommissionAmount(com); 
			}

			if (paymentType.equalsIgnoreCase(learningToSkiVideo)) {
				processPackingSlip = generatePackingSlip(learningToSkiVideo);
			}

		return processPackingSlip;
	}

	private PackingSlip generatePackingSlip(String paymentType) {

		Product product1 = new Product(1, "Beer", "2");
		Product product2 = new Product(2, "Wine", "5");
		Product product3=null;

		List<Product> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);
		
		PackingSlip packingSlip1 = new PackingSlip();
		packingSlip1.setSlipId(1);
		packingSlip1.setProductList(products);

		// returns duplicate packing slip
		if (paymentType.equalsIgnoreCase(book)) {
			return packingSlip1;
		}

		//add product to the packing slip
		if (paymentType.equalsIgnoreCase(learningToSkiVideo)) {
		    product3 = new Product(3, "Free First Aid Video", "1");
			products.add(product3);
		}

		return packingSlip1;
	}

}
