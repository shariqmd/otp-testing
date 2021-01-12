package com.ecommerce.site.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.h2.util.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.InputStreamEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.site.entity.User;

import com.ecommerce.site.userRepo.UserRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;

@Controller
public class MainController {
	Logger log=LoggerFactory.getLogger(MainController.class);

	@Autowired
	private BCryptPasswordEncoder bc;
	
	@Autowired
	UserRepository userRep;
	
	@GetMapping("/home")
	public String home()
	
	
	{
		User u=new User();
		u.setId(1);
		u.setUsername("sonu");
		u.setPassword(bc.encode("sonu"));
		u.setRole("ADMIN");
		
		userRep.save(u);
		log.info("home controller called");
		
		return "index";
	}
	
	
	@GetMapping("/about")
	
	public String aboutUs()
	{
	
		
		
		return "about";
	}
	
	
	@GetMapping("/loginPage")
	public String loginPage()
	{
		
		return "loginPage";
	}
	
	
	@GetMapping("/BcryptPasswordEncoder")
	public String bcrptPass()
	{
		
		return "BcryptPasswordEncoder";
	}
	
	@PostMapping("/BcryptingPassowrd")
	public String bcryptingPassword(@RequestParam("string")String stringasPassword,Model model)
	{
		
		String encode = bc.encode(stringasPassword); //converting in hashcode
		model.addAttribute("userclickedHash", true);
		model.addAttribute("encodedPassword", encode);
		
		return "BcryptPasswordEncoder";
	}
	
	@GetMapping("/sentotp")
	
	@ResponseBody
	public String sendOtp(@RequestParam String inputs,HttpServletRequest req) throws MalformedURLException
	{
		
		

		   String authkey = "349791AtxrqKONY35fde476cP1";
		   int route=4;
		   
		    /*String mainUrl="http://api.msg91.com/api/sendhttp.php?";*/
		   
		   String mainUrl="http://localhost:8080/msg91/"+inputs;
		    int randomPIN=(int)(Math.random()*9000)+1000;
		    
		    req.getSession().setAttribute("otp", randomPIN);
		    StringBuilder sbPostData= new StringBuilder(mainUrl);
	       
	       /* sbPostData.append("&mobiles="+inputs);
	        sbPostData.append("&message="+randomPIN);
	        sbPostData.append("&route="+route);
	        sbPostData.append("&sender="+"sharque");*/
	        
	        mainUrl = sbPostData.toString();
	        
	        System.out.println("usrl "+mainUrl);

	        try
	        {
	        URL url=new URL(mainUrl);  
	        URLConnection urlcon=url.openConnection(); 
	        
	        urlcon.connect();
	      
	        
	      BufferedReader br=new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
	      
	     
	        String line=br.readLine();
	        req.getSession().setAttribute("otp", line);
	        
	       /* Gson gson = new Gson();
	    
	        Otp otp= gson.fromJson(line, Otp.class);
	        
	        req.getSession().setAttribute("otp", otp.getOtp());
	        
	        
	        System.out.println("value from api"+otp.getOtp());*/
	 
	        
	        System.out.println(mainUrl);
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	     
		
		
		
		
		
		
		
		return inputs;
		
	}
	
	
	@GetMapping("/verify")
	
	@ResponseBody
	public String verifyOtp(@RequestParam Integer otp1,HttpServletRequest req) 
	{
		Integer prevIousOtp=(Integer) req.getSession().getAttribute("otp");
		
		if(prevIousOtp==null)
		{
			throw new RuntimeException("thre is some mistake");
		}
		
		System.out.println("etner otp "+otp1 + "session otp "+prevIousOtp);
			if(prevIousOtp.equals(otp1))
			{
				
				return "done";
			}
			else
			{
				return "not done";
			}
		
		
		
		
	}
	
	
	@GetMapping("/loginProcessingurl")
	public String demo()
	{
		return "index";
	}
	
	
	@GetMapping("/getuser")
	@ResponseBody
	public List<User> getuser()
	{
		List<User> findAll = userRep.findAll();
		
		return findAll;
		
	}
	
}
