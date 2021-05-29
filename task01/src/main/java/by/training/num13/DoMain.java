package by.training.num13;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Заданы координаты трех вершин треугольника (x1, y1), (x2, y2) (x3, y3) найти
 * его периметр и площадь.
 * 
 * @author AlexeySupruniuk
 * @see Num13Logic
 *
 */
public class DoMain {

	private static final Logger LOG = LogManager.getLogger(DoMain.class);

	public static void main(String[] args) {

		LOG.info("start from main");
		Num13Logic act = new Num13Logic();
		act.num13Action();

	}
}
