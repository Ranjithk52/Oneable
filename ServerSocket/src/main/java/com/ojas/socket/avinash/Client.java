package com.ojas.socket.avinash;



import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    private static final int SERVER_PORT = 5000;
    private static final int THREAD_POOL_SIZE = 100000;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try {
            InetAddress serverAddress = InetAddress.getLocalHost();
            Socket socket = new Socket(serverAddress, SERVER_PORT);
            System.out.println("Connected to server: " + socket);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            for (int i = 1; i <= THREAD_POOL_SIZE; i++) {
                String message = "Message " + i;

                Runnable task = () -> {
                    out.println(message);
                    String response = null;
                    try {
                        response = in.readLine();
                    } catch (IOException e) {
                        System.err.println("Error reading server response: " + e.getMessage());
                    }
                    System.out.println("Received response: " + response);
                };

                executorService.execute(task);
            }

            executorService.shutdown();
        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }
}
