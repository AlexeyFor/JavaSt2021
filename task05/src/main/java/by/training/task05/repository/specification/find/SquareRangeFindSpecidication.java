package by.training.task05.repository.specification.find;

import java.math.BigDecimal;

import by.training.task05.entity.Sphere;
import by.training.task05.repository.Repository;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         Specification for finding Spheres by square
 * 
 * @param <Sphere>
 */
public class SquareRangeFindSpecidication extends FindSpecification<Sphere> {

    private BigDecimal min;
    private BigDecimal max;

    public void setMin(double min) {
	this.min = new BigDecimal(min);
    }

    public void setMax(double max) {
	this.max = new BigDecimal(max);
    }

    public SquareRangeFindSpecidication(double min, double max) {
	this.min = new BigDecimal(min);
	this.max = new BigDecimal(max);
    }

    /**
     * check, if square of sphere is between min and max values
     */
    @Override
    public boolean test(Sphere tmp) {
	BigDecimal tmpS = Repository.getInstance().getListener(tmp.getID()).getSquare();
	return ((tmpS.compareTo(min) >= 0) && (tmpS.compareTo(max) <= 0));
    }

}
