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
    private final int maxAmountOfClients;
    private final RequestHandler requestHandler;

    public Server(String address, int port, int maxAmountOfClients, RequestHandler requestHandler) {
        this.address = address;
        this.port = port;
        this.maxAmountOfClients = maxAmountOfClients;
        this.requestHandler = requestHandler;
    }

    public void start() {
        try (ServerSocket server = new ServerSocket(port, maxAmountOfClients, InetAddress.getByName(address))) {
            System.out.println("Server started!");

            while (requestHandler.isServerOnline()) {
                try (
                        Socket socket = server.accept();
                        var input = new DataInputStream(socket.getInputStream());
                        var output = new DataOutputStream(socket.getOutputStream())
                ) {
                        String request = input.readUTF();
                        System.out.println("Received: " + request);
                        String response = requestHandler.handle(request);
                        output.writeUTF(response);
                        System.out.println("Sent: " + response);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
