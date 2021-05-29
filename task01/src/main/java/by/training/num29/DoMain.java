package by.training.num29;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Найти (в радианах, в градусах) всe углы треугольника со сторонами a, b, c
 * 
 * @author AlexeySupruniuk
 * @see Num29Logic
 *
 */
public class DoMain {

	private static final Logger LOG = LogManager.getLogger(DoMain.class);

	public static void main(String[] args) {

		LOG.info("start from main");
		Num29Logic act = new Num29Logic();
		act.num29Action();
	}
}
