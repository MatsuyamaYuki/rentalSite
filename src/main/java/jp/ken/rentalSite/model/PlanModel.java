package jp.ken.rentalSite.model;

import java.io.Serializable;

public class PlanModel implements Serializable {

	private String planName;
	private int planPrice;
	private int Max;

	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public int getPlanPrice() {
		return planPrice;
	}
	public void setPlanPrice(int planPrice) {
		this.planPrice = planPrice;
	}
	public int getMax() {
		return Max;
	}
	public void setMax(int max) {
		Max = max;
	}
}
