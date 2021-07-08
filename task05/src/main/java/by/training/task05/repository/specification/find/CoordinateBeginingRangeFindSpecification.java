package by.training.task05.repository.specification.find;

import java.math.BigDecimal;
import java.math.MathContext;

import by.training.task05.entity.Sphere;

public class CoordinateBeginingRangeFindSpecification extends FindSpecification<Sphere> {

	private BigDecimal distanceMin;
	private BigDecimal distanceMax;

	public CoordinateBeginingRangeFindSpecification(double distanceMin, double distanceMax) {
		this.distanceMin = new BigDecimal(distanceMin);
		this.distanceMax = new BigDecimal(distanceMax);

	}

	@Override
	public boolean test(Sphere tmp) {
		final BigDecimal caclulateDisatnce = findDistanceToBeginning(tmp);
		boolean condition1 = caclulateDisatnce.compareTo(distanceMin) >= 0;
		boolean condition2 = caclulateDisatnce.compareTo(distanceMax) <= 0;

		if (condition1 && condition2) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * find distance to the point (0, 0, 0);
	 * 
	 * @param sphere
	 * @return
	 */
	private BigDecimal findDistanceToBeginning(final Sphere sphere) {
		BigDecimal coordinateX = new BigDecimal(sphere.getCenterX());
		BigDecimal coordinateY = new BigDecimal(sphere.getCenterY());
		BigDecimal coordinateZ = new BigDecimal(sphere.getCenterZ());

		BigDecimal tmpX = coordinateX.multiply(coordinateX);
		BigDecimal tmpY = coordinateY.multiply(coordinateY);
		BigDecimal tmpZ = coordinateZ.multiply(coordinateZ);

		BigDecimal sum = tmpX.add(tmpY).add(tmpZ);
		return sum.sqrt(MathContext.DECIMAL32);
	}

}
