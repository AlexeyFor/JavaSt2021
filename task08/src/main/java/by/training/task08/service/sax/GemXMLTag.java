package by.training.task08.service.sax;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         all tags for UnprocessedGem and ProcessedGem
 *
 */
public enum GemXMLTag {

	GEMS("gems"), UNPROCESSEDGEM("unprocessedGem"), PROCESSEDGEM("processedGem"), ID("ID"),
	PRECIOUSNESS("preciousness"), NAME("name"), PRICE("price"), DATEOFRECEIVING("dateOfReceiving"),
	ORIGINCOUNTRY("originCountry"), COLOUR("colour"), TRANSPORANCY("transporancy"), WEIGHT("weight"),
	PROCESSEDTYPE("processedType"), FACESNUMBER("facesNumber"), HEIGHT("height"), LENGTH("length"), WIDTH("width");

	private String value;

	GemXMLTag(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
