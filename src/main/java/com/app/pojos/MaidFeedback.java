package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="tbl_maid_feedback")
public class MaidFeedback extends AbstractEntity{
	
	private int maid_id;//need to add maid object here
	private int avgRating;
	private String comment;
	public MaidFeedback() {
		super();
		
	}
	public MaidFeedback(int maid_id, int avgRating, String comment) {
		super();
		this.maid_id = maid_id;
		this.avgRating = avgRating;
		this.comment = comment;
	}
	@NotEmpty
	public int getMaid_id() {
		return maid_id;
	}
	public void setMaid_id(int maid_id) {
		this.maid_id = maid_id;
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
		return "MaidFeedback [maid_id=" + maid_id + ", avgRating=" + avgRating + ", comment=" + comment + "]";
	}
	
	
	
}
