package com.ojas.spring;

import java.util.Random;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DemoApplication {
	
	public static String getCaptcha() {
		char ch[]= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u',
				'v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q',
				'R','S','T','U','V','W','X','Y','Z','@','#','$','%','&'};
		char captcha[]=new char[6];
		Random rdm=new Random();
		for(int i=0;i<captcha.length;i++) {
			int rd=rdm.nextInt(ch.length);
			captcha[i]=ch[rd];
			
		}
		
				
		
		
		
		return new String(captcha);
	}
	
	
	


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//System.out.println(getCaptcha());
		
	}

}
