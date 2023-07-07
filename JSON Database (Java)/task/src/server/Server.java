package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final String address;
    private final int port;
    private  final int maxAmountOfClients;

    public Server(String address, int port, int maxAmountOfClients) {
        this.address = address;
        this.port = port;
        this.maxAmountOfClients = maxAmountOfClients;
    }

    public void start() {
        try (ServerSocket server = new ServerSocket(port, maxAmountOfClients, InetAddress.getByName(address))) {
            System.out.println("Server started!");
            try (
                    Socket socket = server.accept();
                    var input = new DataInputStream(socket.getInputStream());
                    var output = new DataOutputStream(socket.getOutputStream())
            ) {
                System.out.println("Received: " + input.readUTF());
                output.writeUTF(answer);
                System.out.println("Sent: " + answer);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
