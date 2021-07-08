package by.training.task05.service.specification_creator;

import by.training.task05.repository.specification.Specification;
import by.training.task05.repository.specification.sort.SquareSortSpecification;
import by.training.task05.service.ServiceException;

public class SortSpecificationSquareCreator implements SpecificationCreator {

    /**
     * return SquareSortSpecification
     */
    @Override
    public Specification createSpecification(String[] params) throws ServiceException {
	return new SquareSortSpecification();
    }

}
