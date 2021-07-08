package by.training.task05.repository.specification.sort;

import java.util.Comparator;
import java.util.function.Supplier;

import by.training.task05.entity.Sphere;
import by.training.task05.repository.specification.Specification;

/**
 * 
 * @author AlexeySupruniuk
 *
 */
public abstract class SortSpecification extends Specification implements Supplier <Comparator<Sphere>> {

}
