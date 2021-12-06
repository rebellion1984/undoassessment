package com.undo.assessment.businessrule.domain;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PackingSlip {

	private int slipId;
	private List<Product> productList;
	
	public PackingSlip() {

	}
	
	public PackingSlip(int slipId, List<Product> productList) {
		super();
		this.slipId = slipId;
		this.productList = productList;
	}



	public int getSlipId() {
		return slipId;
	}

	public void setSlipId(int slipId) {
		this.slipId = slipId;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    return gson.toJson(this, PackingSlip.class);
	}
	
	
}
