package by.training.num37;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Num37ConditionsTest {

	Num37Conditions temp = new Num37Conditions();

	// condition0 data
	@DataProvider(name = "positiveCondition0")
	public Object[] createPositiveCondition0() {
		return new Object[] { 98, -98, 10, -10 };
	}

	@DataProvider(name = "negativeCondition0")
	public Object[] createNegativeCondition0() {
		return new Object[] { 0, 9, -9, 100, 95 };
	}

	// condition1 data
	@DataProvider(name = "positiveCondition1")
	public Object[] createPositiveCondition1() {
		return new Object[] { 2680, 2011, -1010, -8695 };
	}

	@DataProvider(name = "negativeCondition1")
	public Object[] createNegativeCondition1() {
		return new Object[] { 0, 10000, -1122, 1123, 999 };
	}

	// condition2 data
	@DataProvider(name = "positiveCondition2")
	public Object[] createPositiveCondition2() {
		return new Object[] { 952, 101, 998, -800 };
	}

	@DataProvider(name = "negativeCondition2")
	public Object[] createNegativeCondition2() {
		return new Object[] { 0, 1001, 99, 502, -681 };
	}

	// condition3 data
	@DataProvider(name = "positiveCondition3")
	public Object[] createPositiveCondition3() {
		return new double[][] { new double[] { 2, 1, 3 }, new double[] { -2.5, -3.5, 0 },
				new double[] { 1.5, 1.1, 2.6 }, new double[] { -1.5, -2.6, -1 } };
	}

	@DataProvider(name = "negativeCondition3")
	public Object[] createNegativeCondition3() {
		return new double[][] { new double[] { 0, 0, 0 }, new double[] { 0, 1, 2 }, new double[] { -1, -0.5, 1 },
				new double[] { 2, 0.5, 1.1 }, new double[] { 1, 2, 1 } };
	}

	// condition4 data

	@DataProvider(name = "negativeCondition4")
	public Object[] createNegativeCondition4() {
		return new Object[] { 0, 1001, 99, 502, -681, 875, 125, 657 };
	}

	// condition5 data
	@DataProvider(name = "positiveCondition5")
	public Object[] createPositiveCondition5() {
		return new double[][] { new double[] { 6, 6, 4 }, new double[] { 6, 4, 6 }, new double[] { 4, 6, 6 },
				new double[] { 6, 6, 6 }, new double[] { 6.5, 6.5, 4.5 }, new double[] { 6.5, 4.5, 6.5 },
				new double[] { 4.5, 6.5, 6.5 }, new double[] { 6.5, 6.5, 6.5 } };
	}

	@DataProvider(name = "negativeCondition5")
	public Object[] createNegativeCondition5() {
		return new double[][] { new double[] { 0, 6, 4 }, new double[] { 6, 0, 6 }, new double[] { 4, 6, 0 },
				new double[] { -6, 6, 6 }, new double[] { 6.5, -6.5, 4.5 }, new double[] { 6.5, 4.5, -6.5 },
				new double[] { 4.5, 7.5, 6.5 } };
	}

	// condition6 data
	@DataProvider(name = "positiveCondition6")
	public Object[] createPositiveCondition6() {
		return new Object[] { 123, 321, 101, 990 };
	}

	@DataProvider(name = "negativeCondition6")
	public Object[] createNegativeCondition6() {
		return new Object[] { 0, 26, 1001, -505, 560 };
	}

	// condition7 data
	@DataProvider(name = "positiveCondition7")
	public Object[] createPositiveCondition7() {
		return new double[][] { new double[] { 225, 15 }, new double[] { -216, -6 }, new double[] { 1, -5 },
				new double[] { 1, 68 }, new double[] { 0, 0 } };
	}

	@DataProvider(name = "negativeCondition7")
	public Object[] createNegativeCondition7() {
		return new double[][] { new double[] { 224, 15 }, new double[] { -215, -6 }, new double[] { 0, 456 },
				new double[] { 2, 68 }, };
	}

	// condition8 data
	// mas[0] a, mas[1] b, mas[2] c, mas[3] m, mas[4] n
	@DataProvider(name = "positiveCondition8")
	public Object[] createPositiveCondition8() {
		return new double[][] { new double[] { 3, 7, -4, -3, 2 }, { 3, 7, -4, 1, 6 }, { 1, -5, 6, 1, 2 } };
	}

	@DataProvider(name = "negativeCondition8")
	public Object[] createNegativeCondition8() {
		return new double[][] { new double[] { 3, 7, 0, -3, 2 }, { 3, 7, -4, 1, 0 }, { 3, 7, -4, 1, -10 } };

	}

	// condition0
	@Test(description = "Positive scenary for condition0", dataProvider = "positiveCondition0")
	public void testPositiveCondition0(int n) {
		boolean actual = temp.condition0(n);
		assertTrue(actual);
	}

	@Test(description = "Negative scenary for condition0", dataProvider = "negativeCondition0")
	public void testNegativeCondition0(int n) {
		boolean actual = temp.condition0(n);
		assertFalse(actual);
	}

	// condition1
	@Test(description = "Positive scenary for condition1", dataProvider = "positiveCondition1")
	public void testPositiveCondition1(int n) {
		boolean actual = temp.condition1(n);
		assertTrue(actual);
	}

	@Test(description = "Negative scenary for condition1", dataProvider = "negativeCondition1")
	public void testNegativeCondition1(int n) {
		boolean actual = temp.condition1(n);
		assertFalse(actual);
	}

	// condition2
	@Test(description = "Positive scenary for condition2", dataProvider = "positiveCondition2")
	public void testPositiveCondition2(int n) {
		boolean actual = temp.condition2(n);
		assertTrue(actual);
	}

	@Test(description = "Negative scenary for condition2", dataProvider = "negativeCondition2")
	public void testNegativeCondition2(int n) {
		boolean actual = temp.condition2(n);
		assertFalse(actual);
	}

	// condition3
	// (mas[0] x, mas[1] m, mas[2] n
	@Test(description = "Positive scenary for condition3", dataProvider = "positiveCondition3")
	public void testPositiveCondition3(double[] mas) {
		boolean actual = temp.condition3(mas[0], mas[1], mas[2]);
		assertTrue(actual);
	}

	@Test(description = "Negative scenary for condition3", dataProvider = "negativeCondition3")
	public void testNegativeCondition3(double[] mas) {
		boolean actual = temp.condition3(mas[0], mas[1], mas[2]);
		assertFalse(actual);
	}

	// condition4
	@Test(description = "Negative scenary for condition4", dataProvider = "negativeCondition4")
	public void testNegativeCondition4(int n) {
		boolean actual = temp.condition4(n);
		assertFalse(actual);
	}

	// condition5
	// (mas[0] a, mas[1] b, mas[2] c
	@Test(description = "Positive scenary for condition5", dataProvider = "positiveCondition5")
	public void testPositiveCondition5(double[] mas) {
		boolean actual = temp.condition5(mas[0], mas[1], mas[2]);
		assertTrue(actual);
	}

	@Test(description = "Negative scenary for condition5", dataProvider = "negativeCondition5")
	public void testNegativeCondition5(double[] mas) {
		boolean actual = temp.condition5(mas[0], mas[1], mas[2]);
		assertFalse(actual);
	}

	// condition6
	@Test(description = "Positive scenary for condition6", dataProvider = "positiveCondition6")
	public void testPositiveCondition6(int n) {
		boolean actual = temp.condition6(n);
		assertTrue(actual);
	}

	@Test(description = "Negative scenary for condition6", dataProvider = "negativeCondition6")
	public void testNegativeCondition6(int n) {
		boolean actual = temp.condition6(n);
		assertFalse(actual);
	}

	// condition7
	// mas[0] N, mas[1] a
	@Test(description = "Positive scenary for condition7", dataProvider = "positiveCondition7")
	public void testPositiveCondition7(double[] mas) {
		boolean actual = temp.condition7((int) mas[0], mas[1]);
		assertTrue(actual);
	}

	@Test(description = "Negative scenary for condition7", dataProvider = "negativeCondition7")
	public void testNegativeCondition7(double[] mas) {
		boolean actual = temp.condition7((int) mas[0], mas[1]);
		assertFalse(actual);
	}

	// condition8
	// mas[0] a, mas[1] b, mas[2] c, mas[3] m, mas[4] n
	@Test(description = "Positive scenary for condition8", dataProvider = "positiveCondition8")
	public void testPositiveCondition8(double[] mas) {
		boolean actual = temp.condition8(mas[0], mas[1], mas[2], mas[3], mas[4]);
		assertTrue(actual);
	}

	@Test(description = "Negative scenary for condition8", dataProvider = "negativeCondition8")
	public void testNegativeCondition8(double[] mas) {
		boolean actual = temp.condition8(mas[0], mas[1], mas[2], mas[3], mas[4]);
		assertFalse(actual);
	}
}
