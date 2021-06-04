package by.training.cycle37;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author AlexeySupruniuk
 * @see DoMainCycle37
 *
 */
public class Cycle37Logic {

	private static final Logger LOG = LogManager.getLogger(Cycle37Logic.class);

	/**
	 * main action for task37
	 * 
	 * @return int {A, B}
	 */
	public int[] execute() {
		LOG.info("start execute");
		List<Integer> numA = new ArrayList<Integer>();

		int temp;
		int result = 0;
		for (int i = 1089; i < 9999; i += 99) {
			if (i % 99 == 0) {
				temp = changeNumberPairs(i);
				numA.add(i);
				if (temp % 49 == 0) {
					result = temp;
				}
			}
		}
		int[] masResult = convertNumAABBtoAA_BB(result);
		return masResult;
	}

	/**
	 * 
	 * @param int aabb
	 * @return mas {aa, bb}
	 */
	private int[] convertNumAABBtoAA_BB(int aabb) {
		int numbersOfaabb[] = fromIntToIntArr(aabb);
		int aa = numbersOfaabb[0] * 10 + numbersOfaabb[1];
		int bb = numbersOfaabb[2] * 10 + numbersOfaabb[3];
		int[] result = new int[] { aa, bb };
		return result;
	}

	/**
	 * convert from int to int []
	 * 
	 * @param int number abcd
	 * @return int {a, b, c, d}
	 */
	public int[] fromIntToIntArr(int num) {
		LOG.info("start fromIntToIntArr with num = " + num);

		num = Math.abs(num);
		String str = String.valueOf(num);
		char[] masOfInt = str.toCharArray();
		int[] mas = new int[masOfInt.length];

		for (int i = 0; i < mas.length; i++) {
			mas[i] = Character.getNumericValue(masOfInt[i]);
		}
		return mas;
	}

	/**
	 * convert from int to List <Integer>
	 * 
	 * @param int number abcd
	 * @return List <Integer> {a, b, c, d}
	 */
	public List<Integer> fromIntToIntList(int num) {
		LOG.info("start fromIntToIntArr with num = " + num);

		num = Math.abs(num);
		String str = String.valueOf(num);
		char[] masOfInt = str.toCharArray();
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < masOfInt.length; i++) {
			result.add(Character.getNumericValue(masOfInt[i]));
		}
		return result;
	}

	/**
	 * get number abcd and return cdba
	 * 
	 * @param number abcd
	 * @return number cdba
	 */
	private int changeNumberPairs(int abcd) {
		LOG.info("start changeNumberPairs with abcd = " + abcd);

		int[] mas = fromIntToIntArr(abcd);

		int a = mas[0];
		int b = mas[1];
		int c = mas[2];
		int d = mas[3];

		int cdba;
		cdba = c * 1000 + d * 100 + a * 10 + b;
		LOG.debug("get result = " + cdba);
		return cdba;
	}
}
