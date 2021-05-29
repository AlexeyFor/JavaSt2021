package by.training.cycle21;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.training.util.exception.MyTxtReaderException;
import by.training.util.exception.SearchDataInStrException;

public class Cycle21LogicTest {

	private final String defaultPath = System.getProperty("user.dir") + "//src//test//java//by//training//cycle21//";
	Cycle21Logic temp = new Cycle21Logic();

	@DataProvider(name = "countFunctionWithParamFromTxt")
	public Object[] countFunctionWithParamFromTxt() {
		List<double[]> result = new ArrayList<double[]>();
		result.add(new double[] { 1.0, 0.1585290151921035 });
		result.add(new double[] { 1.5, 0.5025050133959456 });
		result.add(new double[] { 2.0, 1.0907025731743183 });
		result.add(new double[] { 2.5, 1.9015278558960436 });
		result.add(new double[] { 3.0, 2.8588799919401326 });
		result.add(new double[] { 3.5, 3.85078322768962 });
		result.add(new double[] { 4.0, 4.756802495307928 });

		return new Object[] { "Cycle21.txt", result };
	}

	@Test(description = "positive for countFunctionWithParamFromTxt")
	public void testCountFunctionWithParamFromTxt() throws SearchDataInStrException, MyTxtReaderException {
		List<double[]> result = new ArrayList<double[]>();
		result.add(new double[] { 1.0, 0.1585290151921035 });
		result.add(new double[] { 1.5, 0.5025050133959456 });
		result.add(new double[] { 2.0, 1.0907025731743183 });
		result.add(new double[] { 2.5, 1.9015278558960436 });
		result.add(new double[] { 3.0, 2.8588799919401326 });
		result.add(new double[] { 3.5, 3.85078322768962 });
		result.add(new double[] { 4.0, 4.756802495307928 });
		String fileName = defaultPath + "Cycle21.txt";
		List<double[]> actual = temp.countFunctionWithParamFromTxt(fileName);
		boolean answer = true;
		for (int i = 0; i < result.size(); i++) {

			if (result.get(i)[0] != (actual.get(i)[0])) {
				answer = false;
			}
			if (result.get(i)[1] != (actual.get(i)[1])) {
				answer = false;
			}
		}
		assertTrue(answer);
	}

	@Test(description = "negative for countFunctionWithParamFromTxt", enabled = true, expectedExceptions = SearchDataInStrException.class)
	public void testCountFunctionWithParamFromTxtNegative2() throws SearchDataInStrException, MyTxtReaderException {
		String fileName = defaultPath + "Cycle21_ThrowsData.txt";
		List<double[]> result = temp.countFunctionWithParamFromTxt(fileName);
	}

	@Test(description = "negative for countFunctionWithParamFromTxt", enabled = true, expectedExceptions = MyTxtReaderException.class)
	public void testCountFunctionWithParamFromTxtNegative1() throws SearchDataInStrException, MyTxtReaderException {
		String fileName = defaultPath + "WrongFile.txt";
		List<double[]> result = temp.countFunctionWithParamFromTxt(fileName);
	}
}
