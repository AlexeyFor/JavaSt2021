package by.training.service.creator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.Engine;
import by.training.service.ServiceException;

public class EngineCreator {

	private static final Logger LOG = LogManager.getLogger(EngineCreator.class);

	/**
	 * create Engine
	 * 
	 * @param fuelConsumptionPerHundred
	 * @param type
	 * @return
	 * @throws ServiceException
	 */
	public Engine createEngine(double fuelConsumptionPerHundred, String type) throws ServiceException {

		LOG.debug(String.format("start createEngine with type + %s, fuelConsumptionPerHundred + %s", type,
				fuelConsumptionPerHundred));
		if (fuelConsumptionPerHundred < 0) {
			throw new ServiceException("wrong_data");
		}
		Engine engine = new Engine(fuelConsumptionPerHundred, type);
		return engine;
	}
}
