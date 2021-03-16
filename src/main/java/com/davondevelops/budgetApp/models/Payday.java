package com.davondevelops.budgetApp.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="paydays")
public class Payday extends Transactions {
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="revenues")
	private Revenues revenue;

	public Payday() {
	}

	public Revenues getRevenue() {
		return revenue;
	}

	public void setRevenue(Revenues revenue) {
		this.revenue = revenue;
	}
	
	
}
