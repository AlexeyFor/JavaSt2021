package by.training.task05.service.specification_creator;

import by.training.task05.repository.specification.Specification;
import by.training.task05.repository.specification.sort.CoordinateZSortSpecification;
import by.training.task05.service.ServiceException;

public class SortSpecificationZCreator implements SpecificationCreator {

    /**
     * return CoordinateZSortSpecification
     */
    @Override
    public Specification createSpecification(String[] params) throws ServiceException {
	return new CoordinateZSortSpecification();
    }

}
