package by.training.vetv29;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.CoordinateXY;

/**
 * 
 * Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они
 * расположены на одной прямой.
 * 
 * @author AlexeySupruniuk
 * @see Vetv29Logic
 * @see CoordinateXY
 * @see CoordinateXYLogic
 *
 */
public class DoMainVetv29 {

	private static final Logger LOG = LogManager.getLogger(DoMainVetv29.class);

	public static void main(String[] args) {
		LOG.info("start from main ");
		String path = System.getProperty("user.dir") + "//src//main//java//by//training//vetv29//vetv29.txt";
		Vetv29Logic temp = new Vetv29Logic();
		temp.execute(path);
	}
}
