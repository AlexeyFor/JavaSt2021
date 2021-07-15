package by.training.task06.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task06.entity.MatrixForThreads;
import by.training.task06.entity.ThreadCyclicBarrier;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         Service for ThreadCyclicBarrier. Do all operations to demonstrate how
 *         it works.
 *
 */
public class ThreadCyclicBarrierService {

    private static final Logger LOG = LogManager.getLogger(ThreadCyclicBarrierService.class);

    /**
     * get matrix, than get ThreadCyclicBarrier, than get threads than start and
     * join () all threads, and finally return the matrix with field diagonal
     * members
     * 
     * @param arraysPath
     * @param arraysNumber
     * @param threadsPath
     * @param threadsNumber
     * @return
     * @throws ServiceException
     */
    public MatrixForThreads threadCyclicBarrierAction(String arraysPath, int arraysNumber,
	    String threadsPath, int threadsNumber) throws ServiceException {

	LOG.info("start threadCyclicBarrierAction");
	
	//check incoming data
	checkThreadsArraysNumbers(threadsNumber, arraysNumber);
	
	final int numberOfCycles;
	InitiateMatrixImpl initiateMatrix = InitiateMatrixImpl.getInstance();
	InitiateThreadCyclicBarrier initiateThreadsCyclicBarrier = InitiateThreadCyclicBarrier
		.getInstance();

	// get matrix
	MatrixForThreads matrix = initiateMatrix.takeMatrixFromFile(arraysPath, arraysNumber);

	// calculate number of cycles
	numberOfCycles = (int) Math
		.ceil((double) matrix.getMatrixLength() / (double) threadsNumber);
//	LOG.debug("calculate numberOfCycles " + numberOfCycles + " matrixLength "
//		+ matrix.getMatrixLength() + " threadsNumber " + threadsNumber);

	// get threadCyclicBarrier
	List<ThreadCyclicBarrier> threadsCyclicBarrier = initiateThreadsCyclicBarrier
		.takeThreadsFromFile(threadsPath, threadsNumber, matrix);

	// set CyclicBarrier and numberOfCycles, for threadsCyclicBarrier
	// WARNING - MUST SET static int numberOfOperations as -1;
	setBarrierAndNumberOfCycles(threadsCyclicBarrier, threadsNumber, numberOfCycles);

	// get threads
	List<Thread> threads = createThreads(threadsCyclicBarrier);

	// start all threads
	for (int i = 0; i < threads.size(); i++) {
	    Thread tmp;
	    tmp = threads.get(i);
	    tmp.start();
	}
//
	// join all threads with main thread
	for (int i = 0; i < threads.size(); i++) {
	    try {
		threads.get(i).join();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	LOG.info("end threadCyclicBarrierAction");

	return matrix;
    }

    /**
     * 
     * @param List ThreadCyclicBarrier
     * @return
     */
    private List<Thread> createThreads(List<ThreadCyclicBarrier> threadsCyclicBarrier) {
	List<Thread> threads = new ArrayList<>();

	for (int i = 0; i < threadsCyclicBarrier.size(); i++) {
	    threads.add(new Thread(threadsCyclicBarrier.get(i)));
	}
	return threads;
    }

    /**
     * 
     * @param threads
     * @param threadsNumber
     * @param numberOfCycles
     */
    private void setBarrierAndNumberOfCycles(List<ThreadCyclicBarrier> threads, int threadsNumber,
	    int numberOfCycles) {
	CyclicBarrier barrier = new CyclicBarrier(threadsNumber);
	for (int i = 0; i < threads.size(); i++) {
	    threads.get(i).setBarrier(barrier);
	    threads.get(i).setNumberOfCycles(numberOfCycles);
	}
	ThreadCyclicBarrier.setNumberOfOperations(-1);
    }

    /**
     * check ThreadsNumber and ArraysNumber, if they are wrong - throw exception
     * @param threadsNumber
     * @param arraysNumber
     * @throws ServiceException
     */
    private void checkThreadsArraysNumbers(int threadsNumber, int arraysNumber) throws ServiceException {
	boolean condition = Validation.getInstance().checkThreadsArraysnumbers(threadsNumber,
		arraysNumber);
	if (!condition) {
	   throw new ServiceException ("wrong_incoming_data");
	}
    }

}
