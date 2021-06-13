package by.training.dal;

import java.io.Serializable;

public class DALException extends Exception implements Serializable {

	private static final long serialVersionUID = -7133742087440147500L;

	public DALException() {
		super();
	}

	public DALException(String message) {
		super(message);
	}

	public DALException(Exception e) {
		super(e);
	}

	public DALException(String message, Exception e) {
		super(message, e);
	}

}
