package by.training.ex05thread_disable;

public class RunnerInterrupt {

    public static void main(String[] args) {

	System.out.println("Главный поток начал работу");

	Thread myT = new ThreadToInterrupt();
	myT.start();

	try {
	    Thread.sleep(500);

	    myT.interrupt();

	    // without this entry, the main thread will end before the thread myT
	    Thread.sleep(500);

	} catch (InterruptedException e) {
	    System.out.println("Поток прерван");
	}
	System.out.println("Главный поток завершил работу...");
    };

}
