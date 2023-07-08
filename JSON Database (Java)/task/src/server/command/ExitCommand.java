package server.command;

import server.RequestHandler;

public class ExitCommand implements Command {
    private final RequestHandler requestHandler;
    public ExitCommand(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    @Override
    public String execute() {
        requestHandler.shutdownServer();
        return "OK";
    }
}
