package by.training.service.sorting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;

import by.training.entity.MyArray;

/**
 * * Binary Merging sort with hash method. Contain testing methods for sort with
 * Comparator<T>.
 * 
 * @author AlexeySupruniuk
 *
 */
public class BinaryMergingSorting implements Sorting {

	private static final Logger LOG = LogManager.getLogger(BinaryMergingSorting.class);

	/**
	 * Binary Merging sort by increasing of MyArray, there must be Comparator<T> for
	 * elements of MyArray
	 */
	@Override
	public <T extends Comparable<T>> void sortIncr(MyArray<T> myArray) {
		LOG.debug("start sortIncr");

		T[] tmp;
		T[] currentArray = fromMyArrayToArray(myArray);
		T[] currentDest = fromMyArrayToArray(myArray);

		int size = 1;
		while (size < currentArray.length) {
			// Each iteration merges pairs of arrays [size]
			// currentDest is smth like buffer array
			for (int i = 0; i < currentArray.length; i += 2 * size) {
				mergeIncreasing(currentArray, i, currentArray, i + size, currentDest, i, size);
			}

			tmp = currentArray;
			currentArray = currentDest;
			currentDest = tmp;

			size = size * 2;
		}
		for (int i = 0; i < myArray.getLength(); i++) {
			myArray.setValue(currentArray[i], i);
		}
		LOG.debug("end sortIncr");
	}

	/**
	 * Binary Merging sort by decreasing of MyArray, there must be Comparator<T> for
	 * elements of MyArray
	 */
	@Override
	public <T extends Comparable<T>> void sortDecr(MyArray<T> myArray) {
		LOG.debug("start sortDecr");

		T[] tmp;
		T[] currentArray = fromMyArrayToArray(myArray);
		T[] currentDest = fromMyArrayToArray(myArray);

		int size = 1;
		while (size < currentArray.length) {
			// Each iteration merges pairs of arrays [size]
			// currentDest is smth like buffer array
			for (int i = 0; i < currentArray.length; i += 2 * size) {
				mergeDecreasing(currentArray, i, currentArray, i + size, currentDest, i, size);
			}

			tmp = currentArray;
			currentArray = currentDest;
			currentDest = tmp;

			size = size * 2;
		}
		for (int i = 0; i < myArray.getLength(); i++) {
			myArray.setValue(currentArray[i], i);
		}
		LOG.debug("end sortDecr");

	}

	// from two sorted arrays into one sorted array
	private <T extends Comparable<T>> void mergeIncreasing(T[] array1, int array1Start, T[] array2, int array2Start,
			T[] bufferArray, int bufferArrayStart, int size) {
		int index1 = array1Start;
		int index2 = array2Start;

		int src1End = Math.min(array1Start + size, array1.length);
		int src2End = Math.min(array2Start + size, array2.length);

		// the total number of elements in both subarrays
		int iterationCount = src1End - array1Start + src2End - array2Start;

		for (int i = bufferArrayStart; i < bufferArrayStart + iterationCount; i++) {
			// if element from first array is bigger than element from the second array
			// ended, or s - save it into result array, else save from the second array
			if (index1 < src1End && (index2 >= src2End || array1[index1].compareTo(array2[index2]) < 0)) {
				bufferArray[i] = array1[index1];
				index1++;
			} else {
				bufferArray[i] = array2[index2];
				index2++;
			}
		}
	}

	// from two sorted arrays into one sorted array
	private <T extends Comparable<T>> void mergeDecreasing(T[] array1, int array1Start, T[] array2, int array2Start,
			T[] bufferArray, int bufferArrayStart, int size) {
		int index1 = array1Start;
		int index2 = array2Start;

		int src1End = Math.min(array1Start + size, array1.length);
		int src2End = Math.min(array2Start + size, array2.length);

		// the total number of elements in both subarrays
		int iterationCount = src1End - array1Start + src2End - array2Start;

		for (int i = bufferArrayStart; i < bufferArrayStart + iterationCount; i++) {
			// if element from first array is bigger than element from the second array
			// ended, or s - save it into result array, else save from the second array
			if (index1 < src1End && (index2 >= src2End || array1[index1].compareTo(array2[index2]) > 0)) {
				bufferArray[i] = array1[index1];
				index1++;
			} else {
				bufferArray[i] = array2[index2];
				index2++;
			}
		}
	}

	// Due to the fact that in Java it is impossible to directly create an array of
	// a parameterized type (the compiler must know which objects are stored in the
	// array, but using parameters this is impossible), we will use the following
	// method
	private <T extends Comparable<T>> T[] fromMyArrayToArray(MyArray<T> array) {
		T tmp = array.getValue(0);
		T[] result = (T[]) Array.newInstance(tmp.getClass(), array.getLength());

		for (int i = 0; i < result.length; i++) {
			result[i] = array.getValue(i);
		}
		return result;
	}
}
