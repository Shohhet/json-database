package server.command;

import server.storage.Storage;

public class SetCommand implements Command {
    private final Storage storage;
    private final int index;
    private final String value;

    public SetCommand(Storage storage, int index, String value) {
        this.storage = storage;
        this.index = index;
        this.value = value;
    }

    @Override
    public String execute() {
        return storage.set(index, value) ? "OK" : "ERROR";
    }
}
