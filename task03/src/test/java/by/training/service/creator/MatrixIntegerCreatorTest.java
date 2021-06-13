package by.training.service.creator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MatrixIntegerCreatorTest {

	MatrixIntegerCreator tmp = new MatrixIntegerCreator();

	@DataProvider(name = "createRandomMatrixNegative")
	public Object[][] createRandomMatrix() {
		return new Object[][] { { 0, 0, 2, 5 }, { -1, 5, 2, 5 }, { 5, -1, 2, 5 }, { 5, 5, 10, 9 } };
	}

	@Test(description = "negative for createRandomMatrix", dataProvider = "createRandomMatrixNegative", enabled = true, expectedExceptions = CreatorException.class)
	public void createRandomMatrixNegativeTest(int matrixlegth, int arrayLength, int min, int max)
			throws CreatorException {
		tmp.createRandomMatrix(matrixlegth, arrayLength, min, max);
	}

	@Test(description = "negative for createMatrix", enabled = true, expectedExceptions = CreatorException.class)
	public void createMatrixTest() throws CreatorException {
		tmp.createMatrix(new Integer[] { 1, 1 }, new Integer[] { 1, 1, 1 });
	}

}
