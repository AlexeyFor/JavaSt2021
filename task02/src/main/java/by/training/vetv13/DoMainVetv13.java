package by.training.vetv13;

/**
 * Даны две точки А(х1, у1) и В(х2, у2). Составить алгоритм, определяющий,
 * которая из точек находится ближе к началу координат.
 * 
 * @author AlexeySupruniuk
 * @see Vetv13Logic
 * @see CoordinateXY
 * @see CoordinateXYLogic
 */

public class DoMainVetv13 {
	public static void main(String[] args) {

		String path = System.getProperty("user.dir") + "//src//main//java//by//training//vetv13//vetv13.txt";
		Vetv13Logic temp = new Vetv13Logic();
		temp.showNearestCoordinate(path);
	}
}
