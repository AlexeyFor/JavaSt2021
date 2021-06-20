package by.training.service;

import by.training.entity.Car;

public interface Logic {
	
	/**
	 * Return Car from file
	 * @param path
	 * @return
	 * @throws ServiceException
	 */
	public Car takeCarFromFile(String path) throws ServiceException;

	/**
	 * Save car in file
	 * @param car
	 * @param path
	 * @return
	 * @throws ServiceException
	 */
	public  boolean saveCarInFile(Car car, String path) throws ServiceException;

}
