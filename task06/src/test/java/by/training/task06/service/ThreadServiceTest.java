package by.training.task06.service;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import by.training.task06.entity.MatrixForThreads;

public class ThreadServiceTest {

    ThreadLockService lock = new ThreadLockService();
    ThreadSingletonService single = new ThreadSingletonService();
    ThreadCyclicBarrierService barrier = new ThreadCyclicBarrierService();
    ThreadLongAdderService adder = new ThreadLongAdderService();

    // check only counter
    @Test(description = "positive for ThreadLockActionCounter", dataProvider = "PositiveForThreadService", dataProviderClass = ThreadServiceTestData.class)
    public void threadLockActionPositiveCounter(String arraysPath, int arraysNumber,
	    String threadsPath, int threadsNumber) throws ServiceException {
	MatrixForThreads matrix = lock.threadLockAction(arraysPath, arraysNumber, threadsPath,
		threadsNumber);
	boolean condition = checkMatrixDiagonalCounter(matrix);
	assertTrue(condition);

    }

    // check only values, sometimes all value can be the same.
    @Test(description = "positive for ThreadLockActionValues", dataProvider = "PositiveForThreadServiceValue", dataProviderClass = ThreadServiceTestData.class)
    public void threadLockActionPositive(String arraysPath, int arraysNumber, String threadsPath,
	    int threadsNumber) throws ServiceException {
	MatrixForThreads matrix = lock.threadLockAction(arraysPath, arraysNumber, threadsPath,
		threadsNumber);
	boolean condition = checkMatrixDiagonalValue(matrix);
	assertTrue(condition);

    }

    // check only counter
    @Test(description = "positive for ThreadSingletonActionCounter", dataProvider = "PositiveForThreadService", dataProviderClass = ThreadServiceTestData.class)
    public void threadSingletonActionPositiveCounter(String arraysPath, int arraysNumber,
	    String threadsPath, int threadsNumber) throws ServiceException {
	MatrixForThreads matrix = single.threadSingletonAction(arraysPath, arraysNumber,
		threadsPath, threadsNumber);
	boolean condition = checkMatrixDiagonalCounter(matrix);
	assertTrue(condition);

    }

    // check only values, sometimes all value can be the same.
    @Test(description = "positive for ThreadSingletonAction", dataProvider = "PositiveForThreadServiceValue", dataProviderClass = ThreadServiceTestData.class)
    public void threadSingletonActionPositive(String arraysPath, int arraysNumber,
	    String threadsPath, int threadsNumber) throws ServiceException {
	MatrixForThreads matrix = single.threadSingletonAction(arraysPath, arraysNumber,
		threadsPath, threadsNumber);
	boolean condition = checkMatrixDiagonalValue(matrix);
	assertTrue(condition);

    }

    // check only counter
    @Test(description = "positive for threadCyclicBarrierAction", dataProvider = "PositiveForThreadService", dataProviderClass = ThreadServiceTestData.class)
    public void threadCyclicBarrierActionPositiveCounter(String arraysPath, int arraysNumber,
	    String threadsPath, int threadsNumber) throws ServiceException {
	MatrixForThreads matrix = barrier.threadCyclicBarrierAction(arraysPath, arraysNumber,
		threadsPath, threadsNumber);
	boolean condition = checkMatrixDiagonalCounter(matrix);
	assertTrue(condition);

    }

    // check only values, sometimes all value can be the same.
    @Test(description = "positive for threadCyclicBarrierAction", dataProvider = "PositiveForThreadServiceValue", dataProviderClass = ThreadServiceTestData.class)
    public void threadCyclicBarrierActionPositiveValue(String arraysPath, int arraysNumber,
	    String threadsPath, int threadsNumber) throws ServiceException {
	MatrixForThreads matrix = barrier.threadCyclicBarrierAction(arraysPath, arraysNumber,
		threadsPath, threadsNumber);
	boolean condition = checkMatrixDiagonalValue(matrix);
	assertTrue(condition);

    }

    // check only counter
    @Test(description = "positive for threadLongAdderAction", dataProvider = "PositiveForThreadService", dataProviderClass = ThreadServiceTestData.class)
    public void threadLongAdderActionPositiveCounter(String arraysPath, int arraysNumber,
	    String threadsPath, int threadsNumber) throws ServiceException {
	MatrixForThreads matrix = adder.threadLongAdderAction(arraysPath, arraysNumber, threadsPath,
		threadsNumber);
	boolean condition = checkMatrixDiagonalCounter(matrix);
	assertTrue(condition);

    }

    // check only values, sometimes all value can be the same.
    @Test(description = "positive for threadLongAdderAction", dataProvider = "PositiveForThreadServiceValue", dataProviderClass = ThreadServiceTestData.class)
    public void ThreadLongAdderActionPositiveValue(String arraysPath, int arraysNumber,
	    String threadsPath, int threadsNumber) throws ServiceException {
	MatrixForThreads matrix = adder.threadLongAdderAction(arraysPath, arraysNumber, threadsPath,
		threadsNumber);
	boolean condition = checkMatrixDiagonalValue(matrix);
	assertTrue(condition);

    }

    ////// NEGATIVE TESTS
    @Test(description = "negative for threadLockAction", dataProvider = "NegativeForThreadService", dataProviderClass = ThreadServiceTestData.class, enabled = true, expectedExceptions = ServiceException.class)
    public void threadLockActionNegativeTest(String arraysPath, int arraysNumber,
	    String threadsPath, int threadsNumber) throws ServiceException {
	lock.threadLockAction(arraysPath, arraysNumber, threadsPath, threadsNumber);
    }

    @Test(description = "negative for threadCyclicBarrierAction", dataProvider = "NegativeForThreadService", dataProviderClass = ThreadServiceTestData.class, enabled = true, expectedExceptions = ServiceException.class)
    public void threadCyclicBarrierActionNegativeTest(String arraysPath, int arraysNumber,
	    String threadsPath, int threadsNumber) throws ServiceException {
	barrier.threadCyclicBarrierAction(arraysPath, arraysNumber, threadsPath, threadsNumber);
    }

    @Test(description = "negative for threadSingletonAction", dataProvider = "NegativeForThreadService", dataProviderClass = ThreadServiceTestData.class, enabled = true, expectedExceptions = ServiceException.class)
    public void threadSingletonActionNegativeTest(String arraysPath, int arraysNumber,
	    String threadsPath, int threadsNumber) throws ServiceException {
	single.threadSingletonAction(arraysPath, arraysNumber, threadsPath, threadsNumber);
    }

    @Test(description = "negative for threadLongAdderAction", dataProvider = "NegativeForThreadService", dataProviderClass = ThreadServiceTestData.class, enabled = true, expectedExceptions = ServiceException.class)
    public void threadLongAdderActionNegativeTest(String arraysPath, int arraysNumber,
	    String threadsPath, int threadsNumber) throws ServiceException {
	adder.threadLongAdderAction(arraysPath, arraysNumber, threadsPath, threadsNumber);
    }

    /**
     * check, if all Counter of all diagonal MatrixMember of MatrixForThreads are
     * equals 1
     * 
     * @param matrix
     * @return
     */
    private boolean checkMatrixDiagonalCounter(MatrixForThreads matrix) {
	int tmp;

	int matrixLength = matrix.getMatrixLength();

	for (int i = 0; i < matrixLength; i++) {

	    tmp = matrix.getMatrixMember(i, i).getCounter();
	    if (tmp != 1) {
		// LOG.debug("error in " + i);
		return false;
	    }
	}
	return true;
    }

    /**
     * check, if all Counter of all diagonal MatrixMember of MatrixForThreads are
     * equals 1
     * 
     * @param matrix
     * @return
     */
    private boolean checkMatrixDiagonalValue(MatrixForThreads matrix) {
	int tmp;
	int tmp2;

	int matrixLength = matrix.getMatrixLength();
	tmp = matrix.getMatrixMember(0, 0).getValue();

	for (int i = 0; i < matrixLength; i++) {

	    tmp2 = matrix.getMatrixMember(i, i).getValue();
	    if (tmp != tmp2) {
		return true;
	    }
	}
	// LOG.debug("all members are the same! ");
	return false;
    }
}
