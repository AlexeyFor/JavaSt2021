package by.training.task05.service.specification_creator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task05.repository.specification.Specification;
import by.training.task05.repository.specification.find.SquareRangeFindSpecidication;
import by.training.task05.service.ServiceException;

public class SpecificationSquareRangeCreator implements SpecificationCreator {

    private static final Logger LOG = LogManager.getLogger(SpecificationSquareRangeCreator.class);

    /**
     * 
     * create SquareRangeFindSpecidication from string
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

	SquareRangeFindSpecidication result = new SquareRangeFindSpecidication(min, max);

	return result;
    }
}
