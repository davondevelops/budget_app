package com.davondevelops.budgetApp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.davondevelops.budgetApp.models.Savings;
import com.davondevelops.budgetApp.models.User;

@Repository
public interface SavingsRepo extends CrudRepository<Savings, Long> {
	Savings findByUser(User user);
	
}
