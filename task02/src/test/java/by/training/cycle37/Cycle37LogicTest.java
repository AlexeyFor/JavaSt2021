package by.training.cycle37;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Cycle37LogicTest {

	private Cycle37Logic temp = new Cycle37Logic();

	@DataProvider(name = "fromIntToIntArr")
	public Object[][] createFromIntToIntArr() {
		return new Object[][] { { 5698, new int[] { 5, 6, 9, 8 } }, { -12, new int[] { 1, 2 } }, { 4, new int[] { 4 } },
				{ 0, new int[] { 0 } }, };
	}

	@Test(description = "Positive scenary for the fromIntToIntArr()", dataProvider = "fromIntToIntArr")
	public void testFromIntToIntArr(int number, int[] result) {
		int[] actual = temp.fromIntToIntArr(number);
		int[] expected = result;
		assertEquals(actual, expected);
	}

}
