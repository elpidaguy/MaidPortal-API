package com.app.pojos;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

//@Entity
//@Table(name = "tbl_user_feedback")
public class UserFeedback extends AbstractEntity {

	private int user_id;// need to add user object here
	private int avgRating;
	private String comment;

	public UserFeedback() {
	}

	public UserFeedback(int user_id, int avgRating, String comment) {
		super();
		this.user_id = user_id;
		this.avgRating = avgRating;
		this.comment = comment;
	}

	@NotEmpty
	public int getUser_id() {
		return user_id;
	}

	public void getUser_id(int user_id) {
		this.user_id = user_id;
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
		return "UserFeedback [user_id=" + user_id + ", avgRating=" + avgRating + ", comment=" + comment + "]";
	}

}
