package by.training.task05.entity;

import java.io.Serializable;

/**
 * Creation of sphere, set new radius - only with SphereCreator
 * 
 * @author AlexeySupruniuk
 */
public class Sphere {

    // for name only [0-9 . a-z A-Z -] symbols allowed
    private final String name;
    private CoordinateXYZ center;
    private double radius;
    private final long ID;

    public Sphere(String name, CoordinateXYZ center, double radius) {
	super();
	this.name = name;
	this.center = center;
	this.radius = radius;
	ID = (long) (Math.random() * 9223372036854775806L);
    }

    public Sphere(String name, double x, double y, double z, double radius) {
	super();
	this.name = name;
	this.center = new CoordinateXYZ(x, y, z);
	this.radius = radius;
	ID = (long) (Math.random() * 9223372036854775806L);
    }

    /**
     * Only with SphereCreator
     * 
     * @param radius
     */
    public void setRadius(double radius) {
	this.radius = radius;
	SphereListenerCatalog.getInstance().callListener(this.ID, radius);
    }

    public String getName() {
	return name;
    }

    public double getRadius() {
	return radius;

    }

    public long getID() {
	return ID;
    }

    public double getCenterX() {
	return center.getX();
    }

    public double getCenterY() {
	return center.getY();
    }

    public double getCenterZ() {
	return center.getZ();
    }

    public static class CoordinateXYZ implements Serializable {

	private static final long serialVersionUID = -8179854991159239639L;
	private double x;
	private double y;
	private double z;

	public CoordinateXYZ() {
	    super();
	}

	public CoordinateXYZ(double x, double y, double z) {
	    super();
	    this.x = x;
	    this.y = y;
	    this.z = z;
	}

	public double getX() {
	    return x;
	}

	public double getY() {
	    return y;
	}

	public double getZ() {
	    return z;
	}

	public void setX(double x) {
	    this.x = x;
	}

	public void setY(double y) {
	    this.y = y;
	}

	public void setZ(double z) {
	    this.z = z;
	}

	// overriding without using Objects
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    long temp;
	    temp = Double.doubleToLongBits(x);
	    result = prime * result + (int) (temp ^ (temp >>> 32));
	    temp = Double.doubleToLongBits(y);
	    result = prime * result + (int) (temp ^ (temp >>> 32));
	    temp = Double.doubleToLongBits(z);
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
	    CoordinateXYZ other = (CoordinateXYZ) obj;
	    return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
		    && Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y)
		    && Double.doubleToLongBits(z) == Double.doubleToLongBits(other.z);
	}

	@Override
	public String toString() {
	    return "CoordinateXYZ [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

    }

    // overriding without using Objects
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (ID ^ (ID >>> 32));
	result = prime * result + ((center == null) ? 0 : center.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	long temp;
	temp = Double.doubleToLongBits(radius);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
    }

    // overriding without using Objects
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Sphere other = (Sphere) obj;
	if (ID != other.ID)
	    return false;
	if (center == null) {
	    if (other.center != null)
		return false;
	} else if (!center.equals(other.center))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Sphere [name=" + name + ", center=" + center + ", radius=" + radius + ", ID=" + ID
		+ "]";
    }

}
