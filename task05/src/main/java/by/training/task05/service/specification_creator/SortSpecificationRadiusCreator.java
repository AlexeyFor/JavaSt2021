package by.training.task05.service.specification_creator;

import by.training.task05.repository.specification.Specification;
import by.training.task05.repository.specification.sort.RadiusSortSpecification;
import by.training.task05.service.ServiceException;

public class SortSpecificationRadiusCreator implements SpecificationCreator {

    /**
     * return RadiusSortSpecification
     */
    @Override
    public Specification createSpecification(String[] params) throws ServiceException {
	return new RadiusSortSpecification();
    }

}
