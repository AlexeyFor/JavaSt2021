package by.training.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.controller.Command;
import by.training.entity.Car;
import by.training.entity.Wheel;
import by.training.service.ServiceException;
import by.training.service.ServiceProvider;
import by.training.service.creator.WheelCreator;

/**
 * request in form:
 * 
 * command___fileName___wheelType___wheelDiameter___index___saving
 * 
 * index - index of wheel
 * 
 * @author AlexeySupruniuk
 *
 */
public class ChangeWheelCommand implements Command {

	private static final Logger LOG = LogManager.getLogger(ChangeWheelCommand.class);

	@Override
	public String execute(String[] request) {

		if (request.length != 6) {
			LOG.warn("wrong request");
			return "1___wrong_request";
		}
		LOG.debug("start execute with " + request[1] + " " + request[2] + " " + request[3] + " " + request[4] + " "
				+ request[5]);
		double wheelDiameter = 0;
		int index = 0;
		try {
			wheelDiameter = Double.valueOf(request[3]);
			index = Integer.valueOf(request[4]);
		} catch (NumberFormatException e) {
			LOG.debug("Not number!");
			return "1___wrong_request";
		}
		String fileName = request[1];
		String wheelType = request[2];
		boolean saving = Boolean.valueOf(request[5]);
		boolean answer;

		ServiceProvider provider = ServiceProvider.getInstance();
		try {
			Car car = provider.getLogic().takeCarFromFile(fileName);
			WheelCreator creator = new WheelCreator();
			Wheel wheel = creator.createWheel(wheelDiameter, wheelType);
			answer = provider.getCarLogic().changeWheel(car, wheel, index);

			if (saving) {
				LOG.debug("saving car");
				provider.getLogic().saveCarInFile(car, fileName);
			}
		} catch (ServiceException e) {
			LOG.error("from execute, " + e.getMessage());
			return "1___" + e.getMessage();
		}

		if (answer) {
			return "0___change_success";
		} else {
			return "0___change_failed";
		}

	}
}
