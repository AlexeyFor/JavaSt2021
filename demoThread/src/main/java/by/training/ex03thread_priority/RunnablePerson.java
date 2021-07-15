package by.training.ex03thread_priority;

import java.util.concurrent.TimeUnit;

public class RunnablePerson extends Person implements Runnable {

    public RunnablePerson(String firstName) {
	super(firstName);
    }

    @Override
    public void run() {
	for (int i = 0; i < 30; i++) {
	    System.out.println(i + "    " + getFirstName() + "Hello");
	    try {
		TimeUnit.MILLISECONDS.sleep(0);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }

	}
    }

}
