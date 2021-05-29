package by.training.util;

import java.io.Serializable;


public class MyScanException extends Exception implements Serializable  {

	private static final long serialVersionUID = -3954782397730064385L;

		public MyScanException() {
			super();
		}

		public MyScanException(String message) {
			super(message);
		}

		public MyScanException(Exception e) {
			super(e);
		}

		public MyScanException(String message, Exception e) {
			super(message, e);
		}

	}


