package by.training.util.exception;

import java.io.Serializable;

public class MyTxtReaderException extends Exception implements Serializable {

	private static final long serialVersionUID = 2073038950120840890L;

	public MyTxtReaderException() {
		super();
	}

	public MyTxtReaderException(String message) {
		super(message);
	}

	public MyTxtReaderException(Exception e) {
		super(e);
	}

	public MyTxtReaderException(String message, Exception e) {
		super(message, e);
	}

}
