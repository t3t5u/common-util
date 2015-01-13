package com.github.t3t5u.common.util;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ExtraFieldUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExtraFieldUtils.class);

	private ExtraFieldUtils() {
	}

	public static <V> V readStaticFieldOrNull(final Class<?> clazz, final String fieldName) {
		if ((clazz == null) || (fieldName == null)) {
			return null;
		}
		try {
			return readStaticField(clazz, fieldName);
		} catch (final Throwable t) {
			LOGGER.info("readStaticFieldOrNull", t);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <V> V readStaticField(final Class<?> clazz, final String fieldName) {
		try {
			return (V) FieldUtils.readStaticField(clazz, fieldName);
		} catch (final IllegalAccessException e) {
			LOGGER.warn("readStaticField", e);
			throw new RuntimeException(e);
		}
	}

	public static <V> V readStaticFieldOrNull(final Class<?> clazz, final String fieldName, final boolean forceAccess) {
		if ((clazz == null) || (fieldName == null)) {
			return null;
		}
		try {
			return readStaticField(clazz, fieldName, forceAccess);
		} catch (final Throwable t) {
			LOGGER.info("readStaticFieldOrNull", t);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <V> V readStaticField(final Class<?> clazz, final String fieldName, final boolean forceAccess) {
		try {
			return (V) FieldUtils.readStaticField(clazz, fieldName, forceAccess);
		} catch (final IllegalAccessException e) {
			LOGGER.warn("readStaticField", e);
			throw new RuntimeException(e);
		}
	}

	public static <V> V readDeclaredStaticFieldOrNull(final Class<?> clazz, final String fieldName) {
		if ((clazz == null) || (fieldName == null)) {
			return null;
		}
		try {
			return readDeclaredStaticField(clazz, fieldName);
		} catch (final Throwable t) {
			LOGGER.info("readDeclaredStaticFieldOrNull", t);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <V> V readDeclaredStaticField(final Class<?> clazz, final String fieldName) {
		try {
			return (V) FieldUtils.readDeclaredStaticField(clazz, fieldName);
		} catch (final IllegalAccessException e) {
			LOGGER.warn("readDeclaredStaticField", e);
			throw new RuntimeException(e);
		}
	}

	public static <V> V readDeclaredStaticFieldOrNull(final Class<?> clazz, final String fieldName, final boolean forceAccess) {
		if ((clazz == null) || (fieldName == null)) {
			return null;
		}
		try {
			return readDeclaredStaticField(clazz, fieldName, forceAccess);
		} catch (final Throwable t) {
			LOGGER.info("readDeclaredStaticFieldOrNull", t);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <V> V readDeclaredStaticField(final Class<?> clazz, final String fieldName, final boolean forceAccess) {
		try {
			return (V) FieldUtils.readDeclaredStaticField(clazz, fieldName, forceAccess);
		} catch (final IllegalAccessException e) {
			LOGGER.warn("readDeclaredStaticField", e);
			throw new RuntimeException(e);
		}
	}

	public static <V, T> V readFieldOrNull(final T target, final Class<? super T> clazz, final String fieldName) {
		if ((target == null) || (clazz == null) || (fieldName == null)) {
			return null;
		}
		try {
			return readField(target, clazz, fieldName);
		} catch (final Throwable t) {
			LOGGER.info("readFieldOrNull", t);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <V, T> V readField(final T target, final Class<? super T> clazz, final String fieldName) {
		try {
			return (V) FieldUtils.readField(FieldUtils.getField(clazz, fieldName), target);
		} catch (final IllegalAccessException e) {
			LOGGER.warn("readField", e);
			throw new RuntimeException(e);
		}
	}

	public static <V, T> V readFieldOrNull(final T target, final Class<? super T> clazz, final String fieldName, final boolean forceAccess) {
		if ((target == null) || (clazz == null) || (fieldName == null)) {
			return null;
		}
		try {
			return readField(target, clazz, fieldName, forceAccess);
		} catch (final Throwable t) {
			LOGGER.info("readFieldOrNull", t);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <V, T> V readField(final T target, final Class<? super T> clazz, final String fieldName, final boolean forceAccess) {
		try {
			return (V) FieldUtils.readField(FieldUtils.getField(clazz, fieldName, forceAccess), target);
		} catch (final IllegalAccessException e) {
			LOGGER.warn("readField", e);
			throw new RuntimeException(e);
		}
	}

	public static <V, T> V readDeclaredFieldOrNull(final T target, final Class<? super T> clazz, final String fieldName) {
		if ((target == null) || (clazz == null) || (fieldName == null)) {
			return null;
		}
		try {
			return readDeclaredField(target, clazz, fieldName);
		} catch (final Throwable t) {
			LOGGER.info("readDeclaredFieldOrNull", t);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <V, T> V readDeclaredField(final T target, final Class<? super T> clazz, final String fieldName) {
		try {
			return (V) FieldUtils.readField(FieldUtils.getDeclaredField(clazz, fieldName), target);
		} catch (final IllegalAccessException e) {
			LOGGER.warn("readDeclaredField", e);
			throw new RuntimeException(e);
		}
	}

	public static <V, T> V readDeclaredFieldOrNull(final T target, final Class<? super T> clazz, final String fieldName, final boolean forceAccess) {
		if ((target == null) || (clazz == null) || (fieldName == null)) {
			return null;
		}
		try {
			return readDeclaredField(target, clazz, fieldName, forceAccess);
		} catch (final Throwable t) {
			LOGGER.info("readDeclaredFieldOrNull", t);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <V, T> V readDeclaredField(final T target, final Class<? super T> clazz, final String fieldName, final boolean forceAccess) {
		try {
			return (V) FieldUtils.readField(FieldUtils.getDeclaredField(clazz, fieldName, forceAccess), target);
		} catch (final IllegalAccessException e) {
			LOGGER.warn("readDeclaredField", e);
			throw new RuntimeException(e);
		}
	}

	public static <V> V readFieldOrNull(final Object target, final String fieldName) {
		if ((target == null) || (fieldName == null)) {
			return null;
		}
		try {
			return readField(target, fieldName);
		} catch (final Throwable t) {
			LOGGER.info("readFieldOrNull", t);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <V> V readField(final Object target, final String fieldName) {
		try {
			return (V) FieldUtils.readField(target, fieldName);
		} catch (final IllegalAccessException e) {
			LOGGER.warn("readField", e);
			throw new RuntimeException(e);
		}
	}

	public static <V> V readFieldOrNull(final Object target, final String fieldName, final boolean forceAccess) {
		if ((target == null) || (fieldName == null)) {
			return null;
		}
		try {
			return readField(target, fieldName, forceAccess);
		} catch (final Throwable t) {
			LOGGER.info("readFieldOrNull", t);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <V> V readField(final Object target, final String fieldName, final boolean forceAccess) {
		try {
			return (V) FieldUtils.readField(target, fieldName, forceAccess);
		} catch (final IllegalAccessException e) {
			LOGGER.warn("readField", e);
			throw new RuntimeException(e);
		}
	}

	public static <V> V readDeclaredFieldOrNull(final Object target, final String fieldName) {
		if ((target == null) || (fieldName == null)) {
			return null;
		}
		try {
			return readDeclaredField(target, fieldName);
		} catch (final Throwable t) {
			LOGGER.info("readDeclaredFieldOrNull", t);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <V> V readDeclaredField(final Object target, final String fieldName) {
		try {
			return (V) FieldUtils.readDeclaredField(target, fieldName);
		} catch (final IllegalAccessException e) {
			LOGGER.warn("readDeclaredField", e);
			throw new RuntimeException(e);
		}
	}

	public static <V> V readDeclaredFieldOrNull(final Object target, final String fieldName, final boolean forceAccess) {
		if ((target == null) || (fieldName == null)) {
			return null;
		}
		try {
			return readDeclaredField(target, fieldName, forceAccess);
		} catch (final Throwable t) {
			LOGGER.info("readDeclaredFieldOrNull", t);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <V> V readDeclaredField(final Object target, final String fieldName, final boolean forceAccess) {
		try {
			return (V) FieldUtils.readDeclaredField(target, fieldName, forceAccess);
		} catch (final IllegalAccessException e) {
			LOGGER.warn("readDeclaredField", e);
			throw new RuntimeException(e);
		}
	}

	public static <T> Class<T> writeStaticFieldOrNull(final Class<T> clazz, final String fieldName, final Object value) {
		if ((clazz == null) || (fieldName == null)) {
			return null;
		}
		try {
			return writeStaticField(clazz, fieldName, value);
		} catch (final Throwable t) {
			LOGGER.info("writeStaticFieldOrNull", t);
			return null;
		}
	}

	public static <T> Class<T> writeStaticField(final Class<T> clazz, final String fieldName, final Object value) {
		try {
			FieldUtils.writeStaticField(clazz, fieldName, value);
			return clazz;
		} catch (final IllegalAccessException e) {
			LOGGER.warn("writeStaticField", e);
			throw new RuntimeException(e);
		}
	}

	public static <T> Class<T> writeStaticFieldOrNull(final Class<T> clazz, final String fieldName, final Object value, final boolean forceAccess) {
		if ((clazz == null) || (fieldName == null)) {
			return null;
		}
		try {
			return writeStaticField(clazz, fieldName, value, forceAccess);
		} catch (final Throwable t) {
			LOGGER.info("writeStaticFieldOrNull", t);
			return null;
		}
	}

	public static <T> Class<T> writeStaticField(final Class<T> clazz, final String fieldName, final Object value, final boolean forceAccess) {
		try {
			FieldUtils.writeStaticField(clazz, fieldName, value, forceAccess);
			return clazz;
		} catch (final IllegalAccessException e) {
			LOGGER.warn("writeStaticField", e);
			throw new RuntimeException(e);
		}
	}

	public static <T> Class<T> writeDeclaredStaticFieldOrNull(final Class<T> clazz, final String fieldName, final Object value) {
		if ((clazz == null) || (fieldName == null)) {
			return null;
		}
		try {
			return writeDeclaredStaticField(clazz, fieldName, value);
		} catch (final Throwable t) {
			LOGGER.info("writeDeclaredStaticFieldOrNull", t);
			return null;
		}
	}

	public static <T> Class<T> writeDeclaredStaticField(final Class<T> clazz, final String fieldName, final Object value) {
		try {
			FieldUtils.writeDeclaredStaticField(clazz, fieldName, value);
			return clazz;
		} catch (final IllegalAccessException e) {
			LOGGER.warn("writeDeclaredStaticField", e);
			throw new RuntimeException(e);
		}
	}

	public static <T> Class<T> writeDeclaredStaticFieldOrNull(final Class<T> clazz, final String fieldName, final Object value, final boolean forceAccess) {
		if ((clazz == null) || (fieldName == null)) {
			return null;
		}
		try {
			return writeDeclaredStaticField(clazz, fieldName, value, forceAccess);
		} catch (final Throwable t) {
			LOGGER.info("writeDeclaredStaticFieldOrNull", t);
			return null;
		}
	}

	public static <T> Class<T> writeDeclaredStaticField(final Class<T> clazz, final String fieldName, final Object value, final boolean forceAccess) {
		try {
			FieldUtils.writeDeclaredStaticField(clazz, fieldName, value, forceAccess);
			return clazz;
		} catch (final IllegalAccessException e) {
			LOGGER.warn("writeDeclaredStaticField", e);
			throw new RuntimeException(e);
		}
	}

	public static <T> T writeFieldOrNull(final T target, final Class<? super T> clazz, final String fieldName, final Object value) {
		if ((target == null) || (clazz == null) || (fieldName == null)) {
			return null;
		}
		try {
			return writeField(target, clazz, fieldName, value);
		} catch (final Throwable t) {
			LOGGER.info("writeFieldOrNull", t);
			return null;
		}
	}

	public static <T> T writeField(final T target, final Class<? super T> clazz, final String fieldName, final Object value) {
		try {
			FieldUtils.writeField(FieldUtils.getField(clazz, fieldName), target, value);
			return target;
		} catch (final IllegalAccessException e) {
			LOGGER.warn("writeField", e);
			throw new RuntimeException(e);
		}
	}

	public static <T> T writeFieldOrNull(final T target, final Class<? super T> clazz, final String fieldName, final Object value, final boolean forceAccess) {
		if ((target == null) || (clazz == null) || (fieldName == null)) {
			return null;
		}
		try {
			return writeField(target, clazz, fieldName, value, forceAccess);
		} catch (final Throwable t) {
			LOGGER.info("writeFieldOrNull", t);
			return null;
		}
	}

	public static <T> T writeField(final T target, final Class<? super T> clazz, final String fieldName, final Object value, final boolean forceAccess) {
		try {
			FieldUtils.writeField(FieldUtils.getField(clazz, fieldName, forceAccess), target, value);
			return target;
		} catch (final IllegalAccessException e) {
			LOGGER.warn("writeField", e);
			throw new RuntimeException(e);
		}
	}

	public static <T> T writeDeclaredFieldOrNull(final T target, final Class<? super T> clazz, final String fieldName, final Object value) {
		if ((target == null) || (clazz == null) || (fieldName == null)) {
			return null;
		}
		try {
			return writeDeclaredField(target, clazz, fieldName, value);
		} catch (final Throwable t) {
			LOGGER.info("writeDeclaredFieldOrNull", t);
			return null;
		}
	}

	public static <T> T writeDeclaredField(final T target, final Class<? super T> clazz, final String fieldName, final Object value) {
		try {
			FieldUtils.writeField(FieldUtils.getDeclaredField(clazz, fieldName), target, value);
			return target;
		} catch (final IllegalAccessException e) {
			LOGGER.warn("writeDeclaredField", e);
			throw new RuntimeException(e);
		}
	}

	public static <T> T writeDeclaredFieldOrNull(final T target, final Class<? super T> clazz, final String fieldName, final Object value, final boolean forceAccess) {
		if ((target == null) || (clazz == null) || (fieldName == null)) {
			return null;
		}
		try {
			return writeDeclaredField(target, clazz, fieldName, value, forceAccess);
		} catch (final Throwable t) {
			LOGGER.info("writeDeclaredFieldOrNull", t);
			return null;
		}
	}

	public static <T> T writeDeclaredField(final T target, final Class<? super T> clazz, final String fieldName, final Object value, final boolean forceAccess) {
		try {
			FieldUtils.writeField(FieldUtils.getDeclaredField(clazz, fieldName, forceAccess), target, value);
			return target;
		} catch (final IllegalAccessException e) {
			LOGGER.warn("writeDeclaredField", e);
			throw new RuntimeException(e);
		}
	}

	public static <T> T writeFieldOrNull(final T target, final String fieldName, final Object value) {
		if ((target == null) || (fieldName == null)) {
			return null;
		}
		try {
			return writeField(target, fieldName, value);
		} catch (final Throwable t) {
			LOGGER.info("writeFieldOrNull", t);
			return null;
		}
	}

	public static <T> T writeField(final T target, final String fieldName, final Object value) {
		try {
			FieldUtils.writeField(target, fieldName, value);
			return target;
		} catch (final IllegalAccessException e) {
			LOGGER.warn("writeField", e);
			throw new RuntimeException(e);
		}
	}

	public static <T> T writeFieldOrNull(final T target, final String fieldName, final Object value, final boolean forceAccess) {
		if ((target == null) || (fieldName == null)) {
			return null;
		}
		try {
			return writeField(target, fieldName, value, forceAccess);
		} catch (final Throwable t) {
			LOGGER.info("writeFieldOrNull", t);
			return null;
		}
	}

	public static <T> T writeField(final T target, final String fieldName, final Object value, final boolean forceAccess) {
		try {
			FieldUtils.writeField(target, fieldName, value, forceAccess);
			return target;
		} catch (final IllegalAccessException e) {
			LOGGER.warn("writeField", e);
			throw new RuntimeException(e);
		}
	}

	public static <T> T writeDeclaredFieldOrNull(final T target, final String fieldName, final Object value) {
		if ((target == null) || (fieldName == null)) {
			return null;
		}
		try {
			return writeDeclaredField(target, fieldName, value);
		} catch (final Throwable t) {
			LOGGER.info("writeDeclaredFieldOrNull", t);
			return null;
		}
	}

	public static <T> T writeDeclaredField(final T target, final String fieldName, final Object value) {
		try {
			FieldUtils.writeDeclaredField(target, fieldName, value);
			return target;
		} catch (final IllegalAccessException e) {
			LOGGER.warn("writeDeclaredField", e);
			throw new RuntimeException(e);
		}
	}

	public static <T> T writeDeclaredFieldOrNull(final T target, final String fieldName, final Object value, final boolean forceAccess) {
		if ((target == null) || (fieldName == null)) {
			return null;
		}
		try {
			return writeDeclaredField(target, fieldName, value, forceAccess);
		} catch (final Throwable t) {
			LOGGER.info("writeDeclaredFieldOrNull", t);
			return null;
		}
	}

	public static <T> T writeDeclaredField(final T target, final String fieldName, final Object value, final boolean forceAccess) {
		try {
			FieldUtils.writeDeclaredField(target, fieldName, value, forceAccess);
			return target;
		} catch (final IllegalAccessException e) {
			LOGGER.warn("writeDeclaredField", e);
			throw new RuntimeException(e);
		}
	}
}
