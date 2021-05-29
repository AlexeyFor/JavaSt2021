package by.training.vetv21;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.util.MyScan;
import by.training.util.SearchDataInStr;
import by.training.util.exception.SearchDataInStrException;

/**
 * 
 * @author AlexeySupruniuk
 * @see DoMainVetv21
 */
public class Vetv21Logic {

	private static final Logger LOG = LogManager.getLogger(Vetv21Logic.class);

	/**
	 * get char from console
	 * 
	 * @return char from console
	 * @throws SearchDataInStrException
	 */
	public char getCharFromScan() throws SearchDataInStrException {
		LOG.info("start searchChar");
		MyScan scan = MyScan.getMyScan();
		SearchDataInStr searchDataInStr = SearchDataInStr.getSearchDataInStr();
		String str = scan.getScan();
		LOG.debug("from console get: " + str);

		char ch;
		try {
			ch = searchDataInStr.searchChar(str, "");
			LOG.debug("get char: " + ch);
		} catch (SearchDataInStrException e) {
			LOG.warn(e.getMessage());
			throw new SearchDataInStrException(e.getMessage());
		}
		LOG.debug("return: " + ch);
		return ch;
	}

	/**
	 * check char from console and return String
	 * 
	 * @return String
	 */
	public String vetv21Action() {
		LOG.info("start vetv21Action");

		String result;

		try {
			char ch = getCharFromScan();
			result = pleaser(ch);
		} catch (SearchDataInStrException e) {
			LOG.warn(e.getMessage());
			result = e.getMessage();
		}
		LOG.debug("return: " + result);
		return result;
	}

	/**
	 * check char, if 'Д' return "Мне нравятся девочки!" if 'М' return "Мне нравятся
	 * мальчики!"
	 * 
	 * @param ch
	 * @return string
	 */
	public String pleaser(char ch) {
		LOG.info("start pleaser");
		String result;
		switch (ch) {
		case 'Д':
			result = "Мне нравятся девочки!";
			break;
		case 'М':
			result = "Мне нравятся мальчики!";
			break;
		default:
			result = "enter 'Д' or 'М'";
		}
		return result;
	}
}
