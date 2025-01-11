package com.w3villa.taskmanagement2.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.w3villa.taskmanagement2.entity.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {
	List<Task> findByUserUsername(String username);
}
