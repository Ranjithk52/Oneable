package com.ojas.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailMessage {
	@Autowired
	private JavaMailSender mailSender;
	@RequestMapping("/mail")
	public String sentMessage() {
		
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setFrom("ranjith.karapu@gmail.com");
		mail.setTo("mamidalaharish1997@gmail.com");
		mail.setSubject("Greetings");
		mail.setText("hello Harishh Good Eveningg..");
		
		mailSender.send(mail);
		
		return "mail sent successfullyy....";
			
	}

}
