package by.training.task05.service.specification_creator;

import by.training.task05.repository.specification.Specification;
import by.training.task05.repository.specification.sort.NameSortSpecification;
import by.training.task05.service.ServiceException;

public class SortSpecificationNameCreator implements SpecificationCreator {

    /**
     * return NameSortSpecification
     */
    @Override
    public Specification createSpecification(String[] params) throws ServiceException {
	return new NameSortSpecification();
    }

}
