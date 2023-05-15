package com.ojas.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.spring.model.Pdfdata;
import com.ojas.spring.service.ExcelService2;

@RestController
@RequestMapping("/excelsheet")
public class ExcelController2 {
	@Autowired
	private ExcelService2 excelService2;
	@Autowired
	private JavaMailSender mailSender;
	@PostMapping("/sendmail")
	public ResponseEntity<?> getExcell(@RequestBody List<Pdfdata> data){
		
		try {
			byte[] bytes=excelService2.generateExcel(data);
			String[] email={"mamidalaharish1997@gmail.com","sureshlucky9131@gmail.com"};
			
			MimeMessage message=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			helper.setFrom("ranjith.karapu@gmail.com");
			helper.setTo("ssreddy251098@gmail.com");
			helper.setCc(email);
			helper.setSubject("Greetingsss...");
			helper.setText("Please Find The Below Excel Sheet");
			helper.addAttachment("My Excel Sheet.xlsx", new ByteArrayResource(bytes));
			mailSender.send(message);
		} catch (MailException | IOException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().build();
		
	}

}
