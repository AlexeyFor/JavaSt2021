package by.training.task05.repository.specification.find;

import by.training.task05.entity.Sphere;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         Specification for finding Spheres by radius (in range)
 * 
 * @param <Sphere>
 */
public class RadiusRangeFindSpecidication extends FindSpecification<Sphere> {

    private double min;
    private double max;

    public void setMin(double min) {
	this.min = min;
    }

    public void setMax(double max) {
	this.max = max;
    }

    public RadiusRangeFindSpecidication(double min, double max) {
	this.min = min;
	this.max = max;
    }

    /**
     * check, if radius of sphere is between min and max values
     */
    @Override
    public boolean test(Sphere tmp) {
	double tmpR = tmp.getRadius();
	return ((tmpR >= min) && (tmpR <= max));
    }

}
