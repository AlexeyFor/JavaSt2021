package by.training.service;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IntervalLogicTest {

// checkIntervalStep(double startA, double endB, double stepH) {	
	IntervalLogic temp = IntervalLogic.getIntervalLogic();

	@DataProvider(name = "checkIntervalStepTrue")
	public Object[] createCheckIntervalStepTrue() {
		return new Object[] { new double[] { 1, 6, 1 }, new double[] { 0, 6, 1 }, new double[] { -5, 0, 0.5 },
				new double[] { 0.7, 0.8, 0.1 }, new double[] { -10, -2, 2 } };
	}

	@DataProvider(name = "checkIntervalStepFalse")
	public Object[] createCheckIntervalStepFalse() {
		return new Object[] { new double[] { 7, 6, 1 }, new double[] { 0, 0, 1 }, new double[] { -5, -4, 2 },
				new double[] { 0.7, 0.8, 0.3 }, new double[] { -10, -11, -3 } };
	}

	// getIntervalsStep
	@DataProvider(name = "getIntervalsStep")
	public Object[][] createGetIntervalsStep() {
		return new Object[][] { { new double[] { 1, 6, 1 }, new double[] { 1, 2, 3, 4, 5, 6 } },
				{ new double[] { -3, 0, 0.5 }, new double[] { -3, -2.5, -2, -1.5, -1, -0.5, 0 } },
				{ new double[] { 0.7, 0.8, 0.1 }, new double[] { 0.7, 0.8 } },

		};
	}

	@Test(description = "Positive scenary of the checkIntervalStep (true)", dataProvider = "checkIntervalStepTrue")
	public void testCheckIntervalStepTrue(double[] mas) {
		double startA = mas[0];
		double endB = mas[1];
		double stepH = mas[2];
		boolean actual = temp.checkIntervalStep(startA, endB, stepH);
		assertTrue(actual);
	}

	@Test(description = "Positive scenary of the checkIntervalStep (False)", dataProvider = "checkIntervalStepFalse")
	public void testCheckIntervalStepFalse(double[] mas) {
		double startA = mas[0];
		double endB = mas[1];
		double stepH = mas[2];
		boolean actual = temp.checkIntervalStep(startA, endB, stepH);
		assertFalse(actual);
	}

	@Test(description = "Positive scenary of the getIntervalsStep ", dataProvider = "getIntervalsStep")
	public void testGetIntervalsStep(double[] mas, double[] expected) {
		double startA = mas[0];
		double endB = mas[1];
		double stepH = mas[2];
		double[] actual = temp.getIntervalsStep(startA, endB, stepH);
		assertEquals(actual, expected);
	}

	@Test(description = "Negative scenary of the getIntervalsStep ", dataProvider = "checkIntervalStepFalse")
	public void testGetIntervalsStepNegative(double[] mas) {
		double startA = mas[0];
		double endB = mas[1];
		double stepH = mas[2];
		double[] expected = {};
		double[] actual = temp.getIntervalsStep(startA, endB, stepH);
		assertEquals(actual, expected);
	}

}
