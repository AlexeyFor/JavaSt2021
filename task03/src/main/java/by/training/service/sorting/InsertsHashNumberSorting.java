package by.training.service.sorting;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.MyArray;


/**
 * * Insert sort with hash method. Contain testing methods for sort with
 * Comparator<T>.
 * 
 * WORK ONLY WITH  HEIR OF NUMBER
 * 
 * @author AlexeySupruniuk
 *
 */
public class InsertsHashNumberSorting {

	private static final Logger LOG = LogManager.getLogger(InsertsHashNumberSorting.class);

	public <T extends Number & Comparable<T>> void sortIncr(MyArray<T> myArray) {
		LOG.debug("start sortIncr");
		int numOfArrays = 5;
		BigDecimal numberOfArrays = new BigDecimal(numOfArrays);

		BigDecimal minValue = new BigDecimal(findMin(myArray).toString());
		BigDecimal maxValue = new BigDecimal(findMax(myArray).toString());
		BigDecimal distanceBetwinStartEnd = maxValue.subtract(minValue);
		BigDecimal arraysLength = distanceBetwinStartEnd.divide(numberOfArrays);


		// find boards for additional lists
		BigDecimal[] boards = new BigDecimal[numOfArrays];
		boards[0] = minValue.add(arraysLength);
		for (int i = 1; i < numOfArrays; i++) {
			
			boards[i] = boards[i - 1].add(arraysLength);
		}

		// create additional lists
		List<T>[] additionalLists = new List[numOfArrays];
		for (int i = 0; i < numOfArrays; i++) {
			additionalLists[i] = new ArrayList<>();
		}

		for (int i = 0; i < myArray.getLength(); i++) {
			for (int j = 0; j < numOfArrays; j++) {
				if (new BigDecimal(myArray.getValue(i).toString()).compareTo(boards[j]) < 1) {
					insertIncrease(additionalLists[j], myArray.getValue(i));
					break;
				}
			}
		}

		List<T> result = new ArrayList<>();
		for (int i = 0; i < numOfArrays; i++) {
			result.addAll(additionalLists[i]);
		}

		for (int i = 0; i < myArray.getLength(); i++) {
			myArray.setValue(result.get(i), i);
		}
		LOG.debug("end sortIncr");

	}

	///////////DECREASING
	public <T extends Number & Comparable<T>> void sortDecr(MyArray<T> myArray) {
		LOG.debug("start sortDecr");

		int numOfArrays = 5;
		BigDecimal numberOfArrays = new BigDecimal(numOfArrays);

		BigDecimal minValue = new BigDecimal(findMin(myArray).toString());
		BigDecimal maxValue = new BigDecimal(findMax(myArray).toString());
		BigDecimal distanceBetwinStartEnd = maxValue.subtract(minValue);
		BigDecimal arraysLength = distanceBetwinStartEnd.divide(numberOfArrays);

		// find boards for additional lists
		BigDecimal[] boards = new BigDecimal[numOfArrays];
		boards[0] = minValue.add(arraysLength);
		for (int i = 1; i < numOfArrays; i++) {
			boards[i] = boards[i - 1].add(arraysLength);
		}

		// create additional lists
		List<T>[] additionalLists = new List[numOfArrays];
		for (int i = 0; i < numOfArrays; i++) {
			additionalLists[i] = new ArrayList<>();
		}

		for (int i = 0; i < myArray.getLength(); i++) {
			for (int j = 0; j < numOfArrays; j++) {
				if (new BigDecimal(myArray.getValue(i).toString()).compareTo(boards[j]) < 1) {
					insertDecrease(additionalLists[j], myArray.getValue(i));
					break;
				}
			}
		}

		List<T> result = new ArrayList<>();
		for (int i = numOfArrays - 1; i >= 0; i--) {
			result.addAll(additionalLists[i]);
		}

		for (int i = 0; i < myArray.getLength(); i++) {
			myArray.setValue(result.get(i), i);
		}
		LOG.debug("end sortDecr");

	}

	private <T extends Number & Comparable<T>> T findMin(MyArray<T> myArray) {

		int length = myArray.getLength();
		T minimal = myArray.getValue(0);

		for (int i = 1; i < length; i++) {
			if (minimal.compareTo(myArray.getValue(i)) > 0) {
				minimal = myArray.getValue(i);
			}
		}
		LOG.debug("find min " + minimal);
		return minimal;
	}

	private <T extends Number & Comparable<T>> T findMax(MyArray<T> myArray) {

		int length = myArray.getLength();
		T maximum = myArray.getValue(0);

		for (int i = 1; i < length; i++) {
			if (maximum.compareTo(myArray.getValue(i)) < 0) {
				maximum = myArray.getValue(i);
			}
		}
		LOG.debug("find max " + maximum);

		return maximum;
	}

	private <T extends Number & Comparable<T>> void insertIncrease(List<T> list, T element) {

		int size = list.size();
		if (list.size() == 0) {
			list.add(element);
		}

		for (int i = 0; i < size; i++) {
			if (list.get(i).compareTo(element) > 0) {
				list.add(i, element);

				break;
			}
			if (i == size - 1) {
				list.add(size, element);
			}
		}
	}
	
	private <T extends Number & Comparable<T>> void insertDecrease(List<T> list, T element) {

		int size = list.size();
		if (list.size() == 0) {
			list.add(element);
		}

		for (int i = 0; i < size; i++) {
			if (list.get(i).compareTo(element) < 0) {
				list.add(i, element);

				break;
			}
			if (i == size - 1) {
				list.add(size, element);
			}
		}
	}
}
