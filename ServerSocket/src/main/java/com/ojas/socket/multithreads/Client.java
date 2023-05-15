package com.ojas.socket.multithreads;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	ExecutorService executorService = Executors.newFixedThreadPool(100000);
         try{

             int count=1;
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
                      socket.close();
                }
               // outStream.close();
               // outStream.close();
              }catch(Exception e){
                System.out.println(e);
              }
    }
}