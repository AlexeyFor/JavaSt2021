package by.training.service.creator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.dal.WorkWithFileImpl;
import by.training.entity.Car;
import by.training.entity.Engine;
import by.training.entity.Wheel;
import by.training.service.ServiceException;

public class CarCreator {
	private static final Logger LOG = LogManager.getLogger(CarCreator.class);

	/**
	 * Create Car
	 * 
	 * @param mark
	 * @param model
	 * @param fuelVolume
	 * @param MAX_FUEL_VOLUME
	 * @return
	 * @throws ServiceException
	 */
	public Car createCar(String mark, String model, double fuelVolume, double MAX_FUEL_VOLUME) throws ServiceException {
		LOG.debug(String.format("start createCar with mark - %s, model - %s, fuelVolume - %s, MAX_FUEL_VOLUME - %s",
				mark, model, fuelVolume, MAX_FUEL_VOLUME));
		if (!checkFuelVolume(fuelVolume, MAX_FUEL_VOLUME) || (MAX_FUEL_VOLUME < 0)) {
			throw new ServiceException("wrong data, check fuel");
		}
		Car car = new Car(mark, model, fuelVolume, MAX_FUEL_VOLUME);
		return car;
	};

	/**
	 * Create Car
	 * 
	 * @param mark
	 * @param model
	 * @param fuelVolume
	 * @param MAX_FUEL_VOLUME
	 * @param engine
	 * @param wheels
	 * @return
	 * @throws ServiceException
	 */
	public Car createCar(String mark, String model, double fuelVolume, double MAX_FUEL_VOLUME, Engine engine,
			Wheel[] wheels) throws ServiceException {
		LOG.debug(String.format("start createCar with mark - %s, model - %s, fuelVolume - %s, MAX_FUEL_VOLUME - %s",
				mark, model, fuelVolume, MAX_FUEL_VOLUME));
		if (wheels.length > 4) {
			throw new ServiceException("wrong number of wheels");
		}
		Car car = createCar(mark, model, fuelVolume, MAX_FUEL_VOLUME);
		car.setWheels(wheels);
		car.setEngine(engine);
		return car;
	}

	private boolean checkFuelVolume(double fuelVolume, double MAX_FUEL_VOLUME) {
		if ((fuelVolume >= 0) && (fuelVolume < MAX_FUEL_VOLUME)) {
			return true;
		}
		return false;
	}
}
