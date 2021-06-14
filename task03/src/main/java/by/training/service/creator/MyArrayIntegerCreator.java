package by.training.service.creator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.MyArray;

/**
 * Logics for creation MyArray <Integer>
 * 
 * @author AlexeySupruniuk
 *
 */
public class MyArrayIntegerCreator {

	private static final Logger LOG = LogManager.getLogger(MyArrayIntegerCreator.class);

	/**
	 * Create and return MyArray <Integer> with given length and random numbers from
	 * min to max
	 * 
	 * @param length
	 * @param min
	 * @param max
	 * @return
	 * @throws CreatorException
	 */
	public MyArray<Integer> createRandomMA(int length, int min, int max) throws CreatorException {
		LOG.debug(String.format("start createRandomMA with length %s, min %s, max %s", length, min, max));

		if ((max < min) || (length < 1)) {
			LOG.warn("from createRandomMA, wring data ");
			throw new CreatorException("wrong parametres");
		}
		Integer[] array = new Integer[length];

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * (max - min) + min);
		}
		MyArray<Integer> result = new MyArray<Integer>(array);
		LOG.debug("return MyArray");
		return result;
	}

	/**
	 * Create and return MyArray <Integer>
	 * 
	 * @param array
	 * @return MyArray<Integer>
	 * @throws CreatorException
	 */
	public MyArray<Integer> createMA(Integer[] array) throws CreatorException {
		LOG.debug("start createMA");

		if (array.length == 0) {
			LOG.warn("from createMA, wrong array length ");
			throw new CreatorException("wrong_parametres");
		}

		for (int i = 0; i < array.length; i++) {
			if ((array[i] == null)) {
				LOG.warn("null in array");
				throw new CreatorException("null in array");
			}
		}
		MyArray<Integer> result = new MyArray<Integer>(array);
		LOG.debug("return MyArray");
		return result;
	}

	/**
	 * Create and return MyArray <Integer>, filled with one number
	 * 
	 * @param length
	 * @param number
	 * @return MyArray<Integer>
	 * @throws CreatorException
	 */
	public MyArray<Integer> createOneNumMA(int length, int number) throws CreatorException {
		LOG.debug("start createOneNumMA with length " + length + " number " + number);

		if ((length < 1)) {
			LOG.warn("from createOneNumMA, wrong data ");
			throw new CreatorException("wrong parametres");
		}
		Integer[] array = new Integer[length];

		for (int i = 0; i < array.length; i++) {
			array[i] = number;
		}
		MyArray<Integer> result = new MyArray<Integer>(array);
		LOG.debug("return MyArray");
		return result;
	}

}
