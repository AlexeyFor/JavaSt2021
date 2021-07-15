package by.training.task06.entity;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author AlexeySupruniuk
 *
 */
public class MatrixMember {

    private int value;
    private int counter = 0;
    private boolean wasChanging = false;
    ReentrantLock locker = new ReentrantLock();

    public MatrixMember(int value) {
	super();
	this.value = value;
    }

    public int getValue() {
	return value;
    }

    public int getCounter() {
	return counter;
    }

    public void setValue(int value) {
//	locker.lock();
//	try {
	if (!wasChanging) {
	    this.wasChanging = true;
	    this.value = value;
	    this.counter++;
	}
//	} finally {
//	    locker.unlock();
//	}

    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + counter;
	result = prime * result + value;
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	MatrixMember other = (MatrixMember) obj;
	if (counter != other.counter)
	    return false;
	if (value != other.value)
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "ArrayMember [value=" + value + ", counter=" + counter + "]";
    }

}
