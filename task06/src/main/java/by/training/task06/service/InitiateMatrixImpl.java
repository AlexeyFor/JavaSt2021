package by.training.task06.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task06.dal.DALException;
import by.training.task06.dal.DALProvider;
import by.training.task06.dal.FileReaderImpl;
import by.training.task06.dal.FileReaderInterface;
import by.training.task06.entity.MatrixForThreads;
import by.training.task06.entity.MatrixMember;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         Logics for initiating MatrixForThreads
 *
 */
public class InitiateMatrixImpl {

    private InitiateMatrixImpl() {
    }

    private static class SingletonHolder {
	public static final InitiateMatrixImpl HOLDER_INSTANCE = new InitiateMatrixImpl();
    }

    public static InitiateMatrixImpl getInstance() {
	return SingletonHolder.HOLDER_INSTANCE;
    }

    private static final Logger LOG = LogManager.getLogger(InitiateMatrixImpl.class);

    private DALProvider provider = DALProvider.getInstance();
    private FileReaderInterface reader = provider.getWorkWithFile();

    /**
     * 
     * @param path
     * @param arraysNumber
     * @return
     * @throws ServiceException
     */
    public MatrixForThreads takeMatrixFromFile(String path, int arraysNumber)
	    throws ServiceException {

	LOG.debug("start takeMatrixFromFile with path " + path + " arraysNumber " + arraysNumber);
	MatrixForThreads resultMatrix;
	MatrixMember[][] tmpMatrix = new MatrixMember[arraysNumber][arraysNumber];

	try {
	    List<String> matrixInStr = reader.readFileList(path);
	    String[] arrayMembers;

	    for (int i = 0; i < arraysNumber; i++) {
		arrayMembers = matrixInStr.get(i).split("  ");
		for (int j = 0; j < arraysNumber; j++) {
		    tmpMatrix[i][j] = createMatrixMemberFromString(arrayMembers[j]);
		}
	    }

	    resultMatrix = new MatrixForThreads(tmpMatrix);
	    return resultMatrix;
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
    private MatrixMember createMatrixMemberFromString(String str) throws ServiceException {

	try {
	    int number = Integer.valueOf(str);
	    MatrixMember result = new MatrixMember(number);
	    return result;
	} catch (NumberFormatException e) {
	    throw new ServiceException("wrong_data_in_file");

	}

    }
}
