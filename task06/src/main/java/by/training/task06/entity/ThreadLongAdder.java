package by.training.task06.entity;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.LongAdder;

public class ThreadLongAdder implements Runnable {

    static {
	numberOfOperations = new LongAdder();
    }

    private CyclicBarrier barrier;
    private static LongAdder numberOfOperations;
    private int numberOfCycles = 0;
    private int fieldNumber;
    private MatrixForThreads matrix;

    public ThreadLongAdder(int fieldNumber, MatrixForThreads matrix) {
	this.fieldNumber = fieldNumber;
	this.matrix = matrix;
    }

    public void setBarrier(CyclicBarrier barrier) {
	this.barrier = barrier;
    }

    public void setNumberOfCycles(int numberOfCycles) {
	this.numberOfCycles = numberOfCycles;
    }

    public static void resetNumberOfOperations() {
	numberOfOperations.reset();
    }

    @Override
    public void run() {
	MatrixMember member;

	for (int j = 0; j < numberOfCycles; j++) {
	    int numberOperationsInt = numberOfOperations.intValue();
	    if (numberOperationsInt < matrix.getMatrixLength()) {
		member = matrix.getMatrixMember(numberOperationsInt, numberOperationsInt);
		if (member.getValue() == 0) {
		    member.setValue(fieldNumber);
		    numberOfOperations.increment();
		}
	    }
	    try {
		barrier.await();
	    } catch (InterruptedException | BrokenBarrierException e) {
		e.printStackTrace();
	    }
	}

    }
}
