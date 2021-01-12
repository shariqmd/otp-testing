package com.ecommerce.site.userRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.ecommerce.site.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
	@Query("from User  where username=:username")
	User getUserByname(@Param("username") String username);
	
	
	
	User findByPasswordAndUsername(String username,String password);
	
	

	/*User findbyUsername(String username);*/

}
