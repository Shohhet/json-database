package server.command;

import server.RequestHandler;

public class CommandResolver {
    private final RequestHandler requestHandler;

    public CommandResolver(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public Command resolve(String request) {
        Command command = new WrongCommand();
        if (request == null) {
            return command;
        }

        String[] requestParts = request.split("\\s+", 2);
        switch (requestParts[0]) {
            case "get" -> {
                try {
                    int index = Integer.parseInt(requestParts[1]);
                    command = new GetCommand(requestHandler.getStorage(), index);
                } catch (NumberFormatException e) {
                    command = new WrongCommand();
                }
            }
            case "set" -> {
                String[] setRequestParts = requestParts[1].split("\\s+", 2);
                if (setRequestParts.length > 1) {
                    try {
                        int index = Integer.parseInt(setRequestParts[0]);
                        command = new SetCommand(requestHandler.getStorage(), index, setRequestParts[1]);
                    } catch (NumberFormatException e) {
                        command = new WrongCommand();
                    }
                }
            }
            case "delete" -> {
                try {
                    int index = Integer.parseInt(requestParts[1]);
                    command = new DeleteCommand(requestHandler.getStorage(), index);
                } catch (NumberFormatException e) {
                    command = new WrongCommand();
                }
            }
            case "exit" -> {
                if (requestParts.length == 1) {
                    command = new ExitCommand(requestHandler);
                }
            }
        }
        return command;
    }

}
