package by.training.task06.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task06.entity.MatrixForThreads;
import by.training.task06.entity.ThreadLongAdder;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         Service for ThreadLongAdder. Do all operations to demonstrate how it
 *         works.
 *
 */
public class ThreadLongAdderService {

    private static final Logger LOG = LogManager.getLogger(ThreadLongAdderService.class);

    /**
     * get matrix, than get ThreadLongAdder, than get threads than start and join ()
     * all threads, and finally return the matrix with field diagonal members
     * 
     * @param arraysPath
     * @param arraysNumber
     * @param threadsPath
     * @param threadsNumber
     * @return
     * @throws ServiceException
     */
    public MatrixForThreads threadLongAdderAction(String arraysPath, int arraysNumber,
	    String threadsPath, int threadsNumber) throws ServiceException {

	LOG.info("start threadLongAdderAction");

	// check incoming data
	checkThreadsArraysNumbers(threadsNumber, arraysNumber);

	final int numberOfCycles;
	InitiateMatrixImpl initiateMatrix = InitiateMatrixImpl.getInstance();
	InitiateThreadLongAdder initiateThreadsLongAdder = InitiateThreadLongAdder.getInstance();

	// get matrix
	MatrixForThreads matrix = initiateMatrix.takeMatrixFromFile(arraysPath, arraysNumber);

	// calculate number of cycles
	numberOfCycles = (int) Math
		.ceil((double) matrix.getMatrixLength() / (double) threadsNumber);
//	LOG.debug("calculate numberOfCycles " + numberOfCycles + " matrixLength "
//		+ matrix.getMatrixLength() + " threadsNumber " + threadsNumber);

	// get ThreadLongAdder
	List<ThreadLongAdder> threadsLongAdder = initiateThreadsLongAdder
		.takeThreadsFromFile(threadsPath, threadsNumber, matrix);

	// set ThreadLongAdder and numberOfCycles, for ThreadsLongAdder
	// WARNING - MUST SET static int numberOfOperations as -1;
	setBarrierAndNumberOfCycles(threadsLongAdder, threadsNumber, numberOfCycles);

	// get threads
	List<Thread> threads = createThreads(threadsLongAdder);

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
     * @param List ThreadLongAdder
     * @return
     */
    private List<Thread> createThreads(List<ThreadLongAdder> threadsLongAdder) {
	List<Thread> threads = new ArrayList<>();

	for (int i = 0; i < threadsLongAdder.size(); i++) {
	    threads.add(new Thread(threadsLongAdder.get(i)));
	}
	return threads;
    }

    /**
     * 
     * @param threads
     * @param threadsNumber
     * @param numberOfCycles
     */
    private void setBarrierAndNumberOfCycles(List<ThreadLongAdder> threads, int threadsNumber,
	    int numberOfCycles) {
	CyclicBarrier barrier = new CyclicBarrier(threadsNumber);
	for (int i = 0; i < threads.size(); i++) {
	    threads.get(i).setBarrier(barrier);
	    threads.get(i).setNumberOfCycles(numberOfCycles);
	}
	ThreadLongAdder.resetNumberOfOperations();
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
