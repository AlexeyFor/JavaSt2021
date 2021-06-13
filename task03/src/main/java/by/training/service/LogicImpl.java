package by.training.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.dal.DALException;
import by.training.dal.DALProvider;
import by.training.dal.WorkWithFileInterface;
import by.training.dal.WorkWithFileMatrixInterface;
import by.training.entity.Matrix;
import by.training.entity.MyArray;

/**
 * Universal logics for MyArray<T>
 * 
 * @author AlexeySupruniuk
 *
 * @param <T>
 */
public class LogicImpl implements Logic {

	private static final Logger LOG = LogManager.getLogger(Logic.class);

	/**
	 * return MyArray <T> from file on the path
	 */
	public <T> MyArray<T> takeMyArray(String path) throws ServiceException {
		LOG.debug("start takeMyArray with path " + path);
		MyArray<T> result;
		DALProvider dal = DALProvider.getInstance();

		try {
			WorkWithFileInterface<T> workFile = dal.getWorkFile();
			result = workFile.readFile(path);
			return result;
		} catch (DALException e) {
			LOG.error("can't take MyArray from file");
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * save MyArray <T> in file on the path, if successfully - return true
	 */
	public <T> boolean saveMyArray(MyArray<T> array, String path) throws ServiceException {
		LOG.debug("start saveMyArray with path" + path);
		boolean result;
		DALProvider dal = DALProvider.getInstance();

		try {
			WorkWithFileInterface<T> workFile = dal.getWorkFile();
			result = workFile.saveInFile(array, path);
			return result;
		} catch (DALException e) {
			LOG.error("can't save MyArray in file");
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * return Matrix <T> from file on the path
	 */
	public <T extends Number> Matrix<T> takeMatrix(String path) throws ServiceException {
		LOG.debug("start takeMyArray with path " + path);
		Matrix<T> result;
		DALProvider dal = DALProvider.getInstance();

		try {
			WorkWithFileMatrixInterface<T> workFile = dal.getWorkFileMatrix();
			result = workFile.readFile(path);
			return result;
		} catch (DALException e) {
			LOG.error("can't take Matrix from file");
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * save Matrix <T> in file on the path, if successfully - return true
	 */
	public <T extends Number> boolean saveMatrix(Matrix<T> matrix, String path) throws ServiceException {
		LOG.debug("start saveMatrix with path" + path);
		boolean result;
		DALProvider dal = DALProvider.getInstance();

		try {
			WorkWithFileMatrixInterface<T> workFile = dal.getWorkFileMatrix();
			result = workFile.saveInFile(matrix, path);
			return result;
		} catch (DALException e) {
			LOG.error("can't save Matrix in file");
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
