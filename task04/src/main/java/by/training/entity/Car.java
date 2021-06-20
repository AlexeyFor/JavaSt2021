package by.training.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Due to the peculiarities of Jackson work, for correct serialization and
 * deserialization of JSON objects, a special constructor and separate methods
 * were created for fields engine and wheels
 * 
 * @author AlexeySupruniuk
 *
 */
@JsonAutoDetect
public class Car implements Serializable {

	private static final long serialVersionUID = -415069128765241086L;

	private Wheel[] wheels = { new Wheel(Double.NaN, null), new Wheel(Double.NaN, null), new Wheel(Double.NaN, null),
			new Wheel(Double.NaN, null) };
	private String mark;
	private String model;
	private Engine engine = new Engine(Double.NaN, null);
	private double fuelVolume;
	private final double MAX_FUEL_VOLUME;

	public Car() {
		super();
		this.MAX_FUEL_VOLUME = 100;
	}

	public Car(String mark, String model, double fuelVolume, double MAX_FUEL_VOLUME) {
		super();
		this.mark = mark;
		this.model = model;
		this.MAX_FUEL_VOLUME = MAX_FUEL_VOLUME;
		this.fuelVolume = fuelVolume;
	}

	// constructor for JSON
	@JsonCreator
	public Car(@JsonProperty("wheelsTypes") String[] wheelsTypes, @JsonProperty("mark") String mark,
			@JsonProperty("model") String model, @JsonProperty("fuelVolume") double fuelVolume,
			@JsonProperty("engineFuelConsumptionPerHundred") double engineFuelConsumptionPerHundred,
			@JsonProperty("engineType") String engineType, @JsonProperty("wheelsDiametres") double[] wheelsDiametres,
			@JsonProperty("max_FUEL_VOLUME") double mAX_FUEL_VOLUME) {
		super();
		createWheels(wheelsTypes, wheelsDiametres);
		this.mark = mark;
		this.model = model;
		this.engine = new Engine(engineFuelConsumptionPerHundred, engineType);
		MAX_FUEL_VOLUME = mAX_FUEL_VOLUME;
		this.fuelVolume = fuelVolume;
	}

	// method for JSON
	private void createWheels(String[] wheelsTypes, double[] wheelsDiametres) {
		for (int i = 0; i < wheels.length; i++) {
			this.wheels[i] = new Wheel(wheelsDiametres[i], wheelsTypes[i]);
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getWheelType(int index) {
		if (wheels[index] == null) {
			return null;
		}
		return wheels[index].getType();
	}

	public double getWheelDiameter(int index) {
		if (wheels[index] == null) {
			return Double.NaN;
		}
		return wheels[index].getDiameter();
	}

	public String getMark() {
		return mark;
	}

	public String getModel() {
		return model;
	}

	public double getEngineFuelConsumptionPerHundred() {
		if (engine == null) {
			return Double.NaN;
		}
		return engine.getFuelConsumptionPerHundred();
	}

	public String getEngineType() {
		if (engine == null) {
			return null;
		}
		return engine.getType();
	}

	public String[] getWheelsTypes() {
		String result[] = new String[4];
		for (int i = 0; i < 4; i++) {
			if (wheels[i] == null) {
				result[i] = null;
			} else {
				result[i] = wheels[i].getType();
			}
		}
		return result;
	}

	public double[] getWheelsDiametres() {
		double result[] = new double[4];
		for (int i = 0; i < 4; i++) {
			if (wheels[i] == null) {
				result[i] = Double.NaN;
			} else {
				result[i] = wheels[i].getDiameter();
			}
		}
		return result;
	}

	public double getFuelVolume() {
		return fuelVolume;
	}

	public double getMAX_FUEL_VOLUME() {
		return MAX_FUEL_VOLUME;
	}

	public void setWheel(Wheel wheel, int index) {
		this.wheels[index] = new Wheel(wheel.getDiameter(), wheel.getType());
	}

	public void setWheels(Wheel[] wheelsArray) {
		for (int i = 0; i < wheelsArray.length; i++) {
			if (wheelsArray[i] == null) {
				this.wheels[i] = new Wheel(Double.NaN, null);
			} else {
				this.wheels[i] = new Wheel(wheelsArray[i].getDiameter(), wheelsArray[i].getType());
			}
		}
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setEngine(Engine engine) {
		this.engine = new Engine(engine.getFuelConsumptionPerHundred(), engine.getType());
	}

	public void setFuelVolume(double fuelVolume) {
		this.fuelVolume = fuelVolume;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(wheels);
		result = prime * result + Objects.hash(MAX_FUEL_VOLUME, engine, fuelVolume, mark, model);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Double.doubleToLongBits(MAX_FUEL_VOLUME) == Double.doubleToLongBits(other.MAX_FUEL_VOLUME)
				&& Objects.equals(engine, other.engine)
				&& Double.doubleToLongBits(fuelVolume) == Double.doubleToLongBits(other.fuelVolume)
				&& Objects.equals(mark, other.mark) && Objects.equals(model, other.model)
				&& Arrays.equals(wheels, other.wheels);
	}

	@Override
	public String toString() {
		return "Car [wheels=" + Arrays.toString(wheels) + ", mark=" + mark + ", model=" + model + ", engine=" + engine
				+ ", fuelVolume=" + fuelVolume + ", MAX_FUEL_VOLUME=" + MAX_FUEL_VOLUME + "]";
	}

}
