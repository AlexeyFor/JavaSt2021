package by.training.task05.repository.specification.find;

/**
 * condition "no" for specification
 * 
 * @author AlexeySupruniuk
 *
 * @param <T>
 */
public class NegationFindSpecification<T> extends FindSpecification<T> {

	private FindSpecification<T> specification;

	protected NegationFindSpecification(FindSpecification<T> specification) {
		this.specification = specification;
	}

	@Override
	public boolean test(T tmp) {
		return !specification.test(tmp);
	}
}
