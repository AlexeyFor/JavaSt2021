package by.training.num13;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Num13LogicTest {

	Num13Logic temp = new Num13Logic();

	@DataProvider(name = "countSizesPositiveData")
	public Object[][] createCountSizesPositiveData() {
		return new Object[][] {

				{ new double[][] { { 1, 1 }, { 1, 5 }, { 4, 5 } }, new double[] { 4, 5, 3 } }, };
	}

	@DataProvider(name = "countSizeLengthPositiveData")
	public Object[][] createCountSizeLengthPositiveData() {
		return new Object[][] {

				{ new double[] { 11.11, 11.22 }, new double[] { 22.33, 22.44 }, 15.867476169826126 },
				{ new double[] { -11.11, -11.22 }, new double[] { 22.33, 22.44 }, 47.447120039049786 },
				{ new double[] { 11.11, 11.22 }, new double[] { -22.33, -22.44 }, 47.447120039049786 },
				{ new double[] { -11.11, 11.22 }, new double[] { 22.33, 22.44 }, 35.27211363102585 },
				{ new double[] { 11.11, -11.22 }, new double[] { 22.33, 22.44 }, 35.48075534708922 },
				{ new double[] { 11.11, 11.22 }, new double[] { -22.33, 22.44 }, 35.27211363102585 },
				{ new double[] { 11.11, 11.22 }, new double[] { 22.33, -22.44 }, 35.48075534708922 },
				{ new double[] { -11.11, -11.22 }, new double[] { -22.33, -22.44 }, 15.867476169826126 },
				{ new double[] { 0, 0 }, new double[] { -22.33, -22.44 }, 31.65726614854795 },
				{ new double[] { -11.11, -11.22 }, new double[] { 0, 0 }, 15.789886003388371 },

		};
	}

	@DataProvider(name = "countPerimeterPositiveData")
	public Object[][] createCountPerimiterPositiveData() {
		return new Object[][] {

				{ new double[] { 13.11, 11.22, 11.33 }, 35.66 },

		};
	}

	@DataProvider(name = "countSquarePositiveData")
	public Object[][] createCountSqusarePositiveData() {
		return new Object[][] {

				{ new double[] { 13.11, 11.22, 11.33 }, new double[] { 35.66, 60.13178264445514 } },

		};
	}

	@Test(description = "Positive scenary for countSizes", dataProvider = "countSizesPositiveData")
	public void testCountSizes(double[][] mas, double[] res) {
		double[] actual = temp.countSizes(mas);
		double[] expected = res;
		assertEquals(actual, expected);
	}

	@Test(description = "Positive scenary for countSizeLength", dataProvider = "countSizeLengthPositiveData")
	public void testSum(double[] mas1, double[] mas2, double res) {
		double actual = temp.countSizeLength(mas1, mas2);
		double expected = res;
		assertEquals(actual, expected);
	}

	@Test(description = "Positive scenary for countPerimeter", dataProvider = "countPerimeterPositiveData")
	public void testCountPerimiter(double[] mas, double res) {
		double actual = temp.countPerimeter(mas);
		double expected = res;
		assertEquals(actual, expected);
	}

	@Test(description = "Positive scenary for countSquare", dataProvider = "countSquarePositiveData")
	public void testCountSquare(double[] mas1, double[] mas2) {
		double perimiter = mas2[0];
		double square = mas2[1];
		double actual = temp.countSquare(mas1, perimiter);
		double expected = square;
		assertEquals(actual, expected);
	}
}
