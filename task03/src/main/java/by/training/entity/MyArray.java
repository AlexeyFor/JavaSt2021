package by.training.entity;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 
 * @author AlexeySupruniuk
 * 
 * @param <T>
 */
public class MyArray<T> implements Serializable {

	private static final long serialVersionUID = -5684262887654516511L;

	private T[] myArray;

	public MyArray(T[] myArray) {
		super();
		this.myArray = myArray;
	}
	
	
	public MyArray() {
		super();
	}

//	public T[] getValue() {
//		return myArray;
//	}

	public T getValue(int index) {
		return myArray[index];
	}

	public void setMyArray(T[] myArray) {
		this.myArray = myArray;
	}

	public void setValue(T tmp, int index) {
		this.myArray[index] = tmp;
	}

	public int getLength() {
		return myArray.length;
	}

	/**
	 * swaps two elements
	 */
	public void swapByIndex(int firstInd, int secondInd) {
		T tmp;
		tmp = myArray[firstInd];
		myArray[firstInd] = myArray[secondInd];
		myArray[secondInd] = tmp;
	}

	@Override
	public String toString() {
		return "MyArray [myArray=" + Arrays.toString(myArray) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(myArray);
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
		MyArray<T> other = (MyArray<T>) obj;
		if (!Arrays.deepEquals(myArray, other.myArray))
			return false;
		return true;
	}

}
