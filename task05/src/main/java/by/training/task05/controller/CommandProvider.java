package by.training.task05.controller;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private static final CommandProvider сommandProvider = new CommandProvider();

    public static CommandProvider getсommandProvider() {
	return сommandProvider;
    }

    private Map<String, Command> commands = new HashMap<String, Command>();

    private CommandProvider() {
	// commands.put("RIDE", new RideCommand());

	// commands.put("ERROR СOMMAND", new ErrorCommand());

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
