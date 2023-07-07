package server.operation;

import server.storage.Storage;

public class GetStorageOperation implements StorageOperation {
    Storage storage;
    int index;

    public GetStorageOperation(Storage storage, int index) {
        this.storage = storage;
        this.index = index;
    }

    @Override
    public String execute() {
        String value = storage.get(index);
        return value.isEmpty() ? "ERROR" : value;
    }
}
