package by.training.task06.view;

import by.training.task06.entity.MatrixForThreads;

public class MatrixForThreadsView {

    /**
     * show only Value of MatrixMember of MatrixForThreads
     * 
     * @param matrix
     */
    public void showMatrixValue(MatrixForThreads matrix) {
	int tmp;

	for (int i = 0; i < matrix.getMatrixLength(); i++) {
	    for (int j = 0; j < matrix.getMatrixLength(); j++) {
		tmp = matrix.getMatrixMember(i, j).getValue();
		System.out.print(tmp);
		System.out.print("  ");
	    }
	    System.out.println("");
	}
    }

    /**
     * show only Counter of MatrixMember of MatrixForThreads
     * 
     * @param matrix
     */
    public void showMatrixCounter(MatrixForThreads matrix) {

	int tmp;

	for (int i = 0; i < matrix.getMatrixLength(); i++) {
	    for (int j = 0; j < matrix.getMatrixLength(); j++) {
		tmp = matrix.getMatrixMember(i, j).getCounter();
		System.out.print(tmp);
		System.out.print("  ");
	    }
	    System.out.println("");
	}
    }
}
