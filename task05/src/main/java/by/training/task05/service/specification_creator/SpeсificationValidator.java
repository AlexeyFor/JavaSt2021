package by.training.task05.service.specification_creator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task05.service.ServiceException;

/**
 * validation for SpecificationCreator
 * @author AlexeySupruniuk
 *
 */
public class SpeсificationValidator {

    private static SpeсificationValidator instance = new SpeсificationValidator();

    private SpeсificationValidator() {
    }

    public static SpeсificationValidator getInstance() {
	return instance;
    }

    private static final Logger LOG = LogManager.getLogger(SpeсificationValidator.class);


    /**
     * take String return double
     * 
     * @param str
     * @return double
     * @throws ServiceException
     */
    public double validateDoubleFromString(String str) throws ServiceException {
	final String invalidCharacters = "[^0-9\\-\\.]";
	double result;
	if (checkForINvalidCharacters(str, invalidCharacters)) {
	    try {
		result = Double.valueOf(str);
		return result;
	    } catch (NumberFormatException e) {
		LOG.debug("from validateDoubleFromString, too big number");
		throw new ServiceException("wrong_data");
	    }
	} else {
	    LOG.debug("from validateDoubleFromString, wrong symbols in data");
	    throw new ServiceException("wrong_data");
	}
    }

    /**
     * take String return Long
     * 
     * @param str
     * @return Long
     * @throws ServiceException
     */
    public Long validateLongFromString(String str) throws ServiceException {
	final String invalidCharacters = "[^0-9\\-]";
	Long result;
	if (checkForINvalidCharacters(str, invalidCharacters)) {
	    try {
		result = Long.valueOf(str);
		return result;
	    } catch (NumberFormatException e) {
		LOG.debug("from validateDoubleFromString, too big number");
		throw new ServiceException("wrong_data");
	    }
	} else {
	    LOG.debug("from validateDoubleFromString, wrong symbols in data");
	    throw new ServiceException("wrong_data");
	}
    }

    /**
     * check String for invalid characters
     * 
     * @param str
     * @return boolean
     * @throws SearchDataInStrException
     */
    private boolean checkForINvalidCharacters(String dataInStr, String invalidCharacters) {
	Pattern pat = Pattern.compile(invalidCharacters);
	Matcher match = pat.matcher(dataInStr);
	if (!match.find()) {
	    return true;
	} else {
	    return false;

	}
    }
}
