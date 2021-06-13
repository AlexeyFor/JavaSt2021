package by.training.service.sorting;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.training.entity.MyArray;
import by.training.service.creator.CreatorException;
import by.training.service.creator.MyArrayIntegerCreator;

public class ShakeSortingTest {
 
	ShakeSorting tmp = new ShakeSorting();
	MyArrayIntegerCreator creator = new MyArrayIntegerCreator();

	@DataProvider(name = "PositiveForSorting")
	public Object[] positiveForIncrSorting() throws CreatorException {
		return new Object[] { new MyArray<>(new Integer[] { 5, 5, 5, 5, 5, 5, 5 }),
				new MyArray<Integer>(new Integer[] { 0, 1, -6, 7, 11, 9, 3 }),
				new MyArray<Integer>(new Integer[] { 0, 1, 5, 7, 11, 9, 3, Integer.MAX_VALUE, 0, -6,Integer.MAX_VALUE, 3  }),
				new MyArray<Integer>(new Integer[] { 0, 1, 5, 7, 11, 9, 3, Integer.MIN_VALUE, 0, -6,Integer.MIN_VALUE, 3  }),
				new MyArray<Integer>(new Integer[] { 0, 1, 5, 7, 11, 9, 3, Integer.MIN_VALUE, 0, -6,Integer.MAX_VALUE, 3  }),
				new MyArray<Short>(new Short[] { 0, 1, 5, 7, 11, 9, 3, 0, -6, 3  }),
				new MyArray<Double>(new Double[] { 0.5, -1.0, 15.9, -7.3, 11.2}),
				creator.createRandomMA(101, -100, 100),
				creator.createRandomMA(113, -100, 100),
				};
	}
	
	@Test(description = "positive for IncrSorting", dataProvider = "PositiveForSorting")
	public <T extends Comparable<T>> void incrSortingTest(MyArray <T> array){
		tmp.sortIncr(array);
		boolean answer = checkIncreasing(array);
		assertTrue(answer);
	}
	
	@Test(description = "positive for DecrSorting", dataProvider = "PositiveForSorting")
	public <T extends Comparable<T>> void decrSortingTest(MyArray <T> array){
		tmp.sortDecr(array);
		boolean answer = checkDecreasing(array);
		assertTrue(answer);
	}
	
	public <T extends Comparable<T>>  boolean checkIncreasing (MyArray <T> arr) {
		for (int i = 0; i < arr.getLength() - 1; i++) {
			if (arr.getValue(i).compareTo(arr.getValue(i + 1)) > 0) {
				return false;
			}
		}
		return true;
	}
	
	public <T extends Comparable<T>>  boolean checkDecreasing (MyArray <T> arr) {
		for (int i = 0; i < arr.getLength() - 1; i++) {
			if (arr.getValue(i).compareTo(arr.getValue(i + 1)) < 0) {
				return false;
			}
		}
		return true;
	}

}
