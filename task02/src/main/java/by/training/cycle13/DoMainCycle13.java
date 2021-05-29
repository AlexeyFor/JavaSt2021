package by.training.cycle13;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.service.ShowArray;

/**
 * Составить таблицу значений функции y = 5 - x^2/2 на отрезке [-5; 5] с шагом
 * 0.5.
 * 
 * @author AlexeySupruniuk
 *
 */
public class DoMainCycle13 {
	private static final Logger LOG = LogManager.getLogger(DoMainCycle13.class);

	public static void main(String[] args) {

		LOG.info("start from main");
		Cycle13Logic temp = new Cycle13Logic();
		ShowArray show = ShowArray.getShowArray();
		double[][] mas = temp.countFunctionOnInterval();
		show.showDoubleArray(mas);

	}
}
