package by.training.task07.dal;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         provider for DAL
 * @see WorkWithFileInterface<T>
 * @param <T>
 */
public class DALProvider {

	private static DALProvider instance = new DALProvider();

	private DALProvider() {
	}

	public static DALProvider getInstance() {
		return instance;
	}

	public  WorkWithFile getWorkWithFile() {
		return WorkWithFileImpl.getInstance();
	}

	
}
