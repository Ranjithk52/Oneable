package com.ojas.spring.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;
import com.ojas.spring.model.Pdfdata;
import com.ojas.spring.service.PdfService;

@RestController
@RequestMapping("/base")
public class PdfController {
	@Autowired
	private PdfService pdfService;
	@Autowired
	private JavaMailSender mailSender;
@PostMapping("/pdf")
	public ResponseEntity<?> sendMail(@RequestBody List<Pdfdata> pdfdata){
		try {
			// generate the PDF as a byte array
			byte[] bytes=pdfService.generatePdf(pdfdata);
			
			// create the email message with the PDF as an attachment

			MimeMessage message=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			
			helper.setFrom("ranjith.karapu@gmail.com");
			helper.setTo("mamidalaharish1997@gmail.com");
			helper.setSubject("Pdf Data");
			helper.setText("Please find the below pdf data");
			helper.addAttachment("MyData.pdf", new ByteArrayResource(bytes));
			 // send the email message
			mailSender.send(message);
			return ResponseEntity.ok().build();
		} catch (MailException | DocumentException | MessagingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
}
