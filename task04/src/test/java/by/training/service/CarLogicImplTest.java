package by.training.service;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.training.entity.Car;
import by.training.entity.Wheel;

public class CarLogicImplTest {

	ServiceProvider provider = ServiceProvider.getInstance();
	Logic logic = provider.getLogic();
	CarLogic tmp = provider.getCarLogic();
	private final String defaultPath = System.getProperty("user.dir") + "//src//test//java//by//training//source//";

	public Map<String, Car> getCars() throws ServiceException {
		Map<String, Car> cars = new HashMap<String, Car>();
		Car carWithoutTwoWheels = logic.takeCarFromFile(defaultPath + "carWithoutTwoWheels.txt");
		Car carWithoutOneWheel = logic.takeCarFromFile(defaultPath + "carWithoutOneWheel.txt");
		Car carWithoutWheels = logic.takeCarFromFile(defaultPath + "carWithoutWheels.txt");
		Car carWithoutEngine = logic.takeCarFromFile(defaultPath + "carWithoutEngine.txt");
		Car carWithoutWheelsEngine = logic.takeCarFromFile(defaultPath + "carWithoutWheelsEngine.txt");
		Car car1 = logic.takeCarFromFile(defaultPath + "car1.txt");
		Car carWithInfinityFuelVolume = logic.takeCarFromFile(defaultPath + "carWithInfinityFuelVolume.txt");
		Car carWithInfinityFuelConsumption = logic.takeCarFromFile(defaultPath + "carWithInfinityFuelConsumption.txt");
		Car carWithZeroFuelConsumption = logic.takeCarFromFile(defaultPath + "carWithZeroFuelConsumption.txt");
		Car carWithZeroFuelVolume = logic.takeCarFromFile(defaultPath + "carWithZeroFuelVolume.txt");
		Car carNull = null;

		cars.put("carWithoutTwoWheels", carWithoutTwoWheels);
		cars.put("carWithoutOneWheel", carWithoutOneWheel);
		cars.put("carWithoutWheels", carWithoutWheels);
		cars.put("carWithoutEngine", carWithoutEngine);
		cars.put("carWithoutWheelsEngine", carWithoutWheelsEngine);
		cars.put("car1", car1);
		cars.put("carWithInfinityFuelVolume", carWithInfinityFuelVolume);
		cars.put("carWithInfinityFuelConsumption", carWithInfinityFuelConsumption);
		cars.put("carWithZeroFuelConsumption", carWithZeroFuelConsumption);
		cars.put("carWithZeroFuelVolume", carWithZeroFuelVolume);
		cars.put("carNull", carNull);

		return cars;
	}

	@DataProvider(name = "ridePositiveTrue")
	public Object[][] ridePositiveTrue() throws ServiceException {
		Map<String, Car> cars = getCars();

		Car carWithoutTwoWheels = cars.get("carWithoutTwoWheels");
		Car carWithoutOneWheel = cars.get("carWithoutOneWheel");
		Car carWithoutWheels = cars.get("carWithoutWheels");
		Car carWithoutEngine = cars.get("carWithoutEngine");
		Car carWithoutWheelsEngine = cars.get("carWithoutWheelsEngine");
		Car car1 = cars.get("car1");
		Car carWithInfinityFuelVolume = cars.get("carWithInfinityFuelVolume");
		Car carWithInfinityFuelConsumption = cars.get("carWithInfinityFuelConsumption");
		Car carWithZeroFuelConsumption = cars.get("carWithZeroFuelConsumption");
		Car carWithZeroFuelVolume = cars.get("carWithZeroFuelVolume");

		return new Object[][] { { carWithoutTwoWheels, 0.0 }, { carWithoutOneWheel, 0.0 }, { carWithoutWheels, 0.0 },
				{ carWithoutEngine, 0.0 }, { carWithoutWheelsEngine, 0.0 }, { carWithInfinityFuelVolume, 0.0 },
				{ car1, 0.0 }, { carWithInfinityFuelConsumption, 0.0 }, { carWithZeroFuelConsumption, 0.0 },
				{ carWithZeroFuelVolume, 0.0 }, { carWithoutOneWheel, 10.0 }, { car1, 10.0 },
				{ carWithInfinityFuelVolume, 10.0 }, { carWithZeroFuelConsumption, 10.0 } };
	}

	@DataProvider(name = "ridePositiveFalse")
	public Object[][] ridePositiveFalse() throws ServiceException {
		Map<String, Car> cars = getCars();

		Car carWithoutTwoWheels = cars.get("carWithoutTwoWheels");
		Car carWithoutWheels = cars.get("carWithoutWheels");
		Car carWithoutEngine = cars.get("carWithoutEngine");
		Car carWithoutWheelsEngine = cars.get("carWithoutWheelsEngine");
		Car car1 = cars.get("car1");
		Car carWithInfinityFuelConsumption = cars.get("carWithInfinityFuelConsumption");
		Car carWithZeroFuelVolume = cars.get("carWithZeroFuelVolume");

		return new Object[][] { { carWithoutTwoWheels, 10.0 }, { carWithoutWheels, 10.0 }, { carWithoutEngine, 10.0 },
				{ carWithoutWheelsEngine, 10.0 }, { car1, 10000.0 }, { carWithInfinityFuelConsumption, 10.0 },
				{ carWithZeroFuelVolume, 10.0 } };
	}

	@DataProvider(name = "refuelPositiveTrue")
	public Object[][] refuelPositiveTrue() throws ServiceException {
		Map<String, Car> cars = getCars();

		Car carWithoutTwoWheels = cars.get("carWithoutTwoWheels");
		Car carWithoutOneWheel = cars.get("carWithoutOneWheel");
		Car carWithoutWheels = cars.get("carWithoutWheels");
		Car carWithoutEngine = cars.get("carWithoutEngine");
		Car carWithoutWheelsEngine = cars.get("carWithoutWheelsEngine");
		Car car1 = cars.get("car1");
		Car carWithInfinityFuelVolume = cars.get("carWithInfinityFuelVolume");
		Car carWithInfinityFuelConsumption = cars.get("carWithInfinityFuelConsumption");
		Car carWithZeroFuelConsumption = cars.get("carWithZeroFuelConsumption");
		Car carWithZeroFuelVolume = cars.get("carWithZeroFuelVolume");

		return new Object[][] { { carWithoutTwoWheels, 0.0 }, { carWithoutOneWheel, 0.0 }, { carWithoutWheels, 0.0 },
				{ carWithoutEngine, 0.0 }, { carWithoutWheelsEngine, 0.0 }, { carWithInfinityFuelVolume, 0.0 },
				{ car1, 0.0 }, { carWithInfinityFuelConsumption, 0.0 }, { carWithZeroFuelConsumption, 0.0 },
				{ carWithZeroFuelVolume, 0.0 }, { carWithoutTwoWheels, 10.0 }, { carWithoutOneWheel, 10.0 },
				{ carWithoutWheels, 10.0 }, { carWithoutEngine, 10.0 }, { carWithoutWheelsEngine, 10.0 },
				{ carWithInfinityFuelVolume, 10.0 }, { car1, 10.0 }, { carWithInfinityFuelConsumption, 10.0 },
				{ carWithZeroFuelConsumption, 10.0 }, { car1, 40.0 } };
	}

	@DataProvider(name = "refuelPositiveFalse")
	public Object[][] refuelPositiveFalse() throws ServiceException {
		Map<String, Car> cars = getCars();

		Car carWithoutEngine = cars.get("carWithoutEngine");

		return new Object[][] { { carWithoutEngine, 1000.0 } };
	}

	@DataProvider(name = "changeWheelPositiveTrue")
	public Object[][] changeWheelTrue() throws ServiceException {
		Map<String, Car> cars = getCars();

		Car carWithoutTwoWheels = cars.get("carWithoutTwoWheels");
		Car carWithoutOneWheel = cars.get("carWithoutOneWheel");
		Car carWithoutWheels = cars.get("carWithoutWheels");
		Car carWithoutEngine = cars.get("carWithoutEngine");
		Car carWithoutWheelsEngine = cars.get("carWithoutWheelsEngine");
		Car car1 = cars.get("car1");

		Wheel wheel = new Wheel(15.0, "Summer");
		return new Object[][] { { carWithoutTwoWheels, wheel, 3 }, { carWithoutOneWheel, wheel, 3 },
				{ carWithoutWheels, wheel, 3 }, { carWithoutEngine, wheel, 3 }, { carWithoutWheelsEngine, wheel, 3 },
				{ car1, wheel, 3 }, };
	}

	@Test(description = "positive for ride (true)", dataProvider = "ridePositiveTrue")
	public void rideTrueTest(Car car, double distance) throws ServiceException {
		boolean result = tmp.ride(car, distance);
		assertTrue(result);
	}

	@Test(description = "positive for ride (false)", dataProvider = "ridePositiveFalse")
	public void rideFalseTest(Car car, double distance) throws ServiceException {
		boolean result = tmp.ride(car, distance);
		assertFalse(result);
	}

	@Test(description = "positive for refuel (true)", dataProvider = "refuelPositiveTrue")
	public void refuelTrueTest(Car car, double fuel) throws ServiceException {
		boolean result = tmp.refuel(car, fuel);
		assertTrue(result);
	}

	@Test(description = "positive for refuel (false)", dataProvider = "refuelPositiveFalse")
	public void refuelFalseTest(Car car, double fuel) throws ServiceException {
		boolean result = tmp.refuel(car, fuel);
		assertFalse(result);
	}

	@Test(description = "positive for changeWheel (true)", dataProvider = "changeWheelPositiveTrue")
	public void changeWheelTrueTest(Car car, Wheel wheel, int index) throws ServiceException {
		boolean result = tmp.changeWheel(car, wheel, index);
		assertTrue(result);
	}

	///////////// NEGATIVE TESTS
	@Test(description = "negative for ride (wrong car)", enabled = true, expectedExceptions = ServiceException.class)
	public void rideNegativeTest1() throws ServiceException {
		Car car = null;
		tmp.ride(car, 10.0);
	}

	@Test(description = "negative for ride (wrong distance)", enabled = true, expectedExceptions = ServiceException.class)
	public void rideNegativeTest2() throws ServiceException {
		Map<String, Car> cars = getCars();
		Car car1 = cars.get("car1");
		tmp.ride(car1, -10.0);
	}
	
	@Test(description = "negative for refuel (wrong fuel)", enabled = true, expectedExceptions = ServiceException.class)
	public void refuelNegativeTest1() throws ServiceException {
		Map<String, Car> cars = getCars();
		Car car1 = cars.get("car1");
		tmp.refuel(car1, -10.0);
	}
	
	@Test(description = "negative for refuel (wrong car)", enabled = true, expectedExceptions = ServiceException.class)
	public void refuelNegativeTest2() throws ServiceException {
		Car car = null;
		tmp.refuel(car, -10.0);
	}
	
	@Test(description = "negative for refuel (wrong index)", enabled = true, expectedExceptions = ServiceException.class)
	public void changeWheelNegativeTest1() throws ServiceException {
		Map<String, Car> cars = getCars();
		Car car1 = cars.get("car1");
		Wheel wheel = new Wheel (1.0, "ph");
		tmp.changeWheel(car1, wheel, 5);
	}
	
	@Test(description = "negative for refuel (wrong car)", enabled = true, expectedExceptions = ServiceException.class)
	public void changeWheelNegativeTest2() throws ServiceException {
		Car car = null;
		Wheel wheel = new Wheel (1.0, "ph");
		tmp.changeWheel(car, wheel, 2);
	}
	
	@Test(description = "negative for refuel (wrong wheel)", enabled = true, expectedExceptions = ServiceException.class)
	public void changeWheelNegativeTest3() throws ServiceException {
		Map<String, Car> cars = getCars();
		Car car1 = cars.get("car1");
		Wheel wheel = null;
		tmp.changeWheel(car1, wheel, 0);
	}

}
