package by.training.service;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.Matrix;
import by.training.service.creator.CreatorException;
import by.training.service.creator.MatrixBigDecimalCreator;

/**
 *logics for Matrix
 * 
 * @author AlexeySupruniuk
 *
 */
public class MatrixCalculationImpl implements MatrixCalculation {

	private static final Logger LOG = LogManager.getLogger(MatrixCalculationImpl.class);

	@Override
	/**
	 * Addition of matrix
	 */
	public <T extends Number> Matrix<BigDecimal> matrixAddition(Matrix<T> matrix1, Matrix<T> matrix2)
			throws ServiceException {
		LOG.debug("start sumMatrix");

		if (!chekMatrix(matrix1, matrix2)) {
			LOG.warn("wrong matrix size");
			throw new ServiceException("wrong_matrix_size");
		}

		try {
			MatrixBigDecimalCreator tmp = new MatrixBigDecimalCreator();
			BigDecimal value;
			Matrix<BigDecimal> result = tmp.createEmptyMatrix(matrix1.getMatrixLength(), matrix1.getArrayLength(0));

			for (int i = 0; i < result.getMatrixLength(); i++) {
				for (int j = 0; j < result.getArrayLength(0); j++) {
					BigDecimal firstMatrixValue = new BigDecimal(matrix1.getValue(i, j).toString());
					BigDecimal secondMatrixValue = new BigDecimal(matrix2.getValue(i, j).toString());
					value = firstMatrixValue.add(secondMatrixValue);
					result.setValue(i, j, value);
				}
			}

			LOG.debug("calculation of the sum of matrices was successful ");
			return result;
		} catch (CreatorException e) {
			LOG.warn("wrong matrix size");
			throw new ServiceException("wrong_matrix_size");
		}
	}

	@Override
	/**
	 * Subtraction of matrix
	 */
	public <T extends Number> Matrix<BigDecimal> matrixSubtraction(Matrix<T> matrix1, Matrix<T> matrix2)
			throws ServiceException {
		LOG.debug("start matrixSubtraction");

		if (!chekMatrix(matrix1, matrix2)) {
			LOG.warn("wrong matrix size");
			throw new ServiceException("wrong_matrix_size");
		}

		try {
			MatrixBigDecimalCreator tmp = new MatrixBigDecimalCreator();
			BigDecimal value;
			Matrix<BigDecimal> result = tmp.createEmptyMatrix(matrix1.getMatrixLength(), matrix1.getArrayLength(0));

			for (int i = 0; i < result.getMatrixLength(); i++) {
				for (int j = 0; j < result.getArrayLength(0); j++) {
					BigDecimal firstMatrixValue = new BigDecimal(matrix1.getValue(i, j).toString());
					BigDecimal secondMatrixValue = new BigDecimal(matrix2.getValue(i, j).toString());
					value = firstMatrixValue.subtract(secondMatrixValue);
					result.setValue(i, j, value);
				}
			}

			LOG.debug("calculation of the subtraction of matrices was successful ");
			return result;
		} catch (CreatorException e) {
			LOG.warn("wrong matrix size");
			throw new ServiceException("wrong_matrix_size");
		}
	}

	/**
	 * Multiplication of matrix
	 */
	public <T extends Number> Matrix<BigDecimal> matrixMultiplication(Matrix<T> matrix1, Matrix<T> matrix2)
			throws ServiceException {
		LOG.debug("start matrixMultiplication");

		if (!chekMatrixForMultiplication(matrix1, matrix2)) {
			LOG.warn("wrong matrix size");
			throw new ServiceException("wrong_matrix_size");
		}

		try {
			MatrixBigDecimalCreator tmp = new MatrixBigDecimalCreator();

			// The number of rows in matrix1 - А, the number of columns in the matrix2 - B
			// Therefore, the dimension of the matrix C = AxB.
			Matrix<BigDecimal> result = tmp.createEmptyMatrix(matrix1.getMatrixLength(), matrix2.getArrayLength(0));

			for (int i = 0; i < result.getMatrixLength(); i++) {
				for (int j = 0; j < result.getArrayLength(0); j++) {
					BigDecimal value = new BigDecimal(0);

					for (int k = 0; k < result.getMatrixLength(); k++) {
						BigDecimal firstMatrixValue = new BigDecimal(matrix1.getValue(i, k).toString());
						BigDecimal secondMatrixValue = new BigDecimal(matrix2.getValue(k, j).toString());
						value = value.add(firstMatrixValue.multiply(secondMatrixValue));
					}

					result.setValue(i, j, value);
				}
			}

			LOG.debug("calculation of the multiplicatiom of matrices was successful ");
			return result;
		} catch (CreatorException e) {
			LOG.warn("wrong matrix size");
			throw new ServiceException("wrong_matrix_size");
		}

	}

	/**
	 * check if the sizes of the matrices are the same
	 * 
	 * @param matrix1
	 * @param matrix2
	 * @return
	 */
	private <T extends Number> boolean chekMatrix(Matrix<T> matrix1, Matrix<T> matrix2) {
		if (matrix1.getMatrixLength() != matrix2.getMatrixLength()) {
			return false;
		}
		if (matrix1.getArrayLength(0) != matrix2.getArrayLength(0)) {
			return false;
		}
		return true;
	}

	/**
	 * checks if matrices are suitable for multiplication
	 * 
	 * @param matrix1
	 * @param matrix2
	 * @return
	 */
	private <T extends Number> boolean chekMatrixForMultiplication(Matrix<T> matrix1, Matrix<T> matrix2) {
		if (matrix1.getArrayLength(0) == matrix2.getMatrixLength()) {
			return true;
		} else {
			return false;
		}

	}

}
