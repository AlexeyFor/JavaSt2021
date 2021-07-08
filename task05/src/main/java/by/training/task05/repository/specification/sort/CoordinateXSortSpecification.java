package by.training.task05.repository.specification.sort;

import java.util.Comparator;

import by.training.task05.entity.Sphere;

/**
 * Specification for sorting Spheres by coordinate X
 * 
 * @author AlexeySupruniuk
 *
 */
public class CoordinateXSortSpecification extends SortSpecification {

	/**
	 * return comparator for sorting spheres by coordinate X
	 */
	@Override
	public Comparator<Sphere> get() {
		return Comparator.comparing(Sphere::getCenterX);
	}

}
