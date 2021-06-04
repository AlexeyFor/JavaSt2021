package by.training.cycle13;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.service.IntervalLogic;

/**
 * 
 * @author AlexeySupruniuk
 *
 */
public class Cycle13Logic {

	private static final Logger LOG = LogManager.getLogger(Cycle13Logic.class);

	/**
	 * Count function from the task
	 * 
	 * @param x
	 * @return y
	 */
	public double calcFunction(double x) {
		LOG.debug("calculate function with x = " + x);
		double y;
		y = 5 - ((x * x) / 2);
		LOG.debug("get result y = " + y);

		return y;
	}

	/**
	 * calculate function on interval [-5;5] with step 0.5
	 * 
	 * @return List<double[]>, where [0] = x, and [1] = F(x).
	 */

	public List<double[]> countFunctionOnInterval() {

		LOG.info("start countFunctionOnInterval");

		IntervalLogic logic = IntervalLogic.getIntervalLogic();
		List<double[]> result = new ArrayList<double[]>();

		double intervalStart = -5;
		double intervalEnd = 5;
		double step = 0.5;
		double[] stepsForFunction = logic.getIntervalsStep(intervalStart, intervalEnd, step);

		for (double temp : stepsForFunction) {
			result.add(new double[] { temp, calcFunction(temp) });
		}
		return result;
	}

}
