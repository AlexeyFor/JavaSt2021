package by.training.vetv29;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

import by.training.util.exception.MyTxtReaderException;
import by.training.util.exception.SearchDataInStrException;

/**
 * Method threePointsOnLineFromTxt() from CoordinateXYLogic.class was tested, so
 * we will consider only one option for each situation
 * 
 * @author AlexeySupruniuk
 * @see test/../util/CoordinateXYLogicTest
 */
public class Vetv29LogicTest {

	private final String defaultPath = System.getProperty("user.dir") + "//src//test//java//by//training//vetv29//";
	Vetv29Logic temp = new Vetv29Logic();

	@Test(description = "positive (true) for checkThreePointsOnLineFromTxt")
	public void test1CompareDistToBeginFromTxt() throws SearchDataInStrException, MyTxtReaderException {
		String fileName = defaultPath + "vetv29True.txt";
		boolean actual = temp.checkThreePointsOnLineFromTxt(fileName);
		assertTrue(actual);
	}

	@Test(description = "positive (false) for checkThreePointsOnLineFromTxt")
	public void test2CompareDistToBeginFromTxt() throws SearchDataInStrException, MyTxtReaderException {
		String fileName = defaultPath + "vetv29False.txt";
		boolean actual = temp.checkThreePointsOnLineFromTxt(fileName);
		assertFalse(actual);
	}

	@Test(description = "negative for checkThreePointsOnLineFromTxt", enabled = true, expectedExceptions = MyTxtReaderException.class)
	public void test3CompareDistToBeginFromTxt() throws SearchDataInStrException, MyTxtReaderException {
		String fileName = defaultPath + "WrongFile.txt";
		boolean actual = temp.checkThreePointsOnLineFromTxt(fileName);
		assertFalse(actual);
	}

	@Test(description = "negative for checkThreePointsOnLineFromTxt", enabled = true, expectedExceptions = SearchDataInStrException.class)
	public void test4CompareDistToBeginFromTxt() throws SearchDataInStrException, MyTxtReaderException {
		String fileName = defaultPath + "vetv29Throw_Data.txt";
		boolean actual = temp.checkThreePointsOnLineFromTxt(fileName);
		assertFalse(actual);
	}
}
