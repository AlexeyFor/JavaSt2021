package by.training.task08.service;

public enum Parsers {

	DOM("DOM"), SAX("SAX"), STAX("STAX");

	private String value;

	Parsers(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
