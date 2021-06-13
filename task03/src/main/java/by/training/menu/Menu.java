package by.training.menu;

import java.util.Locale;
import java.util.ResourceBundle;

import by.training.controller.Controller;
import by.training.controller.ControllerImpl;

public class Menu {

	private Locale locale = new Locale("ru", "RU");
	private ResourceBundle rb = ResourceBundle.getBundle("langs.text", locale);

	public void menu(String str) {
		Controller contr = ControllerImpl.getController();

		String answ;
		int answNum;

		answ = contr.doAction(str);
		answNum = Integer.parseInt(answ.split("___")[0]);

		if (answNum == 0) {
			System.out.println(rb.getString(answ.split("___")[1]));
		} else {
			System.out.println(rb.getString("error"));
			System.out.println(rb.getString(answ.split("___")[1]));

		}

	}
}
