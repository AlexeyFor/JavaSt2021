package by.training.task05.repository.specification.find;

import java.util.List;

/**
 * condition "or" for specification
 * 
 * @author AlexeySupruniuk
 *
 * @param <T>
 */
public class DisjunctionFindSpecification<T> extends FindSpecification<T> {

	private final List<FindSpecification<T>> specificationsList;

	protected DisjunctionFindSpecification(FindSpecification<T>... specifications) {
		this.specificationsList = List.of(specifications);
	}

	/**
	 * Tests if any selectors pass the test.
	 */
	@Override
	public boolean test(T tmp) {
		return specificationsList.stream().anyMatch(comp -> (comp.test(tmp)));
	}

}
