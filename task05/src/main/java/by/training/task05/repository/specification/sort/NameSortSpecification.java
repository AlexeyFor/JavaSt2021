package by.training.task05.repository.specification.sort;

import java.util.Comparator;

import by.training.task05.entity.Sphere;

/**
 * Specification for sorting Spheres by name
 * 
 * @author AlexeySupruniuk
 *
 */
public class NameSortSpecification extends SortSpecification {

	/**
	 * return comparator for sorting spheres by name
	 */
	@Override
	public Comparator<Sphere> get() {
		return Comparator.comparing(Sphere::getName);
	}

}
