package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_customer_feedback")
public class CustomerFeedback extends AbstractEntity {

	//private int user_id;// need to add user object here
	private int avgRating;
	private String comment;
	private Customer customer;

	public CustomerFeedback() {
	}

	@OneToOne
	@JoinColumn(name = "cust_id")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerFeedback(int avgRating, String comment) {
		super();
		//this.user_id = user_id;
		this.avgRating = avgRating;
		this.comment = comment;
	}

	/*
	 * @NotEmpty public int getUser_id() { return user_id; }
	 */

	/*
	 * public void getUser_id(int user_id) { this.user_id = user_id; }
	 */

	@NotEmpty
	public int getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(int avgRating) {
		this.avgRating = avgRating;
	}

	@NotEmpty
	@Column(length = 30, name = "comment")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "CustomerFeedback [avgRating=" + avgRating + ", comment=" + comment + "]";
	}

	

}
