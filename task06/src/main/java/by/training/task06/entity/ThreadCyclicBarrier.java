package by.training.task06.entity;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCyclicBarrier implements Runnable {

    private CyclicBarrier barrier;
    private static int numberOfOperations = -1;
    private int numberOfCycles = 0;
    private int fieldNumber;
    private MatrixForThreads matrix;

    private ReentrantLock locker = new ReentrantLock();

    public ThreadCyclicBarrier(int fieldNumber, MatrixForThreads matrix) {
	this.fieldNumber = fieldNumber;
	this.matrix = matrix;
    }

    public void setBarrier(CyclicBarrier barrier) {
	this.barrier = barrier;
    }

    public void setNumberOfCycles(int numberOfCycles) {
	this.numberOfCycles = numberOfCycles;
    }

    public static void setNumberOfOperations(int number) {
	numberOfOperations = number;
    }

    @Override
    public void run() {

	for (int j = 0; j < numberOfCycles; j++) {

	    setMemberValue();
	    try {
		barrier.await();
	    } catch (InterruptedException | BrokenBarrierException e) {
		e.printStackTrace();
	    }
	}

    }

    /**
     * Set value of MatrixMember using Locker
     * 
     * @param index
     * @param value
     */
    private void setMemberValue() {

	this.locker.lock();

	try {
	    numberOfOperations++;
	    MatrixMember member;
	    if (numberOfOperations < matrix.getMatrixLength()) {
		member = matrix.getMatrixMember(numberOfOperations, numberOfOperations);
		if (member.getValue() == 0) {
		    member.setValue(fieldNumber);
		}
	    }
	} finally {
	    locker.unlock();
	}
    }

}
