package by.training.ex06thread_common_resource;

import java.util.concurrent.TimeUnit;

public class CommonResource {

    int x;

    void increment() {
	x = 1;
	for (int i = 1; i < 7; i++) {
	    System.out.printf("%s %d \n", Thread.currentThread().getName(), x);
	    x++;
	    try {
		Thread.sleep(100);
	    } catch (InterruptedException e) {
	    }
	}
    }

    void action() {
	int y = 0;

	for (int i = 1; i < 8; i++) {
	    y++;
	    System.out.printf("action %s %d \n", Thread.currentThread().getName(), y);
	    try {
		TimeUnit.MILLISECONDS.sleep(100);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }
    
    
}
