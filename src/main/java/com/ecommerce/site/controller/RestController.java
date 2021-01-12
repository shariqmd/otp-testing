package com.ecommerce.site.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {
	
	
	@GetMapping("/msg91/{mobileNo}")
	@ResponseBody
	public Otp getotp(@PathVariable("mobileNo")String mbo)
	{
		int randomPIN=(int)(Math.random()*9000)+1000;
		
		Otp ot=new Otp();
		ot.setOtp(randomPIN);
		
		return ot;
	}
	

}

class Otp
{
	
	private int otp;

	public void setOtp(int otp) {
		this.otp = otp;
	}
public int getOtp() {
	return otp;
}
}
