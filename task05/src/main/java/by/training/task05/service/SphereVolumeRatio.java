package by.training.task05.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task05.entity.Sphere;
import by.training.task05.repository.Repository;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         Contains all methods for method calculateCuttingVolumeRatio()
 */
public class SphereVolumeRatio {

    private static SphereVolumeRatio instance = new SphereVolumeRatio();

    private SphereVolumeRatio() {
    }

    public static SphereVolumeRatio getInstance() {
	return instance;
    }

    private static final Logger LOG = LogManager.getLogger(SphereVolumeRatio.class);

    public BigDecimal calculateCuttingVolumeRatio(Sphere sphere, Sphere.CoordinateXYZ firstPoint,
	    Sphere.CoordinateXYZ secondPoint) throws ServiceException {

	if (!checkParamsForNull(sphere, firstPoint, secondPoint)) {
	    LOG.debug("from calculateCuttingVolumeRatio, null in params");
	    throw new ServiceException("wrong_data");
	}

	LOG.info("start calculateCuttingVolumeRatio");
	// find needed coordinate, to find distance between the center of sphere and
	// plane
	final double[] coordinates = findNeededCoordinate(sphere, firstPoint, secondPoint);
	final double sphereOneCoordinate = coordinates[0];
	final double planeOneCoordinate = coordinates[1];

	final BigDecimal bigRadius = new BigDecimal(sphere.getRadius());
	BigDecimal h = calculateH(bigRadius, sphereOneCoordinate, planeOneCoordinate);

	// volume of cutted segment
	BigDecimal segmentVolume = calculateSegmentVolume(bigRadius, h);
	BigDecimal sphereVolume = Repository.getInstance().getListener(sphere.getID()).getVolume();
	BigDecimal volumeWithoutSegment = sphereVolume.subtract(segmentVolume);
	BigDecimal volumeRatio = volumeWithoutSegment.divide(segmentVolume, 10,
		RoundingMode.HALF_DOWN);
	return volumeRatio;
    }

    /**
     * calculate "h" for calculateCuttingVolumeRatio, where h - the length of the
     * perpendicular drawn from the middle of the base of the segment to the surface
     * of the segment.
     * 
     * @param sphere
     * @param oneCoordinate
     * @return BigDecimal resultH
     * @throws ServiceException
     */
    private BigDecimal calculateH(final BigDecimal bigRadius, final double sphereOneCoordinate,
	    final double planeOneCoordinate) throws ServiceException {
	LOG.debug(String.format(
		"start calculateH with bigRadius:  %s, sphereOneCoordinate: %s, planeOneCoordinate  %s",
		bigRadius, sphereOneCoordinate, planeOneCoordinate));

	// distance between the center of sphere and plane
	BigDecimal distanceCenterPlane;
	final BigDecimal bigSphereOneCoordinate = new BigDecimal(sphereOneCoordinate);
	final BigDecimal bigPlaneOneCoordinate = new BigDecimal(planeOneCoordinate);
	final BigDecimal resultH;

	distanceCenterPlane = bigSphereOneCoordinate.subtract(bigPlaneOneCoordinate);
	distanceCenterPlane = distanceCenterPlane.abs();
	resultH = bigRadius.subtract(distanceCenterPlane);
	LOG.debug("from calculateH get result " + resultH);

	if (resultH.compareTo(new BigDecimal(0)) < 0) {
	    LOG.debug("this plane will not cross the Sphere");
	    throw new ServiceException("plane_don't_cross");
	}
	return resultH;
    }

    /**
     * calculate volume of segment
     * 
     * @param radius
     * @param h
     * @return
     */
    private BigDecimal calculateSegmentVolume(final BigDecimal bigRadius, final BigDecimal h) {
	LOG.debug(String.format("start calculateSegmentVolume with bigRadius: %s, h: %s", bigRadius,
		h));

	final BigDecimal volume;
	// (pi * h^2)/ 3
	final BigDecimal piH2divideThree = h.multiply(h).multiply(new BigDecimal(Math.PI / 3));
	// 3*R - h
	final BigDecimal threeRMinusH = bigRadius.add(bigRadius).add(bigRadius).subtract(h);
	volume = piH2divideThree.multiply(threeRMinusH);
	LOG.debug("from calculateSegmentVolume get result " + volume);

	return volume;
    }

    /**
     * returns an array of two values - 1 value of the desired coordinate of the
     * center of the sphere 2 the value of the desired plane coordinate
     */
    private double[] findNeededCoordinate(Sphere sphere, Sphere.CoordinateXYZ firstPoint,
	    Sphere.CoordinateXYZ secondPoint) throws ServiceException {
	double[] result = new double[2];

	boolean conditionX = (secondPoint.getX() == firstPoint.getX());
	boolean conditionY = (secondPoint.getY() == firstPoint.getY());
	boolean conditionZ = (secondPoint.getZ() == firstPoint.getZ());

	if (checkConditions(conditionX, conditionY, conditionZ)) {
	    if (conditionX) {
		result[0] = sphere.getCenterX();
		result[1] = firstPoint.getX();
	    } else if (conditionY) {
		result[0] = sphere.getCenterY();
		result[1] = firstPoint.getY();
	    } else if (conditionZ) {
		result[0] = sphere.getCenterZ();
		result[1] = firstPoint.getZ();
	    }
	} else {
	    LOG.debug(
		    "from findNeededCoordinate, wrong data, has more than one pair of similar coordinates");
	    throw new ServiceException("wronga_data");
	}

	return result;
    }

    /**
     * Only one condition must be true
     * 
     * @param conditionX
     * @param conditionY
     * @param conditionZ
     * @return
     */
    private boolean checkConditions(boolean conditionX, boolean conditionY, boolean conditionZ) {

	if (conditionX && conditionY) {
	    return false;
	}
	if (conditionX && conditionZ) {
	    return false;
	}
	if (conditionY && conditionZ) {
	    return false;
	}
	return true;
    }

    /**
     * return true if all parametres are not Null
     * 
     * @param sphere
     * @param firstPoint
     * @param secondPoint
     * @return
     */
    private boolean checkParamsForNull(Sphere sphere, Sphere.CoordinateXYZ firstPoint,
	    Sphere.CoordinateXYZ secondPoint) {

	boolean condition1 = (sphere != null);
	boolean condition2 = (firstPoint != null);
	boolean condition3 = (secondPoint != null);

	return (condition1 && condition2 && condition3);

    }

}
