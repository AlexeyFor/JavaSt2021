package by.training.service;

import java.math.BigDecimal;

import by.training.entity.Matrix;

public interface MatrixCalculation  {

	/**
	 * return summ of matrix
	 * @param <T>
	 * @param matrix1
	 * @param matrix2
	 * @return
	 * @throws ServiceException
	 */
	<T extends Number> Matrix <BigDecimal> matrixAddition (Matrix <T> matrix1, Matrix <T> matrix2) throws ServiceException;
	
	/**
	 * return result of subtraction of matrix
	 * @param <T>
	 * @param matrix1
	 * @param matrix2
	 * @return
	 * @throws ServiceException
	 */
	<T extends Number> Matrix <BigDecimal> matrixSubtraction (Matrix <T> matrix1, Matrix <T> matrix2) throws ServiceException;

	/**
	 * return result of subtraction of multiplication
	 * @param <T>
	 * @param matrix1
	 * @param matrix2
	 * @return
	 * @throws ServiceException
	 */
	<T extends Number> Matrix <BigDecimal> matrixMultiplication (Matrix <T> matrix1, Matrix <T> matrix2) throws ServiceException;

}
