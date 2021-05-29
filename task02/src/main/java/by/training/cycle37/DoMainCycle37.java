package by.training.cycle37;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Даны два двузначных числа А и В. Из этих чисел составили 2 четырехзначных
 * числа: первое число получили путем написания сначала числа А, затем В. Для
 * получения второго числа сначала записали число В, затем А. Найти числа А и В
 * если известно , что первое четырехзначное число нацело делится на 99, а
 * второе на 49.
 * 
 * @author AlexeySupruniuk
 * @see Cycle37Logic
 *
 */
public class DoMainCycle37 {
	private static final Logger LOG = LogManager.getLogger(DoMainCycle37.class);

	public static void main(String[] args) {
		Cycle37Logic temp = new Cycle37Logic();

		LOG.info("start from main");
		int mas[] = temp.Cycle37Action();
		System.out.println(String.format("numbers are: A = %s, B = %s", mas[1], mas[0]));
	}
}
