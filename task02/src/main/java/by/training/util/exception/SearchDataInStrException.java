package by.training.util.exception;

import java.io.Serializable;

public class SearchDataInStrException extends Exception implements Serializable {

	private static final long serialVersionUID = 2759816522330486590L;

	public SearchDataInStrException() {
		super();
	}

	public SearchDataInStrException(String message) {
		super(message);
	}

	public SearchDataInStrException(Exception e) {
		super(e);
	}

	public SearchDataInStrException(String message, Exception e) {
		super(message, e);
	}

}
