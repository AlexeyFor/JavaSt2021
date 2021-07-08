package by.training.task05.repository.specification.find;

import java.util.function.Predicate;

import by.training.task05.repository.specification.Specification;

public abstract class FindSpecification<T> extends Specification implements Predicate<T> {

	public FindSpecification<T> and(FindSpecification<T> other) {
		return new ConjuctionFindSpecification(this, other);
	}

	public FindSpecification<T> or(FindSpecification<T> other) {
		return new DisjunctionFindSpecification(this, other);
	}

	public FindSpecification<T> not() {
		return new NegationFindSpecification(this);
	}
}
