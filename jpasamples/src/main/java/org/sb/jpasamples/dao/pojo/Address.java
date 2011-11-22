package org.sb.jpasamples.dao.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address extends BaseEntity {

	public Address() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ADDRESS_ID_PK", updatable = false)
	private Long addressId;
	
	@Column(name="ADDRESS_1", insertable=true, updatable=true, nullable=false)
	private String address1;
	
	@Column(name="ADDRESS_2", insertable=true, updatable=true, nullable=true)
	private String address2;
	
	@Column(name="CITY", insertable=true, updatable=true, nullable=false)
	private String city;
	
	@Column(name="STATE", insertable=true, updatable=true, nullable=false)
	private String state;
	
	@Column(name="ZIP", insertable=true, updatable=true, nullable=false, length=9)
	private String zip;
	
	@OneToOne(mappedBy = "address")
	private Customer customer;
	
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
