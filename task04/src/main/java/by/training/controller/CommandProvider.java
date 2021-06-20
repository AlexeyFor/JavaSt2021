package by.training.controller;

import java.util.HashMap;
import java.util.Map;

import by.training.controller.command.*;

public class CommandProvider {
	private static final CommandProvider сommandProvider = new CommandProvider();

	public static CommandProvider getсommandProvider() {
		return сommandProvider;
	}

	private Map<String, Command> commands = new HashMap<String, Command>();

	private CommandProvider() {
		commands.put("RIDE", new RideCommand());
		commands.put("REFUEL", new RefuelCommand());
		commands.put("VIEW", new ViewCarCommand());
		commands.put("CHANGE WHEEL", new ChangeWheelCommand());

		commands.put("ERROR СOMMAND", new ErrorCommand());
		commands.put("SET LANGUAGE", new SetLanguageCommand());

		

	}

	public Command getCommand(String key) {
		if (commands.containsKey(key)) {
			Command com = commands.get(key);
			return com;
		} else {
			return commands.get("ERROR СOMMAND");
		}

	}
}
