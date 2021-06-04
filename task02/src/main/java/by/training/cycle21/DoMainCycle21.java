package by.training.cycle21;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Составить программу для вычисления значений функции F(x) на отрезке [а, b] с
 * шагом h. Результат представить в виде таблицы, первый столбец которой –
 * значения аргумента, второй - соответствующие значения функции:
 * 
 * @author AlexeySupruniuk
 *
 */
public class DoMainCycle21 {
	private static final Logger LOG = LogManager.getLogger(DoMainCycle21.class);

	public static void main(String[] args) {

		LOG.info("start from main");

		String path = System.getProperty("user.dir") + "//src//main//java//by//training//cycle21//Cycle21.txt";
		Cycle21Logic logic = new Cycle21Logic();
		logic.execute(path);
	}
}
