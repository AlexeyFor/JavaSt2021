package by.training.service.sorting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.MyArray;

public class SelectionSorting implements Sorting {

	private static final Logger LOG = LogManager.getLogger(SelectionSorting.class);

	/**
	 * "Selection" sort by increasing of MyArray, there must be method compareTo()
	 * for elements of MyArray
	 */
	public <T extends Comparable<T>> void sortIncr(MyArray<T> myArray) {

		LOG.debug("start sortIncr");

		int length = myArray.getLength();

		for (int i = 0; i < length - 1; i++) {
			T tmp = myArray.getValue(i);
			int position = i;
			for (int j = i + 1; j < length; j++) {
				if (tmp.compareTo(myArray.getValue(j)) > 0) {
					tmp = myArray.getValue(j);
					position = j;
				}
			}
			if (i != position) {
				myArray.swapByIndex(i, position);
			}
		}
		LOG.debug("end sortIncr");

	}

	/**
	 * "Selection" sort by decreasing of MyArray, there must be method compareTo()
	 * for elements of MyArray
	 */
	@Override
	public <T extends Comparable<T>> void sortDecr(MyArray<T> myArray) {
		LOG.debug("start sortDecr");

		int length = myArray.getLength();

		for (int i = 0; i < length - 1; i++) {
			T tmp = myArray.getValue(i);
			int position = i;
			for (int j = i + 1; j < length; j++) {
				if (tmp.compareTo(myArray.getValue(j)) < 0) {
					tmp = myArray.getValue(j);
					position = j;
				}
			}
			if (i != position) {
				myArray.swapByIndex(i, position);
			}
		}
		LOG.debug("end sortDecr");

	}

}
