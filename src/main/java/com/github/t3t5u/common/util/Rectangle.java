package com.github.t3t5u.common.util;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Rectangle<T> implements Serializable {
	private final T top;
	private final T left;
	private final T right;
	private final T bottom;

	public Rectangle(final T top, final T left, final T right, final T bottom) {
		this.top = top;
		this.left = left;
		this.right = right;
		this.bottom = bottom;
	}

	public T getTop() {
		return top;
	}

	public T getLeft() {
		return left;
	}

	public T getRight() {
		return right;
	}

	public T getBottom() {
		return bottom;
	}
}
