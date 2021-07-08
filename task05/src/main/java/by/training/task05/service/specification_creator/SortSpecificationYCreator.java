package by.training.task05.service.specification_creator;

import by.training.task05.repository.specification.Specification;
import by.training.task05.repository.specification.sort.CoordinateYSortSpecification;
import by.training.task05.service.ServiceException;

public class SortSpecificationYCreator implements SpecificationCreator {

    /**
     * return CoordinateYSortSpecification
     */
    @Override
    public Specification createSpecification(String[] params) throws ServiceException {
	return new CoordinateYSortSpecification();
    }

}
