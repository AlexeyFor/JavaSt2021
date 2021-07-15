package by.training.ex01hello_world;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static final Logger LOG = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
	LOG.debug("from main start");

	DemoThread thr = new DemoThread();
	thr.start();
	LOG.debug("from main end");

    }
}
