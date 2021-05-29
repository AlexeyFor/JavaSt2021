package by.training.service;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.CoordinateXY;

/**
 * 
 * All logic for CoordinateXY
 * 
 * @author AlexeySupruniuk
 * 
 *
 */
public class CoordinateXYLogic {

	private static final Logger LOG = LogManager.getLogger(CoordinateXYLogic.class);

	private static final CoordinateXYLogic coordinateXYLogic = new CoordinateXYLogic();

	private CoordinateXYLogic() {
	}

	/**
	 * @return CoordinateXYLogic coordinateXYLogic
	 */
	public static CoordinateXYLogic getCoordinateXYLogic() {
		return coordinateXYLogic;
	}

	/**
	 * Count distance from coordinate (0;0)
	 * 
	 * @param coordinate
	 * @return double distance
	 */
	public double distanceFromCenter(CoordinateXY coordinate) {
		LOG.debug("start distanceFromCenter");
		double distance;
		double x = coordinate.getX();
		double y = coordinate.getY();
		LOG.debug(String.format("start cound distance with x = %s, y = %s", x, y));

		distance = Math.sqrt((x * x + y * y));
		LOG.debug("distance = " + distance);
		return distance;
	}

	/**
	 * compare distance to the begining of coordinates (0;0)
	 * 
	 * @param CoordinateXY
	 * @param CoordinateXY
	 * @return int answer ( a > b ->1, a < b -> -1, a = b -> 0)
	 * @throws CoordinateXYLogicException
	 */
	public int compareDistanceToBegining(CoordinateXY coordinate1, CoordinateXY coordinate2)
			throws CoordinateXYLogicException {
		LOG.debug(String.format("start compare distance with coordinate1 = %s, coordinate2 = %s ", coordinate1,
				coordinate2));
		double distance1 = distanceFromCenter(coordinate1);
		double distance2 = distanceFromCenter(coordinate2);
		int result;

		if (distance1 > distance2) {
			result = 1;
			// second coordinate is closer
		} else if (distance1 < distance2) {
			result = -1;
			// first coordinate is closer
		} else if (distance1 == distance2) {
			result = 0;
		} else {
			LOG.warn("can't compare distance, wrong data");
			throw new CoordinateXYLogicException("can't compare distance, wrong data");
		}

		LOG.debug("get result " + result);
		return result;
	}

	/**
	 * if (x3 - x1)/(x2 - x1) == (y3 - y1)/(y2 - y1) - points are on one line
	 * 
	 * @param coord1
	 * @param coord2
	 * @param coord3
	 * @return boolean answer
	 */
	public boolean threePointsOnLine(CoordinateXY coord1, CoordinateXY coord2, CoordinateXY coord3) {
		LOG.debug(String.format("start threePointsOnLine with coordinate1 = %s, coordinate2 = %s , coordinate3 = %s",
				coord1, coord2, coord3));
		double x1 = coord1.getX();
		double y1 = coord1.getY();
		double x2 = coord2.getX();
		double y2 = coord2.getY();
		double x3 = coord3.getX();
		double y3 = coord3.getY();

		boolean straightLineConditionX = (x1 == x2) && (x2 == x3) && (x1 == x3);
		boolean straightLineConditionY = (y1 == y2) && (y2 == y3) && (y1 == y3);

		if (straightLineConditionX || straightLineConditionY) {
			return true;
		}

		try {
			BigDecimal forX = countForThreePointsOnLine(x1, x2, x3);
			LOG.debug("count defenition for x " + forX);
			BigDecimal forY = countForThreePointsOnLine(y1, y2, y3);
			LOG.debug("count defenition for y " + forY);
			if (forX.compareTo(forY) == 0) {
				return true;
			} else {
				return false;
			}
		} catch (NumberFormatException e) {
			LOG.warn(e.getMessage());
			return false;
		}
	}

	private BigDecimal countForThreePointsOnLine(double x1, double x2, double x3) {
		double result;
		BigDecimal answer;
		result = (x3 - x1) / (x2 - x1);
		LOG.debug("count result in fouble from  countForThreePointsOnLine " + result);
		answer = new BigDecimal(result);
		return answer;
	}

}
