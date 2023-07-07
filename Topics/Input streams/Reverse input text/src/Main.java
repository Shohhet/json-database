import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        try(var reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.lines()
                    .map(s -> new StringBuilder(s).reverse())
                    .forEach(System.out::println);
        }
    }
}