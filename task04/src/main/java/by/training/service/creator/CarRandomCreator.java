package by.training.service.creator;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.dal.DALException;
import by.training.dal.WorkWithFileImpl;

import by.training.entity.Car;
import by.training.entity.Engine;
import by.training.entity.Wheel;
import by.training.service.ServiceException;

/**
 * A class for creating an object type Car with random field assignments (values
 * are taken from text documents)
 * 
 * @author AlexeySupruniuk
 *
 */
public final class CarRandomCreator {

	private static final Logger LOG = LogManager.getLogger(CarRandomCreator.class);
	private static final CarRandomCreator instance = new CarRandomCreator();

	private CarRandomCreator() {
	}

	public static CarRandomCreator getInstance() {
		return instance;
	}

	private List<String> carModels = new ArrayList<>();
	private List<String> carMarks = new ArrayList<>();
	private List<String> wheelTypes = new ArrayList<>();
	private List<String> engineTypes = new ArrayList<>();

	private double[] wheelDiameter = { 15.0, 15.5, 16.0, 16.5, 17.0, 17.5, 18.0, 18.5, 19, 19.5, 20.0 };
	private double[] fuelConsumptionPerHundred = { 5.0, 5.5, 6.0, 6.5, 7.0, 7.5, 8.0, 8.5, 9, 9.5, 10.0 };

	WorkWithFileImpl workFile = WorkWithFileImpl.getInstance();

	/**
	 * Set default data for all arrays, (to create random Car)
	 * 
	 * @throws ServiceException
	 */
	public void setDefaultData() throws ServiceException {
		LOG.debug("start setDefaultData");
		final String path = System.getProperty("user.dir") + "//src//main//java//by//training//source//defaultData";
		try {
			carModels = workFile.readFileList(path + "//" + "CarModels.txt");
			carMarks = workFile.readFileList(path + "//" + "CarMarks.txt");
			wheelTypes = workFile.readFileList(path + "//" + "WheelTypes.txt");
			engineTypes = workFile.readFileList(path + "//" + "EngineTypes.txt");
		} catch (DALException e) {
			LOG.warn("wrong path to the file");
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * create an object type Car with random field assignments (values are taken
	 * from text documents)
	 * 
	 * @return Car
	 */
	public Car createRandomCar() {
		Car car = new Car();
		setRandomWheels(car);
		setRandomEngine(car);
		car.setMark(randomFromList(carMarks));
		car.setModel(randomFromList(carModels));
		return car;

	}

	/**
	 * create an object type Car with random field assignments (values are taken
	 * from text documents). Has all fields except wheels
	 * 
	 * @return car
	 */
	public Car createRandomCarWithoutWheels() {
		Car car = new Car();
		setRandomEngine(car);
		car.setMark(randomFromList(carMarks));
		car.setModel(randomFromList(carModels));
		return car;
	}

	/**
	 * create an object type Car with random field assignments (values are taken
	 * from text documents). Has all fields except engine
	 * 
	 * @return
	 */
	public Car createRandomCarWithoutEngine() {
		Car car = new Car();
		setRandomWheels(car);
		car.setMark(randomFromList(carMarks));
		car.setModel(randomFromList(carModels));
		return car;

	}

	/**
	 * create an object type Car with random field assignments (values are taken
	 * from text documents). Has all fields except wheels, engine
	 * 
	 * @return
	 */
	public Car createRandomCarWithoutWheelsEngine() {
		Car car = new Car();
		car.setMark(randomFromList(carMarks));
		car.setModel(randomFromList(carModels));
		return car;

	}

	private String randomFromList(List<String> list) {
		String result;
		int randNumber = (int) (Math.random() * list.size());
		result = list.get(randNumber);
		return result;
	}

	private double randomFromDoubleArray(double[] array) {
		double result;
		int randNumber = (int) (Math.random() * array.length);
		result = array[randNumber];
		return result;
	}

	private void setRandomWheels(Car car) {
		double diameter = randomFromDoubleArray(this.wheelDiameter);
		String type = randomFromList(wheelTypes);
		for (int i = 0; i < 4; i++) {
			car.setWheel(new Wheel(diameter, type), i);
		}
	}

	private void setRandomEngine(Car car) {
		double fuelConsumptionPerHundred = randomFromDoubleArray(this.fuelConsumptionPerHundred);
		String type = randomFromList(engineTypes);
		car.setEngine(new Engine(fuelConsumptionPerHundred, type));
	}

}
