package by.training.task06.entity;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task06.dal.FileReaderImpl;
import by.training.task06.service.ThreadSingletonSetValue;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         For filling the MatrixForThreads with using Locker
 *
 */
public class ThreadLock implements Runnable {

    private static final Logger LOG = LogManager.getLogger(ThreadLock.class);

    private MatrixForThreads matrix;
    private int fieldNumber;

    public ThreadLock(MatrixForThreads matrix, int fieldNumber) {
	super();
	this.matrix = matrix;
	this.fieldNumber = fieldNumber;
    }

    @Override
    public void run() {
	LOG.debug("start run() " + Thread.currentThread().getName());

	int matrixLength = matrix.getMatrixLength();
	for (int i = 0; i < matrixLength; i++) {
	    setMemberValue(i, fieldNumber);

//		LOG.debug(Thread.currentThread().getName() + " set value on poisition " + i);
	    try {
		TimeUnit.MILLISECONDS.sleep(1);
//		LOG.debug("sleep " + Thread.currentThread().getName());
	    } catch (InterruptedException e) {
	    }
	}
    }

    /**
     * Set value of MatrixMember using Locker
     * 
     * @param index
     * @param value
     */
    private void setMemberValue(int index, int value) {
	ReentrantLock locker = new ReentrantLock();
	locker.lock();

	try {
	    MatrixMember member;
	    member = matrix.getMatrixMember(index, index);
	    if (member.getValue() == 0) {
		member.setValue(value);

	    }

	} finally {
	    locker.unlock();
	}
    }

}
