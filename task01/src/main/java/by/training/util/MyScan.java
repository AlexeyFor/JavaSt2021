package by.training.util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyScan {

	private static final MyScan myScan = new MyScan();

	private MyScan() {
	}

	/**
	 * @return MyScan myScan
	 */
	public static MyScan getMyScan() {
		return myScan;
	}

	/**
	 * return str from console (scaner)
	 * 
	 * @return string
	 */
	public String getScan() {

		String str;

		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		return str;
	}

	/**
	 * check and return double [2] from console
	 * 
	 * @return double [2]
	 * @throws MyScanException
	 */
	public double[] getTwoNum() throws MyScanException {

		double[] mas = new double[2];
		String str = getScan();
		mas = fromStrToMasDoubTwo(str);

		return mas;
	}

	/**
	 * check and return double from console
	 * 
	 * @return double
	 * @throws MyScanException
	 */
	public double getNum() throws MyScanException {

		double result;
		String str = getScan();
		result = fromStrToDouble(str);

		return result;
	}

	/**
	 * check and return double from console
	 * 
	 * @return int
	 * @throws MyScanException
	 */
	public int getInt() throws MyScanException {

		int result;
		String str = getScan();
		result = fromStrToInt(str);

		return result;
	}

	/**
	 * With regEx get two num from String
	 * 
	 * @param str
	 * @return double [2]
	 * @throws MyScanException
	 */
	public double[] fromStrToMasDoubTwo(String str) throws MyScanException {

		double[] mas = new double[2];

		// search for num
		Pattern pat = Pattern.compile("([\\-]{0,1}[0-9]+[\\.]{0,1}[0-9]*) ([\\-]{0,1}[0-9]+[\\.]{0,1}[0-9]*)");
		Matcher match = pat.matcher(str);
		if (match.find()) {
			mas[0] = Double.valueOf(match.group(1));
			mas[1] = Double.valueOf(match.group(2));
		} else {
			throw new MyScanException("incorrect data entered");
		}

		// check information from console for invalid characters
		Pattern pat2 = Pattern.compile("[^0-9\\- \\.]");
		Matcher match2 = pat2.matcher(str);
		if (match2.find()) {
			throw new MyScanException("incorrect data entered");
		}

		return mas;
	}

	/**
	 * With regEx get num from String
	 * 
	 * @param str
	 * @return double
	 * @throws MyScanException
	 */
	public double fromStrToDouble(String str) throws MyScanException {

		double result;

		// check information from console for invalid characters
		Pattern pat2 = Pattern.compile("[^0-9\\-\\.]");
		Matcher match2 = pat2.matcher(str);
		if (match2.find()) {
			throw new MyScanException("incorrect data entered");
		}

		// search for num
		Pattern pat = Pattern.compile("[\\-]{0,1}[0-9]+[\\.]{0,1}[0-9]*");
		Matcher match = pat.matcher(str);
		if (match.find()) {
			result = Double.valueOf(match.group(0));
		} else {
			throw new MyScanException("incorrect data entered");
		}

		return result;
	}

	/**
	 * With regEx get int from String
	 * 
	 * @return int
	 * @throws MyScanException
	 */
	public int fromStrToInt(String str) throws MyScanException {

		int result;

		// check information from console for invalid characters
		Pattern pat2 = Pattern.compile("[^0-9\\-]");
		Matcher match2 = pat2.matcher(str);
		if (match2.find()) {
			throw new MyScanException("incorrect data entered");
		}

		// search for int
		Pattern pat = Pattern.compile("^[\\-]{0,1}[0-9]+$");
		Matcher match = pat.matcher(str);
		if (match.find()) {
			result = Integer.valueOf(match.group(0));
		} else {
			throw new MyScanException("incorrect data entered");
		}

		return result;
	}

}
