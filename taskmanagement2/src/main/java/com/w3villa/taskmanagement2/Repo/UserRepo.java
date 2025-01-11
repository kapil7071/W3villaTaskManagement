package com.w3villa.taskmanagement2.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.w3villa.taskmanagement2.entity.User;

public interface UserRepo extends JpaRepository<User,Long> {
	Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
