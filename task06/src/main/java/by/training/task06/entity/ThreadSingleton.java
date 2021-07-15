package by.training.task06.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task06.service.ServiceException;
import by.training.task06.service.ThreadSingletonSetValue;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         For filling the MatrixForThreads with using Thread-safety singleton
 *
 */
public class ThreadSingleton implements Runnable {

    private static final Logger LOG = LogManager.getLogger(ThreadSingleton.class);

    private MatrixForThreads matrix;
    private int fieldNumber;

    public ThreadSingleton(MatrixForThreads matrix, int fieldNumber) {
	super();
	this.matrix = matrix;
	this.fieldNumber = fieldNumber;
    }

    @Override
    public void run() {
	LOG.debug("start run() " + Thread.currentThread().getName());

	int matrixLength = matrix.getMatrixLength();
	for (int i = 0; i < matrixLength; i++) {
	    try {
		ThreadSingletonSetValue.getInstance().setMemberValue(i, fieldNumber, matrix);
	    } catch (ServiceException e1) {
		LOG.warn("wrong index " + e1.getMessage());
	    }
//		LOG.debug(Thread.currentThread().getName() + " set value on poisition " + i);
	    try {
		Thread.sleep(1);
//		LOG.debug("sleep " + Thread.currentThread().getName());
	    } catch (InterruptedException e) {
	    }
	}
    }

}
