package datamodel;

import java.util.Date;

public class Payment {
	
	private int payId;
	private String payMode;
	private float payAmount;
	private Date payDate;
	
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public float getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(float payAmount) {
		this.payAmount = payAmount;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	

}
