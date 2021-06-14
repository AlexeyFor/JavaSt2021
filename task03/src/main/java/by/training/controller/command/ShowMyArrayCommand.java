package by.training.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.controller.Command;
import by.training.entity.MyArray;
import by.training.service.ServiceException;
import by.training.service.ServiceProvider;
import by.training.view.ShowMyArray;

/**
 * request in form:
 * 
 * command___fileName
 * 
 * filename - name of the file from console
 * 
 * @author AlexeySupruniuk
 *
 */

public class ShowMyArrayCommand implements Command {

	private static final Logger LOG = LogManager.getLogger(ShowMyArrayCommand.class);

	@Override
	public String execute(String[] request) {

		if (request.length != 2) {
			LOG.warn("wrong request");
			return "1___wrong_request";
		}
		LOG.debug("start execute with " + request[1]);

		ShowMyArray show = ShowMyArray.getInstance();
		ServiceProvider provider = ServiceProvider.getInstance();
		MyArray<?> array;

		try {
			array = provider.getLogic().takeMyArray(request[1]);
			show.showMyArrayInRow(array, 50);
		} catch (ServiceException e) {
			LOG.error("from execute, " + e.getMessage());
			return "1___" + e.getMessage();
		}

		return "0___myArray_show_success";
	}
}
