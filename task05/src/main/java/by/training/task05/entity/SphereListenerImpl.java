package by.training.task05.entity;

import java.math.BigDecimal;

import by.training.task05.service.ServiceException;
import by.training.task05.service.ServiceProvider;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         For every Sphere - its own listener
 */
public class SphereListenerImpl implements SphereListener {

    private final Long ID;
    private BigDecimal square;
    private BigDecimal volume;

    public SphereListenerImpl(Long id, double radius) {
	super();
	this.ID = id;
	update(radius);
    }

    @Override
    public void update(double radius) {

	try {
	    square = ServiceProvider.getInstance().getSphereLogic().calculateSquare(radius);
	} catch (ServiceException e) {

	    square = new BigDecimal(Double.NaN);
	}
	try {
	    volume = ServiceProvider.getInstance().getSphereLogic().calculateVolume(radius);
	} catch (ServiceException e) {
	    square = new BigDecimal(Double.NaN);

	}
    }

    public Long getID() {
	return ID;
    }

    public BigDecimal getSquare() {
	return square;
    }

    public BigDecimal getVolume() {
	return volume;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((ID == null) ? 0 : ID.hashCode());
	result = prime * result + ((square == null) ? 0 : square.hashCode());
	result = prime * result + ((volume == null) ? 0 : volume.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	SphereListenerImpl other = (SphereListenerImpl) obj;
	if (ID == null) {
	    if (other.ID != null)
		return false;
	} else if (!ID.equals(other.ID))
	    return false;
	if (square == null) {
	    if (other.square != null)
		return false;
	} else if (!square.equals(other.square))
	    return false;
	if (volume == null) {
	    if (other.volume != null)
		return false;
	} else if (!volume.equals(other.volume))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "SphereListenerImpl [ID=" + ID + ", square=" + square + ", volume=" + volume + "]";
    }

}
