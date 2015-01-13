package com.github.t3t5u.common.util;

@SuppressWarnings("serial")
public class NoResultException extends RuntimeException {
	public NoResultException() {
	}

	public NoResultException(final String message) {
		super(message);
	}

	public NoResultException(final Throwable cause) {
		super(cause);
	}

	public NoResultException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
