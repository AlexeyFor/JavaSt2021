package by.training.task05.controller.command;

import by.training.task05.controller.Command;

public class ErrorCommand implements Command {

    @Override
    public String execute(String[] request) {
	return "1___absent_command";
    }

}
