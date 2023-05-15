package com.ojas.socket.multithreads;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;
public class Client2 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
         try{
             int count=0;
                while(true) {
                    Socket socket=new Socket("localhost",8383);
                     DataInputStream inStream=new DataInputStream(socket.getInputStream());
                        DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
                        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                        String serverMessage="";
                    String message=Integer.toString(count++);
                      //message=br.readLine();
                      outStream.writeUTF(message);
                      outStream.flush();
                      serverMessage=inStream.readUTF();
                      System.out.println(serverMessage);
                      //socket.close();
                }
               // outStream.close();
               // outStream.close();
              }catch(Exception e){
                System.out.println(e);
                try {
					Thread.sleep(20000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
              }
    }
}
