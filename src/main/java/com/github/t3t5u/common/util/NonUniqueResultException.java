package com.github.t3t5u.common.util;

@SuppressWarnings("serial")
public class NonUniqueResultException extends RuntimeException {
	public NonUniqueResultException() {
	}

	public NonUniqueResultException(final String message) {
		super(message);
	}

	public NonUniqueResultException(final Throwable cause) {
		super(cause);
	}

	public NonUniqueResultException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
