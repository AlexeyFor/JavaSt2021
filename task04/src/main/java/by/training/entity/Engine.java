package by.training.entity;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * 
 * @author AlexeySupruniuk
 *
 */
@JsonAutoDetect
public class Engine implements Serializable {

	private static final long serialVersionUID = -5691453954011211552L;
	private double fuelConsumptionPerHundred;
	private String type;

	public Engine() {
		super();
	}

	public Engine(double fuelConsumptionPerHundred, String type) {
		super();
		this.fuelConsumptionPerHundred = fuelConsumptionPerHundred;
		this.type = type;
	}

	public double getFuelConsumptionPerHundred() {
		return fuelConsumptionPerHundred;
	}

	public String getType() {
		return type;
	}

	public void setFuelConsumptionPerHundred(double fuelConsumptionPerHundred) {
		this.fuelConsumptionPerHundred = fuelConsumptionPerHundred;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Engine [fuelConsumptionPerHundred=" + fuelConsumptionPerHundred + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fuelConsumptionPerHundred, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Engine other = (Engine) obj;
		return Double.doubleToLongBits(fuelConsumptionPerHundred) == Double
				.doubleToLongBits(other.fuelConsumptionPerHundred) && Objects.equals(type, other.type);
	}

}
