package com.w3villa.taskmanagement2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.w3villa.taskmanagement2.Repo.TaskRepo;
import com.w3villa.taskmanagement2.Repo.UserRepo;
import com.w3villa.taskmanagement2.entity.Task;
import com.w3villa.taskmanagement2.entity.User;

import jakarta.transaction.Transactional;

@Service
public class TaskServiceClass implements TaskSerrvice{

	@Autowired
	private TaskRepo taskRepo;
	@Autowired
	private UserRepo userRepo;
	@Override
	public List<Task> findAllTasks() {
		// TODO Auto-generated method stub
		return taskRepo.findAll();
	}
	@Override
	public Task saveTask(Task task) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		// TODO Auto-generated method stub
		 User user = userRepo.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("User not found"));
	        task.setUser(user);
	        return taskRepo.save(task);
	}
	@Override
	public List<Task> getTasksForCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return taskRepo.findByUserUsername(username);
	}
	@Transactional
	@Override
	public Task findTaskById(Long id) {
	    String username = SecurityContextHolder.getContext().getAuthentication().getName();
	    Task task = taskRepo.findById(id).orElse(null);

	    if (task == null || !task.getUser().getUsername().equals(username)) {
	        throw new IllegalArgumentException("Task not found or you do not have permission to access this task");
	    }

	    return task;
	}

	@Override
	public void deleteTask(Long id) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByUsername(username).orElseThrow();
        Task task = taskRepo.findById(id).orElseThrow();

        if (task.getUser() == user)
            taskRepo.deleteById(id);
		
	}
}
