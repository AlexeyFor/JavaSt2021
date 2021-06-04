package by.training.vetv05;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.util.MyTxtReader;
import by.training.util.SearchDataInStr;
import by.training.util.exception.MyTxtReaderException;
import by.training.util.exception.SearchDataInStrException;

/**
 * Compare two double (from a file)
 * 
 * @author AlexeySupruniuk
 *
 */
public class Vetv05Logic {

	private static final Logger LOG = LogManager.getLogger(Vetv05Logic.class);

	private double[] takeNumbersFromTxt(String path) throws SearchDataInStrException, MyTxtReaderException {
		LOG.info("takeNumbersFromTxt started");
		MyTxtReader reader = MyTxtReader.getMyTxtReader();
		SearchDataInStr search = SearchDataInStr.getSearchDataInStr();
		double[] result = new double[2];

		try {
			LOG.debug("trying get numbers");
			List<String> list = reader.readFile(path);
			result[0] = search.searchDouble(list.get(0), "number a: ");
			result[1] = search.searchDouble(list.get(1), "number b: ");
			return result;
		} catch (MyTxtReaderException e) {
			throw new MyTxtReaderException(e);
		} catch (SearchDataInStrException e) {
			throw new SearchDataInStrException(e);
		}
	}

	/**
	 * compare two num from txt
	 * 
	 * @param path (way to the file with numbers)
	 * @return answer ( a > b ->1, a < b -> -1, a = b -> 0, smth wrong -> 2)
	 * @throws MyTxtReaderException
	 * @throws SearchDataInStrException
	 */
	public int compareNumFromTxt(String path) throws MyTxtReaderException, SearchDataInStrException {
		LOG.info("compareNumFromTxt started");
		try {
			double[] nums = takeNumbersFromTxt(path);
			int answer = compareTwoNum(nums[0], nums[1]);
			LOG.debug("get answer " + answer);
			return answer;
		} catch (MyTxtReaderException e) {
			LOG.error(e.getMessage());
			throw new MyTxtReaderException("wrong path to the file");
		} catch (SearchDataInStrException e) {
			LOG.error(e.getMessage());
			throw new SearchDataInStrException("wrong data");
		}

	}

	/**
	 * compare two double
	 * 
	 * @param first
	 * @param second
	 * @return answer ( a > b ->1, a < b -> -1, a = b -> 0)
	 */
	public int compareTwoNum(double first, double second) {
		LOG.info("compareTwoNum started");
		int result;

		if (first > second) {
			result = 1;
		} else if (first < second) {
			result = -1;
		} else {
			result = 0;
		}
		LOG.debug("get result " + result);

		return result;
	}

	/**
	 * get path to the file with two double, compare them and show the result
	 * 
	 * @param path
	 */
	public void execute(String path) {
		LOG.info("start execute");
		try {
			int result = compareNumFromTxt(path);
			if (result == 0) {
				System.out.println("a = b");
			}
			if (result == 1) {
				System.out.println("a > b");
			}
			if (result == -1) {
				System.out.println("a < b");
			}
		} catch (MyTxtReaderException e) {
			System.out.println(e.getMessage());
		} catch (SearchDataInStrException e) {
			System.out.println(e.getMessage());
		}
	}
}
