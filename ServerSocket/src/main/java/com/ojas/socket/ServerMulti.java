package com.ojas.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMulti{
//    public static void main (String [] args) throws IOException
//    {
//        ServerSocket server=new ServerSocket(8383);
//        int counter=0;
//        System.out.println("Server Started....");
//        while(true) {
//            counter++;
//            Socket serverClient=server.accept();
//            System.out.println(" >> "+"Client No:"+ counter + "started!");
//            ServerClientThread sct=new ServerClientThread(serverClient,counter);
//        sct.start();
//        }
//    }
	
	    private static List<Socket> clientSockets = new ArrayList<>();
	    private static List<OutputStream> clientOutputStreams = new ArrayList<>();

	    public static void main(String[] args) {
	        try {
	            // create a server socket object and start listening for client connections
	            ServerSocket serverSocket = new ServerSocket(8383);
	            int counter=0;
	            System.out.println("Server started on port 8383...");

	            while (true) {
	            	 counter++;
	                // accept a new client connection
	                Socket clientSocket = serverSocket.accept();
	               // System.out.println("Accepted new client connection...");
	                System.out.println(" >> "+"Client No:"+ counter + "started!");
	                // add the client socket and output stream to the lists
	                clientSockets.add(clientSocket);
	                clientOutputStreams.add(clientSocket.getOutputStream());

	                // create a new thread to handle the client connection
	                //Thread clientThread = new Thread(new ClientHandler(clientSocket));
	                ServerClientThread sct=new ServerClientThread(clientSocket,counter);
	                sct.start();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

//	    private static void sendResponse(String response, OutputStream outputStream) throws IOException {
//	        outputStream.write(response.getBytes());
//	        outputStream.flush();
//	    
//}
}