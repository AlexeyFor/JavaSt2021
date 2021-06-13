package by.training.service.sorting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.MyArray;

/**
 * Shell sort the MyArray. Contain testing methods for sort with Comparator<T>.
 * Methods don't use in project
 * 
 * @author AlexeySupruniuk
 *
 */
public class ShellSorting implements Sorting {

	private static final Logger LOG = LogManager.getLogger(ShellSorting.class);

	/**
	 * Shell sort by increasing of MyArray, there must be Comparator<T> for elements
	 * of MyArray
	 */
	@Override
	public <T extends Comparable<T>> void sortIncr(MyArray<T> myArray) {
		LOG.debug("start sortIncr");

		int halfLength = myArray.getLength() / 2;

		while (halfLength > 0) {
			for (int i = 0; i < (myArray.getLength() - halfLength); i++) {
				int p = i;
				while ((p >= 0) && (myArray.getValue(p).compareTo(myArray.getValue(p + halfLength)) > 0)) {
					myArray.swapByIndex(p, (p + halfLength));

					// only for final step, when adjacent elements will compare
					if (halfLength == 1) {
						p--;
					}
				}
			}
			halfLength /= 2;
		}
		LOG.debug("end sortIncr");
	}

	/**
	 * Shell sort by decreasing of MyArray, there must be Comparator<T> for elements
	 * of MyArray
	 */
	@Override
	public <T extends Comparable<T>> void sortDecr(MyArray<T> myArray) {
		LOG.debug("start sortDecr");

		int halfLength = myArray.getLength() / 2;

		while (halfLength > 0) {
			for (int i = 0; i < (myArray.getLength() - halfLength); i++) {
				int p = i;
				while ((p >= 0) && (myArray.getValue(p).compareTo(myArray.getValue(p + halfLength)) < 0)) {
					myArray.swapByIndex(p, (p + halfLength));

					// only for final step, when adjacent elements will compare
					if (halfLength == 1) {
						p--;
					}
				}
			}
			halfLength /= 2;
		}
		LOG.debug("end sortDecr");
	}

}
