package org.sb.jpasamples.dao.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LINE_ITEM")
public class LineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LINE_ITEM_ID_PK")
	private Long lineItemId;
	
	@Column(name = "QUANTITY")
	private Long quantity;
	
	@Column(name = "PRICE")
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "BOOK_ID_FK", referencedColumnName = "BOOK_ID_PK")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "ORDER_ID_FK", referencedColumnName = "ORDER_ID_PK")
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Long getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(Long lineItemId) {
		this.lineItemId = lineItemId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
