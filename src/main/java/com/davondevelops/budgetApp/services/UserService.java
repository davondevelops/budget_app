package com.davondevelops.budgetApp.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.davondevelops.budgetApp.models.User;
import com.davondevelops.budgetApp.repositories.UserRepo;

@Service
public class UserService {
	private final UserRepo repo;

	public UserService(UserRepo repo) {
		this.repo = repo;
	}
	
	public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return repo.save(user);
    }
	
	public List <User> findAll(){
		return repo.findAll();
	}
    
    // find user by email
    public User findByEmail(String email) {
        return repo.findByEmail(email);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = repo.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = repo.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    public void delete(Long id) {
    	User user=findUserById(id);
    	repo.delete(user);
    }
}
