package by.training.task06.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task06.entity.MatrixForThreads;
import by.training.task06.entity.ThreadSingleton;

public class ThreadSingletonService {

    private static final Logger LOG = LogManager.getLogger(ThreadLockService.class);

    /**
     * get matrix, than get threadsSingleton, than get threads than start and join
     * () all threads, and finally return the matrix with field diagonal members
     * 
     * @param arraysPath
     * @param arraysNumber
     * @param threadsPath
     * @param threadsNumber
     * @return
     * @throws ServiceException
     */
    public MatrixForThreads threadSingletonAction(String arraysPath, int arraysNumber,
	    String threadsPath, int threadsNumber) throws ServiceException {

	LOG.info("start ThreadSingletonAction");

	// check incoming data
	checkThreadsArraysNumbers(threadsNumber, arraysNumber);

	InitiateMatrixImpl initiateMatrix = InitiateMatrixImpl.getInstance();
	InitiateThreadSingleton initiateThreadsSingleton = InitiateThreadSingleton.getInstance();

	// get matrix
	MatrixForThreads matrix = initiateMatrix.takeMatrixFromFile(arraysPath, arraysNumber);

	// get threadsSleep
	List<ThreadSingleton> threadsSingleton = initiateThreadsSingleton
		.takeThreadsFromFile(threadsPath, threadsNumber, matrix);

	// get threads
	List<Thread> threads = createThreads(threadsSingleton);

	// start all threads
	for (int i = 0; i < threads.size(); i++) {
	    Thread tmp;
	    tmp = threads.get(i);
	    tmp.start();
	}

	// join all threads with main thread
	for (int i = 0; i < threads.size(); i++) {
	    try {
		threads.get(i).join();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	LOG.info("end ThreadSingletonAction");

	return matrix;
    }

    /**
     * 
     * @param threadsSleep
     * @return
     */
    private List<Thread> createThreads(List<ThreadSingleton> threadsSingleton) {
	List<Thread> threads = new ArrayList<Thread>();

	for (int i = 0; i < threadsSingleton.size(); i++) {
	    threads.add(new Thread(threadsSingleton.get(i)));
	}
	return threads;
    }

    /**
     * check ThreadsNumber and ArraysNumber, if they are wrong - throw exception
     * 
     * @param threadsNumber
     * @param arraysNumber
     * @throws ServiceException
     */
    private void checkThreadsArraysNumbers(int threadsNumber, int arraysNumber)
	    throws ServiceException {
	boolean condition = Validation.getInstance().checkThreadsArraysnumbers(threadsNumber,
		arraysNumber);
	if (!condition) {
	    throw new ServiceException("wrong_incoming_data");
	}
    }

}
