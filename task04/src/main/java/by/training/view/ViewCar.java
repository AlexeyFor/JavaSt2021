package by.training.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.entity.Car;

/**
 * View Car objects
 * 
 * @author AlexeySupruniuk
 *
 */
public class ViewCar {

	private static final Logger LOG = LogManager.getLogger(ViewCar.class);
	private static final ViewCar instance = new ViewCar();

	private ViewCar() {
	}

	public static ViewCar getInstance() {
		return instance;
	}

	public void viewCar(Car car) {
		if (car == null) {
			System.out.println("null");
		}
		LOG.debug("start viewCar");
		String markModel = "mark: " + car.getMark() + " , model: " + car.getModel();
		String engine = "engine: " + car.getEngineType() + " , Fuel consumption per hundred: "
				+ car.getEngineFuelConsumptionPerHundred();

		StringBuilder wheels = new StringBuilder(
				"wheel 1: " + car.getWheelDiameter(0) + " ,type " + car.getWheelType(0));
		wheels.append(" , wheel 2: " + car.getWheelDiameter(1) + " ,type " + car.getWheelType(1));
		wheels.append(" , wheel 3: " + car.getWheelDiameter(2) + " ,type " + car.getWheelType(2));
		wheels.append(" , wheel 4: " + car.getWheelDiameter(3) + " ,type " + car.getWheelType(3));

		String fuel = "fuel volume: " + car.getFuelVolume() + " , max fuel volume: " + car.getMAX_FUEL_VOLUME();

		System.out.println(markModel);
		System.out.println(engine);
		System.out.println(wheels);
		System.out.println(fuel);
	}
}
