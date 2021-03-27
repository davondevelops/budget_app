package com.davondevelops.budgetApp.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.davondevelops.budgetApp.models.Expenses;
import com.davondevelops.budgetApp.models.Income;
import com.davondevelops.budgetApp.models.Savings;
import com.davondevelops.budgetApp.models.User;
import com.davondevelops.budgetApp.repositories.ExpenseRepo;
import com.davondevelops.budgetApp.repositories.IncomeRepo;
import com.davondevelops.budgetApp.repositories.SavingsRepo;

@Service
public class MainService {
	private final ExpenseRepo expenseRepo;
	private final IncomeRepo incomeRepo;
	private final SavingsRepo savingsRepo;
	public MainService(ExpenseRepo expenseRepo, IncomeRepo incomeRepo, SavingsRepo savingsRepo) {
		this.expenseRepo = expenseRepo;
		this.incomeRepo = incomeRepo;
		this.savingsRepo = savingsRepo;
	}
	
	public List<Expenses> findExpenses(User user){
		return expenseRepo.findByUser(user);
	}
	public List<Income> findRevenues(User user){
		return incomeRepo.findByUser(user);
	}
	public Savings findSavings(User user) {
		return savingsRepo.findByUser(user);
	}
	public Expenses newExpense(Expenses expense) {
		return expenseRepo.save(expense);
	}
	public Income newRevenue(Income income) {
		return incomeRepo.save(income);
	}
	public Savings saveSavings(Savings savings) {
		return savingsRepo.save(savings);
	}
	public void deleteExpense(Expenses expense) {
		expenseRepo.delete(expense);
	}
	public void deleteRevenue(Income income) {
		incomeRepo.delete(income);
	}
	
	public float calculateWeeklyIncome(User user) {
		Date todayDate= new Date();
		Calendar today = Calendar.getInstance();
		today.setTime(todayDate);
		float weeklyIncome=0;
		int x= today.get(today.DAY_OF_WEEK); //x represents day of the week
		int date =today.get(today.DATE);
		int month=today.get(today.MONTH)+1;
		int year=today.get(today.YEAR);
		for(int i=0-x; i<=(6-x); i++) {
			int day= date+i;
			String current= year+"-"+month+"-"+day;//
			List <Income> dayIncomes= incomeRepo.findByDateAndUser(current, user);
			for (Income income :dayIncomes){
				weeklyIncome+= income.getAmount();
			}
		}
		return weeklyIncome;
	}
	
	public float calculateWeeklyExpenses(User user) {
		Date todayDate= new Date();
		Calendar today = Calendar.getInstance();
		today.setTime(todayDate);
		float weeklyExpenses=0;
		int x= today.get(today.DAY_OF_WEEK); //x represents day of the week
		int date =today.get(today.DATE);
		int month=today.get(today.MONTH)+1;
		int year=today.get(today.YEAR);
		for(int i=1-x; i<=(7-x); i++) {
			int day= date+i;
			String current= year+"-"+month+"-"+day;//
			List <Expenses> dayExpenses= expenseRepo.findByDateAndUser(current, user);
			for (Expenses expense:dayExpenses){
				weeklyExpenses+= expense.getAmount();
			}
		}
		return weeklyExpenses;
	}	
}