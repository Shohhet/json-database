package server.command;

public class WrongCommand implements Command {
    @Override
    public String execute() {
        return "ERROR";
    }
}
