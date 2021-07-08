package by.training.task05.service.specification_creator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task05.repository.specification.Specification;
import by.training.task05.service.ServiceException;

public class ErrorSpecification implements SpecificationCreator {

    private static final Logger LOG = LogManager.getLogger(ErrorSpecification.class);

    @Override
    public Specification createSpecification(String[] params) throws ServiceException {

	LOG.debug("wrong specification");
	throw new ServiceException("wrong_data");

    }

}
