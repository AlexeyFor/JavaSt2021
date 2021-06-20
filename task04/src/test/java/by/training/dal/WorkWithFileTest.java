package by.training.dal;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class WorkWithFileTest {
	
	private final String defaultPath = System.getProperty("user.dir") + "//src//test//java//by//training//dal//";
	WorkWithFile temp = DALProvider.getInstance().getWorkWithFile();


	@Test(description = "positive for readFileList")
	public void readFileListTest() throws DALException {
		String fileName = defaultPath + "testAB.txt";
		List <String> actual = temp.readFileList(fileName);
		List <String> expected = new ArrayList<String>();
		expected.add("A");
		expected.add("B");
		assertEquals(expected, actual);
	}
	
	@Test(description = "positive for readFileString")
	public void readFileStringTest() throws DALException {
		String fileName = defaultPath + "testABC.txt";
		String actual = temp.readFileString(fileName);
		String expected = "ABC";
		assertEquals(expected, actual);
	}
	
	@Test(description = "negative for readFileList (wrong path)", enabled = true, expectedExceptions = DALException.class)
	public void readFileListTestNegative() throws DALException {
		String fileName = defaultPath + "wrong.txt";
		temp.readFileList(fileName);
	}
	@Test(description = "negative for readFileString (wrong path)", enabled = true, expectedExceptions = DALException.class)
	public void readFileStringTestNegative() throws DALException {
		String fileName = defaultPath + "wrong.txt";
		temp.readFileString(fileName);
	}
	@Test(description = "negative for writeInFile (wrong path)", enabled = true, expectedExceptions = DALException.class)
	public void writeInFileTestNegative() throws DALException {
		String fileName = System.getProperty("user.dir") + "//src//test//java//by//WRONG//dal//wrong.txt";
		temp.writeInFile("smth",fileName);
	}
	
  }

