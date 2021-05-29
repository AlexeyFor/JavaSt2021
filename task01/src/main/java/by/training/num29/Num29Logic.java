package by.training.num29;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.util.MyScan;
import by.training.util.MyScanException;

/**
 * logic for task01.num29
 * 
 * @author AlexeySupruniuk
 * @see by.training.util.MyScan
 */
public class Num29Logic {

	private static final Logger LOG = LogManager.getLogger(Num29Logic.class);

	/**
	 * main method
	 */
	public void num29Action() {
		LOG.info("main method started");
		double[] sides;
		double[] angles;
		double[] anglesDeg;

		try {
			sides = getSides();
			LOG.debug("get sides from scan");
			if (checkSides(sides)) {
				LOG.debug("check sides");
				angles = findTriangleAngles(sides);
				anglesDeg = fromRadInDeg(angles);
				System.out.println("Angles of triangle in radians: " + angles[0] + " " + angles[1] + " " + angles[2]);
				System.out.println(
						"Angles of triangle in degrees: " + anglesDeg[0] + " " + anglesDeg[1] + " " + anglesDeg[2]);
			} else {
				System.out.println("entered wrong data");
				LOG.error("entered wrong data from main method");
			}
		} catch (MyScanException e) {
			System.out.println(e.getMessage());
			LOG.error(e.getMessage() + "from main method");
		}

	}

	/**
	 * return sides of the triangle as double[]
	 * 
	 * @return double[]
	 * @throws MyScanException
	 */
	public double[] getSides() throws MyScanException {
		LOG.info("get sides from console");

		double[] sides = new double[3];

		MyScan scan = MyScan.getMyScan();

		try {
			System.out.println("enter number for first side");
			sides[0] = scan.getNum();
			LOG.debug("get first side " + sides[0]);
		} catch (MyScanException e) {
			LOG.error(e.getMessage() + "from getSides");
			throw new MyScanException("wrong first side");
		}

		try {
			System.out.println("enter number for second side");
			sides[1] = scan.getNum();
			LOG.debug("get second side " + sides[1]);
		} catch (MyScanException e) {
			LOG.error(e.getMessage() + "from getSides");
			throw new MyScanException("wrong second side");
		}

		try {
			System.out.println("enter number for third side");
			sides[2] = scan.getNum();
			LOG.debug("get third side " + sides[2]);
		} catch (MyScanException e) {
			LOG.error(e.getMessage() + "from getSides");
			throw new MyScanException("wrong third side");
		}

		return sides;
	}

	/**
	 * find angles of triangle by three sides
	 * 
	 * @param sides
	 * @return
	 */
	private double[] findTriangleAngles(double[] sides) {
		LOG.debug("find angles of triangle");

		double sideA = sides[0];
		double sideB = sides[1];
		double sideC = sides[2];

		double mas[] = new double[3];

		mas[0] = findAngle(sideA, sideB, sideC);
		mas[1] = findAngle(sideB, sideA, sideC);
		mas[2] = findAngle(sideC, sideB, sideA);

		return mas;
	}

	/**
	 * found angle by three sides
	 * 
	 * @param sought
	 * @param side1
	 * @param side2
	 * @return double
	 */
	public double findAngle(double sought, double side1, double side2) {
		double angle;
		double temp;

		temp = ((side1 * side1 + side2 * side2 - sought * sought) / (2 * side1 * side2));
		angle = Math.acos(temp);

		return angle;
	}

	/**
	 * check triangle sides
	 * 
	 * @param sides
	 * @return boolean
	 */
	private boolean checkSides(double[] sides) {
		LOG.debug("check triangle sides");

		if (checkSidesForZeroAndLess(sides) && checkSidesMax(sides)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * check sides for zero and less
	 * 
	 * @param sides
	 * @return boolean
	 */
	private boolean checkSidesForZeroAndLess(double[] sides) {
		LOG.debug("check triangle sides for zero and less");

		for (int i = 0; i < sides.length; i++) {
			if (sides[i] <= 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * check max side of triangle
	 * 
	 * @param sides
	 * @return boolean
	 */
	private boolean checkSidesMax(double[] sides) {
		LOG.debug("check max side of triangle");

		if ((sides[0] + sides[1]) <= sides[2]) {
			return false;
		}
		if ((sides[0] + sides[2]) <= sides[1]) {
			return false;
		}
		if ((sides[1] + sides[2]) <= sides[0]) {
			return false;
		}
		return true;
	}

	/**
	 * convert mas of angles in radians into mas of angles in degrees
	 * 
	 * @param double []
	 * @return double []
	 */
	private double[] fromRadInDeg(double[] mas) {
		LOG.debug("convert mas of angles in radians into mas of angles in degrees");

		double[] masDeg = new double[mas.length];

		for (int i = 0; i < mas.length; i++) {
			masDeg[i] = mas[i] * (180 / Math.PI);
		}

		return masDeg;
	}
}
