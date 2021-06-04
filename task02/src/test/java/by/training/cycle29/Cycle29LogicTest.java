package by.training.cycle29;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.training.util.exception.MyTxtReaderException;
import by.training.util.exception.SearchDataInStrException;

public class Cycle29LogicTest {

	private final String defaultPath = System.getProperty("user.dir") + "//src//test//java//by//training//cycle29//";
	Cycle29Logic temp = new Cycle29Logic();

	@DataProvider(name = "cycle29ActionPositive")
	public Object[][] createCycle29ActionPositive() {
		return new Object[][] { { "Cycle29_123.txt", new int[] { 1, 2, 3 } },
				{ "Cycle29_046.txt", new int[] { 0, 4, 6 } },
				{ "Cycle29_1235789.txt", new int[] { 1, 2, 3, 5, 7, 8, 9 } }, { "Cycle29_0.txt", new int[] { 0 } },
				{ "Cycle29_.txt", new int[] {} } };
	}

	@Test(description = "positive for cycle29Action", dataProvider = "cycle29ActionPositive")
	public void testCycle29Action(String name, int[] answer) throws SearchDataInStrException, MyTxtReaderException {
		String fileName = defaultPath + name;
		int[] actual = temp.coommonDiggitsFromTwoIntTxt(fileName);
		int[] expected = answer;
		assertEquals(actual, expected);
	}

	@Test(description = "negative for cycle29Action", enabled = true, expectedExceptions = MyTxtReaderException.class)
	public void testCycle29Action1() throws SearchDataInStrException, MyTxtReaderException {
		String fileName = defaultPath + "WrongFile.txt";
		int[] actual = temp.coommonDiggitsFromTwoIntTxt(fileName);
	}

	@Test(description = "negative for cycle29Action", enabled = true, expectedExceptions = SearchDataInStrException.class)
	public void testCycle29Action2() throws SearchDataInStrException, MyTxtReaderException {
		String fileName = defaultPath + "Cycle29_ThrowsData.txt";
		int[] actual = temp.coommonDiggitsFromTwoIntTxt(fileName);
	}

}
