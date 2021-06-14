package by.training.menu;

/**
 * 
 * @author AlexeySupruniuk
 *
 */
public class Runner {

	/**
	 * for sorting request in form:
	 * 
	 * command___fileName___ascending___saving___show
	 * 
	 * filename - name of the file from console
	 * 
	 * saving - save the result of sorting
	 * 
	 * show - show the result of sorting on console
	 * 
	 * 
	 * for operations with matrix :
	 * 
	 * request in form:
	 * 
	 * command___fileName1___fileName2
	 * 
	 * filename - name of the file from console
	 * 
	 */

	public static void main(String args[]) {
		String path = System.getProperty("user.dir") + "//src//main//java//by//training//source//";

		Menu menu = Menu.getInstance();

		// possible commands:
		// "BUBBLE SORTING"
		// "INSERT HASH SORTING"
		// "INSERTS SORTING"
		// "SELECTION SORTING"
		// "SHAKE SORTING"
		// "SHELL SORTING"
		// "BINARY MERGING SORTING"

		// "MATRIX ADDITION"
		// "MATRIX SUBTRACTION"
		// "MATRIX MULTIPLICATION"

		// "SHOW MATRIX"
		// "SHOW MYARRAY"
		// "SET LANGUAGE"
		String file = path + "randomArr3.txt";
		
		menu.menu("SET LANGUAGE___EN");
		menu.menu("BUBBLE SORTING___" + file + "___false___false___true");
		
		menu.menu("SET LANGUAGE___RU");
		menu.menu("BUBBLE SORTING___" + file + "___false___false___true");

		menu.menu("SET LANGUAGE___EN");

		String file1 = path + "randomMatrix4x4.1.txt";
		String file2 = path + "randomMatrix4x4.2.txt";
		menu.menu("MATRIX SUBTRACTION___" + file1 + "___" + file2);

	}
}
