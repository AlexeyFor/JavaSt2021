package by.training.dal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.Matrix;
import by.training.entity.MyArray;

/**
 * 
 * @author AlexeySupruniuk
 *
 *         All logics with files - read MyArray from file, save in file.
 *         Everything through serialization
 *
 * @param <T>
 */
public class WorkWithFileMatrix<T extends Number> implements WorkWithFileMatrixInterface<T> {

	private static final Logger LOG = LogManager.getLogger(WorkWithFile.class);

	/**
	 * take path to the file read it, and return MyArray<T> object
	 */
	public Matrix<T> readFile(String path) throws DALException {
		LOG.debug("start readFile() with path " + path);
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(path);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Matrix<T> matrix = (Matrix<T>) objectInputStream.readObject();
			objectInputStream.close();
			LOG.debug("return Matrix ");
			return matrix;
		} catch (FileNotFoundException e) {
			throw new DALException("wrong_path", e);
		} catch (IOException e) {
			throw new DALException("damaged_file", e);
		} catch (ClassNotFoundException e) {
			throw new DALException("class_error", e);
		}
	}

	/**
	 * take Matrix<T> object, and save it in the file along the path
	 */
	public boolean saveInFile(Matrix<T> matrix, String path) throws DALException {
		LOG.debug("start saveInFile() with path " + path);

		try {
			FileOutputStream outputStream = new FileOutputStream(path);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(matrix);
			objectOutputStream.close();
			LOG.debug("file saved successfully");
			return true;

		} catch (FileNotFoundException e) {
			throw new DALException("wrong_path", e);
		} catch (IOException e) {
			throw new DALException("damaged_file", e);
		}
	}

}
