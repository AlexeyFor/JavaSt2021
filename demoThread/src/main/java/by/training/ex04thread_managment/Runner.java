package by.training.ex04thread_managment;

public class Runner {

    static {
	System.out.println("Старт потока main");
    }

    /**
     * interrupts the thread (joinThread) in which the method is called,until the
     * thread (t1) on which the method is called ends, or for a time specified in
     * the method (.join(time) )
     * 
     * @param args
     */
    public static void main(String[] args) {
	JoinThread t1 = new JoinThread("First");

	Thread thread1 = new Thread(t1);

	Thread joinThread = new Thread(() -> {
	    System.out.println("thread joinThread 0");
	    System.out.println("thread joinThread 1");
	    System.out.println("thread joinThread 2");
	    System.out.println("thread joinThread 3");
	    thread1.start();
	    try {
		thread1.join(4000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    System.out.println("thread joinThread 4");
	    System.out.println("thread joinThread 5");
	    System.out.println("thread joinThread ended");

	}, "joinThread");

	joinThread.start();

    }

}
