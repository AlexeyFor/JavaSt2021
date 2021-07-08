package by.training.task05.repository.specification.find;

import java.util.List;

/**
 * condition "all" for specification
 * 
 * @author AlexeySupruniuk
 *
 * @param <T>
 */
public class ConjuctionFindSpecification<T> extends FindSpecification<T> {

	private final List<FindSpecification<T>> specificationsList;

	protected ConjuctionFindSpecification(FindSpecification<T>... specifications) {
		this.specificationsList = List.of(specifications);
	}

	/**
	 * Tests if all selectors pass the test.
	 */
	@Override
	public boolean test(T tmp) {
		return specificationsList.stream().allMatch(comp -> (comp.test(tmp)));
	}

}
