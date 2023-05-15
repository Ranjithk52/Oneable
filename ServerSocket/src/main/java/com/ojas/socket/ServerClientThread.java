package com.ojas.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerClientThread extends Thread{
    Socket serverClient;
    int clientNo;
    int squre;
     ServerClientThread(Socket inSocket,int counter){
        serverClient=inSocket;
        clientNo=counter;
    }
//    public void run() {
//        try {
//        	 BufferedReader in = new BufferedReader(new InputStreamReader(serverClient.getInputStream()));
//            //DataInputStream inStream=new DataInputStream(serverClient.getInputStream());
//            //DataOutputStream outStream=new DataOutputStream(serverClient.getOutputStream());
//        	 PrintWriter out = new PrintWriter(serverClient.getOutputStream(), true);
//            String clientMessage="",serverMessage="";
//            while(true) {
//                clientMessage=in.readLine();
//                System.out.println("From Client-" +clientNo+ ": Number is :"+clientMessage);
//                squre=Integer.parseInt(clientMessage)*Integer.parseInt(clientMessage);
//                serverMessage="From Server to CLient-" +clientNo+" Square of "+clientMessage+" is "+squre;
//                //Scanner sc=new Scanner(System.in);
//                //System.out.println("Send message to client");
//               //serverMessage="From Server to CLient-" +clientNo+" Message is :"+sc.nextLine();
//                out.write(serverMessage);
//                //outStream.flush();
//            }
//           
//            //in.close();
//            //outStream.close();
//            //serverClient.close();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//        	System.err.println("Error handling client: " + e.getMessage());
//        }finally {
//            System.out.println("CLient -" +clientNo +" exit!! ");
//        }
//    }
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(serverClient.getInputStream()));
            PrintWriter out = new PrintWriter(serverClient.getOutputStream(), true);

            String inputLine;
            String serverMessage="";
            while ((inputLine = in.readLine()) != null) {
//                System.out.println("Received message: " + inputLine);
//                out.println("Server received: " + inputLine);
            	 System.out.println("From Client-" +clientNo+ ": Number is :"+inputLine);
               squre=Integer.parseInt(inputLine)*Integer.parseInt(inputLine);
               serverMessage="From Server to CLient-" +clientNo+" Square of "+inputLine+" is "+squre;
               //Scanner sc=new Scanner(System.in);
               //System.out.println("Send message to client");
              //serverMessage="From Server to CLient-" +clientNo+" Message is :"+sc.nextLine();
               out.write(serverMessage);
            }

            System.out.println("Client disconnected: " + serverClient);
            serverClient.close();
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        }
    }
}