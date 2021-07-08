package by.training.task05.repository.specification.find;

import by.training.task05.entity.Sphere;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         Specification for finding Spheres by coordinate X (in range)
 * 
 * @param <Sphere>
 */
public class CoordinateXRangeFindSpecidication extends FindSpecification<Sphere> {

    private double min;
    private double max;

    public void setMin(double min) {
	this.min = min;
    }

    public void setMax(double max) {
	this.max = max;
    }

    public CoordinateXRangeFindSpecidication(double min, double max) {
	this.min = min;
	this.max = max;
    }

    /**
     * check, if coordinate X of sphere is between min and max values
     */
    @Override
    public boolean test(Sphere tmp) {
	double tmpX = tmp.getCenterX();
	return ((tmpX >= min) && (tmpX <= max));
    }

}
