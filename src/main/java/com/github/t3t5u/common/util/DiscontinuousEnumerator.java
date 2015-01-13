package com.github.t3t5u.common.util;

public interface DiscontinuousEnumerator {
	int IGNORE_RAW_NUMBER = Integer.MIN_VALUE;

	int number();

	int rawNumber();
}
