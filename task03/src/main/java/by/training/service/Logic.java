package by.training.service;

import by.training.entity.Matrix;
import by.training.entity.MyArray;

public interface Logic {

	/**
	 * 
	 * @param <T>
	 * @param path
	 * @return
	 * @throws ServiceException
	 */
	public <T> MyArray<T> takeMyArray(String path) throws ServiceException;

	/**
	 * 
	 * @param <T>
	 * @param array
	 * @param path
	 * @return
	 * @throws ServiceException
	 */
	public <T> boolean saveMyArray(MyArray<T> array, String path) throws ServiceException;

	/**
	 * 
	 * @param <T>
	 * @param path
	 * @return
	 * @throws ServiceException
	 */
	public <T extends Number> Matrix<T> takeMatrix(String path) throws ServiceException;

	/**
	 * 
	 * @param <T>
	 * @param matrix
	 * @param path
	 * @return
	 * @throws ServiceException
	 */
	public <T extends Number> boolean saveMatrix(Matrix<T> matrix, String path) throws ServiceException;

}
