package com.davondevelops.budgetApp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.davondevelops.budgetApp.models.Expenses;
import com.davondevelops.budgetApp.models.User;

@Repository
public interface ExpenseRepo extends CrudRepository<Expenses, Long>  {
	List <Expenses> findByUser(User user);
	List <Expenses> findByDateAndUser(String date, User user);
}
