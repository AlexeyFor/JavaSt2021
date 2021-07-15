package by.training.task06.service;

import org.testng.annotations.DataProvider;

public class ThreadServiceTestData {

    @DataProvider(name = "PositiveForThreadService")
    public Object[] psitiveForThreadLockService() {
	final String arrayPath = System.getProperty("user.dir")
		+ "//src//main//resources//array.txt";
	final String threadsPath = System.getProperty("user.dir")
		+ "//src//main//resources//threads.txt";

	return new Object[][] { { arrayPath, 200, threadsPath, 10 },
		{ arrayPath, 200, threadsPath, 10 }, { arrayPath, 200, threadsPath, 10 },
		{ arrayPath, 200, threadsPath, 10 }, { arrayPath, 200, threadsPath, 10 },
		{ arrayPath, 200, threadsPath, 2 }, { arrayPath, 200, threadsPath, 2 },
		{ arrayPath, 200, threadsPath, 2 }, { arrayPath, 200, threadsPath, 2 },
		{ arrayPath, 200, threadsPath, 2 }, { arrayPath, 200, threadsPath, 50 },
		{ arrayPath, 200, threadsPath, 50 }, { arrayPath, 200, threadsPath, 50 },
		{ arrayPath, 200, threadsPath, 50 }, { arrayPath, 200, threadsPath, 50 },
		{ arrayPath, 1, threadsPath, 2 }, };
    }

    @DataProvider(name = "PositiveForThreadServiceValue")
    public Object[] psitiveForThreadLockServiceValue() {
	final String arrayPath = System.getProperty("user.dir")
		+ "//src//main//resources//array.txt";
	final String threadsPath = System.getProperty("user.dir")
		+ "//src//main//resources//threads.txt";

	return new Object[][] { { arrayPath, 200, threadsPath, 10 },
		{ arrayPath, 200, threadsPath, 10 }, { arrayPath, 200, threadsPath, 10 },
		{ arrayPath, 200, threadsPath, 10 }, { arrayPath, 200, threadsPath, 10 },
		{ arrayPath, 200, threadsPath, 2 }, { arrayPath, 200, threadsPath, 2 },
		{ arrayPath, 200, threadsPath, 2 }, { arrayPath, 200, threadsPath, 2 },
		{ arrayPath, 200, threadsPath, 2 }, { arrayPath, 200, threadsPath, 50 },
		{ arrayPath, 200, threadsPath, 50 }, { arrayPath, 200, threadsPath, 50 },
		{ arrayPath, 200, threadsPath, 50 }, { arrayPath, 200, threadsPath, 50 }, };
    }

    @DataProvider(name = "NegativeForThreadService")
    public Object[] negativeForThreadService() {
	final String arrayPath = System.getProperty("user.dir")
		+ "//src//main//resources//array.txt";
	final String threadsPath = System.getProperty("user.dir")
		+ "//src//main//resources//threads.txt";
	// only files with wrong data, or absent files
	final String arrayPath1 = System.getProperty("user.dir")
		+ "//src//main//resources//arrayWrong1.txt";
	final String threadsPath1 = System.getProperty("user.dir")
		+ "//src//main//resources//threadsWrong1.txt";
	final String arrayPath2 = System.getProperty("user.dir")
		+ "//src//main//resources//arrayWrong2.txt";
	final String threadsPath2 = System.getProperty("user.dir")
		+ "//src//main//resources//threadsWrong2.txt";
	final String arrayPathWrong = System.getProperty("user.dir") + "wrong";
	final String threadsPathWrong = System.getProperty("user.dir") + "wrong";

	return new Object[][] { { arrayPath1, 200, threadsPath, 10 },
		{ arrayPath2, 200, threadsPath, 10 }, { arrayPath, 200, threadsPath1, 10 },
		{ arrayPath, 200, threadsPath2, 10 }, { arrayPath1, 200, threadsPath1, 10 },
		{ arrayPathWrong, 200, threadsPath2, 10 },
		{ arrayPath1, 200, threadsPathWrong, 10 }, { arrayPath, 251, threadsPath, 10 },
		{ arrayPath, 0, threadsPath, 10 }, { arrayPath, 200, threadsPath, 101 },
		{ arrayPath, 10, threadsPath, 0 },

	};
    }

}