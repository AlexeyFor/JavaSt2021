package by.training.ex05thread_disable;

public class RunnerDaemon {

    public static void main(String[] args) {

	System.out.println("Главный поток начал работу");

	ThreadToDisable myThread = new ThreadToDisable();
	ThreadToDisable myThreadDaemon = new ThreadToDisable();

	Thread myT = new Thread(myThread, "not main thread");
	Thread myTDaemon = new Thread(myThreadDaemon, "daemon thread");
	myTDaemon.setDaemon(true);

	myT.start();
	myTDaemon.start();

	try {
	    Thread.sleep(450);

	    myThread.disable();

	    // т.к. виртуальная машина завершает работу главного потока когда остаются
	    // только потоки-демоны. C завершением главного потока завершаются и потоки -
	    // демоны
	    // Thread.sleep(450);

	} catch (InterruptedException e) {
	    System.out.println("Поток прерван");
	}
	System.out.println("Главный поток завершил работу...");
    };
}
