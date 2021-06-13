package by.training.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.Matrix;

/**
 * Methods for displaying Matrix<>
 * 
 * @author AlexeySupruniuk
 *
 */
public class ShowMatrix {
	private static final Logger LOG = LogManager.getLogger(ShowMatrix.class);

	private static ShowMatrix instance = new ShowMatrix();

	private ShowMatrix() {
	}

	public static ShowMatrix getInstance() {
		return instance;
	}

	/**
	 * show Matrix
	 * 
	 * @param matrix
	 * @param quantityPerLine
	 */
	public void showMatrix(Matrix<?> matrix) {
		LOG.debug("start showMatrix");
		for (int i = 0; i < matrix.getMatrixLength(); i++) {
			for (int j = 0; j < matrix.getArrayLength(0); j++) {
				System.out.print(matrix.getValue(i, j) + "   ");
			}
			System.out.println();
		}
	}
}
