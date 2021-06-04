package by.training.cycle13;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

		List<double[]> mas = temp.countFunctionOnInterval();
		mas.forEach(x -> System.out.println(x[0] + "    " + x[1]));
	}
}
