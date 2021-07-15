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

	System.out.printf("Поток %s начал работу... \n", Thread.currentThread().getName());
	int counter = 1; // счетчик циклов
	while (isActive) {
	    System.out.println("Цикл " + counter++ + " " + Thread.currentThread().getName());
	    try {
		Thread.sleep(100);
	    } catch (InterruptedException e) {
		System.out.println("Поток прерван");
		isActive = false;
	    }
	}
	System.out.printf("Поток %s завершил работу... \n", Thread.currentThread().getName());
    }
}
