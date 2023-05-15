package com.ojas.siva;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
public class Server {
    private static final int SERVER_PORT = 8686;
    private static final int BUFFER_SIZE = 1024;
    private static final int THREAD_POOL_SIZE = 10;
    private ExecutorService threadPool;
    private LinkedBlockingQueue<SocketChannel> messageQueue;
    public Server() {
        threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        messageQueue = new LinkedBlockingQueue<>();
    }
    public void start() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(SERVER_PORT));
        serverSocketChannel.configureBlocking(false);
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                messageQueue.add(socketChannel);
            }
            while (!messageQueue.isEmpty()) {
                SocketChannel client = messageQueue.poll();
                threadPool.execute(() -> {
                    ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
                    try {
                        int numBytesRead = client.read(buffer);
                        if (numBytesRead > 0) {
                            String request = new String(buffer.array(), 0, numBytesRead);
                            System.out.println("Received request: " + request);
                            String response = "Hello, client!";
                            buffer.clear();
                            buffer.put(response.getBytes());
                            buffer.flip();
                            client.write(buffer);
                            System.out.println("Sent response: " + response);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            client.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
    }
}