package com.ecommerce.site.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ecommerce.site.entity.User;
import com.ecommerce.site.userRepo.UserRepository;



public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;




	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		
		User user=userRepo.getUserByname(username);
	  

		

		
		CustomUserDetail cutomUserDetail=new CustomUserDetail(user);
		return cutomUserDetail;
	}

}



















