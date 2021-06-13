package by.training.service.creator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MatrixBigDecimalCreatorTest {

	MatrixBigDecimalCreator tmp = new MatrixBigDecimalCreator();

	@DataProvider(name = "createEmptyMatrixNegative")
	public Object[][] createEmptyMatrixNegative() {
		return new Object[][] { { 0, 0 }, { -1, 5 }, { 5, -1 } };
	}

	@Test(description = "negative for createEmptyMatrixNegative", dataProvider = "createEmptyMatrixNegative", enabled = true, expectedExceptions = CreatorException.class)
	public void createEmptyMatrixNegativeTest(int matrixlegth, int arrayLength) throws CreatorException {
		tmp.createEmptyMatrix(matrixlegth, arrayLength);
	}
}
