package server;


import server.storage.InMemoryStorage;
import server.storage.Storage;

public class Main {
    private final static String ADDRESS = "127.0.0.1";
    private static final int PORT = 23456;
    public static final int MAX_AMOUNT_OF_CLIENTS = 50;

    public static void main(String[] args) {
        Storage storage = new InMemoryStorage();
        RequestHandler requestHandler = new RequestHandler(storage);
        Server server = new Server(ADDRESS, PORT, MAX_AMOUNT_OF_CLIENTS, requestHandler);
        server.start();
    }
}
