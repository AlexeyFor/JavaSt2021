package by.training.service.creator;

import java.io.Serializable;

public class CreatorException extends Exception implements Serializable {

	private static final long serialVersionUID = -3212567476643453561L;

	public CreatorException() {
		super();
	}

	public CreatorException(String message) {
		super(message);
	}

	public CreatorException(Exception e) {
		super(e);
	}

	public CreatorException(String message, Exception e) {
		super(message, e);
	}

}
