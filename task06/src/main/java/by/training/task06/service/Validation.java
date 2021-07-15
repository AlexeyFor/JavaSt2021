package by.training.task06.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         For validation of incoming values
 *
 */
public class Validation {

    private Validation() {
    }

    private static class SingletonHolder {
	public static final Validation HOLDER_INSTANCE = new Validation();
    }

    public static Validation getInstance() {
	return SingletonHolder.HOLDER_INSTANCE;
    }

    private static final Logger LOG = LogManager.getLogger(Validation.class);

    // see file .threads.txt in resources
    private final int MAX_NUMBER_OF_THREADS = 99;

    // see file .arrays.txt in resources
    private final int MAX_NUMBER_OF_ARRAYS = 250;

    /**
     * check number of threads and number of arrays in Matrix
     * 
     * @return boolean
     */
    public boolean checkThreadsArraysnumbers(int numberOfThreads, int numberOfArrays) {
	LOG.debug("start checkTwoInt with numberOfThreads " + numberOfThreads + " ,numberOfArrays "
		+ numberOfArrays);
	boolean condition1 = numberOfThreads <= MAX_NUMBER_OF_THREADS;
	boolean condition2 = numberOfArrays <= MAX_NUMBER_OF_ARRAYS;
	boolean condition3 = numberOfThreads > 0;
	boolean condition4 = numberOfArrays > 0;



	return condition1 && condition2 && condition3 && condition4;

    }
}
