package com.w3villa.taskmanagement2.coontroller;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.w3villa.taskmanagement2.Repo.UserRepo;
import com.w3villa.taskmanagement2.entity.Task;
import com.w3villa.taskmanagement2.entity.User;
import com.w3villa.taskmanagement2.service.TaskServiceClass;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/")

public class ControllerTask {
	@Autowired
private TaskServiceClass serviceClass;

	@Autowired
	private UserRepo userRepo;
	
	
	@GetMapping("/{id}")
	public String getTaskById(@PathVariable Long id, Model model) {
	    try {
	        Task task = serviceClass.findTaskById(id);
	        model.addAttribute("task", task);
	        return "details"; // The view name where task details are shown
	    } catch (IllegalArgumentException e) {
	        model.addAttribute("errorMessage", e.getMessage());
	        return "error"; // The view name for the error page
	    }
	}

	  @GetMapping("/tasks/create")
	    public String showCreateForm(Model model) {
	        model.addAttribute("task", new Task());
	        return "create";
	    }
	  @GetMapping()
	    public String getALlTasksForCurrentUser(Model model){
	        List<Task> tasks = serviceClass.getTasksForCurrentUser();
	        String username ="";
	        for (Task tas : tasks) {
	        	username= tas.getUser().getUsername();
	        	//System.out.println(tas.getUser().getUsername());
	        	break;
	        }
	        model.addAttribute("tasks", tasks);
	        model.addAttribute("username", username);
	        return "list";
	    }
	  @PostMapping
	    public String createTask(@ModelAttribute Task task) {

	        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        String currentPrincipalName = authentication.getName();

	        User user = userRepo.findByUsername(currentPrincipalName).orElse(null);
	        assert user != null;
	        Long userId = user.getId();


	        serviceClass.saveTask(task);
	        // Redirect to the task details page for the newly created task
	        return "redirect:/" + task.getId(); // Assuming the task details page URL includes the task ID
	    }
	  private User getCurrentUser() {
	        // Get the username of the currently authenticated user
	        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
	        // Create a user object with the username
	        User user = new User();
	        user.setUsername(username);
	        return user;
	    }
	  @GetMapping("/{id}/edit")
	  public String showEditForm(@PathVariable Long id, Model model) {
	      try {
	          Task task = serviceClass.findTaskById(id);
	          model.addAttribute("task", task);
	          return "edit"; 
	      } catch (IllegalArgumentException e) {
	          model.addAttribute("errorMessage", e.getMessage());
	          return "error"; 
	      }
	  }

	  @PostMapping("/{id}")
	    public String updateTask(@PathVariable Long id, @ModelAttribute("task") Task taskDetails) throws Throwable {

	        Task task = (Task) serviceClass.findTaskById(id);
	        task.setTitle(taskDetails.getTitle());
	        task.setDescription(taskDetails.getDescription());
	        serviceClass.saveTask(task);
	        return "redirect:/";
	    }

	    @PostMapping("/{id}/delete")
	    public String deleteTask(@PathVariable Long id) {
	    	serviceClass.deleteTask(id);
	        return "redirect:/";
	    }
}
