package com.github.t3t5u.common.util;

import java.math.BigDecimal;

public final class ExtraNumberUtils {
	private ExtraNumberUtils() {
	}

	public static BigDecimal toBigDecimal(final Number number) {
		if (number == null) {
			return null;
		} else if (number instanceof BigDecimal) {
			return (BigDecimal) number;
		} else if (number instanceof Byte) {
			return new BigDecimal((Byte) number);
		} else if (number instanceof Short) {
			return new BigDecimal((Short) number);
		} else if (number instanceof Integer) {
			return new BigDecimal((Integer) number);
		} else if (number instanceof Long) {
			return new BigDecimal((Long) number);
		} else if (number instanceof Float) {
			return new BigDecimal((Float) number);
		} else if (number instanceof Double) {
			return new BigDecimal((Double) number);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T extends Number> T toNumber(final BigDecimal bigDecimal, final Class<T> clazz) {
		if (bigDecimal == null) {
			return null;
		} else if (BigDecimal.class.isAssignableFrom(clazz)) {
			return (T) bigDecimal;
		} else if (Byte.class.isAssignableFrom(clazz)) {
			return (T) new Byte(bigDecimal.byteValue());
		} else if (Short.class.isAssignableFrom(clazz)) {
			return (T) new Short(bigDecimal.shortValue());
		} else if (Integer.class.isAssignableFrom(clazz)) {
			return (T) new Integer(bigDecimal.intValue());
		} else if (Long.class.isAssignableFrom(clazz)) {
			return (T) new Long(bigDecimal.longValue());
		} else if (Float.class.isAssignableFrom(clazz)) {
			return (T) new Float(bigDecimal.floatValue());
		} else if (Double.class.isAssignableFrom(clazz)) {
			return (T) new Double(bigDecimal.doubleValue());
		} else {
			return null;
		}
	}
}
