package by.training.task05.repository.specification.sort;

import java.util.Comparator;

import by.training.task05.entity.Sphere;

/**
 * Specification for sorting Spheres by coordinate Z
 * 
 * @author AlexeySupruniuk
 *
 */
public class CoordinateZSortSpecification extends SortSpecification {

	/**
	 * return comparator for sorting spheres by coordinate Z
	 */
	@Override
	public Comparator<Sphere> get() {
		return Comparator.comparing(Sphere::getCenterZ);
	}

}
