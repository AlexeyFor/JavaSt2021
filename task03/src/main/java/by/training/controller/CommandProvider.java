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
		commands.put("BUBBLE SORTING", new BubbleSortingCommand());
		commands.put("INSERT HASH SORTING", new InsertsHashNumberSortingCommand());
		commands.put("INSERTS SORTING", new InsertsSortingCommand());
		commands.put("SELECTION SORTING", new SelectionSortingCommand());
		commands.put("SHAKE SORTING", new ShakeSortingCommand());
		commands.put("SHELL SORTING", new ShellSortingCommand());
		commands.put("MATRIX ADDITION", new MatrixAdditionCommand());
		commands.put("MATRIX SUBTRACTION", new MatrixSubtractionCommand());
		commands.put("MATRIX MULTIPLICATION", new MatrixMultiplicationCommand());


	}

	public Command getCommand(String key) {
		if (commands.containsKey(key)) {
			Command com = commands.get(key);
			return com;
		} else {
			return commands.get("Err");
		}

	}
}
