package by.training.task05.repository;

import java.io.Serializable;

public class RepositoryException extends Exception implements Serializable {

	private static final long serialVersionUID = 9047971040972534760L;

	public RepositoryException() {
		super();
	}

	public RepositoryException(String message) {
		super(message);
	}

	public RepositoryException(Exception e) {
		super(e);
	}

	public RepositoryException(String message, Exception e) {
		super(message, e);
	}

}
