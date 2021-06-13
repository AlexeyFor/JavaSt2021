package by.training.dal;

import by.training.entity.Matrix;
import by.training.entity.MyArray;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         To simplify further implementation, we use this interface. readFile
 *         (String path) - get path to the file and return the Matrix <T extends
 *         Number> obj saveInFile ( Matrix <T extends Number> matrix, String
 *         path) -save Matrix <T extends Number> to the path
 */
public interface WorkWithFileMatrixInterface<T extends Number> {

	Matrix<T> readFile(String path) throws DALException;

	boolean saveInFile(Matrix<T> matrix, String path) throws DALException;
}
