package by.training.vetv37;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.training.util.exception.MyTxtReaderException;
import by.training.util.exception.SearchDataInStrException;

public class Vetv37LogicTest {

	private final String defaultPath = System.getProperty("user.dir") + "//src//test//java//by//training//vetv37//";
	Vetv37Logic temp = new Vetv37Logic();

	@DataProvider(name = "countXFromTxt")
	public Object[][] createCountXFromTxt() {
		return new Object[][] { { "vetv37_0.txt", -0.16666666666666666 }, { "vetv37_2.9.txt", 0.05438033607047692 },
				{ "vetv37_5.txt", -1 }, { "vetv37_6.8.txt", -16.839999999999996 },
				{ "vetv37_-8.67.txt", -0.0015204168500118343 }, { "vetv37_3.txt", 9 },
				{ "vetv37_Infin.txt", Double.POSITIVE_INFINITY } };
	}

	@Test(description = "positive for countXFromTxt", dataProvider = "countXFromTxt")
	public void testCountXFromTxt(String name, double result) throws SearchDataInStrException, MyTxtReaderException {
		String fileName = defaultPath + name;
		double actual = temp.calcXFromTxt(fileName);
		double expected = result;
		assertEquals(actual, expected);
	}

	@Test(description = "Negative scenary of countXFromTxt throw SearchDataInStrException", enabled = true, expectedExceptions = SearchDataInStrException.class)
	public void negativeTestFromStrToDouble1() throws SearchDataInStrException, MyTxtReaderException {
		String path = defaultPath + "vetv37_ThrowData.txt";
		double actual = temp.calcXFromTxt(path);
	}

	@Test(description = "Negative scenary of countXFromTxt throw MyTxtReaderException", enabled = true, expectedExceptions = MyTxtReaderException.class)
	public void negativeTestFromStrToDouble2() throws SearchDataInStrException, MyTxtReaderException {
		String path = defaultPath + "wrongFile.txt";
		double actual = temp.calcXFromTxt(path);
	}

}
