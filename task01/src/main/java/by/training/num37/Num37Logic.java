package by.training.num37;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.num29.Num29Logic;
import by.training.util.MyScan;
import by.training.util.MyScanException;

/**
 * logic for task01.num37
 * 
 * @author AlexeySupruniuk
 * @see by.training.util.MyScan
 * @see Num37Conditions
 * 
 */
public class Num37Logic {

	private static final Logger LOG = LogManager.getLogger(Num37Logic.class);

	/**
	 * main method
	 */
	public void num37Action() {
		LOG.info("main method started");
		boolean mas[] = checkConditions();
		viewResults(mas);
	}

	/**
	 * Check all conditions from task. Every result is entered into array.
	 * 
	 * @return boolean []
	 */
	private boolean[] checkConditions() {
		LOG.info("start checking of all conditions");
		boolean[] result = new boolean[9];
		double[] mas;
		Num37Conditions conditions = new Num37Conditions();

		try {
			LOG.debug("start receiving numbers");
			mas = getNumbers();
		} catch (MyScanException e) {
			System.out.println(e.getMessage());
			LOG.error(e.getMessage() + "from checkConditions()");
			return null;
		}

		int N = (int) mas[0];
		double a = mas[1];
		double b = mas[2];
		double c = mas[3];
		double x = mas[4];
		double m = mas[5];
		double n = mas[6];
		LOG.debug("get all numbers N:" + N + " a:" + a + " b:" + b + " c:" + c + " x:" + x + " m:" + m + " n: " + n);

		result[0] = conditions.condition0(N);
		result[1] = conditions.condition1(N);
		result[2] = conditions.condition2(N);
		result[3] = conditions.condition3(x, m, n);
		result[4] = conditions.condition4(N);
		result[5] = conditions.condition5(a, b, c);
		result[6] = conditions.condition6(N);
		result[7] = conditions.condition7(N, a);
		result[8] = conditions.condition8(a, b, c, m, n);
		LOG.debug("get all results");

		return result;
	}

	/**
	 * Dispalays all of the conditions with answers.
	 */
	private void viewResults(boolean[] mas) {
		LOG.info("start viewResults()");

		LOG.debug("check for null");
		if (!(mas != null)) {
			System.out.println("restart the app");
		} else {
			System.out.println("0 Целое число N является четным двузначным числом. " + mas[0]);
			System.out.println("1 Сумма двух первых цифр заданного четырехзначного"
					+ " числа равна сумме двух его последних цифр. " + mas[1]);
			System.out.println("2 Сумма цифр данного трехзначного числа N является четным числом. " + mas[2]);
			System.out.println("3 Точка с координатами (х, у) принадлежит части"
					+ " плоскости, лежащей между прямыми х= m, х= n (m<n). " + mas[3]);
			System.out.println("4 Квадрат заданного трехзначного числа равен кубу суммы цифр этого числа." + mas[4]);
			System.out.println("5 Треугольник со сторонами а,b,с является равнобедренным. " + mas[5]);
			System.out.println("6 Сумма каких-либо двух цифр заданного"
					+ " трехзначного натурального числа N равна третьей цифре." + mas[6]);
			System.out.println("7 Заданное число N является степенью числа а"
					+ "(показатель степени может находиться в диапазоне от 0 до 4)." + mas[7]);
			System.out.println(
					"8 График функции у =ах2+bх+с проходит через заданную точку с координатами (m, n). " + mas[8]);
		}
	}

	/**
	 * get all numbers from scan
	 * 
	 * @return Object {int n, double a, double b, double c, double x, double m,
	 *         double n}
	 * @throws MyScanException
	 */
	public double[] getNumbers() throws MyScanException {
		MyScan scan = MyScan.getMyScan();
		LOG.info("start getNumbers()");

		double[] mas = new double[7];

		System.out.println("enter integer number N");
		try {
			mas[0] = scan.getInt();
			LOG.debug("get N " + mas[0]);
		} catch (MyScanException e) {
			System.out.println("wrong dat entered, N must be integer");
			throw new MyScanException(e.getMessage());
		}

		System.out.println("enter number a");
		mas[1] = scan.getNum();
		LOG.debug("get a " + mas[1]);

		System.out.println("enter number b");
		mas[2] = scan.getNum();
		LOG.debug("get b " + mas[2]);

		System.out.println("enter number c");
		mas[3] = scan.getNum();
		LOG.debug("get c " + mas[3]);

		System.out.println("enter number x");
		mas[4] = scan.getNum();
		LOG.debug("get x " + mas[4]);

		System.out.println("enter number m");
		mas[5] = scan.getNum();
		LOG.debug("get m " + mas[5]);

		System.out.println("enter number n");
		mas[6] = scan.getNum();
		LOG.debug("get n " + mas[6]);

		return mas;
	}
}
