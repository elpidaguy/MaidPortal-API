package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

//
@Entity
@Table(name = "tbl_maid_feedback")
public class MaidFeedback extends AbstractEntity {

	// private int maid_id;//need to add maid object here
	private int avgRating;
	private String comment;
	private Maid maid;

	public MaidFeedback() {
	}

	public MaidFeedback(int avgRating, String comment) {
		// this.maid_id = maid_id;
		this.avgRating = avgRating;
		this.comment = comment;
	}

	/*
	 * @NotEmpty public int getMaid_id() { return maid_id; } public void
	 * setMaid_id(int maid_id) { this.maid_id = maid_id; }
	 */

	@OneToOne
	@JoinColumn(name = "maid_id")
	public Maid getMaid() {
		return maid;
	}

	public void setMaid(Maid maid) {
		this.maid = maid;
	}
	
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
		return "MaidFeedback [avgRating=" + avgRating + ", comment=" + comment + "]";
	}

}
