package com.w3villa.taskmanagement2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.w3villa.taskmanagement2.Repo.UserRepo;
import com.w3villa.taskmanagement2.entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByUsername(username).orElse(null);
		
		if (user==null) {
			  throw new UsernameNotFoundException("User can not found !!");

		}
		CustomUserDetailsSecurity customUserDetailsSecurity = new CustomUserDetailsSecurity(user);
		return customUserDetailsSecurity;
	}
}
