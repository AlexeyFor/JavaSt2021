package by.training.task05.service.specification_creator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task05.repository.specification.Specification;
import by.training.task05.repository.specification.find.IDFindSpecification;
import by.training.task05.service.ServiceException;

/**
 * 
 * @author AlexeySupruniuk
 * 
 */
public class SpecificationIDCreator implements SpecificationCreator {

    private static final Logger LOG = LogManager.getLogger(SpecificationIDCreator.class);

    /**
     * 
     * create IDFindSpecification from string
     * 
     * @throws ServiceException
     */
    @Override
    public Specification createSpecification(String[] params) throws ServiceException {

	if (params.length != 2) {
	    LOG.debug("wrong size of request");
	    throw new ServiceException("wrong size of request");
	}
	SpeсificationValidator validator = SpeсificationValidator.getInstance();
	Long id = validator.validateLongFromString(params[1]);

	IDFindSpecification result = new IDFindSpecification(id);

	return result;
    }

}
