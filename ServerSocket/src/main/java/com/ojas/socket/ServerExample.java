package com.ojas.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//public class ServerExample {
//    public static void main(String[] args) {
//    		
//    		
//        try {
//            // create a server socket object and bind it to a port number
//        	 while (true) {
//            ServerSocket serverSocket = new ServerSocket(8383);
//            System.out.println("Server listening on port 8383...");
//            
//            // accept client connections
//            Socket clientSocket = serverSocket.accept();
//            System.out.println("Client connected from " + clientSocket.getInetAddress());
//            
//            // create input and output streams for the client socket
//            InputStream inputStream = clientSocket.getInputStream();
//            OutputStream outputStream = clientSocket.getOutputStream();
//            
//            // read data from the client and send a response
//            byte[] buffer = new byte[1024];
//            int bytesRead = inputStream.read(buffer);
//            String request = new String(buffer, 0, bytesRead);
//            System.out.println("Received message from client: " + request);
//            Scanner sc=new Scanner(System.in);
//            
//            
//            String response = sc.nextLine();
//            outputStream.write(response.getBytes());
//            System.out.println("Sent response to client: " + response);
//            
//            // close the client and server sockets
//            clientSocket.close();
//            //serverSocket.close();
//        	 }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
import java.io.*;
import java.net.*;

public class ServerExample {
    public static void main(String[] args) {
        try {
            // create a server socket object and bind it to a port number
            ServerSocket serverSocket = new ServerSocket(8383);
            System.out.println("Server listening on port 8383...");

            // handle incoming client connections
            while (true) {
                // accept client connections
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getInetAddress());

                // create input and output streams for the client socket
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();
                while (true) {
                // read data from the client and send a response
                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                String request = new String(buffer, 0, bytesRead);
                System.out.println("Received message from client: " + request);

                Scanner sc=new Scanner(System.in);
                System.out.println("Give Response for the client : ");
                String response = sc.nextLine();
                outputStream.write(response.getBytes());
                System.out.println("Sent response to client: " + response);
                }

                // close the client socket
                //clientSocket.close();
            }

            // close the server socket
            //serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

