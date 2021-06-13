package by.training.dal;

import by.training.entity.MyArray;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         To simplify further implementation, we use this interface. readFile
 *         (String path) - get path to the file and return the MyArray obj
 *         saveInFile (MyArray<T> myArray, String path) -save MyArray <T> obj to
 *         the path
 */
public interface WorkWithFileInterface<T> {

	MyArray<T> readFile(String path) throws DALException;

	boolean saveInFile(MyArray<T> myArray, String path) throws DALException;
}
