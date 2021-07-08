package by.training.task05.service.creator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task05.entity.Sphere;

/**
 * Logics for creation Sphere
 * 
 * @author AlexeySupruniuk
 *
 */
public class CoordinateCreator {

    private static final Logger LOG = LogManager.getLogger(CoordinateCreator.class);

    private static CoordinateCreator instance = new CoordinateCreator();

    private CoordinateCreator() {
    }

    public static CoordinateCreator getInstance() {
	return instance;
    }

    /**
     * 
     * @param x
     * @param y
     * @param z
     * @return CoordinateXYZ
     * @throws CreatorException
     */
    public Sphere.CoordinateXYZ createCoordinate(double x, double y, double z)
	    throws CreatorException {
	if (checkDouble(x) && checkDouble(y) && checkDouble(z)) {
	    LOG.debug("start createCoordinate with x " + x + " , y " + y + " , z " + z);
	    return new Sphere.CoordinateXYZ(x, y, z);
	} else {
	    LOG.debug("wrong coordinate");
	    throw new CreatorException("wrong_data");
	}
    }

    private boolean checkDouble(double number) {
	final double MIN = -1.7976931348623157E308;
	final double MAX = 1.7976931348623157E308;

	return ((number > MIN )&&( number < MAX));
    }
}
