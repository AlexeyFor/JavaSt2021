package by.training.task06.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task06.entity.MatrixForThreads;
import by.training.task06.entity.MatrixMember;

/**
 * 
 * @author AlexeySupruniuk
 *
 *         Class only for one method. Just to use Thread-safety singleton
 */
public class ThreadSingletonSetValue {

    private ThreadSingletonSetValue() {
    }

    private static class SingletonHolder {
	public static final ThreadSingletonSetValue HOLDER_INSTANCE = new ThreadSingletonSetValue();
    }

    public static ThreadSingletonSetValue getInstance() {
	return SingletonHolder.HOLDER_INSTANCE;
    }

    private static final Logger LOG = LogManager.getLogger(ThreadSingletonSetValue.class);

    /**
     * set value of MatrixMember in MatrixForThreads
     * 
     * @param index
     * @param value
     * @param matrix
     * @throws ServiceException
     */
    public void setMemberValue(int index, int value, MatrixForThreads matrix)
	    throws ServiceException {

	if (index >= matrix.getMatrixLength()) {
	    throw new ServiceException("wrong index");
	}
	MatrixMember member;
	member = matrix.getMatrixMember(index, index);
	if (member.getValue() == 0) {
	    member.setValue(value);

	}

    }
}
