package by.training.dal;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
public class WorkWithFile<T> implements WorkWithFileInterface<T> {

	private static final Logger LOG = LogManager.getLogger(WorkWithFile.class);

	/**
	 * take path to the file read it, and return MyArray<T> object
	 */
	public MyArray<T> readFile(String path) throws DALException {
		LOG.debug("start readFile() with path " + path);
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(path);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			MyArray<T> myArray = (MyArray<T>) objectInputStream.readObject();
			objectInputStream.close();
			LOG.debug("return MyArray ");
			return myArray;
		} catch (FileNotFoundException e) {
			throw new DALException("wrong_path", e);
		} catch (IOException e) {
			throw new DALException("damaged_file", e);
		} catch (ClassNotFoundException e) {
			throw new DALException("class_error", e);
		}
	}

	/**
	 * take MyArray <T> object, and save it in the file along the path
	 */
	public boolean saveInFile(MyArray<T> myArray, String path) throws DALException {
		LOG.debug("start saveInFile() with path " + path);

		try {
			FileOutputStream outputStream = new FileOutputStream(path);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(myArray);
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
