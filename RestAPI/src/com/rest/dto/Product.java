package com.rest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL )
	private List<Comments> comments = new ArrayList<Comments>();
	
	@OneToMany(mappedBy = "products",cascade = CascadeType.ALL )
	private List<ImageUrls> images = new ArrayList<ImageUrls>();
	
	
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	@ManyToOne
	private Entrepreneur e;
	@Id@GeneratedValue
	@Column 
	private int productId;
	@Column
	private String productName;
	@Column
	private String description;
	public Entrepreneur getE() {
		return e;
	}
	public void setE(Entrepreneur e) {
		this.e = e;
	}
	
	
	public List<ImageUrls> getImages() {
		return images;
	}
	public void setImages(List<ImageUrls> images) {
		this.images = images;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

}
