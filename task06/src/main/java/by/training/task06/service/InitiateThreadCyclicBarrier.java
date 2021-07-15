package by.training.task06.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task06.dal.DALException;
import by.training.task06.dal.DALProvider;
import by.training.task06.dal.FileReaderInterface;
import by.training.task06.entity.MatrixForThreads;
import by.training.task06.entity.ThreadCyclicBarrier;

public class InitiateThreadCyclicBarrier {

    private InitiateThreadCyclicBarrier() {
    }

    private static class SingletonHolder {
	public static final InitiateThreadCyclicBarrier HOLDER_INSTANCE = new InitiateThreadCyclicBarrier();
    }

    public static InitiateThreadCyclicBarrier getInstance() {
	return SingletonHolder.HOLDER_INSTANCE;
    }

    private static final Logger LOG = LogManager.getLogger(InitiateThreadCyclicBarrier.class);

    private DALProvider provider = DALProvider.getInstance();
    private FileReaderInterface reader = provider.getWorkWithFile();

    /**
     * return List of ThreadCyclicBarrier
     * 
     * @param path          - path to the file with array
     * @param threadsNumber - number of threads
     * @param matrix        - number of arrays in matrix
     * @return List <ThreadCyclicBarrier>
     * @throws ServiceException
     */
    public List<ThreadCyclicBarrier> takeThreadsFromFile(String path, int threadsNumber,
	    MatrixForThreads matrix) throws ServiceException {

	LOG.debug(
		"start takeThreadsFromFile with path " + path + " threadsNumber " + threadsNumber);
	List<ThreadCyclicBarrier> result = new ArrayList<>();

	try {
	    List<String> threadsInStr = reader.readFileList(path);

	    for (int i = 0; i < threadsNumber; i++) {
		result.add(createCyclicBarrierFromString(threadsInStr.get(i), matrix));
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
    private ThreadCyclicBarrier createCyclicBarrierFromString(String str, MatrixForThreads matrix)
	    throws ServiceException {

	try {
	    ThreadCyclicBarrier result;
	    int fieldNumber = Integer.valueOf(str);
	    result = new ThreadCyclicBarrier(fieldNumber, matrix);
	    return result;
	} catch (NumberFormatException e) {
	    throw new ServiceException("wrong_data_in_file");
	}
    }
}
