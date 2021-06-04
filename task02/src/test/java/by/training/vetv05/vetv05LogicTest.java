package by.training.vetv05;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.training.util.exception.MyTxtReaderException;
import by.training.util.exception.SearchDataInStrException;

/**
 * due to the verification of the entered information in the
 * SearchDataInStrTest.class, when checking for an unfavorable outcome, all
 * cases are not considered
 * 
 * @author AlexeySupruniuk
 * @see by.training.util.SearchDataInStrTest.class
 */
public class vetv05LogicTest {

	private final String defaultPath = System.getProperty("user.dir") + "//src//test//java//by//training//vetv05//";
	Vetv05Logic temp = new Vetv05Logic();

	@DataProvider(name = "compareNumFromTxtReturn1")
	public String[] createCompareNumFromTxtReturn1() {
		return new String[] { "vetv05return1.1.txt", "vetv05return1.2.txt", "vetv05return1.3.txt",
				"vetv05return1.4.txt" };
	}

	@DataProvider(name = "compareNumFromTxtReturn-1")
	public String[] createcompareNumFromTxtReturnMinus1() {
		return new String[] { "vetv05return-1.1.txt", "vetv05return-1.2.txt", "vetv05return-1.3.txt",
				"vetv05return-1.4.txt" };
	}

	@DataProvider(name = "compareNumFromTxtReturn0")
	public String[] createcompareNumFromTxtReturn0() {
		return new String[] { "vetv05return0.1.txt", "vetv05return0.2.txt", "vetv05return0.3.txt" };
	}

	@Test(description = "return 1 for compareNumFromTxt", dataProvider = "compareNumFromTxtReturn1")
	public void testCompareNumFromTxt1(String name) throws SearchDataInStrException, MyTxtReaderException {
		String fileName = defaultPath + name;
		int actual = temp.compareNumFromTxt(fileName);
		int expected = 1;
		assertEquals(actual, expected);
	}

	@Test(description = "return -1 for compareNumFromTxt", dataProvider = "compareNumFromTxtReturn-1")
	public void testCompareNumFromTxtMinus1(String name) throws SearchDataInStrException, MyTxtReaderException {
		String fileName = defaultPath + name;
		int actual = temp.compareNumFromTxt(fileName);
		int expected = -1;
		assertEquals(actual, expected);
	}

	@Test(description = "return 0 for compareNumFromTxt", dataProvider = "compareNumFromTxtReturn0")
	public void testCompareNumFromTxt0(String name) throws SearchDataInStrException, MyTxtReaderException {
		String fileName = defaultPath + name;
		int actual = temp.compareNumFromTxt(fileName);
		int expected = 0;
		assertEquals(actual, expected);
	}

	@Test(description = "negative for compareNumFromTxt", enabled = true, expectedExceptions = MyTxtReaderException.class)
	public void testCycle29Action1() throws SearchDataInStrException, MyTxtReaderException {
		String fileName = defaultPath + "WrongFile.txt";
		int actual = temp.compareNumFromTxt(fileName);
	}

	@Test(description = "negative for compareNumFromTxt", enabled = true, expectedExceptions = SearchDataInStrException.class)
	public void testCycle29Action2() throws SearchDataInStrException, MyTxtReaderException {
		String fileName = defaultPath + "vetv05throwData.txt";
		int actual = temp.compareNumFromTxt(fileName);
	}

}
