package com.ojas.socket.multithreads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class ServerThreadpool {
	
	
   
    
    public static void main(String[] args) {
        try {
        	 ExecutorService threadPool = Executors.newFixedThreadPool(25000);
            // create a server socket object and start listening for client connections
        	ServerSocket serverSocket = new ServerSocket(8383);
           
            System.out.println("Server started on port 8383...");
            int counter=0;
            while (true) {
            	 
                // accept a new client connection
                Socket clientSocket = serverSocket.accept();
               
                System.out.println("Accepted new client connection...");
                System.out.println(" >> "+"Client No:"+ counter + "started!");
                // submit a new task to the thread pool to handle the client connection
                threadPool.submit(new ServerClientThread(clientSocket,counter));
               
            }
          
        } catch (IOException e) {
        	System.err.println("Error starting server: " + e.getMessage());
        }
    }
}


 
