package by.training.vetv29;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.CoordinateXY;
import by.training.service.CoordinateXYLogic;
import by.training.util.MyTxtReader;
import by.training.util.SearchDataInStr;
import by.training.util.exception.MyTxtReaderException;
import by.training.util.exception.SearchDataInStrException;

/**
 * 
 * @author AlexeySupruniuk
 * @see CoordinateXYLogic
 *
 */
public class Vetv29Logic {

	private static final Logger LOG = LogManager.getLogger(Vetv29Logic.class);

	private CoordinateXY[] getCoordinatesFromTxt(String path) throws SearchDataInStrException, MyTxtReaderException {
		LOG.info("getCoordinatesFromTxt started");
		MyTxtReader reader = MyTxtReader.getMyTxtReader();
		SearchDataInStr search = SearchDataInStr.getSearchDataInStr();

		double x1;
		double y1;
		double x2;
		double y2;
		double x3;
		double y3;

		try {
			LOG.debug("trying get coordinates");
			List<String> list = reader.readFile(path);
			x1 = search.searchDouble(list.get(0), "coordinate x1: ");
			y1 = search.searchDouble(list.get(1), "coordinate y1: ");
			x2 = search.searchDouble(list.get(2), "coordinate x2: ");
			y2 = search.searchDouble(list.get(3), "coordinate y2: ");
			x3 = search.searchDouble(list.get(4), "coordinate x3: ");
			y3 = search.searchDouble(list.get(5), "coordinate y3: ");

			CoordinateXY[] mas = { new CoordinateXY(x1, y1), new CoordinateXY(x2, y2), new CoordinateXY(x3, y3) };
			return mas;

		} catch (MyTxtReaderException e) {
			throw new MyTxtReaderException(e);
		} catch (SearchDataInStrException e) {
			throw new SearchDataInStrException(e);
		}
	}

	/**
	 * check, if three points from txt file are on one line
	 * 
	 * @param path
	 * @return
	 * @throws MyTxtReaderException
	 * @throws SearchDataInStrException
	 */
	public boolean checkThreePointsOnLineFromTxt(String path) throws MyTxtReaderException, SearchDataInStrException {
		LOG.info("checkThreePointsOnLineFromTxt started");

		CoordinateXY[] mas;
		try {
			mas = getCoordinatesFromTxt(path);
			CoordinateXYLogic temp = CoordinateXYLogic.getCoordinateXYLogic();
			boolean answer = temp.threePointsOnLine(mas[0], mas[1], mas[2]);
			LOG.debug("get answer " + answer);
			return answer;
		} catch (MyTxtReaderException e) {
			LOG.warn(e.getMessage());
			throw new MyTxtReaderException(e);
		} catch (SearchDataInStrException e) {
			LOG.warn(e.getMessage());
			throw new SearchDataInStrException(e);
		}
	}

	/**
	 * main action for vetv29
	 * 
	 * @param path
	 */
	public void vetv29Action(String path) {

		try {
			boolean answer;
			answer = checkThreePointsOnLineFromTxt(path);
			if (answer) {
				System.out.println("three points are on one line");
			} else {
				System.out.println("three points are not on one line");
			}
		} catch (MyTxtReaderException e) {
			System.out.println("Wrong path");
		} catch (SearchDataInStrException e) {
			System.out.println("Wrong parameters");

		}
	}

}
