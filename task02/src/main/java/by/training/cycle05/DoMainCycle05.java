package by.training.cycle05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * С помощью оператора while напишите программу определения суммы всех нечетных
 * чисел в диапазоне от 1 до 99 включительно.
 * 
 * @author AlexeySupruniuk
 *
 */
public class DoMainCycle05 {

	private static final Logger LOG = LogManager.getLogger(DoMainCycle05.class);

	public static void main(String[] args) {
		LOG.info ("start from main");
		int sum = 0;
		int i = 1;
		while (i <= 99) {
			if (i % 2 != 0) {
				sum += i;
			}
			i++;
		}

		System.out.println("sum of odd numbets from 1 to 99 is " + sum);
	}
}
