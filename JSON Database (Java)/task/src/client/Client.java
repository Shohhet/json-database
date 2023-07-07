package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private final static String ADDRESS = "127.0.0.1";
    private static final int PORT = 23456;
    private final static String request = "Give me a record # 12";

    public static void start() {
        try (
                Socket socket = new Socket(InetAddress.getByName(ADDRESS), PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            System.out.println("Client started!");
            output.writeUTF(request);
            System.out.println("Sent: " + request);
            System.out.println("Received: " + input.readUTF());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
