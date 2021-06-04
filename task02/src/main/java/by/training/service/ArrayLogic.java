package by.training.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.util.MyScan;

/**
 * usable methods for arrays
 * 
 * @author AlexeySupruniuk
 *
 */
public class ArrayLogic {

	private static final Logger LOG = LogManager.getLogger(ArrayLogic.class);

	private static final ArrayLogic arrayLogic = new ArrayLogic();

	private ArrayLogic() {
	}

	/**
	 * @return ArrayLogic arrayLogic
	 */
	public static ArrayLogic getArrayLogic() {
		return arrayLogic;
	}

	/**
	 * find equals from any two list. Use collections
	 * 
	 * @param <T>
	 * @param list1
	 * @param list2
	 * @return
	 */
	public <T> List<T> findEqalsFromTwoArrays(List<T> list1, List<T> list2) {
		LOG.debug("start findEqalsFromTwoArrays");
		Set<T> resultSet = new HashSet<T>();
		List<T> resultList = new ArrayList<T>();

		for (T temp : list1) {
			if (list2.contains(temp)) {
				resultSet.add(temp);
			}
		}
		resultList.addAll(resultSet);
		return resultList;
	}

	/**
	 * 
	 * @param List <Integer>
	 * @return int []
	 */
	public int[] fromListToArray(List<Integer> list) {
		LOG.debug("start fromListToArray");
		int[] mas = new int[list.size()];
		int i = 0;
		for (Integer temp : list) {
			mas[i] = temp;
			i++;
		}

		return mas;
	}

}
