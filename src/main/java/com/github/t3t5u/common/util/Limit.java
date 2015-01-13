package com.github.t3t5u.common.util;

import org.apache.commons.lang3.ObjectUtils;

public class Limit<A extends Comparable<? super A>, R extends Comparable<? super R>> {
	private final A absolute;
	private final R relative;

	public Limit(final A absolute, final R relative) {
		this.absolute = absolute;
		this.relative = relative;
	}

	public A getAbsolute() {
		return absolute;
	}

	public R getRelative() {
		return relative;
	}

	public boolean isOver(final A absolute, final R relative) {
		return (ObjectUtils.compare(absolute, this.absolute) > 0) || (ObjectUtils.compare(relative, this.relative) > 0);
	}
}
