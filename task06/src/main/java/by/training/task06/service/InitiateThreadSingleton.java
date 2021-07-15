package by.training.task06.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task06.dal.DALException;
import by.training.task06.dal.DALProvider;
import by.training.task06.dal.FileReaderInterface;
import by.training.task06.entity.MatrixForThreads;
import by.training.task06.entity.ThreadSingleton;

/**
 * 
 * @author AlexeySupruniuk
 *
 */
public class InitiateThreadSingleton {

    private InitiateThreadSingleton() {
    }

    private static class SingletonHolder {
	public static final InitiateThreadSingleton HOLDER_INSTANCE = new InitiateThreadSingleton();
    }

    public static InitiateThreadSingleton getInstance() {
	return SingletonHolder.HOLDER_INSTANCE;
    }

    private static final Logger LOG = LogManager.getLogger(InitiateThreadSingleton.class);

    private DALProvider provider = DALProvider.getInstance();
    private FileReaderInterface reader = provider.getWorkWithFile();

    /**
     * return List of ThreadSingleton
     * 
     * @param path          - path to the file with array
     * @param threadsNumber - number of threads
     * @param matrix        - number of arrays in matrix
     * @return List <ThreadSleep>
     * @throws ServiceException
     */
    public List<ThreadSingleton> takeThreadsFromFile(String path, int threadsNumber,
	    MatrixForThreads matrix) throws ServiceException {

	LOG.debug(
		"start takeThreadsFromFile with path " + path + " threadsNumber " + threadsNumber);
	List<ThreadSingleton> result = new ArrayList<ThreadSingleton>();

	try {
	    List<String> threadsInStr = reader.readFileList(path);

	    for (int i = 0; i < threadsNumber; i++) {
		result.add(createThreadSingletonFromString(threadsInStr.get(i), matrix));
	    }

	    return result;
	} catch (DALException e) {
	    throw new ServiceException(e.getMessage());
	}
    }

    /**
     * 
     * @param str (must contain only int number, otherwise - throw exception)
     * @return
     * @throws ServiceException
     */
    private ThreadSingleton createThreadSingletonFromString(String str, MatrixForThreads matrix)
	    throws ServiceException {

	try {
	    ThreadSingleton result;
	    int fieldNumber = Integer.valueOf(str);
	    result = new ThreadSingleton(matrix, fieldNumber);
	    return result;
	} catch (NumberFormatException e) {
	    throw new ServiceException("wrong_data_in_file");
	}
    }
}
