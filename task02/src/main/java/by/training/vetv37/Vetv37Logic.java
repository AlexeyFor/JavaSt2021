package by.training.vetv37;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.util.MyTxtReader;
import by.training.util.SearchDataInStr;
import by.training.util.exception.MyTxtReaderException;
import by.training.util.exception.SearchDataInStrException;

/**
 * 
 * @author AlexeySupruniuk
 * @see DoMainVetv37
 */
public class Vetv37Logic {

	private static final Logger LOG = LogManager.getLogger(Vetv37Logic.class);

	/**
	 * get X frm txt file
	 * 
	 * @param path
	 * @return
	 * @throws SearchDataInStrException
	 * @throws MyTxtReaderException
	 */
	private double getXFromTxt(String path) throws SearchDataInStrException, MyTxtReaderException {
		LOG.info("getXFromTxt started");
		MyTxtReader reader = MyTxtReader.getMyTxtReader();
		SearchDataInStr search = SearchDataInStr.getSearchDataInStr();

		try {
			double x;
			LOG.debug("trying get x");
			List<String> list = reader.readFile(path);
			x = search.searchDouble(list.get(0), "x = ");
			return x;
		} catch (MyTxtReaderException e) {
			LOG.warn(e.getMessage());
			throw new MyTxtReaderException(e);
		} catch (SearchDataInStrException e) {
			LOG.warn(e.getMessage());
			throw new SearchDataInStrException(e);
		}
	}

	/**
	 * get path to the file with x and count the result of F(x)
	 * 
	 * @param path
	 * @return double result F(x)
	 * @throws SearchDataInStrException
	 * @throws MyTxtReaderException
	 */
	public double countXFromTxt(String path) throws SearchDataInStrException, MyTxtReaderException {
		LOG.info("countXFromTxt started");

		try {
			double x = getXFromTxt(path);
			LOG.debug("get x = " + x);
			double answer = countFunction(x);
			return answer;
		} catch (SearchDataInStrException e) {
			LOG.warn(e.getMessage());
			throw new SearchDataInStrException(e);
		} catch (MyTxtReaderException e) {
			LOG.warn(e.getMessage());
			throw new MyTxtReaderException(e);
		}

	}

	/**
	 * get path to the file with x and show the result of F(x)
	 * 
	 * @param path
	 */
	public void vetv37Action(String path) {
		LOG.info("vetv37Action started");
		try {
			double answer = countXFromTxt(path);
			System.out.println("F(x) = " + answer);
		} catch (SearchDataInStrException e) {
			LOG.warn(e.getMessage());
			System.out.println(e.getMessage());
		} catch (MyTxtReaderException e) {
			LOG.warn(e.getMessage());
			System.out.println(e.getMessage());
		}
	}

	/**
	 * count function depending on the x
	 * 
	 * @param x
	 * @return answer
	 */
	public double countFunction(double x) {
		LOG.info("countFunction started with x=  " + x);

		double answer;
		if (x >= 3) {
			answer = countFirstFunction(x);
		} else {
			answer = countSecondFunction(x);
		}
		LOG.debug("get answer " + answer);
		return answer;
	}

	private double countFirstFunction(double x) {
		LOG.debug("countFirstFunction started");
		double answer = -(x * x) + 3 * x + 9;
		return answer;
	}

	private double countSecondFunction(double x) {
		LOG.debug("countSecondFunction started");
		double answer = 1 / ((x * x * x) - 6);
		return answer;
	}

}
