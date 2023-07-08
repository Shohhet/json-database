package client;

import com.beust.jcommander.JCommander;

public class Main {

    public static void main(String[] args) {
        Args arguments = new Args();
        JCommander.newBuilder()
                .addObject(arguments)
                .build()
                .parse(args);
        Client.start(arguments.resolve());
    }
}
