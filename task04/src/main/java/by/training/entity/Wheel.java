package by.training.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * 
 * @author AlexeySupruniuk
 *
 */
@JsonAutoDetect
public class Wheel implements Serializable {

	private static final long serialVersionUID = -7521412275644617144L;
	private double diameter;
	private String type;

	public Wheel() {
		super();
	}

	public Wheel(double diameter, String type) {
		super();
		this.diameter = diameter;
		this.type = type;
	}

	public double getDiameter() {
		return diameter;
	}

	public String getType() {
		return type;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(diameter);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Wheel other = (Wheel) obj;
		if (Double.doubleToLongBits(diameter) != Double.doubleToLongBits(other.diameter))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wheel [diameter=" + diameter + ", type=" + type + "]";
	}
}
