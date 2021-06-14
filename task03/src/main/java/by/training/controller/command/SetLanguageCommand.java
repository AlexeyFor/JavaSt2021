package by.training.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.controller.Command;
import by.training.entity.MyArray;
import by.training.menu.Menu;
import by.training.service.ServiceException;
import by.training.service.ServiceProvider;
import by.training.view.ShowMyArray;

/**
 * request in form:
 * 
 * command___language
 * 
 * @author AlexeySupruniuk
 *
 */
public class SetLanguageCommand implements Command {

	private static final Logger LOG = LogManager.getLogger(SetLanguageCommand.class);

	@Override
	public String execute(String[] request) {

		if (request.length != 2) {
			LOG.warn("wrong request");
			return "1___wrong_request";
		}
		LOG.debug("start execute with " + request[1]);
		Menu menu = Menu.getInstance();

		if (request[1].equals("RU")) {
			menu.changeLanguage("ru", "RU");
			return "0___language_set_ru";
		} else if (request[1].equals("EN")) {
			menu.changeLanguage("en", "US");
			return "0___language_set_en";
		} else {
			return "1___wrong_language";
		}
			

		
	}
}
