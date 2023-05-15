package com.ojas.socket.avinash;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerThread {
    private static final int PORT = 5050;
    private static final int THREAD_POOL_SIZE = 1;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket);

                ClientHandler clientHandler = new ClientHandler(socket);
                executorService.execute(clientHandler);
            }
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received message: " + inputLine);
                    out.println("Server received: " + inputLine);
                }

                System.out.println("Client disconnected: " + socket);
                socket.close();
            } catch (IOException e) {
                System.err.println("Error handling client: " + e.getMessage());
            }
        }
    }
}
