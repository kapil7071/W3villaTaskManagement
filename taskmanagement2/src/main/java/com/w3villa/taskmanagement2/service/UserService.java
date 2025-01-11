package com.w3villa.taskmanagement2.service;

import java.util.List;
import java.util.Optional;

import com.w3villa.taskmanagement2.entity.User;

public interface UserService {
	User saveUser(User user);
    Optional<User> getUserById(Long id);
    Optional<User> getUserByUsername(String username);
    List<User> getAllUsers();
    void deleteUser(Long id);
}
