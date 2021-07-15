package by.training.task06.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task06.entity.MatrixForThreads;
import by.training.task06.service.ServiceException;
import by.training.task06.service.ThreadCyclicBarrierService;
import by.training.task06.service.ThreadLockService;
import by.training.task06.view.MatrixForThreadsView;

/**
 * 
 *@author AlexeySupruniuk
 *
 *	util class for mor accurate debugging
 */
public class CheckThreadsSleep {

    private static final Logger LOG = LogManager.getLogger(CheckThreadsSleep.class);

    public static void main(String[] args) throws ServiceException, IOException {
	String pathArray = System.getProperty("user.dir") + "//array.txt";
	String pathThreads = System.getProperty("user.dir") + "//threads.txt";
	ArrayList<Boolean> list = new ArrayList<Boolean>();
	MatrixForThreadsView view = new MatrixForThreadsView();

	ThreadCyclicBarrierService barrier = new ThreadCyclicBarrierService();

	int numberOfChecking = 1;
	for (int i = 0; i < numberOfChecking; i++) {
	    int numbersOfThreads = 99;
	    int arrays = 250;
	    MatrixForThreads matrix = barrier.threadCyclicBarrierAction(pathArray, arrays,
		    pathThreads, numbersOfThreads);
	    view.showMatrixValue(matrix);
	    System.out.println("/////////////////////////////////");
	    System.out.println("/////////////////////////////////");

//	MatrixForThreads matrix1 = new ThreadSleepService().ThreadSleepAction(pathArray, arrays,
//		pathThreads, numbersOfThreads);
//	MatrixForThreads matrix2 = new ThreadSleepService().ThreadSleepAction(pathArray, arrays,
//		pathThreads, numbersOfThreads);
//	MatrixForThreads matrix3 = new ThreadSleepService().ThreadSleepAction(pathArray, arrays,
//		pathThreads, numbersOfThreads);
//	MatrixForThreads matrix4 = new ThreadSleepService().ThreadSleepAction(pathArray, arrays,
//		pathThreads, numbersOfThreads);
//	MatrixForThreads matrix5 = new ThreadSleepService().ThreadSleepAction(pathArray, arrays,
//		pathThreads, numbersOfThreads);
//	MatrixForThreads matrix6 = new ThreadSleepService().ThreadSleepAction(pathArray, arrays,
//		pathThreads, numbersOfThreads);
//	MatrixForThreads matrix7 = new ThreadSleepService().ThreadSleepAction(pathArray, arrays,
//		pathThreads, numbersOfThreads);
//	MatrixForThreads matrix8 = new ThreadSleepService().ThreadSleepAction(pathArray, arrays,
//		pathThreads, numbersOfThreads);
	    saveMatrix(matrix);
//	MatrixForThreads matrix1 = new ThreadSleepService().ThreadSleepAction(pathArray, 250,
//		pathThreads, 50);
////	saveMatrix(matrix);
//	MatrixForThreads matrix2 = new ThreadSleepService().ThreadSleepAction(pathArray, 100,
//		pathThreads, 1);
////	saveMatrix(matrix);
//	MatrixForThreads matrix3 = new ThreadSleepService().ThreadSleepAction(pathArray, 200,
//		pathThreads, 90);
//	saveMatrix(matrix);

//	    System.out.println(checkMatrixDiagonalCounter(matrix));
//	    System.out.println(checkMatrixDiagonalValue(matrix));
	    list.add(checkMatrixDiagonalCounter(matrix));
	    list.add(checkMatrixDiagonalValue(matrix));

//	System.out.println(checkMatrixDiagonalCounter(matrix1));
//	System.out.println(checkMatrixDiagonalCounter(matrix2));
//	System.out.println(checkMatrixDiagonalCounter(matrix3));
//	System.out.println(checkMatrixDiagonalCounter(matrix4));
//	System.out.println(checkMatrixDiagonalCounter(matrix5));
//	System.out.println(checkMatrixDiagonalCounter(matrix6));
//	System.out.println(checkMatrixDiagonalCounter(matrix7));
//	System.out.println(checkMatrixDiagonalCounter(matrix8));

//	System.out.println(checkMatrixDiagonalCounter(matrix1));
//	System.out.println(checkMatrixDiagonalCounter(matrix2));
//	System.out.println(checkMatrixDiagonalCounter(matrix3));
	}
	for (int i = 0; i < numberOfChecking * 2; i++) {
	    System.out.println(list.get(i).toString());
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

    /**
     * check, if all Counter of all diagonal MatrixMember of MatrixForThreads are
     * equals 1
     * 
     * @param matrix
     * @return
     */
    public static boolean checkMatrixDiagonalValue(MatrixForThreads matrix) {
	int tmp;
	int tmp2;

	int matrixLength = matrix.getMatrixLength();
	tmp = matrix.getMatrixMember(0, 0).getValue();

	for (int i = 0; i < matrixLength; i++) {

	    tmp2 = matrix.getMatrixMember(i, i).getValue();
	    if (tmp != tmp2) {
		return true;
	    }
	}
	LOG.debug("all members are the same! ");
	return false;
    }

    private static void saveMatrix(MatrixForThreads matrix) throws IOException {
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
    }
}
