package by.training.task08.entity;

public class ProcessedGem extends Gem {

    private String processedType;
    private int facesNumber;

    public String getProcessedType() {
	return processedType;
    }

    public int getFacesNumber() {
	return facesNumber;
    }

    public void setProcessedType(String processedType) {
	this.processedType = processedType;
    }

    public void setFacesNumber(int facesNumber) {
	this.facesNumber = facesNumber;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + facesNumber;
	result = prime * result + ((processedType == null) ? 0 : processedType.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	ProcessedGem other = (ProcessedGem) obj;
	if (facesNumber != other.facesNumber)
	    return false;
	if (processedType == null) {
	    if (other.processedType != null)
		return false;
	} else if (!processedType.equals(other.processedType))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "ProcessedGem [processedType=" + processedType + ", facesNumber=" + facesNumber
		+ ", toString()=" + super.toString() + "]";
    }

}
