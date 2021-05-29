package by.training.num13;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.util.MyScan;
import by.training.util.MyScanException;

/**
 * logic for task01.num13
 * 
 * @author AlexeySupruniuk
 * @see by.training.util.MyScan
 */
public class Num13Logic {

	private static final Logger LOG = LogManager.getLogger(Num13Logic.class);

	/**
	 * main method, displays perimeter and square of triangle. Triangle coordinates
	 * are entered from console.
	 */
	public void num13Action() {
		LOG.info("main method started");
		double[] sizes;
		double[][] coordinates;
		double perimeter;
		double square;

		try {
			coordinates = getSizeCoordinates();
			LOG.debug("get coordinates from scan");
			sizes = countSizes(coordinates);
			LOG.debug("get sizes");
			perimeter = countPerimeter(sizes);
			LOG.debug("count perimeter" + perimeter);
			square = countSquare(sizes, perimeter);
			LOG.debug("count square" + square);

			System.out.println("perimeter = " + perimeter);
			System.out.println("square = " + square);

		} catch (MyScanException e) {
			LOG.error(e.getMessage() + "from main method");
			System.out.println(e.getMessage());
		}

	}

	/**
	 * return coordinates of the triangle as double[][]
	 * 
	 * @return double [] []
	 * @throws MyScanException
	 */
	public double[][] getSizeCoordinates() throws MyScanException {
		LOG.info("get coordinates from console");

		double[][] result = new double[3][2];

		MyScan scan = MyScan.getMyScan();

		try {
			System.out.println("enter two numbers (coordinates) for first point separated by space");
			result[0] = scan.getTwoNum();
			LOG.debug("get first coordinate " + result[0][0] + " " + result[0][1]);
		} catch (MyScanException e) {
			LOG.error(e.getMessage() + "from getSizeCoordinates");
			throw new MyScanException("wrong first coordinate");
		}

		try {
			System.out.println("enter two numbers (coordinates) for second point separated by space");
			result[1] = scan.getTwoNum();
			LOG.debug("get second coordinate" + result[1][0] + " " + result[1][1]);
		} catch (MyScanException e) {
			LOG.error(e.getMessage() + "from getSizeCoordinates");
			throw new MyScanException("wrong second coordinate");
		}

		try {
			System.out.println("enter two numbers (coordinates) for third point separated by space");
			result[2] = scan.getTwoNum();
			LOG.debug("get third coordinate" + result[2][0] + " " + result[2][1]);
		} catch (MyScanException e) {
			LOG.error(e.getMessage() + "from getSizeCoordinates");
			throw new MyScanException("wrong third coordinate");
		}

		if (checkDoubleMasMasForEqals(result) == false) {
			LOG.error("wrong, eqals coordinates " + "from getSizeCoordinates");
			throw new MyScanException("wrong, eqals coordinates");
		}

		return result;
	}

	/**
	 * count sizes length from theirs coordinates
	 * 
	 * @param mas
	 * @return double[]
	 */
	public double[] countSizes(double[][] mas) {
		LOG.info("count sizes");
		double[] result = new double[3];

		result[0] = countSizeLength(mas[0], mas[1]);
		result[1] = countSizeLength(mas[0], mas[2]);
		result[2] = countSizeLength(mas[1], mas[2]);
		LOG.debug("get sizes length" + result[0] + " " + result[1] + " " + result[2]);

		return result;
	}

	/**
	 * count distance between two points
	 * 
	 * @param firstCoordinate
	 * @param secondCoordinate
	 * @return double
	 */
	public double countSizeLength(double[] firstCoordinate, double[] secondCoordinate) {

		double x1 = firstCoordinate[0];
		double y1 = firstCoordinate[1];
		double x2 = secondCoordinate[0];
		double y2 = secondCoordinate[1];
		double temp;

		temp = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);

		double length = Math.sqrt(temp);

		return length;
	}

	/**
	 * count perimeter
	 * 
	 * @param sizes
	 * @return double
	 */
	public double countPerimeter(double[] sizes) {
		LOG.info("count perimeter");
		double perimeter;
		perimeter = sizes[0] + sizes[1] + sizes[2];

		return perimeter;
	}

	/**
	 * count square from sizes length and perimeter
	 * 
	 * @param double[] sizes
	 * @param double   perimeter
	 * @return double
	 */
	public double countSquare(double[] sizes, double perimeter) {
		LOG.info("count sqare");
		double square;
		// halfPerimeter
		double halfP = perimeter / 2;
		double sizeA = sizes[0];
		double sizeB = sizes[1];
		double sizeC = sizes[2];
		double temp;

		temp = halfP * (halfP - sizeA) * (halfP - sizeB) * (halfP - sizeC);

		square = Math.sqrt(temp);
		return square;

	}

	private boolean checkDoubleMasMasForEqals(double[][] mas) {

		if (checkTwoMasForEqals(mas[0], mas[1]) == false) {
			return false;
		}
		if (checkTwoMasForEqals(mas[0], mas[2]) == false) {
			return false;
		}
		if (checkTwoMasForEqals(mas[1], mas[2]) == false) {
			return false;
		}
		return true;
	}

	private boolean checkTwoMasForEqals(double[] mas1, double[] mas2) {

		if ((mas1[0] == mas2[0]) && (mas1[1] == mas2[1])) {
			return false;
		} else {
			return true;
		}
	}
}
