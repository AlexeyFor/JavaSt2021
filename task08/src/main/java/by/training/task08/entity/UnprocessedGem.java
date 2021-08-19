package by.training.task08.entity;

public class UnprocessedGem extends Gem {

    private double height;
    private double length;
    private double width;

    public double getHeight() {
	return height;
    }

    public double getLength() {
	return length;
    }

    public double getWidth() {
	return width;
    }

    public void setHeight(double height) {
	this.height = height;
    }

    public void setLength(double length) {
	this.length = length;
    }

    public void setWidth(double width) {
	this.width = width;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	long temp;
	temp = Double.doubleToLongBits(height);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(length);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(width);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	UnprocessedGem other = (UnprocessedGem) obj;
	if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
	    return false;
	if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
	    return false;
	if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "UnprocessedGem [height=" + height + ", length=" + length + ", width=" + width
		+ ", toString()=" + super.toString() + "]";
    }

}
