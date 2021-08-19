package by.training.task08.controller.command;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task08.controller.Command;
import by.training.task08.entity.Gem;
import by.training.task08.service.GemParserService;

public class GemParserCommand implements Command {

	private static final Logger LOG = LogManager.getLogger(GemParserCommand.class);
/**
 * Command___ParserName___fileXML___fileXSD
 * @param request
 * @return
 */
	@Override
	public String execute(String[] request) {
		final int MAX_REQUEST_NUMBER = 4;

		if (request.length != MAX_REQUEST_NUMBER) {
			LOG.warn("wrong request");
			return "1___wrong_request";
		}
		LOG.debug("start execute with " + request[1]);

		String ParserName = request[1];
		String fileXML = request[2];
		String fileXSD = request[3];
		List<Gem> answer;
		GemParserService parser;
		
		

		if (symbolStr.length() != 1) {
			LOG.warn("wrong request (symbol)");
			return "1___wrong_request_symbol";
		}
		char symbol = symbolStr.charAt(0);

		try {
			text = TextFromFileLogic.getInstance().fromFileToString(fileName);
			answer = service.sortLexemsInTextBySymbolsNumber(text, symbol);
			view.showTextOfLexems(answer);
			return "0___sort_success";
		} catch (ServiceException e) {
			LOG.error("from execute, " + e.getMessage());
			return "1___" + e.getMessage();
		}

	}
}
