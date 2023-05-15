package com.ojas.socket;

import java.net.*;
import java.io.*;

public class ServerSocketExample {
	public static void main(String[] args) {
		try {
			// create a server socket object with a specific port number
			ServerSocket serverSocket = new ServerSocket(8585);

			// wait for a client to connect
			Socket clientSocket = serverSocket.accept();

			// create input and output streams for the client socket
			InputStream inputStream = clientSocket.getInputStream();
			OutputStream outputStream = clientSocket.getOutputStream();

			// read input from the client and write output back to the client
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			// close the client socket
			clientSocket.close();

			// close the server socket
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
