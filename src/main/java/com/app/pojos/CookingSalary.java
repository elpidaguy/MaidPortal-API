package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tbl_cookingSalary")
public class CookingSalary {

	private double payable,bonus,fine; 
	private LocalDate forMonth;	
	private int maid_id;	
	private LocalDate paymentDate,createdDate;
	private boolean _isDeleted,_isPaid;
	
	public CookingSalary() {
		super();
	}

	public CookingSalary(double payable, double bonus, double fine, LocalDate forMonth, int maid_id,
			LocalDate paymentDate, LocalDate createdDate, boolean _isDeleted, boolean _isPaid) {
		super();
		this.payable = payable;
		this.bonus = bonus;
		this.fine = fine;
		this.forMonth = forMonth;
		this.maid_id = maid_id;
		this.paymentDate = paymentDate;
		this.createdDate = createdDate;
		this._isDeleted = _isDeleted;
		this._isPaid = _isPaid;
	}

	
	public double getPayable() {
		return payable;
	}

	public void setPayable(double payable) {
		this.payable = payable;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public LocalDate getForMonth() {
		return forMonth;
	}

	public void setForMonth(LocalDate forMonth) {
		this.forMonth = forMonth;
	}
	
	@NotEmpty
	public int getMaid_id() {
		return maid_id;
	}

	public void setMaid_id(int maid_id) {
		this.maid_id = maid_id;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="paymentDate")
	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="paymentDate")
	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public boolean is_isDeleted() {
		return _isDeleted;
	}

	public void set_isDeleted(boolean _isDeleted) {
		this._isDeleted = _isDeleted;
	}

	public boolean is_isPaid() {
		return _isPaid;
	}

	public void set_isPaid(boolean _isPaid) {
		this._isPaid = _isPaid;
	}

	@Override
	public String toString() {
		return "CookingSalary [payable=" + payable + ", bonus=" + bonus + ", fine=" + fine + ", forMonth=" + forMonth
				+ ", maid_id=" + maid_id + ", paymentDate=" + paymentDate + ", createdDate=" + createdDate
				+ ", _isDeleted=" + _isDeleted + ", _isPaid=" + _isPaid + "]";
	}

	
	
}
