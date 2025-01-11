package com.w3villa.taskmanagement2.coontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.w3villa.taskmanagement2.entity.User;
import com.w3villa.taskmanagement2.service.UserServiceClass;


@Controller
public class ControllerAuth {
	 private final UserServiceClass userService;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    public ControllerAuth(UserServiceClass userService) {
	        this.userService = userService;
	    }
	    @PostMapping("/signup")
	    public String signup(@ModelAttribute("user") User user, @RequestParam("confirmPassword") String confirmPassword) {
	        // Check if passwords match
	        if (!user.getPassword().equals(confirmPassword)) {
	            // Handle password mismatch error
	            return "redirect:/signup?error=passwordMismatch";
	        }

	        // Check if username is available (not already taken)
	        if (userService.isUsernameTaken(user.getUsername())) {
	            // Handle username already taken error
	            return "redirect:/signup?error=usernameTaken";
	        }
	        String hash = passwordEncoder.encode(user.getPassword());
	        user.setPassword(hash);

	        // Save the user
	        userService.saveUser(user);

	        // Redirect to login page after successful signup
	        return "redirect:/signin";
	    }
	    @GetMapping("/signup")
	    public String register(Model m)
	    {
	    
	        m.addAttribute("title","REGISTER");
	        return "signup";
	    }

	    @GetMapping("/signin")
	    public String showLoginForm() {
	        return "login"; // This will return the login.html Thymeleaf template
	    }
}
