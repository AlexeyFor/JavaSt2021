package by.training.task08.entity;

import java.util.Date;

public class Gem {

    private String ID;
    private String preciousness;
    private String name;
    private int price;
    private Date dateOfReceiving;
    private String originCountry;
    private String colour;
    private int transporancy;
    private double weight;

    public double getWeight() {
	return weight;
    }

    public void setWeight(double weight) {
	this.weight = weight;
    }

    public String getName() {
	return name;
    }

    public String getID() {
	return ID;
    }

    public String getPreciousness() {
	return preciousness;
    }

    public void setID(String iD) {
	ID = iD;
    }

    public void setPreciousness(String preciousness) {
	this.preciousness = preciousness;
    }

    public int getPrice() {
	return price;
    }

    public Date getDateOfReceiving() {
	return dateOfReceiving;
    }

    public String getOriginCountry() {
	return originCountry;
    }

    public String getColour() {
	return colour;
    }

    public int getTransporancy() {
	return transporancy;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setPrice(int price) {
	this.price = price;
    }

    public void setDateOfReceiving(Date dateOfReceiving) {
	this.dateOfReceiving = dateOfReceiving;
    }

    public void setOriginCountry(String originCountry) {
	this.originCountry = originCountry;
    }

    public void setColour(String colour) {
	this.colour = colour;
    }

    public void setTransporancy(int transporancy) {
	this.transporancy = transporancy;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((ID == null) ? 0 : ID.hashCode());
	result = prime * result + ((colour == null) ? 0 : colour.hashCode());
	result = prime * result + ((dateOfReceiving == null) ? 0 : dateOfReceiving.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((originCountry == null) ? 0 : originCountry.hashCode());
	result = prime * result + ((preciousness == null) ? 0 : preciousness.hashCode());
	result = prime * result + price;
	result = prime * result + transporancy;
	long temp;
	temp = Double.doubleToLongBits(weight);
	result = prime * result + (int) (temp ^ (temp >>> 32));
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
	Gem other = (Gem) obj;
	if (ID == null) {
	    if (other.ID != null)
		return false;
	} else if (!ID.equals(other.ID))
	    return false;
	if (colour == null) {
	    if (other.colour != null)
		return false;
	} else if (!colour.equals(other.colour))
	    return false;
	if (dateOfReceiving == null) {
	    if (other.dateOfReceiving != null)
		return false;
	} else if (!dateOfReceiving.equals(other.dateOfReceiving))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (originCountry == null) {
	    if (other.originCountry != null)
		return false;
	} else if (!originCountry.equals(other.originCountry))
	    return false;
	if (preciousness == null) {
	    if (other.preciousness != null)
		return false;
	} else if (!preciousness.equals(other.preciousness))
	    return false;
	if (price != other.price)
	    return false;
	if (transporancy != other.transporancy)
	    return false;
	if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Gem [ID=" + ID + ", preciousness=" + preciousness + ", name=" + name + ", price="
		+ price + ", dateOfReceiving=" + dateOfReceiving + ", originCountry="
		+ originCountry + ", colour=" + colour + ", transporancy=" + transporancy
		+ ", weight=" + weight + "]";
    }

}
