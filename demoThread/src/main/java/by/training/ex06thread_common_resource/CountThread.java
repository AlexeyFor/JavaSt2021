package by.training.ex06thread_common_resource;

public class CountThread implements Runnable {

    CommonResource res;

    CountThread(CommonResource res) {
	this.res = res;
    }

    public void run() {
	res.action();
	res.increment();

    }
}
