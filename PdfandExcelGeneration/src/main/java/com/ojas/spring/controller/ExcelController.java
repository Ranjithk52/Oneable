package com.ojas.spring.controller;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.spring.model.Pdfdata;
import com.ojas.spring.service.ExcelService;

@RestController
@RequestMapping("/excel")
public class ExcelController {
    @Autowired
    private ExcelService excelService;
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    @PostMapping("/send")
    public ResponseEntity<?> sendExcel(@RequestBody List<Pdfdata> data) {
        try {
            // generate the Excel sheet as a byte array
            byte[] bytes = excelService.generateExcel(data);
            
            // create the email message with the Excel sheet as an attachment
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("ranjith.karapu@gmail.com");
            helper.setTo("mamidalaharish1997@gmail.com");
            //helper.setCc("sampathyadav.k@gmail.com");
           // helper.setCc("sampathyadav.k@gmail.com","sureshlucky9131@gmail.com");
            helper.setCc("sampathyadav.k@gmail.com");
            helper.setSubject("MY PDF DATA");
            helper.setText("Please find attached the Excel sheet with my data.");
            helper.addAttachment("My PDF Data.xlsx", new ByteArrayResource(bytes));
            
            // send the email message
            javaMailSender.send(message);
            
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

