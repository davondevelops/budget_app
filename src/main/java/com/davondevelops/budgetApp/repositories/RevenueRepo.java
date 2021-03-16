package com.davondevelops.budgetApp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.davondevelops.budgetApp.models.Revenues;
import com.davondevelops.budgetApp.models.User;

@Repository
public interface RevenueRepo extends CrudRepository<Revenues, Long> {
	List <Revenues> findByUser(User user);
}
