package by.training.ex03thread_priority;

public class Runner {

    /**
     * 
     * the longer the time in .sleep() in method run() of RunnablePerson - the
     * greater the heterogeneity. Heterogeneity is more pronounced with more
     * iterations. Priority does not always have an effect - min and max can be
     * completely swapped
     * 
     */
    public static void main(String[] args) {

	RunnablePerson annaMin = new RunnablePerson("AnnaMin");
	RunnablePerson bobNorm = new RunnablePerson("BobNorm");
	RunnablePerson maxMax = new RunnablePerson("MaxMax");

	Thread annaThr = new Thread(annaMin, "Anna");
	Thread bobThr = new Thread(bobNorm, "Bob");
	Thread maxThr = new Thread(maxMax, "Max");

	annaThr.setPriority(Thread.MIN_PRIORITY); // 1
	bobThr.setPriority(Thread.NORM_PRIORITY); // 5
	maxThr.setPriority(Thread.MAX_PRIORITY); // 10

	annaThr.start();
	bobThr.start();
	maxThr.start();

    }
}
