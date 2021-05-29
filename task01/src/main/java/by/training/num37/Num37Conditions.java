package by.training.num37;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Conditions for task 37. The number of each condition corresponds to the task
 * (from 0 to 8)
 * 
 * @author AlexeySupruniuk
 *
 */
public class Num37Conditions {

	private static final Logger LOG = LogManager.getLogger(Num37Conditions.class);

	/**
	 * check condition 0 Целое число N является четным двузначным числом.
	 * 
	 * @param n
	 * @return boolean
	 */
	public boolean condition0(int n) {
		LOG.debug("start condition0");
		int number = Math.abs(n);
		if ((number > 9) && (number < 100) && ((number % 2) == 0)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * check condition 1 Сумма двух первых цифр заданного четырехзначного числа
	 * равна сумме двух его последних цифр.
	 * 
	 * @param n
	 * @return boolean
	 */
	public boolean condition1(int n) {
		LOG.debug("start condition1 with N " + n);

		n = Math.abs(n);
		if ((n < 1000) || (n > 9999)) {
			return false;
		}
		int n1;
		int n2;
		int n3;
		int n4;
		n1 = n / 1000;
		n2 = (n / 100) - n1 * 10;
		n3 = (n / 10) - (n1 * 100 + n2 * 10);
		n4 = (n - (n1 * 1000 + n2 * 100 + n3 * 10));

		if ((n1 + n2) == (n3 + n4)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * check condition 2 Сумма цифр данного трехзначного числа N является четным
	 * числом.
	 * 
	 * @param n
	 * @return boolean
	 */
	public boolean condition2(int n) {
		LOG.debug("start condition2 with N " + n);

		n = Math.abs(n);
		if ((n < 100) || (n > 999)) {
			return false;
		}
		int n1;
		int n2;
		int n3;
		n1 = n / 100;
		n2 = (n / 10) - n1 * 10;
		n3 = n - (n1 * 100 + n2 * 10);

		int expression = ((n1 + n2 + n3) % 2);

		if (expression == 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * check condition 3 Точка с координатами (х, у) принадлежит части плоскости,
	 * лежащей между прямыми х= m, х= n (m<n). 'y' does not affect the answer
	 * 
	 * @param x
	 * @param m
	 * @param n
	 * @return boolean
	 */
	public boolean condition3(double x, double m, double n) {
		LOG.debug("start condition3 with x " + x + " m:" + m + " n:" + n);

		if (m >= n) {
			return false;
		}

		if ((x >= m) && (x <= n)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * check condition 4 Квадрат заданного трехзначного числа равен кубу суммы цифр
	 * этого числа. this condition is unreacheble!!!
	 * 
	 * @param n
	 * @return boolean
	 */
	public boolean condition4(int n) {
		LOG.debug("start condition4 with N " + n);

		n = Math.abs(n);
		if ((n < 100) || (n > 999)) {
			return false;
		}
		int n1;
		int n2;
		int n3;
		n1 = n / 100;
		n2 = (n / 10) - n1 * 10;
		n3 = n - (n1 * 100 + n2 * 10);

		int sum = (n1 + n2 + n3);
		int sumCube = sum * sum * sum;
		int numberSquared = n * n;

		if (sumCube == numberSquared) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * check condition 5 Треугольник со сторонами а,b,с является равнобедренным.
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return boolean
	 */
	public boolean condition5(double a, double b, double c) {
		LOG.debug("start condition5 with a " + a + " b:" + b + " c:" + c);

		if ((a <= 0) || (b <= 0) || (c <= 0)) {
			return false;
		}

		if ((a == c) || (b == c) || (a == b)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * check condition 6 Сумма каких-либо двух цифр заданного трехзначного
	 * натурального числа N равна третьей цифре."
	 * 
	 * @param n
	 * @return boolean
	 */
	public boolean condition6(int n) {
		LOG.debug("start condition6 with N " + n);

		if ((n < 100) || (n > 999)) {
			return false;
		}
		int n1;
		int n2;
		int n3;
		n1 = n / 100;
		n2 = (n / 10) - n1 * 10;
		n3 = n - (n1 * 100 + n2 * 10);

		int sum12 = n1 + n2;
		int sum13 = n1 + n3;
		int sum23 = n2 + n3;

		if ((sum12 == n3) || (sum13 == n2) || (sum23 == n1)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * check condition 7 Заданное число N является степенью числа а (показатель
	 * степени может находиться в диапазоне от 0 до 4).
	 * 
	 * @param n
	 * @return boolean
	 */
	public boolean condition7(int n, double a) {
		LOG.debug("start condition7 with N " + n + "  a:" + a);

		double a0 = 1;
		double a1 = a;
		double a2 = a * a;
		double a3 = a * a * a;
		double a4 = a * a * a * a;

		double[] mas = { a0, a1, a2, a3, a4 };
		for (int i = 0; i < mas.length; i++) {
			if (n == mas[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * check condition 8. To increase accuracy use BigDecimal График функции у
	 * =ах2+bх+с проходит через заданную точку с координатами (m, n).
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param m
	 * @param n
	 * @return boolean
	 */
	public boolean condition8(double a, double b, double c, double m, double n) {
		LOG.debug("start condition8 with a " + a + " b:" + b + " c:" + c + " m:" + m + " n:" + n);

		double expression = a * m * m + b * m + c;
		BigDecimal expr = new BigDecimal(expression);
		BigDecimal y = new BigDecimal(n);

		if (expr.compareTo(y) == 0) {
			return true;
		} else {
			return false;
		}

	}
}
