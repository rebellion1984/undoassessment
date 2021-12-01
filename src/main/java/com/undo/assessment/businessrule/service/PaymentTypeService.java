package com.undo.assessment.businessrule.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.undo.assessment.businessrule.model.CommissionPercentage;
import com.undo.assessment.businessrule.model.Membership;
import com.undo.assessment.businessrule.model.PackingSlip;
import com.undo.assessment.businessrule.model.Product;

@Service
public class PaymentTypeService {

	private String itemToReturn = "";
	private final String physicalProduct = "PHYSICAL_PRODUCT";
	private final String book = "BOOK";
	private final String membership = "MEMBERSHIP";
	private final String upgradeToMembership = "UPGRADE_TO_MEMBERSHIP";
	private final String membershipOrUpgrade = "MEMBERSHIP_OR_UPGRADE";
	private final String learningToSkiVideo = "LEARNING_TO_SKI_VIDEO";
	private final String physicalProductOrABook = "PHYSICAL_PRODUCT_OR_A_BOOK";

	public String resolvePaymentType(String paymentType) {
		return determinePaymentType(paymentType);
	}

	private String determinePaymentType(String paymentType) {

		if (paymentType != null) {

			if (paymentType.equalsIgnoreCase(physicalProduct)) {
				itemToReturn = generatePackingSlip(paymentType);
			}

			if (paymentType.equalsIgnoreCase(book)) {
				itemToReturn = generatePackingSlip(paymentType); // return packing slip again i.e. duplicate
			}

			if (paymentType.equalsIgnoreCase(membership)) {
				itemToReturn = Membership.ACTIVATE_MEMBERSHIP.toString();
			}

			if (paymentType.equalsIgnoreCase(upgradeToMembership)) {
				itemToReturn = Membership.UPGRADE_MEMBERSHIP.toString();
			}

			if (paymentType.equalsIgnoreCase(membershipOrUpgrade)) {
				itemToReturn = Membership.MEMBERSHIP_ACTIVATED.toString();
			}

			if (paymentType.equalsIgnoreCase(learningToSkiVideo)) {
				itemToReturn = generatePackingSlip(learningToSkiVideo);
			}

			if (paymentType.equalsIgnoreCase(physicalProductOrABook)) {
				CommissionPercentage commission = new CommissionPercentage();
				double com = commission.generateCommission(20, 200);
				String s = String.valueOf(com);
				itemToReturn = "Perentage Commission: " + s;
			}
		}

		return itemToReturn;
	}

	private String generatePackingSlip(String paymentType) {

		Product product1 = new Product(1, "Beer", "2");
		Product product2 = new Product(2, "Wine", "5");
		Product product3 = new Product(3, "Free First Aid Video", "1");

		List<Product> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);

		// returns duplicate i.e. product2
		if (paymentType.equalsIgnoreCase(book)) {
			products.removeAll(products);
			products.add(product2);
		}

		if (paymentType.equalsIgnoreCase(learningToSkiVideo)) {
			products.add(product3);
		}

		PackingSlip packingSlip = new PackingSlip();
		packingSlip.setSlipId(1);
		packingSlip.setProductList(products);

		return packingSlip.toString();
	}

}
