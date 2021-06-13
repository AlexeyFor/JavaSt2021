package by.training.service.sorting;

import java.util.Comparator;

import by.training.entity.MyArray;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         Sort MyArray <T>, where elements of array implements Comparable<T>;
 * 
 *         Two methods with which you can sort arrays of any type using
 *         Comparator<T> commented out as unnecessary in this project
 * @param <T>
 */
public interface Sorting {

	//
//	void sortWithComporatorIncr(MyArray<T> myArray, Comparator<T> comparator);

//	void sortWithComporatorDecr(MyArray<T> myArray, Comparator<T> comparator);

	<T extends Comparable<T>> void sortIncr(MyArray<T> myArray);

	<T extends Comparable<T>> void sortDecr(MyArray<T> myArray);

}
