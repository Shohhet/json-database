package server.command;

import server.storage.Storage;

public class DeleteCommand implements Command {
    private final Storage storage;
    private final int index;

    public DeleteCommand(Storage storage, int index) {
        this.storage = storage;
        this.index = index;
    }

    @Override
    public String execute() {
        return storage.delete(index) ? "OK" : "ERROR";
    }
}
