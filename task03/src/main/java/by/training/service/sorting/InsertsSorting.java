package by.training.service.sorting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.MyArray;

/**
 * Insert sort the MyArray. Contain testing methods for sort with Comparator<T>.
 * 
 * @author AlexeySupruniuk
 *
 */
public class InsertsSorting implements Sorting {

	private static final Logger LOG = LogManager.getLogger(InsertsSorting.class);

	/**
	 * "Insert" sort by increasing of MyArray, there must be Comparator<T> for
	 * elements of MyArray
	 */
	@Override
	public <T extends Comparable<T>> void sortIncr(MyArray<T> myArray) {
		LOG.debug("start sortIncr");

		for (int i = 0; i < myArray.getLength(); i++) {
			T tmp = myArray.getValue(i);
			// find the place for our element
			int indexOfRequiredElement = binarySearchForIncreasingSort(myArray, myArray.getValue(i), i);
			for (int q = i; q > indexOfRequiredElement; q--) {
				myArray.setValue(myArray.getValue(q - 1), q);
			}
			myArray.setValue(tmp, indexOfRequiredElement);
		}
		LOG.debug("end sortIncr");

	}

	/**
	 * "Insert" sort by decreasing of MyArray, there must be Comparator<T> for
	 * elements of MyArray
	 */
	@Override
	public <T extends Comparable<T>> void sortDecr(MyArray<T> myArray) {

		LOG.debug("start sortDecr");

		for (int i = 0; i < myArray.getLength(); i++) {
			T tmp = myArray.getValue(i);
			// find the place for our element
			int indexOfRequiredElement = binarySearchForDecreasingSort(myArray, myArray.getValue(i), i);
			for (int q = i; q > indexOfRequiredElement; q--) {
				myArray.setValue(myArray.getValue(q - 1), q);
			}
			myArray.setValue(tmp, indexOfRequiredElement);
		}
		LOG.debug("end sortDecr");

	}

	/**
	 * binary Search for position of the element (for increasing sort)
	 * 
	 * @param <T>
	 * @param array
	 * @param requiredElement
	 * @param lastIndex
	 * @return
	 */
	private <T extends Comparable<T>> int binarySearchForIncreasingSort(MyArray<T> myArray, T requiredElement,
			int lastIndex) {

		int firstIndex = 0;

		while (firstIndex <= lastIndex) {
			int middleIndex = (firstIndex + lastIndex) / 2;

			if (myArray.getValue(middleIndex).compareTo(requiredElement) == 0) {
				return middleIndex;
			}

			// if the middle element is less than the desired one,
			// push our index to middle + 1,
			// removing the first (left) part from consideration

			else if (myArray.getValue(middleIndex).compareTo(requiredElement) < 0) {
				firstIndex = middleIndex + 1;
			}

			// if the middle element is more than the desired one,
			// push our index to middle - 1,
			// removing second (right) part from consideration

			else if (myArray.getValue(middleIndex).compareTo(requiredElement) > 0) {
				lastIndex = middleIndex - 1;
			}

		}
		return firstIndex;
	}

	/**
	 * binary Search for position of the element (for increasing sort)
	 * 
	 * @param <T>
	 * @param array
	 * @param requiredElement
	 * @param lastIndex
	 * @return
	 */
	private <T extends Comparable<T>> int binarySearchForDecreasingSort(MyArray<T> myArray, T requiredElement,
			int lastIndex) {

		int firstIndex = 0;

		while (firstIndex <= lastIndex) {
			int middleIndex = (firstIndex + lastIndex) / 2;

			if (myArray.getValue(middleIndex).compareTo(requiredElement) == 0) {
				return middleIndex;
			}

			// if the middle element is less than the desired one,
			// push our index to middle + 1,
			// removing the first (left) part from consideration

			else if (myArray.getValue(middleIndex).compareTo(requiredElement) > 0) {
				firstIndex = middleIndex + 1;
			}

			// if the middle element is more than the desired one,
			// push our index to middle - 1,
			// removing second (right) part from consideration

			else if (myArray.getValue(middleIndex).compareTo(requiredElement) < 0) {
				lastIndex = middleIndex - 1;
			}

		}
		return firstIndex;
	}
}
