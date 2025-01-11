package com.w3villa.taskmanagement2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.w3villa.taskmanagement2.Repo.UserRepo;
import com.w3villa.taskmanagement2.entity.User;

@Service
public class UserServiceClass implements UserService {
	
	@Autowired
	private  UserRepo userRepo;
	public UserServiceClass(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public Optional<User> getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

	@Override
	public Optional<User> getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		 userRepo.deleteById(id);
	}
	public boolean isUsernameTaken(String username) {
        return userRepo.existsByUsername(username);
    }

}
