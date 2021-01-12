package com.ecommerce.site;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import com.ecommerce.site.config.CustomUserDetailService;
import com.ecommerce.site.userRepo.UserRepository;

@SpringBootTest
class SiteApplicationTests {
	
	@Autowired
	CustomUserDetailService customService;
	
	@Autowired
	UserRepository userRep;
	


	@Test
	void contextLoads() {
		
		
		customService.loadUserByUsername("sonu");
		
		System.out.println("===>");
	}

}


