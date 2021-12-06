package com.undo.assessment.businessrule.domain;

public class Agent {
	
	private int agentID;
	private double commissionAmount;
	
	public Agent(){
		
	}

	public Agent(int agentID, double commissionAmount) {
		super();
		this.agentID = agentID;
		this.commissionAmount = commissionAmount;
	}

	public int getAgentID() {
		return agentID;
	}

	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}

	public double getCommissionAmount() {
		return commissionAmount;
	}

	public void setCommissionAmount(double commissionAmount) {
		this.commissionAmount = commissionAmount;
	}
	
	

}
