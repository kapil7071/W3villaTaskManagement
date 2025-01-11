package com.w3villa.taskmanagement2.service;

import java.util.List;

import com.w3villa.taskmanagement2.entity.Task;

public interface TaskSerrvice {
	   List<Task> findAllTasks();
	    Task saveTask(Task task);
	    List<Task> getTasksForCurrentUser();
	    Task findTaskById(Long id);
	    void deleteTask(Long id);
}
