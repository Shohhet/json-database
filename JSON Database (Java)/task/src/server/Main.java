package server;

import static server.storage.StorageUtils.STORAGE_SIZE;

public class Main {


    public static void main(String[] args) {
    new Server().start();

       /* boolean isExit = false;
        JsonDatabase jsonDatabase = new JsonDatabase();
        do {
            String command = SCANNER.next();

            switch (command) {
                case "set" -> {
                    int index = Integer.parseInt(SCANNER.next());
                    if (checkParameter(index)) {
                        String value = SCANNER.nextLine().trim();
                        jsonDatabase.set(index - 1, value);
                        System.out.println("OK");
                    } else {
                        SCANNER.nextLine();
                        System.out.println("ERROR");
                    }

                }
                case "get" -> {
                    int index = Integer.parseInt(SCANNER.next());
                    if (checkParameter(index)) {
                        String value = jsonDatabase.get(index - 1);
                        System.out.println(value.isEmpty() ? "ERROR" : value);
                    } else {
                        SCANNER.nextLine();
                        System.out.println("ERROR");
                    }
                }
                case "delete" -> {
                    int index = Integer.parseInt(SCANNER.next());
                    if (checkParameter(index)) {
                        jsonDatabase.delete(index - 1);
                        System.out.println("OK");
                    } else {
                        SCANNER.nextLine();
                        System.out.println("ERROR");
                    }
                }
                case "exit" -> isExit = true;
                default -> System.out.println("ERROR");
            }

        } while (!isExit);*/


    }

    private static boolean checkParameter(int index) {
        return index >= 1 && index <= STORAGE_SIZE;
    }

}
