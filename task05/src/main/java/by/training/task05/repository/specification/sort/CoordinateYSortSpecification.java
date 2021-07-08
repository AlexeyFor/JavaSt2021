package by.training.task05.repository.specification.sort;

import java.util.Comparator;

import by.training.task05.entity.Sphere;

/**
 * Specification for sorting Spheres by coordinate Y
 * 
 * @author AlexeySupruniuk
 *
 */
public class CoordinateYSortSpecification extends SortSpecification {

	/**
	 * return comparator for sorting spheres by coordinate Y
	 */
	@Override
	public Comparator<Sphere> get() {
		return Comparator.comparing(Sphere::getCenterY);
	}
}
