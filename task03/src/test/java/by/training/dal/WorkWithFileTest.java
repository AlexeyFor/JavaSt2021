package by.training.dal;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import by.training.entity.MyArray;

public class WorkWithFileTest {

	private final String defaultPath = System.getProperty("user.dir") + "//src//test//java//by//training//dal//";

	DALProvider reader = DALProvider.getInstance();
	WorkWithFileInterface<Integer> temp = reader.getWorkFile();

	@Test(description = "positive for readFile")
	public void readFileTest() throws DALException {
		String fileName = defaultPath + "MAInteger569.txt";
		MyArray<Integer> actual = temp.readFile(fileName);
		MyArray<Integer> expected = new MyArray<Integer>(new Integer[] { 5, 6, 9 });
		assertEquals(expected, actual);
	}

	@Test(description = "negative for readFile (file doesn't exists)", enabled = true, expectedExceptions = DALException.class)
	public void readFileTestNegative1() throws DALException {
		MyArray<Integer> actual = temp.readFile("wrongName");

	}

	@Test(description = "negative for readFile (damaged file)", enabled = true, expectedExceptions = DALException.class)
	public void readFileTestNegative2() throws DALException {
		String fileName = defaultPath + "damagedFile.txt";
		MyArray<Integer> actual = temp.readFile(fileName);

	}

	@Test(description = "negative for readFile (wrong class)", enabled = true, expectedExceptions = DALException.class)
	public void readFileTestNegative3() throws DALException {
		String fileName = defaultPath + "MyArrApplesBox.txt";
		MyArray<Integer> actual = temp.readFile(fileName);
	}

	@Test(description = "positive for saveInFile")
	public void saveInFileTest() throws DALException {
		String fileName = defaultPath + "MAIntegerSAVE.txt";
		MyArray<Integer> array = new MyArray<Integer>(new Integer[] { 5, 6, 9 });
		boolean actual = temp.saveInFile(array, fileName);
		assertTrue(actual);
	}

	@Test(description = "negative for saveInFile (wrong path)", enabled = true, expectedExceptions = DALException.class)
	public void saveInFileTestNegative3() throws DALException {
		final String defaultPath = System.getProperty("user.dir") + "//src//test//java//by//wrong//wrong//";
		final String fileName = defaultPath + "wrongPath";
		MyArray<Integer> array = new MyArray<Integer>(new Integer[] { 5, 6, 9 });
		temp.saveInFile(array, fileName);
	}
}
