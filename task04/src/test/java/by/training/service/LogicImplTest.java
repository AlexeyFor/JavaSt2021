package by.training.service;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.training.dal.DALException;
import by.training.dal.DALProvider;
import by.training.dal.WorkWithFile;
import by.training.entity.Car;
import by.training.entity.Engine;
import by.training.entity.Wheel;
import by.training.service.creator.CarCreator;
import by.training.service.creator.EngineCreator;
import by.training.service.creator.WheelCreator;

public class LogicImplTest {
	
	ServiceProvider provider = ServiceProvider.getInstance();
	Logic temp = provider.getLogic();
	
	private final String defaultPath = System.getProperty("user.dir") + "//src//test//java//by//training//source//";
	CarCreator carCreator = new CarCreator();
	WheelCreator wheelCreator = new WheelCreator();
	EngineCreator engineCreator = new EngineCreator();

	
	@DataProvider(name = "takeCarFromFile")
	public Object[][] createCar() throws ServiceException {
		Wheel[] wheels1 = wheelCreator.createArrayOfSameWheels(4, 19.5, "All-season");
		Engine engine1 = engineCreator.createEngine(9.0, "Steam engine");
		Car carWithInfinity = carCreator.createCar("Great Wall", "universal", 50.0, Double.POSITIVE_INFINITY, engine1,
				wheels1);

		Wheel[] wheels2 = wheelCreator.createArrayOfSameWheels(3, 15.0, "Summer");
		Engine engine2 = engineCreator.createEngine(9.0, "Electric motors");
		Car carWithNaNNul = carCreator.createCar("Chevrolet", "simple", 50.0, 100.0, engine2, wheels2);

		return new Object[][] { { carWithInfinity, "carWithInfinityFuelVolume.txt" },
				{ carWithNaNNul, "carWithoutOneWheel.txt" }, };
	}
	
	@Test(description = "positive for takeCarFromFile",  dataProvider = "takeCarFromFile")
	public void takeCarFromFileTest(Car car, String name) throws ServiceException {
		String fileName = defaultPath + name;
		Car actual = temp.takeCarFromFile(fileName);
		Car expected = car;
		assertEquals(expected, actual);
	}
	
	@Test(description = "negative for takeCarFromFile (Wrong path)",  enabled = true, expectedExceptions = ServiceException.class)
	public void takeCarFromFileNegativeTest1()
			throws ServiceException {
		temp.takeCarFromFile("wrongPath//");
	}
	
	@Test(description = "negative for takeCarFromFile (Wrong file)",  enabled = true, expectedExceptions = ServiceException.class)
	public void takeCarFromFileNegativeTest2()
			throws ServiceException {
		String fileName = defaultPath + "wrong in MAX_FUEL.txt";
		temp.takeCarFromFile(fileName);
	}
	
	@Test(description = "negative for saveCarInFile (Wrong path)",  enabled = true, expectedExceptions = ServiceException.class)
	public void saveCarInFileNegativeTest()
			throws ServiceException {
		Car car = new Car ();
		String fileName = System.getProperty("user.dir") + "//src//test//java//by//WRONG//dal//wrong.txt";
		temp.saveCarInFile(car, fileName);
	}
	
	
}
