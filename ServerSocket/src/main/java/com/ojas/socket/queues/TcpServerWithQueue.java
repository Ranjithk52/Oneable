package com.ojas.socket.queues;
import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class TcpServerWithQueue {
    
    private static final int QUEUE_CAPACITY = 100; // the capacity of the message queue
    
    public static void main(String[] args) throws IOException {
        
        int portNumber = 8585; // the port number for the server to listen on
        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("Server started on 8585");
        BlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
        
        // Start a message processing thread
        new Thread(new MessageProcessor(messageQueue)).start();
        
        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(new TcpServerHandler(clientSocket, messageQueue)).start();
        }
    }
}

class TcpServerHandler implements Runnable {
    
    private Socket clientSocket;
    private BlockingQueue<String> messageQueue;
    
    public TcpServerHandler(Socket clientSocket, BlockingQueue<String> messageQueue) {
        this.clientSocket = clientSocket;
        this.messageQueue = messageQueue;
    }
    
    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                messageQueue.put(inputLine); // put the message into the queue
            }
            
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + clientSocket.getPort() + " or listening for a connection");
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Interrupted while putting message into queue: " + e.getMessage());
        }
    }
}

class MessageProcessor implements Runnable {
    
    private BlockingQueue<String> messageQueue;
    
    public MessageProcessor(BlockingQueue<String> messageQueue) {
        this.messageQueue = messageQueue;
    }
    
    public void run() {
        try {
            while (true) {
                int message = Integer.parseInt(messageQueue.take()); // take the next message from the queue
                System.out.println("Received message: " + message);
                
                // Process the message (in this case, just echo it back to the client in uppercase)
                Socket clientSocket = new Socket("localhost", 8080); // connect to the server
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println(message); // send the message
                clientSocket.close(); // close the connection
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted while taking message from queue: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Exception caught while processing message: " + e.getMessage());
        }
    }
}
