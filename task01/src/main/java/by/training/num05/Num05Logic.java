package by.training.num05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.training.util.MyScan;
import by.training.util.MyScanException;

/**
 * logic for task01.num05
 * 
 * @author AlexeySupruniuk
 * @see by.training.util.MyScan
 */

public class Num05Logic {

	private static final Logger LOG = LogManager.getLogger(Num05Logic.class);

	/**
	 * main method displays the average obtained from two numbers entered from the
	 * console
	 */
	public void num05Action() {
		LOG.info("main method started");

		System.out.println("enter two numbers separated by space");
		try {
			LOG.debug("trying get average");
			double res = getAverage();
			System.out.println("the average number is " + res);
		} catch (MyScanException e) {
			LOG.warn(e.getMessage() + " from num05Action");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * get two num from scan and count average from them
	 * 
	 * @return double average
	 * @throws MyScanException
	 */
	public double getAverage() throws MyScanException {
		LOG.debug("start getAverage()");
		MyScan scan = MyScan.getMyScan();
		double[] mas;
		double result;

		mas = scan.getTwoNum();
		LOG.debug("get two numbers " + mas[0] + " and " + mas[1]);
		result = countAverage(mas[0], mas[1]);
		LOG.debug("get average, result is " + result);
		return result;
	}

	/**
	 * count average from two double (a, b)
	 * 
	 * @param a
	 * @param b
	 * @return double average
	 */
	public double countAverage(double a, double b) {
		double result;
		LOG.debug("start countAverage with " + a + " " + b);
		result = (a + b) / 2;
		return result;
	}
}
