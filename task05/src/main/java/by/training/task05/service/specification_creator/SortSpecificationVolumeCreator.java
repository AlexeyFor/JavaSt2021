package by.training.task05.service.specification_creator;

import by.training.task05.repository.specification.Specification;
import by.training.task05.repository.specification.sort.VolumeSortSpecification;
import by.training.task05.service.ServiceException;

public class SortSpecificationVolumeCreator implements SpecificationCreator {

    /**
     * return VolumeSortSpecification
     */
    @Override
    public Specification createSpecification(String[] params) throws ServiceException {
	return new VolumeSortSpecification();
    }

}
