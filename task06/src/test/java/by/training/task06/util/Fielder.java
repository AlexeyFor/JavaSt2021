package by.training.task06.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import by.training.task06.entity.MatrixForThreads;
import by.training.task06.service.InitiateMatrixImpl;
import by.training.task06.service.ServiceException;
import by.training.task06.view.MatrixForThreadsView;

/**
 * 
 * @author AlexeySupruniuk
 * 
 * 	util class to field docs with array and threads
 *
 */
public class Fielder {

    public static void main(String[] args) throws IOException {

//	String path = "array.txt";
//	int numberOfArrays = 250;
//	File file = new File(path);
//
//	int[][] result = new int[numberOfArrays][numberOfArrays];
//
//	for (int i = 0; i < numberOfArrays; i++) {
//	    for (int j = 0; j < numberOfArrays; j++) {
//		result[i][j] = (int) ((Math.random() * 90) + 10);
//	    }
//	    result[i][i] = 0;
//	}
//
//	for (int i = 0; i < numberOfArrays; i++) {
//	    StringBuilder tmp = new StringBuilder("");
//	    for (int j = 0; j < numberOfArrays; j++) {
//		tmp.append(result[i][j]);
//		tmp.append("  ");
//	    }
//	    BufferedWriter writer = null;
//	    writer = new BufferedWriter(new FileWriter(file, true));
//	    writer.newLine();
//	    writer.write(tmp.toString());
//	    writer.close();
//
//	}

//	String path = "threads.txt";
//	int numberOfArrays = 99;
//	int startNumber = 101;
//	File file = new File(path);
//
//	int[] result = new int[numberOfArrays];
//
//	for (int j = 0; j < numberOfArrays; j++) {
//	    result[j] = startNumber + j;
//
//	}
//
//	for (int i = 0; i < numberOfArrays; i++) {
//	    StringBuilder tmp = new StringBuilder("");
//	    tmp.append(result[i]);
//
//	    BufferedWriter writer = null;
//	    writer = new BufferedWriter(new FileWriter(file, true));
//	    writer.newLine();
//	    writer.write(tmp.toString());
//	    writer.close();
//
//	}

	InitiateMatrixImpl ser = InitiateMatrixImpl.getInstance();
	MatrixForThreadsView view = new MatrixForThreadsView();

	try {
	    MatrixForThreads matrix = ser
		    .takeMatrixFromFile(System.getProperty("user.dir") + "//array.txt", 10);
//	    System.out.println(matrix);
	    view.showMatrixValue(matrix);

	    matrix.getMatrixMember(0, 0).setValue(987);
	    view.showMatrixValue(matrix);

	    view.showMatrixCounter(matrix);

	    System.out.println("oks");
	} catch (ServiceException e) {
	    e.printStackTrace();
	}

    }
}
