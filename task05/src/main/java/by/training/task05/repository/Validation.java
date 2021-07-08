package by.training.task05.repository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         Validation for Sphere and Sphere.CoordinateXYZ
 *
 */
public class Validation {

    private static final Logger LOG = LogManager.getLogger(Validation.class);

    private static final Validation instance = new Validation();

    private Validation() {
    }

    public static Validation getInstance() {
	return instance;
    }

    /**
     * check Name
     * 
     * @param str
     * @return
     */
    public boolean checkName(String str) {
	final String invalidCharacters = "[^0-9\\.a-zA-Z\\-]";
	return checkForINvalidCharacters(str, invalidCharacters);
    }

    /**
     * check Radius
     * 
     * @param str
     * @return
     */
    public boolean checkRadius(String str) {
	final String invalidCharacters = "[^0-9\\.]";
	return checkForINvalidCharacters(str, invalidCharacters);
    }

    /**
     * check One of Coordinates (x, y or z)
     * 
     * @param str
     * @return
     */
    public boolean checkOneCoordinate(String str) {
	final String invalidCharacters = "[^0-9\\-\\.]";
	return checkForINvalidCharacters(str, invalidCharacters);
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
