package by.training.vetv13;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.CoordinateXY;
import by.training.service.CoordinateXYLogic;
import by.training.service.CoordinateXYLogicException;
import by.training.util.MyTxtReader;
import by.training.util.SearchDataInStr;
import by.training.util.exception.MyTxtReaderException;
import by.training.util.exception.SearchDataInStrException;

/**
 * 
 * @author AlexeySupruniuk compare distance to the beginning of coordinate, of
 *         two coordinates from .txt
 */
public class Vetv13Logic {

	private static final Logger LOG = LogManager.getLogger(Vetv13Logic.class);

	private CoordinateXY coordinate1;
	private CoordinateXY coordinate2;

	private void getCoordinatesFromTxt(String path) throws SearchDataInStrException, MyTxtReaderException {
		LOG.info("getCoordinatesFromTxt started");
		MyTxtReader reader = MyTxtReader.getMyTxtReader();
		SearchDataInStr search = SearchDataInStr.getSearchDataInStr();

		double x1;
		double y1;
		double x2;
		double y2;

		try {
			LOG.debug("trying get coordinates");
			List<String> list = reader.readFile(path);
			x1 = search.searchDouble(list.get(0), "coordinate x1: ");
			y1 = search.searchDouble(list.get(1), "coordinate y1: ");
			x2 = search.searchDouble(list.get(2), "coordinate x2: ");
			y2 = search.searchDouble(list.get(3), "coordinate y2: ");
			this.coordinate1 = new CoordinateXY(x1, y1);
			this.coordinate2 = new CoordinateXY(x2, y2);

		} catch (MyTxtReaderException e) {
			throw new MyTxtReaderException(e);
		} catch (SearchDataInStrException e) {
			throw new SearchDataInStrException(e);
		}
	}

	/**
	 * 
	 * @param path
	 * @return ( coordinate1 > coordinate2 ->1, coordinate1 < coordinate2 -> -1,
	 *         coordinate1 = coordinate2 -> 0)
	 * @throws SearchDataInStrException
	 * @throws CoordinateXYLogicException
	 * @throws MyTxtReaderException
	 */
	public int compareDistToBeginFromTxt(String path)
			throws SearchDataInStrException, CoordinateXYLogicException, MyTxtReaderException {
		LOG.info("compareDistToBeginFromTxt started");
		CoordinateXYLogic temp = CoordinateXYLogic.getCoordinateXYLogic();

		try {
			int answer;
			getCoordinatesFromTxt(path);
			answer = temp.compareDistanceToBegining(this.coordinate1, this.coordinate2);
			LOG.debug("get answer " + answer);
			return answer;
		} catch (SearchDataInStrException e) {
			LOG.error(e.getMessage());
			throw new SearchDataInStrException(e);
		} catch (CoordinateXYLogicException e) {
			LOG.error(e.getMessage());
			throw new CoordinateXYLogicException(e);
		} catch (MyTxtReaderException e) {
			LOG.error(e.getMessage());
			throw new MyTxtReaderException(e);
		}
	}

	/**
	 * shows the coordinate closest to the beginning
	 * 
	 * @param path
	 */
	public void showNearestCoordinate(String path) {
		LOG.info("showNearestCoordinate started");

		try {
			int result = compareDistToBeginFromTxt(path);
			if (result == 1) {
				System.out.println("nearest coordinate is " + this.coordinate2);
			}
			if (result == -1) {
				System.out.println("nearest coordinate is " + this.coordinate1);
			}
			if (result == 0) {
				System.out.println("both coordinates have the same distance to the beginning");
			}
		} catch (SearchDataInStrException e) {
			System.out.println(e.getMessage());
		} catch (CoordinateXYLogicException e) {
			System.out.println(e.getMessage());
		} catch (MyTxtReaderException e) {
			System.out.println(e.getMessage());

		}
	}
}
