package org.sb.jpasamples.dao.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.sb.jpasamples.enums.OrderStatus;

@Entity
@Table(name = "ORDERS")
public class Order extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID_PK")
	private Long orderId;
	
	@Column(name = "PRICE")
	private Double price;
	
	@Column(name = "ORDER_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderTime;
	
	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@ManyToOne(optional = false)
	@JoinColumn(name = "CUSTOMER_ID_FK", referencedColumnName = "CUSTOMER_ID_PK")
	private Customer customer;
	
	@OneToMany(mappedBy = "order", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<LineItem> lineItems;
	
	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
}
