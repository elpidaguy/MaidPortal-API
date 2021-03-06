package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_Salary")
public class Salary extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	private double payable, bonus, fine; // these can be NULL
	private LocalDate forMonth; // will only be used for notation of month
	private LocalDate paymentDate, createdDate;
	private boolean _isDeleted, _isPaid;
	private ServiceType serviceType;

	private Customer customer;
	private Maid maid;

	public Salary() {
	}

	// TODO: confirm this if its working or not
//	@ManyToOne
//	@JoinColumn(name="maid_id")

	@Enumerated(EnumType.STRING)
	@Column(name = "service_type")
	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maid_id")
	public Maid getMaid() {
		return maid;
	}

	public void setMaid(Maid maid) {
		this.maid = maid;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name = "payable")
	public double getPayable() {
		return payable;
	}

	public void setPayable(double payable) {
		this.payable = payable;
	}

	@Column(name = "bonus")
	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Column(name = "fine")
	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	@Column(name = "forMonth")
	public LocalDate getForMonth() {
		return forMonth;
	}

	public void setForMonth(LocalDate forMonth) {
		this.forMonth = forMonth;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	// @Temporal(TemporalType.TIMESTAMP) here we can use Time Stamp directly..what
	// do u say?
	@Column(name = "payment_date")
	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	// @Temporal(TemporalType.DATE)
	@Column(name = "created_date")
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

}
