package com.undo.assessment.businessrule.model;

public class CommissionPercentage {
	
	private double percentage;
	private double amount;
	
	public CommissionPercentage() {
		
	}
	
	public CommissionPercentage(double percentage, double amount) {
		super();
		this.percentage = percentage;
		this.amount = amount;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double generateCommission(double commissionPercentage, double amount){
		return (commissionPercentage/100)* amount;
	}
	
}
