package by.training.menu;

/**
 * 
 * @author AlexeySupruniuk
 *
 */
public class Runner {

	/**
	 * request in form (for ride):
	 * 
	 * command___fileName___distance___saving
	 * 
	 * distance - distance for car in double
	 * 
	 * filename - name of the file
	 * 
	 * saving - save the result of sorting
	 * 
	 * for change wheel
	 * command___fileName___wheelType___wheelDiameter___index___saving
	 * 
	 * for view: command___fileName
	 * 
	 * for refuel: command___fileName___fuelAmount___saving
	 */

	public static void main(String args[]) {
		String path = System.getProperty("user.dir") + "//src//main//java//by//training//source//";

		Menu menu = Menu.getInstance();

		// possible commands:
		// "RIDE"
		// "REFUEL"
		// "VIEW"
		// "CHANGE WHEEL"
		// "SET LANGUAGE"
		String file = path + "car1.txt";

		menu.menu("SET LANGUAGE___RU");
		menu.menu("VIEW___" + file);
		menu.menu("REFUEL___" + file + "___6___false");

	}
}
