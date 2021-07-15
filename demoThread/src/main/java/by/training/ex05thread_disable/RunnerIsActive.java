package by.training.ex05thread_disable;

public class RunnerIsActive {

    public static void main(String[] args) {

//	Thread joinThread = new Thread(() -> {
//	    for (int i = 0; i < 5; i++) {
//		System.out.println("Главный поток начал работу в " + i + " раз");

	System.out.println("Главный поток начал работу");

	ThreadToDisable myThread = new ThreadToDisable();
	Thread myT = new Thread(myThread, "not main thread");
	myT.start();

	try {
	    Thread.sleep(450);

	    // Attentoin! on object myThread, but not on thread
	    // just because disable() is inner method
	    myThread.disable();

	    // without this entry, the main thread will end before the thread myT
		    Thread.sleep(500);

	} catch (InterruptedException e) {
	    System.out.println("Поток прерван");
	}
	System.out.println("Главный поток завершил работу...");
    };

//	});
//	joinThread.start();
//    }

}
