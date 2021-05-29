package by.training.num21;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.num13.Num13Logic;

/**
 * Дано действительное число R вида nnn.ddd, поменять местами дробную и целую
 * части числа, ввести полученное значение
 * 
 * @author AlexeySupruniuk
 * @see Num13Logic
 *
 */
public class DoMain {

	private static final Logger LOG = LogManager.getLogger(DoMain.class);

	public static void main(String[] args) {

		LOG.info("start from main");
		Num21Logic act = new Num21Logic();
		act.num21Action();

	}
}
