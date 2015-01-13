package com.github.t3t5u.common.util;

public class Reference<T> {
	private T referent;

	public T get() {
		return referent;
	}

	public void set(final T referent) {
		this.referent = referent;
	}
}
