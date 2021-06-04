package by.training.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Methods for displaying arrays
 * 
 * @author AlexeySupruniuk
 *
 */
public class ShowArray {

	private static final Logger LOG = LogManager.getLogger(ShowArray.class);

	private static final ShowArray showArray = new ShowArray();

	private ShowArray() {
	}

	/**
	 * @return ShowArray showArray
	 */
	public static ShowArray getShowArray() {
		return showArray;
	}

	/**
	 * show double [] []
	 * 
	 * @param mas [] []
	 */
	public void showDoubleArray(double mas[][]) {
		LOG.debug("start showDoubleArray");

		for (int i = 0; i < mas.length; i++) {
			System.out.println("");
			for (int j = 0; j < mas[i].length; j++) {
				System.out.print(String.format("%.2f   ", mas[i][j]));
			}
		}
	}

	/**
	 * show array int []
	 * 
	 * @param mas
	 */
	public void showArray(int[] mas) {
		LOG.debug("start showArray");

		for (int temp : mas) {
			System.out.print(temp + "   ");
		}

	}
}
