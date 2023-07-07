package server.storage;

import java.util.Optional;

public interface Storage {
    boolean set(int index, String value);
    String get(int index);
    boolean delete(int index);
}
