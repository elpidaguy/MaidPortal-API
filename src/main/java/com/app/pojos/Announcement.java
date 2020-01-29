package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_announcements")
public class Announcement extends AbstractEntity {

	private String title;
	private LocalDate createdDate;
	private boolean is_Deleted;

	public Announcement() {

	}

	public Announcement(String title, LocalDate createdDate, boolean is_Deleted) {
		super();
		this.title = title;
		this.createdDate = createdDate;
		this.is_Deleted = is_Deleted;
	}

	@NotEmpty
	@Column(length = 255, name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "created_date")
	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isIs_Deleted() {
		return is_Deleted;
	}

	public void setIs_Deleted(boolean is_Deleted) {
		this.is_Deleted = is_Deleted;
	}

	@Override
	public String toString() {
		return "Announcement [title=" + title + ", createdDate=" + createdDate + ", is_Deleted=" + is_Deleted + "]";
	}

}
