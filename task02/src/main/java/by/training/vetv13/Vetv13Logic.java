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

	/**
	 * take two coordinates from txt
	 * 
	 * @param path
	 * @return CoordinateXY [2]
	 * @throws SearchDataInStrException
	 * @throws MyTxtReaderException
	 */
	private CoordinateXY[] takeCoordinatesFromTxt(String path) throws SearchDataInStrException, MyTxtReaderException {
		LOG.info("takeCoordinatesFromTxt started");
		MyTxtReader reader = MyTxtReader.getMyTxtReader();
		SearchDataInStr search = SearchDataInStr.getSearchDataInStr();

		double x1;
		double y1;
		double x2;
		double y2;
		CoordinateXY[] result = new CoordinateXY[2];

		try {
			LOG.debug("trying get coordinates");
			List<String> list = reader.readFile(path);
			x1 = search.searchDouble(list.get(0), "coordinate x1: ");
			y1 = search.searchDouble(list.get(1), "coordinate y1: ");
			result[0] = new CoordinateXY(x1, y1);

			LOG.debug("get first coordinate " + result[0].toString());
			x2 = search.searchDouble(list.get(2), "coordinate x2: ");
			y2 = search.searchDouble(list.get(3), "coordinate y2: ");
			result[1] = new CoordinateXY(x2, y2);
			LOG.debug("get second coordinate " + result[1].toString());

			return result;
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
			CoordinateXY[] coordinates = takeCoordinatesFromTxt(path);
			answer = temp.compareDistanceToBegining(coordinates[0], coordinates[1]);
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
				System.out.println("second coordinate is nearest to the begining");
			}
			if (result == -1) {
				System.out.println("first coordinate is nearest to the begining");
			}
			if (result == 0) {
				System.out.println("both coordinates have the same distance to the beginning");
			}
		} catch (SearchDataInStrException e) {
			LOG.error(e.getMessage());
			System.out.println(e.getMessage());
		} catch (CoordinateXYLogicException e) {
			LOG.error(e.getMessage());
			System.out.println(e.getMessage());
		} catch (MyTxtReaderException e) {
			LOG.error(e.getMessage());
			System.out.println(e.getMessage());

		}
	}
}
