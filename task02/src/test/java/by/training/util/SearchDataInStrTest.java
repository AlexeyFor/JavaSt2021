package by.training.util;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.training.util.exception.SearchDataInStrException;

public class SearchDataInStrTest {

	SearchDataInStr temp = SearchDataInStr.getSearchDataInStr();

// searchInt

	// data for searchDouble
	@DataProvider(name = "PositiveDataSearchDouble")
	public Object[][] createPositiveDataSearchDouble() {
		return new Object[][] { { "256", 256 }, { "-256", -256 }, { "0", 0 }, { "0.567", 0.567 }, { "-0.567", -0.567 },
				{ "-56.567", -56.567 }, { "56.567", 56.567 }, { "56.0", 56.0 }, };
	}

	@DataProvider(name = "NegativeDataSearchDouble")
	public String[] createNegativeDataSearchDouble() {
		return new String[] { "256a", " 256", "asd", "0 567", "-0,567", "-56n567", "" };
	}

	// data for searchInt
	@DataProvider(name = "PositiveDataSearchInt")
	public Object[][] createPositiveDataSearchInt() {
		return new Object[][] { { "256", 256 }, { "-256", -256 }, { "0", 0 }, };
	}

	@DataProvider(name = "NegativeDataSearchInt")
	public String[] createNegativeDataSearchInt() {
		return new String[] { "256a", " 256", "asd", "0 567", "-0,567", "-56n567", "" };
	}

	// data for searchChar
	@DataProvider(name = "PositiveDataSearchChar")
	public Object[][] createPositiveDataSearchChar() {
		return new Object[][] { { "2", '2' }, { "a", 'a' }, { "0", '0' }, { "-", '-' }, { "ь", 'ь' }, { " ", ' ' }, };
	}

	@DataProvider(name = "NegativeDataSearchChar")
	public String[] createNegativeDataSearchChar() {
		return new String[] { "фф", "", "asd", "0 ",  " a" };
	}

	// tests for searchDouble
	@Test(description = "Positive scenary of the searchDouble", dataProvider = "PositiveDataSearchDouble")
	public void testFromStrToDouble(String str, double result) throws SearchDataInStrException {
		double actual = temp.searchDouble(str, "");
		double expected = result;
		assertEquals(actual, expected);
	}

	@Test(description = "Negative scenary of the searchDouble", dataProvider = "NegativeDataSearchDouble", enabled = true, expectedExceptions = SearchDataInStrException.class)
	public void negativeTestSearchDouble(String str) throws SearchDataInStrException {
		double actual = temp.searchDouble(str, "");
	}

	// tests for searchInt
	@Test(description = "Positive scenary of the searchInt", dataProvider = "PositiveDataSearchInt")
	public void testSearchInt(String str, int result) throws SearchDataInStrException {
		int actual = temp.searchInt(str, "");
		int expected = result;
		assertEquals(actual, expected);
	}

	@Test(description = "Negative scenary of the searchInt", dataProvider = "NegativeDataSearchInt", enabled = true, expectedExceptions = SearchDataInStrException.class)
	public void negativeTestSearchInt(String str) throws SearchDataInStrException {
		double actual = temp.searchInt(str, "");
	}

	// tests for searchChar
		@Test(description = "Positive scenary of the searchChar", dataProvider = "PositiveDataSearchChar")
		public void testSearchChar(String str, char result) throws SearchDataInStrException {
			char actual = temp.searchChar(str, "");
			char expected = result;
			assertEquals(actual, expected);
		}

		@Test(description = "Negative scenary of the SearchChar", dataProvider = "NegativeDataSearchChar", enabled = true, expectedExceptions = SearchDataInStrException.class)
		public void negativeTestSearchChar(String str) throws SearchDataInStrException {
			char actual = temp.searchChar(str, "");
		}

}