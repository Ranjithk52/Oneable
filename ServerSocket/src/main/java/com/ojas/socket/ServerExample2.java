package com.ojas.socket;

import java.io.*;
import java.net.*;

public class ServerExample2 {
    public static void main(String[] args) {
        try {
            // create a server socket object and start listening for client connections
            ServerSocket serverSocket = new ServerSocket(8383);
            System.out.println("Server started on port 8383...");

            while (true) {
                // accept a new client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new client connection...");

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
                    String response = "Hello, client!";
                    outputStream.write(response.getBytes());
                    System.out.println("Sent response to client: " + response);
                }

                // close the client socket
                //clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

