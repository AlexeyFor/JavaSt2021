package by.training.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.controller.Command;
import by.training.entity.Car;
import by.training.service.ServiceException;
import by.training.service.ServiceProvider;
import by.training.view.ViewCar;

/**
 * request in form:
 * 
 * command___fileName
 * 
 * 
 * @author AlexeySupruniuk
 *
 */
public class ViewCarCommand implements Command {

	private static final Logger LOG = LogManager.getLogger(ViewCarCommand.class);

	@Override
	public String execute(String[] request) {
		if (request.length != 2) {
			LOG.warn("wrong request");
			return "1___wrong_request";
		}
		LOG.debug("start execute with " + request[1]);
		String fileName = request[1];

		ServiceProvider provider = ServiceProvider.getInstance();
		try {
			Car car = provider.getLogic().takeCarFromFile(fileName);
			ViewCar view = ViewCar.getInstance();
			view.viewCar(car);
		} catch (ServiceException e) {
			LOG.error("from execute, " + e.getMessage());
			return "1___" + e.getMessage();
		}
		return "0___view_success";
	}
}
