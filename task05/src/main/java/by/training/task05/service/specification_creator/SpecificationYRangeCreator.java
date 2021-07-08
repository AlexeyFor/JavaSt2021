package by.training.task05.service.specification_creator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task05.repository.specification.Specification;
import by.training.task05.repository.specification.find.CoordinateYRangeFindSpecidication;
import by.training.task05.service.ServiceException;

/**
 * 
 * @author AlexeySupruniuk
 * 
 */
public class SpecificationYRangeCreator implements SpecificationCreator {

    private static final Logger LOG = LogManager.getLogger(SpecificationYRangeCreator.class);

    /**
     * 
     * create CoordinateXRangeFindSpecidication from string
     * 
     * @throws ServiceException
     */
    @Override
    public Specification createSpecification(String[] params) throws ServiceException {

	if (params.length != 3) {
	    LOG.debug("wrong size of request");
	    throw new ServiceException("wrong size of request");
	}
	SpeсificationValidator validator = SpeсificationValidator.getInstance();
	double min = validator.validateDoubleFromString(params[1]);
	double max = validator.validateDoubleFromString(params[2]);

	if (min > max) {
	    LOG.debug("minimal value can't be more than maximim value");
	    throw new ServiceException("wrong min and max");
	}

	CoordinateYRangeFindSpecidication result = new CoordinateYRangeFindSpecidication(min, max);

	return result;
    }

}
