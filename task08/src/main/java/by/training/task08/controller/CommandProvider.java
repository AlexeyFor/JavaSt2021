package by.training.task08.controller;

import java.util.HashMap;
import java.util.Map;

import by.training.task08.controller.command.*;

public class CommandProvider {
	private static final CommandProvider сommandProvider = new CommandProvider();

	public static CommandProvider getсommandProvider() {
		return сommandProvider;
	}

	private Map<String, Command> commands = new HashMap<String, Command>();

	private CommandProvider() {
		commands.put("ERROR_СOMMAND", new ErrorCommand());
//		commands.put("SORT_PARAGRAPHS_BY_SENTENCES", new SortParagraphsBySentencesNumCommand());
//		commands.put("SORT_WORDS_IN_SENTENCES_BY_WORDS_LENGTH", new SortWordsInSentencesByWordsLengthCommand());
//		commands.put("SORT_LEXEMS_IN_TEXT_BY_SYMBOLS_NUMBER", new SortLexemsInTextBySymbolsNumberCommand());
//		commands.put("OPERATION_0", new Operation0Command());

	}

	public Command getCommand(String key) {
		if (commands.containsKey(key)) {
			Command com = commands.get(key);
			return com;
		} else {
			return commands.get("ERROR_СOMMAND");
		}

	}
}
