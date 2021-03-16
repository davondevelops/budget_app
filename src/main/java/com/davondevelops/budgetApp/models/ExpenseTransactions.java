package com.davondevelops.budgetApp.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="expense_transactions")
public class ExpenseTransactions extends Transactions {
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="expenses")
	private Expenses expense;

	public ExpenseTransactions() {
		super();
	}

	public Expenses getExpense() {
		return expense;
	}

	public void setExpense(Expenses expense) {
		this.expense = expense;
	}
	
	
}
