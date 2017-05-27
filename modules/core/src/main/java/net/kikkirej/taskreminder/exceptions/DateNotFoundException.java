package net.kikkirej.taskreminder.exceptions;

public class DateNotFoundException extends Exception {

	private static final long serialVersionUID = -5790629075092831816L;

	public DateNotFoundException() {
	}

	public DateNotFoundException(String message) {
		super(message);
	}

	public DateNotFoundException(Throwable cause) {
		super(cause);
	}

	public DateNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public DateNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
