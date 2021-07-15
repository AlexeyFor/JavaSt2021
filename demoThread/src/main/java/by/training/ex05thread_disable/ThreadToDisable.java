package by.training.ex05thread_disable;

public class ThreadToDisable implements Runnable {

    private boolean isActive;

    public void disable() {
	isActive = false;
    }

    public ThreadToDisable() {
	isActive = true;
    }

    public void run() {

	System.out.printf("����� %s ����� ������... \n", Thread.currentThread().getName());
	int counter = 1; // ������� ������
	while (isActive) {
	    System.out.println("���� " + counter++ + " " + Thread.currentThread().getName());
	    try {
		Thread.sleep(100);
	    } catch (InterruptedException e) {
		System.out.println("����� �������");
		isActive = false;
	    }
	}
	System.out.printf("����� %s �������� ������... \n", Thread.currentThread().getName());
    }
}
