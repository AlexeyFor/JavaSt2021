package by.training.num21;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.training.util.MyScanException;

public class Num21LogicTest {

	Num21Logic temp = new Num21Logic();

	@DataProvider(name = "positiveFromStrToStrMas")
	public Object[][] createPositiveFromStrToStrMas() {
		return new Object[][] { { "589.658", new String[] { "589", "658" } },
				{ "999.001", new String[] { "999", "001" } }, { "100.100", new String[] { "100", "100" } },
				{ "-568.001", new String[] { "568", "001" } }, };
	}

	@DataProvider(name = "negativeFromStrToStrMas")
	public Object[] createNegativeFromStrToStrMas() {
		return new Object[] { "89.658", "-99.001", "1000.00", "68.5684", "567.6851", "0.568498", "5684.654" };
	}

	@DataProvider(name = "positiveFromStrMasToDouble")
	public Object[][] createPositiveFromStrMasToDouble() {
		return new Object[][] { { new String[] { "589", "658" }, 658.589 }, { new String[] { "999", "001" }, 1.999 },
				{ new String[] { "100", "100" }, 100.1 }, { new String[] { "568", "001" }, 1.568 } };
	}

	@Test(description = "Positive scenary for fromStrToStrMas", dataProvider = "positiveFromStrToStrMas")
	public void testPositiveFromStrToStrMas(String num, String[] res) throws MyScanException {
		String[] actual = temp.fromStrToStrMas(num);
		String[] expected = res;
		assertEquals(actual, expected);
	}

	@Test(description = "Negative scenary of the fromStrToStrMas", dataProvider = "negativeFromStrToStrMas", enabled = true, expectedExceptions = MyScanException.class)
	public void negativeTestFromStrToStrMas(String str) throws MyScanException {
		String[] actual = temp.fromStrToStrMas(str);
	}

	@Test(description = "Positive scenary for fromStrMasToDouble", dataProvider = "positiveFromStrMasToDouble")
	public void testFromStrMasToDouble(String[] mas, double res) {
		double actual = temp.fromStrMasToDouble(mas);
		double expected = res;
		assertEquals(actual, expected);
	}
}
