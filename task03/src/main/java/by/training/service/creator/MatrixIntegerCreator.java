package by.training.service.creator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.Matrix;

/**
 * Logics for creation Matrix <Integer>
 * 
 * @author AlexeySupruniuk
 *
 */
public class MatrixIntegerCreator {

	private static final Logger LOG = LogManager.getLogger(MatrixIntegerCreator.class);

	/**
	 * Create and return Matrix <Integer> with given matrixlength , arrayLength and
	 * random numbers from min to max
	 * 
	 * @param matrixlegth
	 * @param arrayLength
	 * @param min
	 * @param max
	 * @return Matrix <Integer>
	 * @throws CreatorException
	 */
	public Matrix<Integer> createRandomMatrix(int matrixlegth, int arrayLength, int min, int max)
			throws CreatorException {
		LOG.debug(String.format("start createRandomMA with matrixlegth %s, arrayLength %s, min %s, max %s", matrixlegth,
				arrayLength, min, max));

		if ((max < min) || (matrixlegth < 1) || (arrayLength < 1)) {
			LOG.warn("from createRandomMatrix, wrong data ");
			throw new CreatorException("wrong_parametres");
		}

		Integer[][] array = new Integer[matrixlegth][arrayLength];

		for (int i = 0; i < matrixlegth; i++) {
			for (int j = 0; j < arrayLength; j++) {
				array[i][j] = (int) (Math.random() * (max - min) + min);
			}
		}

		Matrix<Integer> result = new Matrix<Integer>(array);
		LOG.debug("return Matrix");
		return result;
	}

	/**
	 * Create and return Matrix [Integer]
	 * 
	 * @param array
	 * @return MyArray<Integer>
	 * @throws CreatorException
	 */
	public Matrix<Integer> createMatrix(Integer[]... array) throws CreatorException {
		LOG.debug("start createMatrix");
		int length = array[0].length;

		for (int i = 1; i < array.length; i++) {
			if (array[1].length != length) {
				LOG.warn("from createMatrix, wrong array length ");
				throw new CreatorException("wrong_parametres");
			}
		}
		Matrix<Integer> result = new Matrix<Integer>(array);
		LOG.debug("return createMatrix");
		return result;
	}

}
