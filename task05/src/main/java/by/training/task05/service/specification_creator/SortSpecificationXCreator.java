package by.training.task05.service.specification_creator;

import by.training.task05.repository.specification.Specification;
import by.training.task05.repository.specification.sort.CoordinateXSortSpecification;
import by.training.task05.service.ServiceException;

public class SortSpecificationXCreator implements SpecificationCreator {

    /**
     * return CoordinateXSortSpecification
     */
    @Override
    public Specification createSpecification(String[] params) throws ServiceException {
	return new CoordinateXSortSpecification();
    }

}
