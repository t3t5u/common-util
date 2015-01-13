package com.github.t3t5u.common.util;

import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ExtraClassUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExtraClassUtils.class);

	private ExtraClassUtils() {
	}

	public static Class<?> forNameOrNull(final String className) {
		try {
			return forName(className);
		} catch (final Throwable t) {
			LOGGER.info("forNameOrNull", t);
			return null;
		}
	}

	public static Class<?> forName(final String className) {
		try {
			return Class.forName(className);
		} catch (final ClassNotFoundException e) {
			LOGGER.warn("forName", e);
			throw new RuntimeException(e);
		}
	}

	public static <T> T newInstanceOrNull(final Class<T> type) {
		try {
			return newInstance(type);
		} catch (final Throwable t) {
			LOGGER.info("newInstanceOrNull", t);
			return null;
		}
	}

	public static <T> T newInstance(final Class<T> type) {
		try {
			return type.newInstance();
		} catch (final InstantiationException e) {
			LOGGER.warn("newInstance", e);
			throw new RuntimeException(e);
		} catch (final IllegalAccessException e) {
			LOGGER.warn("newInstance", e);
			throw new RuntimeException(e);
		}
	}

	public static <T> T newInstanceOrNull(final Class<T> type, final Class<?>[] types, final Object... params) {
		try {
			return newInstance(type, types, params);
		} catch (final Throwable t) {
			LOGGER.info("newInstanceOrNull", t);
			return null;
		}
	}

	public static <T> T newInstance(final Class<T> type, final Class<?>[] types, final Object... params) {
		if (types.length != params.length) {
			throw new IllegalArgumentException();
		}
		try {
			return type.getConstructor(types).newInstance(params);
		} catch (final InstantiationException e) {
			LOGGER.warn("newInstance", e);
			throw new RuntimeException(e);
		} catch (final IllegalAccessException e) {
			LOGGER.warn("newInstance", e);
			throw new RuntimeException(e);
		} catch (final IllegalArgumentException e) {
			LOGGER.warn("newInstance", e);
			throw new RuntimeException(e);
		} catch (final SecurityException e) {
			LOGGER.warn("newInstance", e);
			throw new RuntimeException(e);
		} catch (final InvocationTargetException e) {
			LOGGER.warn("newInstance", e);
			throw new RuntimeException(e);
		} catch (final NoSuchMethodException e) {
			LOGGER.warn("newInstance", e);
			throw new RuntimeException(e);
		}
	}
}
