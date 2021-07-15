package by.training.ex04thread_managment;

public class JoinThread implements Runnable {

    private String name;

    public JoinThread(String name) {
	super();
	this.name = name;
    }

    public void run() {
	String nameT = name;
	long timeout = 0;
	System.out.println("Старт потока " + nameT);
	try {
	    switch (nameT) {
	    case "First":
		timeout = 5_000;
		break;
	    case "Second":
		timeout = 1_000;
	    }
	    Thread.sleep(timeout);
	    System.out.println("завершение потока " + nameT);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }
}
