package by.training.task05.service.creator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task05.entity.Sphere;
import by.training.task05.entity.Sphere.CoordinateXYZ;

/**
 * Logics for creation Sphere
 * 
 * @author AlexeySupruniuk
 *
 */
public class SphereCreator {

    private static final Logger LOG = LogManager.getLogger(SphereCreator.class);

    private static SphereCreator instance = new SphereCreator();

    private SphereCreator() {
    }

    public static SphereCreator getInstance() {
	return instance;
    }

    /**
     * Create and return Sphere
     * 
     * @param name
     * @param center
     * @param radius
     * @return
     * @throws CreatorException
     */
    public Sphere createSphere(String name, CoordinateXYZ center, double radius)
	    throws CreatorException {
	LOG.debug("start createSphere with coordinate");

	if (!checkName(name)) {
	    LOG.debug("wrong name");
	    throw new CreatorException("wrong_data");
	}

	if (!checkRadius(radius)) {
	    LOG.debug("wrong radius");
	    throw new CreatorException("wrong_data");
	}

	if (!checkRadiusAndCenter(radius, center)) {
	    LOG.debug("wrong center and radius");
	    throw new CreatorException("wrong_data");
	}

	LOG.debug(String.format("start createSphere with name %s, center %s, radius %s", name,
		center.toString(), radius));
	Sphere result = new Sphere(name, center, radius);
	return result;
    }

    /**
     * Create and return Sphere
     * 
     * @param name
     * @param center
     * @param radius
     * @return
     * @throws CreatorException
     */
    public Sphere createSphere(String name, double x, double y, double z, double radius)
	    throws CreatorException {
	LOG.debug(String.format(
		"start createSphere (without CoordinateXYZ) with name %s, x %s, y %s, z %s radius %s",
		name, x, y, z, radius));

	if (!checkName(name)) {
	    LOG.debug("wrong name");
	    throw new CreatorException("wrong_data");
	}
	LOG.debug("name ok");
	
	if (!checkRadius(radius)) {
	    LOG.debug("wrong radius");
	    throw new CreatorException("wrong_data");
	}
	LOG.debug("radius ok");

	Sphere.CoordinateXYZ tmp = CoordinateCreator.getInstance().createCoordinate(x, y, z);
	LOG.debug("coordinate created");

	if (!checkRadiusAndCenter(radius, tmp)) {
	    LOG.debug("wrong radius and coordinate");
	    throw new CreatorException("wrong_data");
	}
	LOG.debug("radius and coordinate ok");


	LOG.debug("sphere was created successfully");
	Sphere result = new Sphere(name, tmp, radius);
	return result;
    }

    /**
     * check and set sphere radius
     * 
     * @param sphere
     * @param radius
     * @return
     */
    public boolean setSphereRadius(Sphere sphere, double radius) {
	double coordinateX = sphere.getCenterX();
	double coordinateY = sphere.getCenterY();
	double coordinateZ = sphere.getCenterZ();

	LOG.info(String.format("start setSphereRadius with  x %s, y %s, z %s radius %s",
		coordinateX, coordinateY, coordinateZ, radius));
	if (checkRadiusAndCenter(radius, coordinateX, coordinateY, coordinateZ)) {
	    sphere.setRadius(radius);
	    return true;
	} else {
	    return false;
	}
    }

    private boolean checkRadius(double radius) {
	return (radius > 0 && radius != Double.POSITIVE_INFINITY);
    }

    /**
     * checks if the sphere will go outside the coordinate axes.
     * 
     * @param radius
     * @param center
     * @return
     */
    private boolean checkRadiusAndCenter(double radius, CoordinateXYZ center) {
	if (center == null) {
	    LOG.debug("radius in null");
	    return false;
	    // throw new CreatorException("wrong_data");
	}
	double maxMinusRadius = Double.MAX_VALUE - radius;
	boolean conditionX = (Math.abs(center.getX()) < maxMinusRadius);
	boolean conditionY = (Math.abs(center.getY()) < maxMinusRadius);
	boolean conditionZ = (Math.abs(center.getZ()) < maxMinusRadius);
	boolean answer = (conditionX && conditionY && conditionZ);
	
	LOG.debug("answer from checkRadiusAndCenter " + answer);
	return answer;

    }

    /**
     * checks if the sphere will go outside the coordinate axes.
     * 
     * @param radius
     * @param center
     * @return
     */
    private boolean checkRadiusAndCenter(double radius, double coordinateX, double coordinateY,
	    double coordinateZ) {
	double maxMinusRadius = Double.MAX_VALUE - radius;
	boolean conditionX = (Math.abs(coordinateX) < maxMinusRadius);
	boolean conditionY = (Math.abs(coordinateY) < maxMinusRadius);
	boolean conditionZ = (Math.abs(coordinateZ) < maxMinusRadius);

	if (conditionX && conditionY && conditionZ) {
	    return true;
	} else {
	    return false;
	}

    }

    /**
     * check Name
     * 
     * @param str
     * @return
     */
    private boolean checkName(String str) {
	final String invalidCharacters = "[^0-9\\.a-zA-Z\\-]";
	Pattern pat = Pattern.compile(invalidCharacters);
	Matcher match = pat.matcher(str);
	if (!match.find()) {
	    return true;
	} else {
	    return false;

	}
    }

}
