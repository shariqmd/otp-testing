package com.ecommerce.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.ecommerce.site.config.CustomUserDetail;
import com.ecommerce.site.config.CustomUserDetailService;
import com.ecommerce.site.entity.User;
import com.ecommerce.site.userRepo.UserRepository;

@Configuration
@EnableWebSecurity

public class springSecurityconfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	CustomUserDetailService customUserdetail;
	

	
/*	
 * 
 * this method is used for authentication mean it is authencation user based on his/her usernane and password
 * 
 * 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryAuthentication = auth.inMemoryAuthentication();
		  
               UserDetailsManagerConfigurer<AuthenticationManagerBuilder, InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder>>.UserDetailsBuilder password = inMemoryAuthentication.withUser("sonu").password(passwordEncoder().encode("sonu"));
               password.roles("ADMIN");
		  
	
	
		  
	} 
	*/
	

/*	 this method is used for authentication mean it is authencation user based on his/her usernane and password*/
	@Bean
	public DaoAuthenticationProvider getDao()
	{
		DaoAuthenticationProvider dao=new DaoAuthenticationProvider();
		dao.setUserDetailsService(customUserdetail);
		
		dao.setPasswordEncoder(new springSecurityconfig().passwordEncoder());
		
		return dao;
		
	}
	
	

	
/*	this is user for authorization mean we are makin url to be accesable by user based on theri role */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().
		authorizeRequests().anyRequest().permitAll();
		
	}
	
	

/*	
 * 
 * this is just createing object of this custom class and giving to spring ioc to maintain it so that later i can autowired  it in whole project without creating its object by using new keyowrd
 * 
	
	*/
	@Bean
	public CustomUserDetailService getCustomUserDetailServiceBean()
	{
		return new CustomUserDetailService();
	}
	
	
	
//	 @Bean
//	    public PasswordEncoder passwordEncoder() {
//		 
//		 
//	        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	    }
	
	/*this is use to bcrypt password  based on some round by default it use round 10*/

	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}




















class MethodChainig{
	
	public static  MethodChainig getHero()
	{
		return new MethodChainig();
	}
	
	public String hi()
	{
		return "sonu";
	}
	
	
}




