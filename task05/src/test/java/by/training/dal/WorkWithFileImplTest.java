package by.training.dal;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import by.training.task05.dal.DALException;
import by.training.task05.dal.DALProvider;
import by.training.task05.dal.WorkWithFile;

public class WorkWithFileImplTest {

	private final String defaultPath = System.getProperty("user.dir") + "//data//";
	WorkWithFile temp = DALProvider.getInstance().getWorkWithFile();

	@Test(description = "positive for readFileList")
	public void readFileListTest() throws DALException {
		String fileName = defaultPath + "testAB.txt";
		List<String> actual = temp.readFileList(fileName);
		List<String> expected = new ArrayList<String>();
		expected.add("A");
		expected.add("B");
		assertEquals(expected, actual);
	}

	@Test(description = "negative for readFileList (wrong path)", enabled = true, expectedExceptions = DALException.class)
	public void readFileListTestNegative() throws DALException {
		String fileName = defaultPath + "wrong.txt";
		temp.readFileList(fileName);
	}

}
