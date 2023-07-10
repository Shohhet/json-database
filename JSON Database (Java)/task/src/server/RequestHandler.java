package server;

import server.command.*;
import server.storage.Storage;

public class RequestHandler {
    private final Storage storage;
    private final CommandResolver commandResolver;
    private boolean serverOnline;

    public RequestHandler(Storage storage) {
        this.storage = storage;
        this.serverOnline = true;
        commandResolver = new CommandResolver(this);
    }

    public String handle(String request) {
        return commandResolver.resolve(request).execute();

    }

    public Storage getStorage() {
        return storage;
    }
    public boolean isServerOnline () {
        return this.serverOnline;
    }

    public void shutdownServer() {
        this.serverOnline = false;
    }
}
