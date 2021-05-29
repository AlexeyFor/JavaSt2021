package by.training.vetv05;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


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

	private final String defaultPath = System.getProperty("user.dir")
			+ "//src//test//java//by//training//vetv05//";
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

	@DataProvider(name = "compareNumFromTxtReturn2")
	public String[] createcompareNumFromTxtReturn2() {
		return new String[] { "vetv05return2.1.txt", "vetv05return2.2.txt", "vetv05return2.3.txt",
				"vetv05return2.4.txt" };
	}

	@Test(description = "return 1 for compareNumFromTxt", dataProvider = "compareNumFromTxtReturn1")
	public void testCompareNumFromTxt1(String name) throws SearchDataInStrException {
		String fileName = defaultPath + name;
		int actual = temp.compareNumFromTxt(fileName);
		int expected = 1;
		assertEquals(actual, expected);
	}

	@Test(description = "return -1 for compareNumFromTxt", dataProvider = "compareNumFromTxtReturn-1")
	public void testCompareNumFromTxtMinus1(String name) throws SearchDataInStrException {
		String fileName = defaultPath + name;
		int actual = temp.compareNumFromTxt(fileName);
		int expected = -1;
		assertEquals(actual, expected);
	}

	@Test(description = "return 0 for compareNumFromTxt", dataProvider = "compareNumFromTxtReturn0")
	public void testCompareNumFromTxt0(String name) throws SearchDataInStrException {
		String fileName = defaultPath + name;
		int actual = temp.compareNumFromTxt(fileName);
		int expected = 0;
		assertEquals(actual, expected);
	}

	@Test(description = "return 2 for compareNumFromTxt", dataProvider = "compareNumFromTxtReturn2")
	public void testCompareNumFromTxt2(String name) throws SearchDataInStrException {
		String fileName = defaultPath + name;
		int actual = temp.compareNumFromTxt(fileName);
		int expected = 2;
		assertEquals(actual, expected);
	}

}
