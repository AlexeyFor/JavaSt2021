package by.training.ex02person;

public class Runner {
    /**
     * the longer the time in .sleep() in method run() of RunnablePerson - the
     * greater the heterogeneity
     * 
     * @param args
     */
    public static void main(String[] args) {

	RunnablePerson anna = new RunnablePerson("Anna");
	RunnablePerson bob = new RunnablePerson("Bob");

	Thread annaThr = new Thread(anna, "Anna");
	Thread bobThr = new Thread(bob, "Bob");

	annaThr.start();
	bobThr.start();
    }
}
