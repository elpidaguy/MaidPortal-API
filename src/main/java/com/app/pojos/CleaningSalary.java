package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_cleaningSalary")
public class CleaningSalary extends AbstractEntity{

	private double payable,bonus,fine; //these can be NULL
	private LocalDate forMonth;	//will only be used for notation of month
	private int maid_id;	//here there should be maid but lets discuss it later on
	private LocalDate paymentDate,createdDate;
	private boolean _isDeleted,_isPaid;
		
	public CleaningSalary() {
		super();
	}

	public CleaningSalary(double payable, double bonus, double fine, LocalDate forMonth, LocalDate paymentDate,
			LocalDate createdDate, boolean _isDeleted, boolean _isPaid) {
		super();
		this.payable = payable;
		this.bonus = bonus;
		this.fine = fine;
		this.forMonth = forMonth;
		this.paymentDate = paymentDate;
		this.createdDate = createdDate;
		this._isDeleted = _isDeleted;
		this._isPaid = _isPaid;
	}
	
	@NotEmpty
	public int getMaid_id() {
		return maid_id;
	}

	public void setMaid_id(int maid_id) {
		this.maid_id = maid_id;
	}

	@Column(name="payable")
	public double getPayable() {
		return payable;
	}

	public void setPayable(double payable) {
		this.payable = payable;
	}
	
	@Column(name="bonus")
	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Column(name="fine")
	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}
	
	@Column(name="forMonth")
	public LocalDate getForMonth() {
		return forMonth;
	}

	public void setForMonth(LocalDate forMonth) {
		this.forMonth = forMonth;
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
	@Column(name="createdDate")
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
		return "CleaningSalary [payable=" + payable + ", bonus=" + bonus + ", fine=" + fine + ", forMonth=" + forMonth
				+ ", maid_id=" + maid_id + ", paymentDate=" + paymentDate + ", createdDate=" + createdDate
				+ ", _isDeleted=" + _isDeleted + ", _isPaid=" + _isPaid + "]";
	}
	
	
		
	
	
	
	
	
	
}
	