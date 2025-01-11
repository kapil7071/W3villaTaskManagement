package com.w3villa.taskmanagement2.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.w3villa.taskmanagement2.entity.User;

public class CustomUserDetailsSecurity implements UserDetails {
	
	@Autowired
	private User user;
	
	public CustomUserDetailsSecurity(User user) {
		// TODO Auto-generated constructor stub
		 this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

}
