package by.training.service.creator;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.Matrix;

/**
 * Logics for creation MyArray <BigDecimal>
 * 
 * @author AlexeySupruniuk
 *
 */

public class MatrixBigDecimalCreator {

	private static final Logger LOG = LogManager.getLogger(MatrixBigDecimalCreator.class);

	/**
	 * create empty Matrix <BigDecimal>
	 * 
	 * @param matrixlegth
	 * @param arrayLength
	 * @return
	 * @throws CreatorException
	 */
	public Matrix<BigDecimal> createEmptyMatrix(int matrixlegth, int arrayLength) throws CreatorException {
		LOG.debug(
				String.format("start createEmptyMatrix with matrixlegth %s, arrayLength %s", matrixlegth, arrayLength));

		if ((matrixlegth < 1) || (arrayLength < 1)) {
			LOG.warn("from createRandomMatrix, wrong data ");
			throw new CreatorException("wrong_parametres");
		}

		BigDecimal[][] array = new BigDecimal[matrixlegth][arrayLength];

		Matrix<BigDecimal> result = new Matrix<BigDecimal>(array);
		LOG.debug("return Matrix");
		return result;
	}

}
