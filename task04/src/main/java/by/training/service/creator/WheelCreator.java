package by.training.service.creator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.Wheel;
import by.training.service.ServiceException;

public class WheelCreator {
	private static final Logger LOG = LogManager.getLogger(WheelCreator.class);

	/**
	 * create Wheel
	 * 
	 * @param diameter
	 * @param type
	 * @return
	 * @throws ServiceException
	 */
	public Wheel createWheel(double diameter, String type) throws ServiceException {
		LOG.debug(String.format("start createWheel with type + %s, diameter + %s", type, diameter));

		if (diameter < 0) {
			throw new ServiceException("wrong_data");
		}
		Wheel wheel = new Wheel(diameter, type);
		return wheel;
	}

	/**
	 * Create array of the same wheels
	 * 
	 * @param length
	 * @param diameter
	 * @param type
	 * @return
	 * @throws ServiceException
	 */
	public Wheel[] createArrayOfSameWheels(int length, double diameter, String type) throws ServiceException {
		LOG.debug(String.format("start createArrayOfSameWheels with type + %s, diameter + %s", type, diameter));

		if (length < 0) {
			throw new ServiceException("wrong_data");
		}

		Wheel[] wheels = new Wheel[length];
		for (int i = 0; i < length; i++) {
			wheels[i] = createWheel(diameter, type);
		}

		return wheels;
	}
}
