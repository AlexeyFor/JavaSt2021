package by.training.service.creator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.training.entity.Engine;
import by.training.entity.Wheel;
import by.training.service.ServiceException;

public class CarCreatorTest {

	CarCreator tmp = new CarCreator();

	@DataProvider(name = "createCar")
	public Object[][] createCar() {
		return new Object[][] { { "mark", "model", 101.0, 100.0 }, { "mark", "model", -90.0, 100.0 },
				{ "mark", "model", 1.0, -100.0 }, { "mark", "model", -1.0, -100.0 } };
	}

	@DataProvider(name = "createCarWithWeelsEngine")
	public Object[][] createCarWithWeelsEngine() {
		Wheel[] wheels = new Wheel[4];
		Wheel[] wheelsWrong = new Wheel[5];
		Engine engine = new Engine();
		return new Object[][] { { "mark", "model", 101.0, 100.0, engine, wheels },
				{ "mark", "model", -90.0, 100.0, engine, wheels }, { "mark", "model", 1.0, -100.0, engine, wheels },
				{ "mark", "model", -1.0, -100.0, engine, wheels },
				{ "mark", "model", -1.0, -100.0, engine, wheelsWrong } };
	}

	@Test(description = "negative for createCar", dataProvider = "createCar", enabled = true, expectedExceptions = ServiceException.class)
	public void createCarNegativeTest(String mark, String model, double fuelVolume, double MAX_FUEL_VOLUME)
			throws ServiceException {
		tmp.createCar(mark, model, fuelVolume, MAX_FUEL_VOLUME);
	}

	@Test(description = "negative for createCar (with wheels and engine)", dataProvider = "createCarWithWeelsEngine", enabled = true, expectedExceptions = ServiceException.class)
	public void createCarNegativeTest(String mark, String model, double fuelVolume, double MAX_FUEL_VOLUME,
			Engine engine, Wheel[] wheels) throws ServiceException {
		tmp.createCar(mark, model, fuelVolume, MAX_FUEL_VOLUME, engine, wheels);
	}

}
