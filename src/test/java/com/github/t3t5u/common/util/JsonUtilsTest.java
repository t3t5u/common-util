package com.github.t3t5u.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mockito.Matchers;

public class JsonUtilsTest {
	@Test
	public void encodeしてdecodeする1() {
		final IntegerMutableRectangle mr = JsonUtils.decode(new ByteArrayInputStream(JsonUtils.encode(new Rectangle<Integer>(1, 2, 3, 4), new ByteArrayOutputStream(), true, true).toByteArray()), IntegerMutableRectangle.class);
		assertThat(mr.getTop(), is(1));
		assertThat(mr.getLeft(), is(2));
		assertThat(mr.getRight(), is(3));
		assertThat(mr.getBottom(), is(4));
	}

	@Test
	public void encodeしてdecodeする2() {
		final IntegerMutableRectangle mr = JsonUtils.decode(JsonUtils.encode(new Rectangle<Integer>(1, 2, 3, 4), true, true), IntegerMutableRectangle.class);
		assertThat(mr.getTop(), is(1));
		assertThat(mr.getLeft(), is(2));
		assertThat(mr.getRight(), is(3));
		assertThat(mr.getBottom(), is(4));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void Mapをencodeしてdecodeする1() {
		final Map<String, Object> input = new HashMap<String, Object>();
		input.put("foo", "abc");
		input.put("bar", 123);
		final Map<String, Object> output = JsonUtils.decode(new ByteArrayInputStream(JsonUtils.encode(input, new ByteArrayOutputStream(), true, true).toByteArray()), Map.class);
		assertThat((String) output.get("foo"), is("abc"));
		assertThat((BigDecimal) output.get("bar"), is(BigDecimal.valueOf(123)));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void Mapをencodeしてdecodeする2() {
		final Map<String, Object> input = new HashMap<String, Object>();
		input.put("foo", "abc");
		input.put("bar", 123);
		final Map<String, Object> output = JsonUtils.decode(JsonUtils.encode(input, true, true), Map.class);
		assertThat((String) output.get("foo"), is("abc"));
		assertThat((BigDecimal) output.get("bar"), is(BigDecimal.valueOf(123)));
	}

	@Test
	public void 自動的にcloseされる() throws Exception {
		final OutputStream output = mock(OutputStream.class);
		JsonUtils.encodeOrNull(new HashMap<String, Object>(), output, true, true);
		verify(output, atLeastOnce()).close();
		reset(output);
		JsonUtils.encode(new HashMap<String, Object>(), output, true, true);
		verify(output, atLeastOnce()).close();
		final InputStream input = mock(InputStream.class);
		JsonUtils.decodeOrNull(input, Map.class);
		verify(input, atLeastOnce()).close();
		reset(input);
		when(input.markSupported()).thenReturn(true);
		when(input.read(Matchers.<byte[]> anyObject(), anyInt(), anyInt())).thenReturn(-1);
		JsonUtils.decode(input, Map.class);
		verify(input, atLeastOnce()).close();
	}

	@Test
	public void nullになる() {
		assertThat(JsonUtils.decodeOrNull((InputStream) null, null), is(nullValue()));
		assertThat(JsonUtils.decodeOrNull((String) null, null), is(nullValue()));
		assertThat(JsonUtils.encodeOrNull(null, null, true, true), is(nullValue()));
		assertThat(JsonUtils.encodeOrNull(null, true, true), is(nullValue()));
	}

	@Test(expected = NullPointerException.class)
	public void nullをdecodeする1() {
		assertThat(JsonUtils.decode((InputStream) null, null), is(nullValue()));
	}

	@Test(expected = NullPointerException.class)
	public void nullをdecodeする2() {
		assertThat(JsonUtils.decode((String) null, null), is(nullValue()));
	}

	@Test(expected = NullPointerException.class)
	public void nullをencodeする1() {
		assertThat(JsonUtils.encode(null, null, true, true), is(nullValue()));
	}

	@Test(expected = NullPointerException.class)
	public void nullをencodeする2() {
		assertThat(JsonUtils.encode(null, true, true), is(nullValue()));
	}
}
