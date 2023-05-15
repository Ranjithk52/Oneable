package com.ojas.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servermulticlients {

	    public static void main(String[] args) {
	        try {
	            // create a server socket object and start listening for client connections
	            ServerSocket serverSocket = new ServerSocket(8383);
	            System.out.println("Server started on port 8383...");

	            while (true) {
	                // accept a new client connection
	                Socket clientSocket = serverSocket.accept();
	                System.out.println("Accepted new client connection...");

	                // create a new thread to handle the client connection
	                Thread thread = new Thread(new ClientHandler(clientSocket));
	                thread.start();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	class ClientHandler implements Runnable {
	    private Socket clientSocket;

	    public ClientHandler(Socket clientSocket) {
	        this.clientSocket = clientSocket;
	    }

	    public void run() {
	        try {
	            // create input and output streams for the client socket
	            InputStream inputStream = clientSocket.getInputStream();
	            OutputStream outputStream = clientSocket.getOutputStream();

	            // handle multiple requests from the client
	            while (true) {
	                // read a request from the client
	                byte[] buffer = new byte[1024];
	                int bytesRead = inputStream.read(buffer);
	                String request = new String(buffer, 0, bytesRead);
	                System.out.println("Received request from client: " + request);

	                // send a response back to the client
	                Scanner sc=new Scanner(System.in);
	                System.out.println("Give Response for the client : ");
	                String response = sc.nextLine();
	                outputStream.write(response.getBytes());
	                System.out.println("Sent response to client: " + response);
	            }

	            // close the client socket
	            //clientSocket.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
