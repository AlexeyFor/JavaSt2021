package by.training.task05.repository.specification.find;

import java.math.BigDecimal;

import by.training.task05.entity.Sphere;
import by.training.task05.repository.Repository;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         Specification for finding Spheres by volume
 * 
 * @param <Sphere>
 */
public class VolumeRangeFindSpecidication extends FindSpecification<Sphere> {

    private BigDecimal min;
    private BigDecimal max;

    public void setMin(double min) {
	this.min = new BigDecimal(min);
    }

    public void setMax(double max) {
	this.max = new BigDecimal(max);
    }

    public VolumeRangeFindSpecidication(double min, double max) {
	this.min = new BigDecimal(min);
	this.max = new BigDecimal(max);
    }

    /**
     * check, if volume of sphere is between min and max values
     */
    @Override
    public boolean test(Sphere tmp) {
	BigDecimal tmpV = Repository.getInstance().getListener(tmp.getID()).getVolume();
	return ((tmpV.compareTo(min) >= 0) && (tmpV.compareTo(max) <= 0));
    }

}
