package by.training.task06.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task06.dal.FileReaderImpl;
import by.training.task06.entity.MatrixForThreads;
import by.training.task06.entity.MatrixMember;
import by.training.task06.entity.ThreadLock;
import by.training.task06.service.InitiateMatrixImpl;
import by.training.task06.service.ServiceException;
import by.training.task06.view.MatrixForThreadsView;

/**
 * 
 * @author AlexeySupruniuk
 *
 *         util class for mor accurate debugging
 */
public class MainForThreads {

    private static final Logger LOG = LogManager.getLogger(MainForThreads.class);

    public static void main(String[] args) throws InterruptedException, IOException {

	InitiateMatrixImpl ser = InitiateMatrixImpl.getInstance();
	MatrixForThreadsView view = new MatrixForThreadsView();

	try {
	    LOG.debug("start");
	    System.out.println("start");
	    MatrixForThreads matrix = ser
		    .takeMatrixFromFile(System.getProperty("user.dir") + "//array.txt", 250);
//	    view.showMatrixValue(matrix);

	    ThreadLock thread1 = new ThreadLock(matrix, 101);
	    ThreadLock thread2 = new ThreadLock(matrix, 102);
	    ThreadLock thread3 = new ThreadLock(matrix, 103);
	    ThreadLock thread4 = new ThreadLock(matrix, 104);
	    ThreadLock thread5 = new ThreadLock(matrix, 105);
	    ThreadLock thread6 = new ThreadLock(matrix, 106);
	    ThreadLock thread7 = new ThreadLock(matrix, 107);
	    ThreadLock thread8 = new ThreadLock(matrix, 108);

	    Thread thr1 = new Thread(thread1, "thread1");
	    Thread thr2 = new Thread(thread2, "thread2");
	    Thread thr3 = new Thread(thread3, "thread3");
	    Thread thr4 = new Thread(thread4, "thread4");

	    Thread thr5 = new Thread(thread5, "thread5");
	    Thread thr6 = new Thread(thread6, "thread6");
	    Thread thr7 = new Thread(thread7, "thread7");
	    Thread thr8 = new Thread(thread8, "thread8");

	    thr1.start();
//	    thr2.start();
//	    thr3.start();
//	    thr4.start();
//	    thr5.start();
//	    thr6.start();
//	    thr7.start();
//	    thr8.start();
////	    
//	    thr1.join();
//	    thr2.join();
//	    thr3.join();
//	    thr4.join();
//	    thr5.join();
//	    thr6.join();
//	    thr7.join();
//	    thr8.join();

	    System.out.println("oks");

//	    view.showMatrixCounter(matrix);

//	    view.showMatrixValue(matrix);

	    File file = new File("arrayResult.txt");
	    BufferedWriter writerDel = null;
	    writerDel = new BufferedWriter(new FileWriter(file, false));
	    writerDel.newLine();
	    writerDel.close();

	    for (int i = 0; i < matrix.getMatrixLength(); i++) {
		StringBuilder tmp = new StringBuilder("");
		for (int j = 0; j < matrix.getMatrixLength(); j++) {
		    tmp.append(matrix.getMatrixMember(i, j).getValue());
		    tmp.append("  ");
		}

		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter(file, true));
		writer.newLine();
		writer.write(tmp.toString());
		writer.close();

	    }

	    File file1 = new File("arrayResultCount.txt");
	    BufferedWriter writerDelCount = null;
	    writerDelCount = new BufferedWriter(new FileWriter(file1, false));
	    writerDelCount.newLine();
	    writerDelCount.close();

	    for (int i = 0; i < matrix.getMatrixLength(); i++) {
		StringBuilder tmp = new StringBuilder("");
		for (int j = 0; j < matrix.getMatrixLength(); j++) {
		    tmp.append(matrix.getMatrixMember(i, j).getCounter());
		    tmp.append("  ");
		}

		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter(file1, true));
		writer.newLine();
		writer.write(tmp.toString());
		writer.close();

	    }

	    System.out.println(checkMatrixDiagonalCounter(matrix));

	} catch (ServiceException e) {
	    e.printStackTrace();
	}

    }

    /**
     * check, if all Counter of all diagonal MatrixMember of MatrixForThreads are
     * equals 1
     * 
     * @param matrix
     * @return
     */
    public static boolean checkMatrixDiagonalCounter(MatrixForThreads matrix) {
	int tmp;

	int matrixLength = matrix.getMatrixLength();

	for (int i = 0; i < matrixLength; i++) {

	    tmp = matrix.getMatrixMember(i, i).getCounter();
	    if (tmp != 1) {
		LOG.debug("error in " + i);
		return false;
	    }
	}
	return true;
    }

}
