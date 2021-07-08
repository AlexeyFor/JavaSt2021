package by.training.task05.repository.specification.sort;

import java.util.Comparator;

import by.training.task05.entity.Sphere;

/**
 * Specification for sorting Spheres by radius
 * 
 * @author AlexeySupruniuk
 *
 */
public class RadiusSortSpecification extends SortSpecification {

	/**
	 * return comparator for sorting spheres by radius
	 */
	@Override
	public Comparator<Sphere> get() {
		return Comparator.comparing(Sphere::getRadius);
	}

}
