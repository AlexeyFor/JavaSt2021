package by.training.controller.command;

import by.training.controller.Command;

public class ErrorCommand implements Command {

	@Override
	public String execute(String[] request) {
		return "1___absent_command";
	}

}
