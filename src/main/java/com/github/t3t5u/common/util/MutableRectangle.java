package com.github.t3t5u.common.util;

public class MutableRectangle<T> {
	private T top;
	private T left;
	private T right;
	private T bottom;

	public MutableRectangle() {
	}

	public MutableRectangle(final T top, final T left, final T right, final T bottom) {
		this.top = top;
		this.left = left;
		this.right = right;
		this.bottom = bottom;
	}

	public T getTop() {
		return top;
	}

	public void setTop(final T top) {
		this.top = top;
	}

	public T getLeft() {
		return left;
	}

	public void setLeft(final T left) {
		this.left = left;
	}

	public T getRight() {
		return right;
	}

	public void setRight(final T right) {
		this.right = right;
	}

	public T getBottom() {
		return bottom;
	}

	public void setBottom(final T bottom) {
		this.bottom = bottom;
	}
}
