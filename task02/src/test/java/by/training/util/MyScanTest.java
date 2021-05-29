package by.training.util;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyScanTest {

	MyScan temp = MyScan.getMyScan();

	@DataProvider(name = "PositiveDataFromStrToMasDoubTwo")
	public Object[][] createPositiveDataForFromStrToMasDoubTwo() {
		return new Object[][] { { "2 2", new double[] { 2, 2 } }, { "-2 2", new double[] { -2.0, 2.0 } },
				{ "2 -2", new double[] { 2.0, -2.0 } }, { "255 266", new double[] { 255.0, 266.0 } },
				{ "-255 266", new double[] { -255.0, 266.0 } }, { "255 -266", new double[] { 255.0, -266.0 } },
				{ "0 2", new double[] { 0.0, 2.0 } }, { "-2 0", new double[] { -2.0, 0.0 } },
				{ "0 -2", new double[] { 0.0, -2.0 } }, { "0 -0", new double[] { 0.0, 0.0 } },
				{ "25.56 2", new double[] { 25.56, 2.0 } }, { "25.56 25.56", new double[] { 25.56, 25.56 } },
				{ "-25.56 25.56", new double[] { -25.56, 25.56 } }, { "25.5 -25.5", new double[] { 25.5, -25.5 } }, };
	}

	@DataProvider(name = "NegativeDataForFromStrToMasDoubTwo")
	public Object[][] createNegativeDataForFromStrToMasDoubTwo() {
		return new Object[][] { { "asd 2" }, { "2 asd" }, { "asd asd" }, { "2asd 2" }, { "asd 2asd" }, { " 2" },
				{ "2  5 adfw" }, { "asd" }, { "2.asd" } };
	}

	@DataProvider(name = "PositiveDatafromStrToDouble")
	public Object[][] createPositiveDataFromStrToDouble() {
		return new Object[][] { { "256", 256 }, { "-256", -256 }, { "0", 0 }, { "0.567", 0.567 }, { "-0.567", -0.567 },
				{ "-56.567", -56.567 }, { "56.567", 56.567 }, { "56.0", 56.0 }, };
	}

	@DataProvider(name = "PositiveDataFromStrToInt")
	public Object[][] createPositiveDataFromStrToInt() {
		return new Object[][] { { "256", 256 }, { "-256", -256 }, { "0", 0 }, { "1", 1 }, { "-1", -1 },
				{ "589759", 589759 }, };
	}

	@Test(description = "Positive scenary of the FromStrToMasDoubTwo", dataProvider = "PositiveDataForFromStrToMasDoubTwo")
	public void testFromStrToMasDoubTwo(String str, double[] mas) throws MyScanException {
		double[] actual = temp.fromStrToMasDoubTwo(str);
		double[] expected = mas;
		assertEquals(actual, expected);
	}

	@Test(description = "Negative scenary of the FromStrToMasDoubTwo", dataProvider = "NegativeDataForFromStrToMasDoubTwo", enabled = true, expectedExceptions = MyScanException.class)
	public void negativeTestFromStrToMasIntTwo(String str) throws MyScanException {
		double[] actual = temp.fromStrToMasDoubTwo(str);

	}

	@Test(description = "Positive scenary of the FromStrToDouble", dataProvider = "PositiveDatafromStrToDouble")
	public void testFromStrToDouble(String str, double result) throws MyScanException {
		double actual = temp.fromStrToDouble(str);
		double expected = result;
		assertEquals(actual, expected);
	}

	@Test(description = "Negative scenary of the FromStrToDouble", dataProvider = "NegativeDataForFromStrToMasDoubTwo", enabled = true, expectedExceptions = MyScanException.class)
	public void negativeTestFromStrToDouble(String str) throws MyScanException {
		double actual = temp.fromStrToDouble(str);
	}

	@Test(description = "Positive scenary of the fromStrToInt", dataProvider = "PositiveDataFromStrToInt")
	public void testGeInt(String str, int result) throws MyScanException {
		int actual = temp.fromStrToInt(str);
		int expected = result;
		assertEquals(actual, expected);
	}

}
