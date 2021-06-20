package by.training.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.controller.Command;
import by.training.entity.Car;
import by.training.service.ServiceException;
import by.training.service.ServiceProvider;

/**
 * request in form:
 * 
 * command___fileName___distance___saving
 * 
 * distance - distance for car in double
 * 
 * filename - name of the file
 * 
 * saving - save the result of sorting 
 * 
 * @author AlexeySupruniuk
 *
 */
public class RideCommand implements Command {

	private static final Logger LOG = LogManager.getLogger(RideCommand.class);

	@Override
	public String execute(String[] request) {

		if (request.length != 4) {
			LOG.warn("wrong request");
			return "1___wrong_request";
		}
		LOG.debug("start execute with " + request[1] + " " + request[2] + " " + request[3]);
		double distance = 0;
		try {
			distance = Double.valueOf(request[2]);
		} catch ( NumberFormatException e) {
			LOG.debug("Not double!");
			return "1___wrong_request";
		}
		String fileName = request[1];
		boolean saving = Boolean.valueOf(request[3]);
		boolean answer;
		LOG.debug("get fileName " + fileName + " ,distance " + distance + " ,saving " + saving);

		ServiceProvider provider = ServiceProvider.getInstance();
		try {
			Car car = provider.getLogic().takeCarFromFile(fileName);

			answer = provider.getCarLogic().ride(car, distance);

			if (saving) {
				LOG.debug("saving car");
				provider.getLogic().saveCarInFile(car, fileName);
			}
		} catch (ServiceException e) {
			LOG.error("from execute, " + e.getMessage());
			return "1___" + e.getMessage();
		}

		if (answer) {
			return "0___ride_success";
		} else {
			return "0___ride_failed";
		}

	}
}
