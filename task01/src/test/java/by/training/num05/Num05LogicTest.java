package by.training.num05;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Num05LogicTest {

	private Num05Logic temp = new Num05Logic();

	@DataProvider(name = "positiveData")
	public Object[][] createPositiveData() {
		return new Object[][] { { new double[] { 2, 2 }, 2 }, { new double[] { 2, 0 }, 1 },
				{ new double[] { 0, 2 }, 1 }, { new double[] { 0, 0 }, 0 }, { new double[] { 4, -2 }, 1 },
				{ new double[] { -2, 4 }, 1 }, { new double[] { 3, 2 }, 2.5 }, { new double[] { 2, 3 }, 2.5 },
				{ new double[] { 25.5, 1.36 }, 13.43 }, { new double[] { -25.5, 1.36 }, -12.07 },
				{ new double[] { -25.5, -1.36 }, -13.43 }, { new double[] { 25.5, -1.36 }, 12.07 }, };
	}

	@Test(description = "Positive scenary for the getAverage()", dataProvider = "positiveData")
	public void testSum(double ab[], double c) {
		double actual = temp.countAverage(ab[0], ab[1]);
		double expected = c;
		assertEquals(actual, expected);
	}

}