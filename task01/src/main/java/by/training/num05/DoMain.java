package by.training.num05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * составить алгоритм нахождения среднего арефметического двух чисел
 * 
 * @author AlexeySupruniuk
 * @see Num05Logic
 */
public class DoMain {

	private static final Logger LOG = LogManager.getLogger(DoMain.class);

	public static void main(String[] args) {

		LOG.info("start from main");
		Num05Logic act = new Num05Logic();
		act.num05Action();

	}
}