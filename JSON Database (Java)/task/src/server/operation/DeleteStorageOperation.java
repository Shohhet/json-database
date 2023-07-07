package server.operation;

import server.storage.Storage;

public class DeleteStorageOperation implements StorageOperation{
    Storage storage;
    int index;
    @Override
    public String execute() {
        return storage.delete(index) ? "OK" : "ERROR";
    }
}
