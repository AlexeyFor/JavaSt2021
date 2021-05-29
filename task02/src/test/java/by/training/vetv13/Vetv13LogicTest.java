package by.training.vetv13;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.training.service.CoordinateXYLogicException;
import by.training.util.exception.MyTxtReaderException;
import by.training.util.exception.SearchDataInStrException;

public class Vetv13LogicTest {

	private final String defaultPath = System.getProperty("user.dir")
			+ "//src//test//java//by//training//vetv13//";
	Vetv13Logic temp = new Vetv13Logic();

	@DataProvider(name = "compareDistToBeginFromTxt")
	public Object[][] createCompareDistToBeginFromTxt() {
		return new Object[][] { { "vetv13return1.txt", 1 }, { "vetv13return0.txt", 0 }, { "vetv13return-1.txt", -1 } };
	}

	@Test(description = "positive for compareDistToBeginFromTxt", dataProvider = "compareDistToBeginFromTxt")
	public void testCompareDistToBeginFromTxt(String name, int result)
			throws SearchDataInStrException, CoordinateXYLogicException, MyTxtReaderException {
		String fileName = defaultPath + name;
		int actual = temp.compareDistToBeginFromTxt(fileName);
		int expected = result;
		assertEquals(actual, expected);
	}

	@Test(description = "Negative scenary of compareDistToBeginFromTxt", enabled = true, expectedExceptions = SearchDataInStrException.class)
	public void negativeTestFromStrToDouble()
			throws SearchDataInStrException, CoordinateXYLogicException, MyTxtReaderException {
		String path = defaultPath + "vetv13throwData.txt";
		int actual = temp.compareDistToBeginFromTxt(path);
	}

	@Test(description = "Negative scenary of compareDistToBeginFromTxt", enabled = true, expectedExceptions = MyTxtReaderException.class)
	public void negativeTestFromStrToDouble2()
			throws SearchDataInStrException, CoordinateXYLogicException, MyTxtReaderException {
		String path = defaultPath + "wrongFile.txt";
		int actual = temp.compareDistToBeginFromTxt(path);
	}
}
