package by.training.vetv05;

/**
 * Составить программу: определения наименьшего из двух чисел а и b. file with
 * numbers is in thus package.
 * 
 * @author AlexeySupruniuk
 * @see Vetv05Logic
 *
 */
public class DoMainVetv05 {

	public static void main(String[] args) {

		Vetv05Logic temp = new Vetv05Logic();
		String path;

		path = System.getProperty("user.dir") + "//src//main//java//by//training//vetv05//vetv05.txt";
		temp.execute(path);

	}
}
