package by.training.task05.service;

import java.math.BigDecimal;
import java.util.List;

import by.training.task05.entity.Sphere;

/**
 * all methods for Sphere
 * 
 * @author AlexeySupruniuk
 *
 */
public interface SphereLogic {

    /**
     * calculate square of Sphere
     * 
     * @param radius
     * @return
     */
    public BigDecimal calculateSquare(double radius) throws ServiceException;

    /**
     * calculate volume of Sphere
     * 
     * @param radius
     * @return
     */
    public BigDecimal calculateVolume(double radius) throws ServiceException;

    /**
     * 
     * Calculates the ratio of the volumes obtained by cutting the ball with a
     * plane. Since, according to the condition, the cutting planes should be
     * oriented in space parallel to the axes and planes of coordinates. The plane
     * is set by two points, in each of them only ONE pair of coordinates are equal
     * (x1 == x2 or y1 == y2 or z1 == z2) otherwise - an error
     * 
     * @param sphere
     * @param firstPoint
     * @param secondPoint
     * @return
     * @throws ServiceException
     */
    public BigDecimal calculateCuttingVolumeRatio(Sphere sphere, Sphere.CoordinateXYZ firstPoint,
	    Sphere.CoordinateXYZ secondPoint) throws ServiceException;

    /**
     * Check, whether the ball touches the coordinate planes
     * 
     * @param sphere
     * @return
     */
    public String sphereTouchCoordinatePlanes(Sphere sphere);

}
