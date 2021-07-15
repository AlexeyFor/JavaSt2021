package by.training.ex02person;

import java.util.concurrent.TimeUnit;

public class RunnablePerson extends Person implements Runnable {

    public RunnablePerson(String firstName) {
	super(firstName);
    }

    @Override
    public void run() {
	for (int i = 0; i < 10; i++) {
	    System.out.println(i + "    " + getFirstName() + "Hello");
	    try {
		TimeUnit.MILLISECONDS.sleep(10);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }

	}
    }

}
