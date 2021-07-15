package by.training.task06.dal;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         provider for DAL
 * @see WorkWithFileInterface<T>
 * @param <T>
 */
public class DALProvider {

    private DALProvider() {
    }

    private static class SingletonHolder {
	public static final DALProvider HOLDER_INSTANCE = new DALProvider();
    }

    public static DALProvider getInstance() {
	return SingletonHolder.HOLDER_INSTANCE;
    }

    public FileReaderInterface getWorkWithFile() {
	return FileReaderImpl.getInstance();
    }

}
