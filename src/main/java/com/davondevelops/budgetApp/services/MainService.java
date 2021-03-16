package com.davondevelops.budgetApp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davondevelops.budgetApp.models.Expenses;
import com.davondevelops.budgetApp.models.Revenues;
import com.davondevelops.budgetApp.models.Savings;
import com.davondevelops.budgetApp.models.User;
import com.davondevelops.budgetApp.repositories.ExpenseRepo;
import com.davondevelops.budgetApp.repositories.RevenueRepo;
import com.davondevelops.budgetApp.repositories.SavingsRepo;
import com.davondevelops.budgetApp.repositories.UserRepo;

@Service
public class MainService {
	private final ExpenseRepo expenseRepo;
	private final RevenueRepo revenueRepo;
	private final SavingsRepo savingsRepo;
	public MainService(ExpenseRepo expenseRepo, RevenueRepo revenueRepo, SavingsRepo savingsRepo) {
		this.expenseRepo = expenseRepo;
		this.revenueRepo = revenueRepo;
		this.savingsRepo = savingsRepo;
	}
	
	public List<Expenses> findExpenses(User user){
		return expenseRepo.findByUser(user);
	}
	public List<Revenues> findRevenues(User user){
		return revenueRepo.findByUser(user);
	}
	public Savings findSavings(User user) {
		return savingsRepo.findByUser(user);
	}
	public Expenses newExpense(Expenses expense) {
		return expenseRepo.save(expense);
	}
	public Revenues newRevenue(Revenues revenue) {
		return revenueRepo.save(revenue);
	}
	public Savings saveSavings(Savings savings) {
		return savingsRepo.save(savings);
	}
	public void deleteExpense(Expenses expense) {
		expenseRepo.delete(expense);
	}
	public void deleteRevenue(Revenues revenue) {
		revenueRepo.delete(revenue);
	}
}
