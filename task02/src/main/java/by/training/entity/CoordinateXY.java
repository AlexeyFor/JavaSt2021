package by.training.entity;

import java.io.Serializable;

/**
 * 
 * @author AlexeySupruniuk numbers x, y check for NaN, if true - number = 0;
 */
public class CoordinateXY implements Serializable {

	private static final long serialVersionUID = -3290663693591001521L;
	private double x;
	private double y;

	public CoordinateXY(double x, double y) {
		super();

		if (Double.isNaN(x)) {
			this.x = 0;
		} else {
			this.x = x;
		}
		if (Double.isNaN(y)) {
			this.y = 0;
		} else {
			this.y = y;
		}
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		if (Double.isNaN(x)) {
			this.x = 0;
		} else {
			this.x = x;
		}
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		if (Double.isNaN(y)) {
			this.y = 0;
		} else {
			this.y = y;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		CoordinateXY other = (CoordinateXY) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CoordinateXY [x=" + x + ", y=" + y + "]";
	}

}
