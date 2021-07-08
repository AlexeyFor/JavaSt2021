package by.training.task05.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task05.entity.Sphere;
import by.training.task05.entity.Sphere.CoordinateXYZ;

/**
 * 
 * @author AlexeySupruniuk
 *
 */
public class SphereLogicImpl implements SphereLogic {

    private static SphereLogicImpl instance = new SphereLogicImpl();

    private SphereLogicImpl() {
    }

    public static SphereLogicImpl getInstance() {
	return instance;
    }

    private static final Logger LOG = LogManager.getLogger(SphereLogicImpl.class);

    @Override
    public BigDecimal calculateSquare(final double radius) throws ServiceException {
	LOG.info("start calculateSquare with radius " + radius);
	if (checkRadius(radius)) {
	    BigDecimal square;
	    BigDecimal radiusBig = new BigDecimal(radius);
	    BigDecimal fourPI = new BigDecimal(4 * Math.PI);
	    square = radiusBig.multiply(radiusBig).multiply(fourPI);
	    return square;
	} else {
	    LOG.debug("from calculateSquare, wrong radius");
	    throw new ServiceException("wronga_data");
	}
    }

    @Override
    public BigDecimal calculateVolume(final double radius) throws ServiceException {
	LOG.info("start calculateVolume with radius " + radius);
	if (checkRadius(radius)) {
	    BigDecimal volume;
	    BigDecimal radiusBig = new BigDecimal(radius);
	    BigDecimal fourPI = new BigDecimal(4 * Math.PI / 3);
	    volume = radiusBig.multiply(fourPI).multiply(radiusBig).multiply(radiusBig);
	    return volume;
	} else {
	    LOG.debug("from calculateVolume, wrong radius");
	    throw new ServiceException("wronga_data");
	}
    }

    @Override
    public BigDecimal calculateCuttingVolumeRatio(Sphere sphere, CoordinateXYZ firstPoint,
	    CoordinateXYZ secondPoint) throws ServiceException {

	BigDecimal result = SphereVolumeRatio.getInstance().calculateCuttingVolumeRatio(sphere,
		firstPoint, secondPoint);
	return result;
    }

    @Override
    public String sphereTouchCoordinatePlanes(final Sphere sphere) {
	LOG.info("start sphereTouchCoordinatePlanes with sphere " + sphere.toString());

	String result = "";
	final BigDecimal bigRadius = new BigDecimal(sphere.getRadius());

	// check plane X
	if (checkSphereTouchCoordinatePlane(bigRadius, sphere.getCenterX())) {
	    result.concat("_X");
	}
	// check plane Y
	if (checkSphereTouchCoordinatePlane(bigRadius, sphere.getCenterY())) {
	    result.concat("_Y");
	}
	// check plane Z
	if (checkSphereTouchCoordinatePlane(bigRadius, sphere.getCenterZ())) {
	    result.concat("_Z");
	}
	return result;
    }

    /**
     * check, if sphere touch coordinate's plane
     * 
     * @param bigRadius
     * @param coordinate
     * @return
     */
    private boolean checkSphereTouchCoordinatePlane(final BigDecimal bigRadius,
	    final double coordinate) {
	final BigDecimal bigCoordinate = new BigDecimal(coordinate).abs();
	if (bigCoordinate.compareTo(bigRadius) == 0) {
	    return true;
	}
	return false;
    }

    private boolean checkRadius(double radius) {
	return (radius > 0 && radius != Double.POSITIVE_INFINITY);
    }

}
