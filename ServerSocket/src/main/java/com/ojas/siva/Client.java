package com.ojas.siva;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
public class Client {
    private static final String SERVER_HOSTNAME = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final int BUFFER_SIZE = 1024;
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress(SERVER_HOSTNAME, SERVER_PORT));
        while (!socketChannel.finishConnect()) {
            // wait for connection to complete
        }
        ByteBuffer writeBuffer = ByteBuffer.allocate(BUFFER_SIZE);
        ByteBuffer readBuffer = ByteBuffer.allocate(BUFFER_SIZE);
        String request = "Hello, server!";
        writeBuffer.put(request.getBytes());
        writeBuffer.flip();
        while (writeBuffer.hasRemaining()) {
            socketChannel.write(writeBuffer);
        }
        readBuffer.clear();
        int numBytesRead = socketChannel.read(readBuffer);
        readBuffer.flip();
        byte[] data = new byte[readBuffer.limit()];
        readBuffer.get(data);
        String response = new String(data);
        System.out.println("Response from server: " + response);
        socketChannel.close();
    }
}