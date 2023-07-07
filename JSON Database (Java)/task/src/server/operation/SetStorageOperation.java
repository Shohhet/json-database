package server.operation;

import server.storage.Storage;

public class SetStorageOperation implements StorageOperation{
    Storage storage;
    int index;
    String value;

    public SetStorageOperation(Storage storage, int index, String value) {
        this.storage = storage;
        this.index = index;
        this.value = value;
    }

    @Override
    public String execute() {
        return storage.set(index, value) ? "OK" : "ERROR";
    }
}
