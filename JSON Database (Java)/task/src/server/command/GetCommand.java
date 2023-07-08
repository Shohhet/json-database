package server.command;

import server.storage.Storage;

public class GetCommand implements Command {
    private final Storage storage;
    private final int index;

    public GetCommand(Storage storage, int index) {
        this.storage = storage;
        this.index = index;
    }

    @Override
    public String execute() {
        String value = storage.get(index);
        return value.isEmpty() ? "ERROR" : value;
    }
}
