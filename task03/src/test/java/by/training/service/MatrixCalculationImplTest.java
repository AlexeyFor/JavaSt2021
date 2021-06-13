package by.training.service;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.training.entity.Matrix;
import by.training.service.MatrixCalculationImpl;
import by.training.service.ServiceException;
import by.training.service.creator.CreatorException;

public class MatrixCalculationImplTest {

	MatrixCalculationImpl tmp = new MatrixCalculationImpl();

	@DataProvider(name = "matrixAddition")
	public Object[] matrixAddition() throws CreatorException {
		return new Object[][] {
				{ new Matrix<Integer>(Integer3x3Array(0, 0, 0, 1, 2, 4, 6, 7, 8)),
						new Matrix<Integer>(Integer3x3Array(0, 0, 0, 1, 9, 15, 11, 13, 19)),
						new Matrix<BigDecimal>(BigDecimal3x3Array("0", "0", "0", "2", "11", "19", "17", "20", "27")) },
				{ new Matrix<Integer>(
						Integer3x3Array(Integer.MAX_VALUE, Integer.MAX_VALUE, 5, 1, Integer.MIN_VALUE, 4, 6, 7, 8)),
						new Matrix<Integer>(Integer3x3Array(Integer.MAX_VALUE, Integer.MAX_VALUE, 6, 13,
								Integer.MIN_VALUE, 0, -6, -7, -8)),
						new Matrix<BigDecimal>(BigDecimal3x3Array("4294967294", "4294967294", "11", "14", "-4294967296",
								"4", "0", "0", "0")) } };
	}

	@DataProvider(name = "matrixSubtraction")
	public Object[] matrixSubtraction() throws CreatorException {
		return new Object[][] {
				{ new Matrix<Integer>(Integer3x3Array(0, 0, 0, 1, 2, 4, 6, 7, 8)),
						new Matrix<Integer>(Integer3x3Array(0, 0, 0, 1, 9, 15, 11, 13, 19)),
						new Matrix<BigDecimal>(
								BigDecimal3x3Array("0", "0", "0", "0", "-7", "-11", "-5", "-6", "-11")) },
				{ new Matrix<Integer>(
						Integer3x3Array(Integer.MAX_VALUE, Integer.MAX_VALUE, 5, 1, Integer.MIN_VALUE, 4, 6, 7, 8)),
						new Matrix<Integer>(Integer3x3Array(Integer.MAX_VALUE, Integer.MAX_VALUE, 6, 13,
								Integer.MIN_VALUE, 0, -6, -7, -8)),
						new Matrix<BigDecimal>(
								BigDecimal3x3Array("0", "0", "-1", "-12", "0", "4", "12", "14", "16")) } };
	}

	@DataProvider(name = "matrixMultiplication")
	public Object[] matrixMultiplication() throws CreatorException {
		return new Object[][] {
				{ new Matrix<Integer>(Integer3x3Array(0, 0, 0, 1, 2, 4, 6, 7, 8)),
						new Matrix<Integer>(Integer3x3Array(0, 0, 0, 1, 9, 15, 11, 13, 19)),
						new Matrix<BigDecimal>(
								BigDecimal3x3Array("0", "0", "0", "46", "70", "106", "95", "167", "257")) },
				{ new Matrix<Integer>(
						Integer3x3Array(Integer.MAX_VALUE, Integer.MAX_VALUE, 5, 1, Integer.MIN_VALUE, 4, 6, 7, 8)),
						new Matrix<Integer>(Integer3x3Array(Integer.MAX_VALUE, Integer.MAX_VALUE, 6, 13,
								Integer.MIN_VALUE, 0, -6, -7, -8)),
						new Matrix<BigDecimal>(
								BigDecimal3x3Array("4611686042049707990", "-2147483682", "12884901842", "-25769803801",
										"4611686020574871523", "-26", "12884901925", "-2147483710", "-28")) } };
	}

	@Test(description = "positive for matrixAddition", dataProvider = "matrixAddition")
	public <T extends Number> void matrixAdditionTest(Matrix<T> matrix1, Matrix<T> matrix2, Matrix<BigDecimal> answer)
			throws ServiceException {
		Matrix<BigDecimal> expected = tmp.matrixAddition(matrix1, matrix2);

		assertEquals(expected, answer);
	}

	@Test(description = "positive for matrixSubtraction", dataProvider = "matrixSubtraction")
	public <T extends Number> void matrixSubtractionTest(Matrix<T> matrix1, Matrix<T> matrix2,
			Matrix<BigDecimal> answer) throws ServiceException {
		Matrix<BigDecimal> expected = tmp.matrixSubtraction(matrix1, matrix2);

		assertEquals(expected, answer);
	}

	@Test(description = "positive for matrixMultiplication", dataProvider = "matrixMultiplication")
	public <T extends Number> void matrixMultiplicationTest(Matrix<T> matrix1, Matrix<T> matrix2,
			Matrix<BigDecimal> answer) throws ServiceException {
		Matrix<BigDecimal> expected = tmp.matrixMultiplication(matrix1, matrix2);

		assertEquals(expected, answer);
	}

	private Integer[][] Integer3x3Array(int... array) {
		Integer[][] result = new Integer[3][3];
		for (int i = 0; i < 3; i++) {
			result[0][i] = array[i];
		}
		for (int i = 0; i < 3; i++) {
			result[1][i] = array[i + 3];
		}
		for (int i = 0; i < 3; i++) {
			result[2][i] = array[i + 6];
		}
		return result;
	}

	private BigDecimal[][] BigDecimal3x3Array(String... array) {
		BigDecimal[][] result = new BigDecimal[3][3];
		for (int i = 0; i < 3; i++) {
			result[0][i] = new BigDecimal(array[i]);
		}
		for (int i = 0; i < 3; i++) {
			result[1][i] = new BigDecimal(array[i + 3]);
		}
		for (int i = 0; i < 3; i++) {
			result[2][i] = new BigDecimal(array[i + 6]);
		}
		return result;
	}
}