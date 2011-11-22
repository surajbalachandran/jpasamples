package org.sb.jpasamples.dao.pojo;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_ID_PK")
	private Long categoryId;
	
	@Column(name = "CATEGORY_NAME")
	private String categoryName;
	
	@ManyToOne
	@JoinColumn(name = "PARENT_CATEGORY_FK", referencedColumnName = "CATEGORY_ID_PK")
	private Category parentCategory;
	
	@OneToMany(mappedBy = "parentCategory")
	private Collection<Category> childCategories;
	
	@ManyToMany(mappedBy = "categories")
	@OrderBy("title ASC, price DESC")
	private Set<Book> books;

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Collection<Category> getChildCategories() {
		return childCategories;
	}

	public void setChildCategories(Collection<Category> childCategories) {
		this.childCategories = childCategories;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
