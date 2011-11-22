package org.sb.jpasamples.dao.pojo;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
@SecondaryTable(name = "CONTENT", 
	pkJoinColumns = @PrimaryKeyJoinColumn(name="BOOK_ID_FPK", referencedColumnName="BOOK_ID_PK"))
public class Book extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOK_ID_PK")
	private Long bookId;
	
	@Column(name = "ISBN")
	private String isbn;
	
	@Column(name = "AUTHOR")
	private String author;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "PRICE", precision = 12, scale = 2)
	private double price;
	
	@Column(name = "RATING")
	private int rating;
	
	@Lob
	@Basic(fetch=FetchType.LAZY, optional=true)
	@Column(name="PDF", insertable=true, updatable=false)
	private byte[] pdf;
	
	@ManyToMany
	@JoinTable(name="BOOK_CATEGORY", 
			joinColumns=@JoinColumn(name = "BOOK_ID_FPK", referencedColumnName = "BOOK_ID_PK"),
			inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID_FPK", referencedColumnName = "CATEGORY_ID_PK"))
	@OrderColumn(name = "CATEGORY_ID_PK")
	private Set<Category> categories;
	
	@OneToMany(mappedBy = "book", cascade={CascadeType.ALL})
	private Set<LineItem> lineItems;
	

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public byte[] getPdf() {
		return pdf;
	}

	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Set<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
}
