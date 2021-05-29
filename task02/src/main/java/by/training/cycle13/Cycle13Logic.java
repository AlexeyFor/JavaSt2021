package by.training.cycle13;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author AlexeySupruniuk
 *
 */
public class Cycle13Logic {

	private static final Logger LOG = LogManager.getLogger(Cycle13Logic.class);

	/**
	 * 
	 * @param x
	 * @return y
	 */
	public double countFunction(double x) {
		double y;
		y = 5 - ((x * x) / 2);
		return y;
	}

	/**
	 * count function on interval [-5;5] with step 0.5
	 * 
	 * @return double [2] [] where double [0] - x, and where double [1] - y
	 */
	public double[][] countFunctionOnInterval() {
		LOG.info("start countFunctionOnInterval");
		double intervalStart = -5;
		double intervalEnd = 5;
		double step = 0.5;
		int lengthOfMas = (int) (((intervalEnd - intervalStart) / step) + 1);
		double[] masY = new double[lengthOfMas];
		double[] masX = new double[lengthOfMas];
		int i = 0;
		double[][] result = new double[2][];

		for (double x = intervalStart; x <= intervalEnd; x += step) {
			masX[i] = x;
			masY[i] = countFunction(x);
			LOG.debug("x = " + masX[i] + "  y = " + masY[i]);
			i++;
		}

		result[0] = masX;
		result[1] = masY;

		return result;
	}

}
