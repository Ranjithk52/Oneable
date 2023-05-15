package com.ojas.spring.service;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.PdfWriter;
import com.ojas.spring.model.Pdfdata;

@Service
public class PdfService {
	
	
	public byte[] generatePdf(List<Pdfdata> data) throws DocumentException {
		
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		  // create a new document
		Document document=new Document();
		document.addTitle("invoice ");
		PdfWriter.getInstance(document, outputStream);
		document.open();
		 // add the data to the document
		for(Pdfdata dt:data) {
			document.add(new Paragraph(dt.getName()+"  "+dt.getMarks()));
		}
		document.close();
		return outputStream.toByteArray();
	}
	
	

}
