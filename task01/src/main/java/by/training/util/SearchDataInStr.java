package by.training.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.util.exception.SearchDataInStrException;

/**
 * Each method looks for information in a given format. The methods accept List
 * <String>, or String as the first parameter (str), and the second parameter
 * (text) is a String, after which the required information should be found.
 * Example: ([the name of the array that contains the required line], String
 * [the text in the line, after which the required data is located])
 * 
 * WARNING! Data only in decimal format!
 * 
 * @author AlexeySupruniuk
 * 
 */
public class SearchDataInStr {

	private static final Logger LOG = LogManager.getLogger(SearchDataInStr.class);

	private static final SearchDataInStr searchDataInStr = new SearchDataInStr();

	private SearchDataInStr() {
	}

	/**
	 * @return SearchDataInStr searchDataInStr
	 */
	public static SearchDataInStr getSearchDataInStr() {
		return searchDataInStr;
	}

	/**
	 * return double from string
	 * 
	 * @param str
	 * @param text (aftet this text will be the searched data)
	 * @return double
	 * @throws SearchDataInStrException
	 */
	public double searchDouble(String str, String text) throws SearchDataInStrException {
		LOG.debug("start searchDouble");
		double result;
		String dataInStr = dataInString(str, text);
		LOG.debug("get dataInStr " + dataInStr + ';');

		if (!checkForINvalidCharacters("[^0-9\\-\\.]", dataInStr)) {
			LOG.error("incorrect data entered");
			throw new SearchDataInStrException("incorrect data entered");
		}

		// search for double
		Pattern pat = Pattern.compile("[\\-]{0,1}[0-9]+[\\.]{0,1}[0-9]*");
		Matcher match = pat.matcher(dataInStr);
		if (match.find()) {
			try {
				result = Double.valueOf(match.group(0));
			} catch (NumberFormatException e) {
				LOG.error("the entered value is greater than the max possible for this format");
				throw new SearchDataInStrException(
						"the entered value is greater than the max possible for this format");
			}
		} else {
			LOG.error("incorrect data entered");
			throw new SearchDataInStrException("incorrect data entered");
		}
		LOG.debug("return " + result);
		return result;
	}

	/**
	 * return int from string
	 * 
	 * @param str
	 * @param text
	 * @return int
	 * @throws SearchDataInStrException
	 */
	public int searchInt(String str, String text) throws SearchDataInStrException {
		LOG.debug("start searchInt");
		int result;
		String dataInStr = dataInString(str, text);
		LOG.debug("get dataInStr " + dataInStr + ';');

		if (!checkForINvalidCharacters("[^0-9\\-]", dataInStr)) {
			LOG.error("incorrect data entered");
			throw new SearchDataInStrException("incorrect data entered");
		}

		// search for int
		Pattern pat = Pattern.compile("^[\\-]{0,1}[0-9]+$");
		Matcher match = pat.matcher(dataInStr);
		if (match.find()) {
			try {
				result = Integer.valueOf(match.group(0));
			} catch (NumberFormatException e) {
				LOG.error("the entered value is greater than the max possible for this format");
				throw new SearchDataInStrException(
						"the entered value is greater than the max possible for this format");
			}
		} else {
			LOG.error("incorrect data entered");
			throw new SearchDataInStrException("incorrect data entered");
		}
		LOG.debug("return " + result);
		return result;
	}

	/**
	 * return char from string
	 * 
	 * @param str
	 * @param text
	 * @return char
	 * @throws SearchDataInStrException
	 */
	public char searchChar(String str, String text) throws SearchDataInStrException {
		LOG.debug("start searchChar");
		char result;
		String dataInStr = dataInString(str, text);

		// search for char
		Pattern pat = Pattern.compile("^.{1}$");
		Matcher match = pat.matcher(dataInStr);
		if (match.find()) {
			result = match.group(0).charAt(0);
		} else {
			LOG.error("incorrect data entered");
			throw new SearchDataInStrException("incorrect data entered");
		}
		LOG.debug("return " + result);
		return result;

	}

	/**
	 * return required data in String
	 * 
	 * @param str
	 * @param text
	 * @throws SearchDataInStrException
	 */
	private String dataInString(String str, String text) throws SearchDataInStrException {

		String result;

		Pattern pat = Pattern.compile("\\Q" + text + "\\E" + "(.*)$");
		Matcher match = pat.matcher(str);
		if (match.find()) {
			result = match.group(1);
		} else {
			throw new SearchDataInStrException("Wrong parameters");
		}
		return result;
	}

	/**
	 * check information from console for invalid characters
	 * 
	 * @param str
	 * @return boolean
	 * @throws SearchDataInStrException
	 */
	private boolean checkForINvalidCharacters(String pattern, String dataInStr) {
		Pattern pat = Pattern.compile(pattern);
		Matcher match = pat.matcher(dataInStr);
		if (match.find()) {
			return false;
		} else {
			return true;

		}
	}

}
