package com.github.t3t5u.common.util;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@SuppressWarnings("serial")
public class Point<T> implements Serializable {
	private final T x;
	private final T y;

	public Point(final T x, final T y) {
		this.x = x;
		this.y = y;
	}

	public T getX() {
		return x;
	}

	public T getY() {
		return y;
	}

	@Override
	public boolean equals(final Object o) {
		return (o == this) || ((o instanceof Point) && new EqualsBuilder().append(getX(), ((Point<?>) o).getX()).append(getY(), ((Point<?>) o).getY()).build());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getX()).append(getY()).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(getX()).append(getY()).build();
	}
}
