package by.training.task05.repository.specification.sort;

import java.util.Comparator;

import by.training.task05.entity.Sphere;
import by.training.task05.repository.Repository;

/**
 * Specification for sorting Spheres by square
 * 
 * @author AlexeySupruniuk
 *
 */
public class SquareSortSpecification extends SortSpecification {

    /**
     * return comparator for sorting spheres by Square
     */
    @Override
    public Comparator<Sphere> get() {

	return Comparator
		.comparing(s -> Repository.getInstance().getListener(s.getID()).getSquare());
    }

}
