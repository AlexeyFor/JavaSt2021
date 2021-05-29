package by.training.cycle29;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Даны два числа. Определить цифры, входящие в запись как первого так и второго
 * числа.
 * 
 * @author AlexeySupruniuk
 * @see Cycle29Logic
 *
 */
public class DoMainCycle29 {
	private static final Logger LOG = LogManager.getLogger(DoMainCycle29.class);

	public static void main(String[] args) {

		String path = System.getProperty("user.dir") + "//src//main//java//by//training//cycle29//Cycle29.txt";
		Cycle29Logic logic = new Cycle29Logic();
		logic.showCycle29Action(path);

	}
}
