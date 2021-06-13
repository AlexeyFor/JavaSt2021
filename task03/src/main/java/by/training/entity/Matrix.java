package by.training.entity;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 
 * @author AlexeySupruniuk
 *
 */
public class Matrix<T extends Number> implements Serializable {

	private static final long serialVersionUID = -3524017683732421431L;
	
	private T[][] matrix;

	public Matrix() {
		super();
	}

	public Matrix(T[][] matrix) {
		super();
		this.matrix = matrix;
	}

	public T[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(T[][] matrix) {
		this.matrix = matrix;
	}
	
	public void setValue(int i, int j, T value) {
		this.matrix [i] [j] = value;
	}

	public T getValue(int arrayNum, int number) {
		return matrix[arrayNum][number];
	}

	public int getMatrixLength() {
		return matrix.length;
	}

	public int getArrayLength(int arrayNum) {
		return matrix[arrayNum].length;
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
		Matrix<T> other = (Matrix<T>) obj;
		if (!Arrays.deepEquals(matrix, other.matrix))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matrix [matrix=" + Arrays.toString(matrix) + "]";
	}

}
