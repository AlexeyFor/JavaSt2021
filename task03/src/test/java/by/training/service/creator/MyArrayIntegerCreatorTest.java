package by.training.service.creator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyArrayIntegerCreatorTest {

	MyArrayIntegerCreator tmp = new MyArrayIntegerCreator();
	
	@DataProvider(name = "createRandomMA")
	public Object[][] createRandomMA() {
		return new Object[][] { { 0,  2, 5 }, { -1,  2, 5 }, { 5, 10, 9 } };
	}
	
	@DataProvider(name = "createMA")
	public Object[][] createMA() {
		return new Object[][] { new Integer []{ 0,  null, 5 } };
	}
	
	@DataProvider(name = "createOneNumMA")
	public Object[][] createOneNumMA() {
		return new Object[][] { { 0,  2 }, { -1,  2 }};
	}

	@Test(description = "negative for createRandomMA", dataProvider = "createRandomMA", enabled = true, expectedExceptions = CreatorException.class)
	public void createRandomMANegativeTest(int length,int min, int max)
			throws CreatorException {
		tmp.createRandomMA(length, min, max);
	}
	
	@Test(description = "negative for createMA", dataProvider = "createMA", enabled = true, expectedExceptions = CreatorException.class)
	public void createMANegativeTest(Integer [] array)
			throws CreatorException {
		tmp.createMA(array);
	}
	
	@Test(description = "negative for createOneNumMA", dataProvider = "createOneNumMA", enabled = true, expectedExceptions = CreatorException.class)
	public void createOneNumMANegativeTest(int length,int num)
			throws CreatorException {
		tmp.createOneNumMA(length, num);
	}
}
