package org.sb.jpasamples.dao.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BankInfo {

	@Column(name="BANK_NAME_X")
	private String bankName;
	
	@Column(name = "BANK_ROUTING_NUMBER")
	private String routingNumber;
	
	@Column(name = "BANK_ACCOUNT_NUMBER")
	private String accoutNumber;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getAccoutNumber() {
		return accoutNumber;
	}

	public void setAccoutNumber(String accoutNumber) {
		this.accoutNumber = accoutNumber;
	}
}
