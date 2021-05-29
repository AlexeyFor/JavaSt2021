package by.training.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * methods for any interval
 * 
 * @author AlexeySupruniuk
 *
 */
public class IntervalLogic {

	private static final Logger LOG = LogManager.getLogger(IntervalLogic.class);

	private static final IntervalLogic intervalLogic = new IntervalLogic();

	private IntervalLogic() {
	}

	/**
	 * @return IntervalLogic intervalLogic
	 */
	public static IntervalLogic getIntervalLogic() {
		return intervalLogic;
	}

	/**
	 * check parametrs of interval and step main conditions - startA < endB;
	 * endB-startA >= stepH; (endB-startA) % stepH == 0; has an inaccuracy due to
	 * use double
	 * 
	 * 
	 * @param startA
	 * @param endB
	 * @param stepH
	 * @return
	 */
	public boolean checkIntervalStep(double startA, double endB, double stepH) {
		LOG.debug("start checkIntervalStep");
		double endMinusStart = endB - startA;

		if (startA >= endB) {
			LOG.debug("checkIntervalStep return false from startA <= endB");
			return false;
		}
		if (endMinusStart < stepH) {
			LOG.debug("checkIntervalStep return false from endB - startA < stepH");
			return false;
		}
		if (((endMinusStart) % stepH) > 0.00000000000001) {
			double temp = (endB - startA) % stepH;
			LOG.debug("checkIntervalStep return false from (endB - startA)% stepH with " + temp);
			return false;
		}

		LOG.debug("checkIntervalStep return true");
		return true;
	}

	/**
	 * return all of interval has an inaccuracy due to use double if parameters are
	 * wrong return empty array
	 * 
	 * @param startA
	 * @param endB
	 * @param stepH
	 * @return
	 */
	public double[] getIntervalsStep(double startA, double endB, double stepH) {
		LOG.debug(String.format("start getIntervalsStep with startA + %s, endB + %s, stepH + %s", startA, endB, stepH));

		double[] result = {};

		if (checkIntervalStep(startA, endB, stepH)) {
			int lengthOfMas = (int) Math.round(((endB - startA) / stepH) + 1);
			double[] temp = new double[lengthOfMas];

			for (int i = 0; i < lengthOfMas - 1; i++) {
				temp[i] = startA + stepH * i;
			}
			temp[lengthOfMas - 1] = endB;
			result = temp;
		}
		return result;
	}

}
