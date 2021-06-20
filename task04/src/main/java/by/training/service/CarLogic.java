package by.training.service;

import by.training.entity.Car;
import by.training.entity.Wheel;

/**
 * Logic for Car
 * @author AlexeySupruniuk
 *
 */
public interface CarLogic {

	/**
	 * take car and distance of "trip", if there not enough fuel, no engine or wheels - return false;
	 * @param car
	 * @param distance
	 * @return
	 */
	public boolean ride (Car car, double distance) throws ServiceException;
	
	/**
	 * take car and amount of fuel, if there not enough space for fuel  - return false;
	 * @param car
	 * @param fuelAmount
	 * @return
	 */
	public boolean refuel (Car car, double fuelAmount) throws ServiceException;
	
	/**
	 *  change wheel in car
	 * @param car
	 * @param wheel
	 * @param index
	 * @return
	 */
	public boolean changeWheel (Car car, Wheel wheel, int index) throws ServiceException;
	
}
