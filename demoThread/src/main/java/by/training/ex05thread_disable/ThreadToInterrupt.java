package by.training.ex05thread_disable;

public class ThreadToInterrupt extends Thread {

    public void run() {

	System.out.printf("����� %s ����� ������... \n", Thread.currentThread().getName());
	int counter = 1; // ������� ������
	while (!isInterrupted()) {
	    System.out.println("���� " + counter++);
	    try {
		Thread.sleep(100);
	    } catch (InterruptedException e) {
		System.out.println("����� �������");
		// Without this entry, when a request is made from outside to interrupt the
		// thread, the exception will be handled and the thread will continue to work.
		Thread.currentThread().interrupt();
	    }
	}
	System.out.printf("����� %s �������� ������... \n", Thread.currentThread().getName());
    }
}
