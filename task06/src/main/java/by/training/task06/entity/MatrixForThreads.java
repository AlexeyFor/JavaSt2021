package by.training.task06.entity;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixForThreads {

    private MatrixMember[][] matrix;
    ReentrantLock locker = new ReentrantLock();

    public MatrixForThreads(MatrixMember[][] matrix) {
	super();
	this.matrix = matrix;
    }

    public int getMatrixLength() {
	return matrix[0].length;
    }

    public MatrixMember getMatrixMember(int i, int j) {

	return matrix[i][j];

    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Arrays.deepHashCode(matrix);
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
	MatrixForThreads other = (MatrixForThreads) obj;
	if (!Arrays.deepEquals(matrix, other.matrix))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "MatrixForThreads [matrix=" + Arrays.toString(matrix) + "]";
    }

}
