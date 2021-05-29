package by.training.service;

import java.io.Serializable;

public class CoordinateXYLogicException extends Exception implements Serializable {

	private static final long serialVersionUID = -1467881680123511783L;

	public CoordinateXYLogicException() {
		super();
	}

	public CoordinateXYLogicException(String message) {
		super(message);
	}

	public CoordinateXYLogicException(Exception e) {
		super(e);
	}

	public CoordinateXYLogicException(String message, Exception e) {
		super(message, e);
	}

}
