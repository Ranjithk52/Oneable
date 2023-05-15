package com.ojas.socket;
import java.io.*;  
import java.net.*;  

public class ServerSocketDemo {

	public static void main(String[] args) {
	
		try {
			ServerSocket ss=new ServerSocket(5555);
			Socket s=ss.accept();
			DataInputStream dis=new DataInputStream(s.getInputStream());
			String str=(String)dis.readUTF();
			System.out.println("message: "+str);
//			ss.close();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}