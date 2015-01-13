package com.github.t3t5u.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.annotation.Nullable;

import org.junit.Test;

import com.google.common.base.Function;

public class ExtraArrayUtilsTest {
	@Test
	public void testToObjectArray() {
		assertThat(ExtraArrayUtils.toObjectArray(new boolean[] { true, false, true }), is((Object[]) new Boolean[] { true, false, true }));
		assertThat(ExtraArrayUtils.toObjectArray(new byte[] { 1, 2, 3 }), is((Object[]) new Byte[] { 1, 2, 3 }));
		assertThat(ExtraArrayUtils.toObjectArray(new char[] { 'a', 'b', 'c' }), is((Object[]) new Character[] { 'a', 'b', 'c' }));
		assertThat(ExtraArrayUtils.toObjectArray(new short[] { 1, 2, 3 }), is((Object[]) new Short[] { 1, 2, 3 }));
		assertThat(ExtraArrayUtils.toObjectArray(new int[] { 1, 2, 3 }), is((Object[]) new Integer[] { 1, 2, 3 }));
		assertThat(ExtraArrayUtils.toObjectArray(new long[] { 1L, 2L, 3L }), is((Object[]) new Long[] { 1L, 2L, 3L }));
		assertThat(ExtraArrayUtils.toObjectArray(new float[] { 1F, 2F, 3F }), is((Object[]) new Float[] { 1F, 2F, 3F }));
		assertThat(ExtraArrayUtils.toObjectArray(new double[] { 1D, 2D, 3D }), is((Object[]) new Double[] { 1D, 2D, 3D }));
		assertThat(ExtraArrayUtils.toObjectArray(new String[] { "a", "b", "c" }), is((Object[]) new String[] { "a", "b", "c" }));
		assertThat(ExtraArrayUtils.toObjectArray(true), is(nullValue()));
		assertThat(ExtraArrayUtils.toObjectArray(1), is(nullValue()));
		assertThat(ExtraArrayUtils.toObjectArray('a'), is(nullValue()));
		assertThat(ExtraArrayUtils.toObjectArray("a"), is(nullValue()));
		assertThat(ExtraArrayUtils.toObjectArray(new Object()), is(nullValue()));
		assertThat(ExtraArrayUtils.toObjectArray(null), is(nullValue()));
	}

	@Test
	public void testTransform() {
		final Integer[] integers = new Integer[] { 1, 2, 3, 4, 5 };
		assertThat(integers, is(new Integer[] { 1, 2, 3, 4, 5 }));
		assertThat(integers.getClass().getComponentType().equals(Integer.class), is(true));
		final String[] strings = ExtraArrayUtils.transform(integers, String.class, new Function<Integer, String>() {
			@Override
			@Nullable
			public String apply(@Nullable final Integer input) {
				return input.toString();
			}
		});
		assertThat(strings, is(new String[] { "1", "2", "3", "4", "5" }));
		assertThat(strings.getClass().getComponentType().equals(String.class), is(true));
		final Long[] longs = ExtraArrayUtils.transform(integers, Long.class, new Function<Integer, Long>() {
			@Override
			@Nullable
			public Long apply(@Nullable final Integer input) {
				return input.longValue();
			}
		});
		assertThat(longs, is(new Long[] { 1L, 2L, 3L, 4L, 5L }));
		assertThat(longs.getClass().getComponentType().equals(Long.class), is(true));
	}
}
