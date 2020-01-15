/**
 * 
 */
package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Kaustubh
 *
 */

@Entity
@Table(name = "tbl_subscription")
public class Subscription extends AbstractEntity {
	
	private ServiceType serviceType;
	private String Salary;
	private Maid maid;
	private Customer customer;
	private LocalDate createdDate;	

	public Subscription() {}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	@ManyToOne
	@JoinColumn(name = "maid_id")
	public Maid getMaid() {
		return maid;
	}

	public void setMaid(Maid maid) {
		this.maid = maid;
	}

	@OneToOne
	@JoinColumn(name = "customer_id")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name = "date_created")
	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	
	
}