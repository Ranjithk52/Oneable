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
public class ExcelService {
    public byte[] generateExcel(List<Pdfdata> data) throws IOException {
        // create a new workbook
        Workbook workbook = new XSSFWorkbook();
        
        // create a new sheet
        Sheet sheet = workbook.createSheet("My Data");
        
        // create the header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Name");
        headerRow.createCell(1).setCellValue("Age");
        
        // create the data rows
        int rowNum = 1;
        for (Pdfdata myData : data) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(myData.getName());
            row.createCell(1).setCellValue(myData.getMarks());
        }
        
        // write the workbook to a byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        byte[] bytes = outputStream.toByteArray();
        outputStream.close();
        
        return bytes;
    }
}
