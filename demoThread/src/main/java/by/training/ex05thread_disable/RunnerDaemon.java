package by.training.ex05thread_disable;

public class RunnerDaemon {

    public static void main(String[] args) {

	System.out.println("������� ����� ����� ������");

	ThreadToDisable myThread = new ThreadToDisable();
	ThreadToDisable myThreadDaemon = new ThreadToDisable();

	Thread myT = new Thread(myThread, "not main thread");
	Thread myTDaemon = new Thread(myThreadDaemon, "daemon thread");
	myTDaemon.setDaemon(true);

	myT.start();
	myTDaemon.start();

	try {
	    Thread.sleep(450);

	    myThread.disable();

	    // �.�. ����������� ������ ��������� ������ �������� ������ ����� ��������
	    // ������ ������-������. C ����������� �������� ������ ����������� � ������ -
	    // ������
	    // Thread.sleep(450);

	} catch (InterruptedException e) {
	    System.out.println("����� �������");
	}
	System.out.println("������� ����� �������� ������...");
    };
}
