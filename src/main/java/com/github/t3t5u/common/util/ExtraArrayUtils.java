package com.github.t3t5u.common.util;

import java.lang.reflect.Array;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.base.Function;

public final class ExtraArrayUtils {
	private ExtraArrayUtils() {
	}

	public static <E> E getIfInBounds(final E[] array, final int index) {
		return (array != null) && (index >= 0) && (index < array.length) ? array[index] : null;
	}

	public static Object[] toObjectArray(final Object object) {
		final Class<?> clazz = object != null ? object.getClass() : null;
		final boolean array = (clazz != null) && clazz.isArray();
		final Class<?> componentType = array ? clazz.getComponentType() : null;
		final boolean primitive = (componentType != null) && componentType.isPrimitive();
		if (!array) {
			return null;
		} else if (!primitive) {
			return (Object[]) object;
		} else if (Boolean.TYPE.equals(componentType)) {
			return ArrayUtils.toObject((boolean[]) object);
		} else if (Byte.TYPE.equals(componentType)) {
			return ArrayUtils.toObject((byte[]) object);
		} else if (Character.TYPE.equals(componentType)) {
			return ArrayUtils.toObject((char[]) object);
		} else if (Short.TYPE.equals(componentType)) {
			return ArrayUtils.toObject((short[]) object);
		} else if (Integer.TYPE.equals(componentType)) {
			return ArrayUtils.toObject((int[]) object);
		} else if (Long.TYPE.equals(componentType)) {
			return ArrayUtils.toObject((long[]) object);
		} else if (Float.TYPE.equals(componentType)) {
			return ArrayUtils.toObject((float[]) object);
		} else if (Double.TYPE.equals(componentType)) {
			return ArrayUtils.toObject((double[]) object);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <F, T> T[] transform(final F[] froms, final Class<T> toType, final Function<? super F, ? extends T> function) {
		if ((froms == null) || (toType == null) || (function == null)) {
			return null;
		}
		final T[] tos = (T[]) Array.newInstance(toType, froms.length);
		for (int index = 0; index < tos.length; index++) {
			tos[index] = function.apply(froms[index]);
		}
		return tos;
	}

	@SuppressWarnings("unchecked")
	public static <F, T> T[] transform(final List<? extends F> froms, final Class<T> toType, final Function<? super F, ? extends T> function) {
		if ((froms == null) || (toType == null) || (function == null)) {
			return null;
		}
		final T[] tos = (T[]) Array.newInstance(toType, froms.size());
		for (int index = 0; index < tos.length; index++) {
			tos[index] = function.apply(froms.get(index));
		}
		return tos;
	}
}
