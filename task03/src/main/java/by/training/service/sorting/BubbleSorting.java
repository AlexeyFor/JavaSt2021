package by.training.service.sorting;

import java.util.Comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.MyArray;

/**
 * Bubble sort the MyArray. Contain testing methods for sort with Comparator<T>.
 * Methods don't use in project
 * 
 * @author AlexeySupruniuk
 *
 * @param <T>
 */
public class BubbleSorting implements Sorting {

	private static final Logger LOG = LogManager.getLogger(BubbleSorting.class);

	/**
	 * "Bubble" sort by increasing of MyArray, there must be Comparator<T> for
	 * elements of MyArray
	 */
	public <T> void sortWithComporatorIncr(MyArray<T> myArray, Comparator<T> comparator) {
		LOG.debug("start sortWithComporatorIncr");

		int length = myArray.getLength();

		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (comparator.compare(myArray.getValue(j), myArray.getValue(j + 1)) > 0) {
					myArray.swapByIndex(j, j + 1);
				}
			}
		}
		LOG.debug("end sortWithComporatorIncr");
	}

	/**
	 * "Bubble" sort by decreasing of MyArray, there must be Comparator<T> for
	 * elements of MyArray
	 */
	public <T> void sortWithComporatorDecr(MyArray<T> myArray, Comparator<T> comparator) {
		LOG.debug("start sortWithComporatorDecr");

		int length = myArray.getLength();

		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (comparator.compare(myArray.getValue(j), myArray.getValue(j + 1)) < 0) {
					myArray.swapByIndex(j, j + 1);
				}
			}
		}
		LOG.debug("end sortWithComporatorDecr");
	}

	/**
	 * "Bubble" sort by increasing of MyArray, there must be method compareTo() for
	 * elements of MyArray
	 */
	public <T extends Comparable<T>> void sortIncr(MyArray<T> myArray) {
		LOG.debug("start sortIncr");
		int length = myArray.getLength();

		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (((myArray.getValue(j)).compareTo(myArray.getValue(j + 1))) > 0) {
					myArray.swapByIndex(j, j + 1);
				}
			}
		}
		LOG.debug("end sortIncr");
	}

	/**
	 * "Bubble" sort by decreasing of MyArray, there must be method compareTo() for
	 * elements of MyArray
	 */
	public <T extends Comparable<T>> void sortDecr(MyArray<T> myArray) {
		LOG.debug("start sortDecr");

		int length = myArray.getLength();

		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (((myArray.getValue(j)).compareTo(myArray.getValue(j + 1))) < 0) {
					myArray.swapByIndex(j, j + 1);
				}
			}
		}
		LOG.debug("end sortDecr");
	}

}
