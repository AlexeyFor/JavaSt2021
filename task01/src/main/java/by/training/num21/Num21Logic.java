package by.training.num21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.util.MyScan;
import by.training.util.MyScanException;

/**
 * logic for task01.num21
 * 
 * @author AlexeySupruniuk
 * @see by.training.util.MyScan
 */
public class Num21Logic {

	private static final Logger LOG = LogManager.getLogger(Num21Logic.class);

	/**
	 * main method, get number nnn.ddd, and displays it like ddd.nnn
	 */
	public void num21Action() {
		LOG.info("main method started");

		String num;
		MyScan scan = MyScan.getMyScan();
		System.out.println("enter number in nnn.ddd format");
		num = scan.getScan();
		LOG.debug("get number from scan");

		try {
			String[] mas;
			mas = fromStrToStrMas(num);
			LOG.debug("get String mas from number from scan " + mas[0] + " " + mas[1]);
			double result = fromStrMasToDouble(mas);
			LOG.debug("get result " + result);

			System.out.println("result " + result);

		} catch (MyScanException e) {
			System.out.println(e.getMessage());
			LOG.error(e.getMessage() + "from main method");
		}

	}

	/**
	 * With regEx get two parts of num from String
	 * 
	 * @param str
	 * @return double
	 * @throws MyScanException
	 */
	public String[] fromStrToStrMas(String str) throws MyScanException {
		LOG.debug("fromStrToStrMas started");
		String[] result = new String[2];

		// check information from console for invalid characters
		Pattern pat2 = Pattern.compile("[^0-9\\-\\.]");
		Matcher match2 = pat2.matcher(str);
		if (match2.find()) {
			LOG.error("incorrect data entered from fromStrToStrMas");
			throw new MyScanException("incorrect data entered");
		}

		// search for num
		Pattern pat = Pattern.compile("^[\\-]{0,1}([0-9]{3})[\\.]{1}([0-9]{3})$");
		Matcher match = pat.matcher(str);
		if (match.find()) {
			result[0] = match.group(1);
			result[1] = match.group(2);
			LOG.debug("get two parts of number " + result[0] + " " + result[1]);
		} else {
			LOG.error("incorrect data entered from fromStrToStrMas");
			throw new MyScanException("incorrect data entered");
		}

		return result;
	}

	/**
	 * From two String make double
	 * 
	 * @param mas
	 * @return double
	 */
	public double fromStrMasToDouble(String[] mas) {
		LOG.debug("fromStrMasToDouble started");
		double result;
		String num;

		num = mas[1].concat(".").concat(mas[0]);
		result = Double.valueOf(num);
		LOG.debug("get " + result);
		return result;
	}

}