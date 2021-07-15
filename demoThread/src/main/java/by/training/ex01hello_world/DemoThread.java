package by.training.ex01hello_world;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DemoThread extends Thread {
    private static final Logger LOG = LogManager.getLogger(DemoThread.class);

    public void run () {
	LOG.debug("from thread");
	System.out.println("hello");
    }
}
