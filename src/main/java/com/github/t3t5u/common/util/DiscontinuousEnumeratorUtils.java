package com.github.t3t5u.common.util;

public final class DiscontinuousEnumeratorUtils {
	private DiscontinuousEnumeratorUtils() {
	}

	public static <T extends DiscontinuousEnumerator> int number(final T value, final int difference, final T[] values, final int ordinal) {
		return value != null ? value.number() + difference : number(values, ordinal);
	}

	private static <T extends DiscontinuousEnumerator> int number(final T[] values, final int ordinal) {
		int difference = 0;
		while ((ordinal - difference) > 0) {
			if (values[ordinal - difference].rawNumber() != DiscontinuousEnumerator.IGNORE_RAW_NUMBER) {
				break;
			}
			difference++;
		}
		final int rawNumber = values[ordinal - difference].rawNumber();
		return (rawNumber != DiscontinuousEnumerator.IGNORE_RAW_NUMBER ? rawNumber : 0) + difference;
	}

	public static <T extends DiscontinuousEnumerator> int rawNumber(final T value, final int difference, final int rawNumber) {
		return value != null ? value.number() + difference : rawNumber;
	}

	public static <T extends DiscontinuousEnumerator> T byNumber(final T[] values, final int number) {
		for (final T value : values) {
			if (value.number() == number) {
				return value;
			}
		}
		return null;
	}
}
