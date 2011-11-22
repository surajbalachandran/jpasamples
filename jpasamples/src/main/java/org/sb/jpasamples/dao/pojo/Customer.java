package org.sb.jpasamples.dao.pojo;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID_PK")
	private Long customerId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CUSTOMER_TYPE")
	private String customerType;
	
	@Column(name = "INCOME")
	private Double income;
	
	@Lob
	@Basic(fetch = FetchType.LAZY, optional = true)
	@Column(name = "PICTURE")
	private byte[] picture;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="bankName", column=@Column(name="BANK_NAME")),
		@AttributeOverride(name="routingNumber", column=@Column(name="ROUTING_NUMBER")),
		@AttributeOverride(name="accountNumber", column=@Column(name="ACCOUNT_NUMBER"))
	})
	private BankInfo bankInfo;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "ADDRESS_ID_FK", referencedColumnName = "ADDRESS_ID_PK")
	private Address address;
	
	@OneToMany(mappedBy = "customer", orphanRemoval=true)
	@OrderColumn(name = "ORDER_ID_PK")
	private Set<Order> orders;

	public BankInfo getBankInfo() {
		return bankInfo;
	}

	public void setBankInfo(BankInfo bankInfo) {
		this.bankInfo = bankInfo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
}
