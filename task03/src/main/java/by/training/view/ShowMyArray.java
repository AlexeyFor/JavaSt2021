package by.training.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.MyArray;

/**
 * Methods for displaying MyArray<>
 * 
 * @author AlexeySupruniuk
 *
 */
public class ShowMyArray {

	private static final Logger LOG = LogManager.getLogger(ShowMyArray.class);

	private static ShowMyArray instance = new ShowMyArray();

	private ShowMyArray() {
	}

	public static ShowMyArray getInstance() {
		return instance;
	}

	/**
	 * show Myarray, where quantityPerLine is number of elements in one line
	 * 
	 * @param array
	 * @param quantityPerLine
	 */
	public void showMyArrayInRow(MyArray<?> array, int quantityPerLine) {
		LOG.debug("start showMyArrayInRow");
		for (int i = 0; i < array.getLength(); i++) {
			for (int p = 0; (p < quantityPerLine) && (i < array.getLength()); i++, p++) {
				System.out.print(array.getValue(i).toString() + " ");
			}
			System.out.println();
		}
	}
}
