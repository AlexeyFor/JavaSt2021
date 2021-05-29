package by.training.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.training.entity.CoordinateXY;

public class CoordinateXYLogicTest {

	CoordinateXYLogic temp = CoordinateXYLogic.getCoordinateXYLogic();

	@DataProvider(name = "PositiveDataDistanceFromCenter")
	public Object[][] createPositiveDataDistanceFromCenter() {
		return new Object[][] { { new CoordinateXY(5.65, 6.65), 8.726110244547682 },
				{ new CoordinateXY(-8.65, 6.65), 10.910774491299874 },
				{ new CoordinateXY(5.65, -9.65), 11.182352167589787 },
				{ new CoordinateXY(-11.65, -12.65), 17.19723815035426 }, { new CoordinateXY(5.65, 0), 5.65 },
				{ new CoordinateXY(0, 6.65), 6.65 }, { new CoordinateXY(0, 0), 0 } };
	}

	@DataProvider(name = "compareDistanceToBegining")
	public Object[][] createCompareDistanceToBegining() {
		return new Object[][] { { new CoordinateXY(5.65, 6.65), new CoordinateXY(26.65, 6.65), -1 },
				{ new CoordinateXY(25.65, 6.65), new CoordinateXY(4.65, 6.65), 1 },
				{ new CoordinateXY(5.65, 6.65), new CoordinateXY(5.65, 6.65), 0 } };
	}

	@DataProvider(name = "trueThreePointsOnLine")
	public Object[][] createTrueThreePointsOnLine() {
		return new Object[][] { { new CoordinateXY(1, 1), new CoordinateXY(2, 2), new CoordinateXY(3, 3) },
				{ new CoordinateXY(3.5, 1), new CoordinateXY(5.5, 2), new CoordinateXY(7.5, 3) },
				{ new CoordinateXY(3.56897, 1), new CoordinateXY(3.56897, 0), new CoordinateXY(3.56897, -9) } };
	}

	@DataProvider(name = "falseThreePointsOnLine")
	public Object[][] createFalseThreePointsOnLine() {
		return new Object[][] { { new CoordinateXY(2, 1), new CoordinateXY(2, 2), new CoordinateXY(3, 3) },
				{ new CoordinateXY(3.5, 0), new CoordinateXY(5.5, 2), new CoordinateXY(7.5, 3) },
				{ new CoordinateXY(3.97, 6), new CoordinateXY(3.56897, 0), new CoordinateXY(3.56897, -9) } };
	}

	@Test(description = "Positive scenary of the DistanceFromCenter", dataProvider = "PositiveDataDistanceFromCenter")
	public void testDistanceFromCenter(CoordinateXY coordinate, double result) {
		double actual = temp.distanceFromCenter(coordinate);
		double expected = result;
		assertEquals(actual, expected);
	}

	@Test(description = "Positive scenary of the compareDistanceToBegining", dataProvider = "compareDistanceToBegining")
	public void testCompareDistanceToBegining(CoordinateXY coordinate1, CoordinateXY coordinate2, int result)
			throws CoordinateXYLogicException {
		double actual = temp.compareDistanceToBegining(coordinate1, coordinate2);
		double expected = result;
		assertEquals(actual, expected);
	}

	@Test(description = "Positive scenary of the threePointsOnLine", dataProvider = "trueThreePointsOnLine")
	public void testTrueThreePointsOnLine(CoordinateXY coordinate1, CoordinateXY coordinate2,
			CoordinateXY coordinate3) {
		boolean actual = temp.threePointsOnLine(coordinate1, coordinate2, coordinate3);
		assertTrue(actual);
	}

	@Test(description = "Positive scenary of the threePointsOnLine", dataProvider = "falseThreePointsOnLine")
	public void testFalseThreePointsOnLine(CoordinateXY coordinate1, CoordinateXY coordinate2,
			CoordinateXY coordinate3) {
		boolean actual = temp.threePointsOnLine(coordinate1, coordinate2, coordinate3);
		assertFalse(actual);
	}

}
