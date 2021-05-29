package by.training.vetv37;

/**
 * Вычислить значение функции.
 * 
 * @author AlexeySupruniuk
 * @see Vetv37Logic
 *
 */

public class DoMainVetv37 {
	public static void main(String[] args) {

		String path = System.getProperty("user.dir") + "//src//main//java//by//training//task02//vetv37//Vetv37.txt";
		Vetv37Logic temp = new Vetv37Logic();
		temp.vetv37Action(path);
	}
}
