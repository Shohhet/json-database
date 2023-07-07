package server.storage;

import java.util.Arrays;
import java.util.Objects;

import static server.storage.StorageUtils.STORAGE_SIZE;
import static server.storage.StorageUtils.EMPTY_CELL_VALUE;

public class InMemoryStorage implements Storage{
    private final String[] storage;

    public InMemoryStorage() {
        storage = new String[STORAGE_SIZE];
        Arrays.fill(storage, EMPTY_CELL_VALUE);
    }

    @Override
    public boolean set(int index, String value) {
        if (isCorrectIndex(index) && isCorrectValue(value)) {
            storage[index - 1] = value;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String get(int index) {
        if (isCorrectIndex(index)) {
            return storage[index - 1];
        } else {
            return EMPTY_CELL_VALUE;
        }
    }
    @Override
    public boolean delete(int index) {
        if (isCorrectIndex(index)) {
            storage[index] = EMPTY_CELL_VALUE;
            return true;
        } else {
            return false;
        }
    }

    private boolean isCorrectIndex(int index) {
        return index > 0 && index <= STORAGE_SIZE;
    }

    private boolean isCorrectValue(String value) {
        return Objects.nonNull(value) && !value.isEmpty();
    }

}
