package by.training.service.sorting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.MyArray;

public class ShakeSorting implements Sorting {

	private static final Logger LOG = LogManager.getLogger(ShakeSorting.class);

	/**
	 * "Bubble" sort by increasing of MyArray, there must be method compareTo() for
	 * elements of MyArray
	 */
	@Override
	public <T extends Comparable<T>> void sortIncr(MyArray<T> myArray) {

		LOG.debug("start sortIncr");

		int length = myArray.getLength();

		for (int i = 0; i < length - 1; i++) {
			for (int j = i; j < length - i - 1; j++) {
				if (((myArray.getValue(j)).compareTo(myArray.getValue(j + 1))) > 0) {
					myArray.swapByIndex(j, j + 1);
				}
			}
			for (int k = length - i - 1; k > i; k--) {
				if (((myArray.getValue(k)).compareTo(myArray.getValue(k - 1))) < 0) {
					myArray.swapByIndex(k, k - 1);
				}
			}
		}
		LOG.debug("end sortIncr");
	}

	/**
	 * "Bubble" sort by decreasing of MyArray, there must be method compareTo() for
	 * elements of MyArray
	 */
	@Override
	public <T extends Comparable<T>> void sortDecr(MyArray<T> myArray) {
		LOG.debug("start sortDecr");

		int length = myArray.getLength();

		for (int i = 0; i < length - 1; i++) {
			for (int j = i; j < length - i - 1; j++) {
				if (((myArray.getValue(j)).compareTo(myArray.getValue(j + 1))) < 0) {
					myArray.swapByIndex(j, j + 1);
				}
			}
			for (int k = length - i - 1; k > i; k--) {
				if (((myArray.getValue(k)).compareTo(myArray.getValue(k - 1))) > 0) {
					myArray.swapByIndex(k, k - 1);
				}
			}
		}
		LOG.debug("end sortDecr");
	}

}
