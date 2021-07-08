package by.training.task05.service.specification_creator;

import java.util.List;

import by.training.task05.repository.specification.Specification;
import by.training.task05.service.ServiceException;

public interface SpecificationCreator {

    /**
     * params [0] - name of Specification, params [1], params [2] - parameters
     * 
     * @param String [] params
     * @return Specification
     * @throws ServiceException
     */
    public Specification createSpecification(String[] params) throws ServiceException;

}
