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

	private double a;
	private double b;

	private void getNumbersFromTxt(String path) throws SearchDataInStrException {
		LOG.info("getNumbersFromTxt started");
		MyTxtReader reader = MyTxtReader.getMyTxtReader();
		SearchDataInStr search = SearchDataInStr.getSearchDataInStr();

		try {
			LOG.debug("trying get numbers");
			List<String> list = reader.readFile(path);
			this.a = search.searchDouble(list.get(0), "number a: ");
			this.b = search.searchDouble(list.get(1), "number b: ");
		} catch (MyTxtReaderException e) {
			System.out.println(e.getMessage());
		} catch (SearchDataInStrException e) {
			System.out.println(e.getMessage());
			throw new SearchDataInStrException(e);
		}
	}

	/**
	 * compare two num from txt
	 * 
	 * @param path (way to the file with numbers)
	 * @return answer ( a > b ->1, a < b -> -1, a = b -> 0, smth wrong -> 2)
	 */
	public int compareNumFromTxt(String path) {
		LOG.info("compareNumFromTxt started");
		try {
			getNumbersFromTxt(path);
			int answer = compareTwoNum(this.a, this.b);
			LOG.debug("get answer " + answer);
			return answer;
		} catch (SearchDataInStrException e) {
			return 2;
		}

	}

	/**
	 * compare two num
	 * 
	 * @param first
	 * @param second
	 * @return answer ( a > b ->1, a < b -> -1, a = b -> 0, smth wrong -> 2)
	 */
	public int compareTwoNum(double first, double second) {
		LOG.info("compareTwoNum started");
		int result = 2;

		if (first > second) {
			result = 1;
		}

		if (first == second) {
			result = 0;
		}

		if (first < second) {
			result = -1;
		}
		LOG.debug("get result " + result);

		return result;
	}

	public void demostrateResult(int num) {
		LOG.info("demostrateResult started with num " + num);
		if ((num > 1) || (num < -1)) {
			System.out.println("comparison is impossible incorrect data");
		}
		if (num == 0) {
			System.out.println("a = b");
		}
		if (num == 1) {
			System.out.println("a > b");
		}
		if (num == -1) {
			System.out.println("a < b");
		}
	}
}
