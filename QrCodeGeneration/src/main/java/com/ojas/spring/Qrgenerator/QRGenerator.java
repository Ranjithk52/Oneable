/**
 * 
 */
package com.ojas.spring.Qrgenerator;


import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * @author $922000-MB7DHOVL5ID5
 *
 */
public class QRGenerator {
	
	static int id=22101;
	static String name="Harish";
	static String email="harish@gmail.com";
	static String mobile="7894561236";
	
	public static void main(String[] args) throws WriterException, IOException {
		
		String file="C:\\Users\\$922000-MB7DHOVL5ID5\\Qr_code";
		
		String filename=file+name+id+"-QRcode.png";
		
		var qrcode=new QRCodeWriter();
		BitMatrix bitMatrix=qrcode.encode("ID: "+id+"\n"+"Name: "+name+"\n"+"email:"+email+"\n"+"Mobile:"+mobile, BarcodeFormat.QR_CODE, 400, 400);
		
		Path path=FileSystems.getDefault().getPath(filename);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
		
		System.out.println("Qr Code generated");
		
	}
}
