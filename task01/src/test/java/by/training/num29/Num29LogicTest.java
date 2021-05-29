package by.training.num29;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.training.util.MyScanException;

public class Num29LogicTest {

	Num29Logic temp = new Num29Logic();

	@DataProvider(name = "positiveFindAngle")
	public Object[][] createPositiveFindAngle() {
		return new Object[][] { { new double[] { 3, 4, 5 }, 0.6435011087932843 },
				{ new double[] { 5, 4, 3 }, 1.5707963267948966 }, { new double[] { 4, 5, 3 }, 0.9272952180016123 }, };
	}

	@Test(description = "Positive scenary for FindAngle", dataProvider = "positiveFindAngle")
	public void testPositiveFindAngles(double[] sides, double angle) {
		double actual = temp.findAngle(sides[0], sides[1], sides[2]);
		double expected = angle;
		assertEquals(actual, expected);
	}
}
