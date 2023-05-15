package com.ojas.spring.service;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.ojas.spring.model.Pdfdata;

@Service
public class ExcelService2 {
	 public byte[] generateExcel(List<Pdfdata> data) throws IOException {
	Workbook workbook=new XSSFWorkbook();
	Sheet sheet=workbook.createSheet("MyExcelSheet");
	
	 Row headerRow=sheet.createRow(0);
	 
	 headerRow.createCell(0).setCellValue("Name");
	 headerRow.createCell(1).setCellValue("Marks");
	 headerRow.createCell(2).setCellValue("Age");
	 headerRow.createCell(3).setCellValue("course");
	int Rownum=1;
	
	for(Pdfdata dt:data) {
		Row row=sheet.createRow(Rownum++);
		row.createCell(0).setCellValue(dt.getName());
		row.createCell(1).setCellValue(dt.getAge());
		row.createCell(2).setCellValue(dt.getCourse());
		row.createCell(3).setCellValue(dt.getMarks());
		
	}
	
	ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
	workbook.write(outputStream);
	byte[] bytes=outputStream.toByteArray();
	return bytes;
	
	 }
}
