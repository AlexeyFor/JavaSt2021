package by.training.dal;

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

	public <T> WorkWithFileInterface<T> getWorkFile() {
		return new WorkWithFile<>();
	}

	public <T extends Number> WorkWithFileMatrixInterface<T> getWorkFileMatrix() {
		return new WorkWithFileMatrix<>();
	}

}
