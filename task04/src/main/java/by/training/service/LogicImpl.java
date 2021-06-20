package by.training.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import by.training.dal.DALException;
import by.training.dal.WorkWithFileImpl;
import by.training.entity.Car;

/**
 * Common logic
 * @author AlexeySupruniuk
 *
 */
public class LogicImpl implements Logic {

	private static final Logger LOG = LogManager.getLogger(LogicImpl.class);
	WorkWithFileImpl workFile = WorkWithFileImpl.getInstance();
	ObjectMapper mp = new ObjectMapper();
	
	private static final LogicImpl instance = new LogicImpl();

	private LogicImpl() {
	}

	public static LogicImpl getInstance() {
		return instance;
	}

	/**
	 * From JSON in .txt to Car
	 */
	@Override
	public Car takeCarFromFile(String path) throws ServiceException {
		LOG.debug("start takeCarFromFile with " + path);
		try {
			String carJSON;
			carJSON = workFile.readFileString(path);
			Car car = mp.readValue(carJSON, Car.class);
			return car;
		} catch (DALException e) {
			throw new ServiceException(e.getMessage());
		} catch (JsonMappingException e) {
			throw new ServiceException("worng_JSON", e);
		} catch (JsonProcessingException e) {
			throw new ServiceException("worng_JSON", e);
		}
	}

	/**
	 * Save Car in JSON format in .txt
	 */
	@Override
	public boolean saveCarInFile(Car car, String path) throws ServiceException {
		LOG.debug("start saveCarInFile with " + path);
		boolean answer;
		try {
			String carJSON = mp.writeValueAsString(car);
			answer = workFile.writeInFile(carJSON, path);
			return answer;
		} catch (JsonProcessingException e) {
			throw new ServiceException("worng_JSON", e);
		} catch (DALException e) {
			throw new ServiceException(e.getMessage());

		}
	}

}
