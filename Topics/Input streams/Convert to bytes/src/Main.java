import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        try (InputStream inputStream = System.in) {
            byte[] bytes;
            bytes = inputStream.readAllBytes();
            for (byte b : bytes) {
                System.out.print(b);
            }
        }
    }
}