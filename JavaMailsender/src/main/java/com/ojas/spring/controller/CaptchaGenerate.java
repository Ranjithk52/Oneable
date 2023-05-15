package com.ojas.spring.controller;

import java.util.Random;

public class CaptchaGenerate {

	public static void main(String[] args) {
		char ch[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u',
				'v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q',
				'R','S','T','U','V','W','X','Y','Z','@','#','$','%','&','1','2','3','4','5','6','7','8','9','0'};
		char captcha[]=new char[6];
		
		Random random=new Random();
		for(int i=0;i<captcha.length;i++) {
			int rdm=random.nextInt(ch.length);
			captcha[i]=ch[rdm];
			
		}
		System.out.println(new String(captcha));
	}

}
