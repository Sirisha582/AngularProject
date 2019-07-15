package com.rest.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comments {
	@ManyToOne
	//@JoinColumn(name = "emailId",insertable = false,updatable = false)
	private Student student;
	@ManyToOne
	private Businessman businessman;
	public Businessman getBusinessman() {
		return businessman;
	}
	public void setBusinessman(Businessman businessman) {
		this.businessman = businessman;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	@Id
	@Column@GeneratedValue
	private int commentId;
	@Column
	private String comment;
	@Column
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
