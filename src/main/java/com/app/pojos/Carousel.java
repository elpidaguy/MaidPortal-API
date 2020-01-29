package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_carousels")
public class Carousel extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	private String url, headerText, bodyText;
	private LocalDate createdDate;
	private boolean is_Deleted;

	public Carousel() {

	}

	public Carousel(String url, String headerText, String bodyText, LocalDate createdDate, boolean is_Deleted) {
		super();
		this.url = url;
		this.headerText = headerText;
		this.bodyText = bodyText;
		this.createdDate = createdDate;
		this.is_Deleted = is_Deleted;
	}

	@Column(length = 255)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(length = 255, name = "header_text")
	public String getHeaderText() {
		return headerText;
	}

	public void setHeaderText(String headerText) {
		this.headerText = headerText;
	}

	@Column(length = 255, name = "body_text")
	public String getBodyText() {
		return bodyText;
	}

	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
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
		return "Carousel [url=" + url + ", headerText=" + headerText + ", bodyText=" + bodyText + ", createdDate="
				+ createdDate + ", is_Deleted=" + is_Deleted + "]";
	}

}
