package by.training.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.Car;
import by.training.entity.Wheel;

public class CarLogicImpl implements CarLogic {

	private static final CarLogicImpl instance = new CarLogicImpl();

	private CarLogicImpl() {
	}

	public static CarLogicImpl getInstance() {

		return instance;
	}

	private static final Logger LOG = LogManager.getLogger(CarLogicImpl.class);

	@Override
	public boolean ride(Car car, double distance) throws ServiceException {
		LOG.debug("start ride");

		if (car == null) {
			throw new ServiceException("car_null");
		}
		if (distance < 0) {
			throw new ServiceException("wrong_distance");
		}
		if (distance == 0) {
			return true;
		}
		LOG.debug("distance is fine");
		if (!checkWheels(car) || !checkEngine(car)) {
			return false;
		}

		return calculateRide(car, distance);
	}

	@Override
	public boolean refuel(Car car, double fuelAmount) throws ServiceException {
		if (car == null) {
			throw new ServiceException("car_null");
		}
		LOG.debug("start refuel with fuelAmount" + fuelAmount + " ,maxFuel " + car.getMAX_FUEL_VOLUME()
				+ " , fuelVolume" + car.getFuelVolume());

		if (fuelAmount < 0) {
			throw new ServiceException("wrong_fuel");
		}

		double maxFuel = car.getMAX_FUEL_VOLUME();
		double fuelVolume = car.getFuelVolume();
		double calculateFuel = fuelVolume + fuelAmount;
		if (calculateFuel > maxFuel) {
			LOG.debug("return false");
			return false;
		} else {
			LOG.debug("return true and set new FuelVolume " + calculateFuel);
			car.setFuelVolume(calculateFuel);
			return true;
		}
	}

	@Override
	public boolean changeWheel(Car car, Wheel wheel, int index) throws ServiceException {
		LOG.debug(" start changeWheel");

		if (car == null) {
			throw new ServiceException("car_null");
		}
		if (wheel == null) {
			throw new ServiceException("wheel_null");
		}
		if (index < 0 || index > 3) {
			throw new ServiceException("wrong_index");
		}
		LOG.debug(" start set Wheel with " + wheel.toString());
		car.setWheel(wheel, index);
		return true;
	}

	/**
	 * check number of wheels, if there are less then 3 - return false
	 * 
	 * @return
	 */
	private boolean checkWheels(Car car) {
		LOG.debug(" start checkWheels");
		int counter = 0;
		for (int i = 0; i < 4; i++) {
			if ((car.getWheelType(i) == null) || (car.getWheelDiameter(i) == Double.NaN)) {
				LOG.debug("find null wheel");
				counter++;
			}
		}
		if (counter > 1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * check engine
	 * 
	 * @param car
	 * @return
	 */
	private boolean checkEngine(Car car) {
		LOG.debug(" start checkEngine type " + car.getEngineType() + " ,consumption "
				+ car.getEngineFuelConsumptionPerHundred());
		if ((car.getEngineType() == null) || (car.getEngineFuelConsumptionPerHundred() == Double.NaN)) {
			return false;
		}
		return true;
	}

	/**
	 * checks if the given car with the available fuel, the given consumption per
	 * hundred, can cover the given distance
	 * 
	 * @param car
	 * @param distance
	 * @return
	 */
	private boolean calculateRide(Car car, double distance) {
		LOG.debug("calculate ride with fuelVolume " + car.getFuelVolume() + " ,consumption "
				+ car.getEngineFuelConsumptionPerHundred() + " , distance " + distance);

		double fuelVolume = car.getFuelVolume();
		double consumption = car.getEngineFuelConsumptionPerHundred();
		if (consumption == 0) {
			return true;
		}

		double possibleDistance = (fuelVolume / consumption) * 100;
		LOG.debug("possibleDistance is " + possibleDistance);
		if (distance <= possibleDistance) {
			return true;
		} else {
			return false;
		}
	}

}
