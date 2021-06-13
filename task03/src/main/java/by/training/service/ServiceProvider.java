package by.training.service;

import by.training.service.sorting.*;

/**
 * 
 * @author AlexeySupruniuk
 *

 */

public class ServiceProvider {

	private static ServiceProvider instance = new ServiceProvider();

	private ServiceProvider() {
	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	private Sorting bubbleSorting = new BubbleSorting();
	private Sorting insertsSorting = new InsertsSorting();
	private Sorting selectionSorting = new SelectionSorting();
	private Sorting shakeSorting = new ShakeSorting();
	private Sorting shellSorting = new ShellSorting();
	private InsertsHashNumberSorting insertHashSorting = new InsertsHashNumberSorting();

	private MatrixCalculation matrixCalculation = new MatrixCalculationImpl();
	private Logic logic = new LogicImpl();

	public Sorting getBubbleSorting() {
		return bubbleSorting;
	}

	public Sorting getInsertsSorting() {
		return insertsSorting;
	}

	public Sorting getSelectionSorting() {
		return selectionSorting;
	}

	public Sorting getShakeSorting() {
		return shakeSorting;
	}

	public Sorting getShellSorting() {
		return shellSorting;
	}
	
	public InsertsHashNumberSorting getInsertsHashNumberSorting() {
		return insertHashSorting;
	}

	public MatrixCalculation getMatrixCalculation() {
		return matrixCalculation;
	}

	public Logic getLogic() {
		return logic;
	}

}
