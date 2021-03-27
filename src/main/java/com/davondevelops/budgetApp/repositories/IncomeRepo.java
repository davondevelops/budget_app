package com.davondevelops.budgetApp.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.davondevelops.budgetApp.models.Income;
import com.davondevelops.budgetApp.models.User;

@Repository
public interface IncomeRepo extends CrudRepository<Income, Long> {
	List<Income> findByUser(User user);
	List<Income> findByDateAndUser(String date, User user);
}
