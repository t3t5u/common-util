package com.github.t3t5u.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;

import org.junit.Test;

public class XmlUtilsTest {
	@Test
	public void writeしてreadする1() {
		final IntegerMutableRectangle mr = XmlUtils.read(new ByteArrayInputStream(XmlUtils.write(new Rectangle<Integer>(1, 2, 3, 4), new ByteArrayOutputStream()).toByteArray()), IntegerMutableRectangle.class);
		assertThat(mr.getTop(), is(1));
		assertThat(mr.getLeft(), is(2));
		assertThat(mr.getRight(), is(3));
		assertThat(mr.getBottom(), is(4));
	}

	@Test
	public void writeしてreadする2() {
		final IntegerMutableRectangle mr = XmlUtils.read(XmlUtils.write(new Rectangle<Integer>(1, 2, 3, 4)), IntegerMutableRectangle.class);
		assertThat(mr.getTop(), is(1));
		assertThat(mr.getLeft(), is(2));
		assertThat(mr.getRight(), is(3));
		assertThat(mr.getBottom(), is(4));
	}

	@Test(expected = RuntimeException.class)
	public void Mapをwriteする1() {
		XmlUtils.write(new HashMap<String, Object>(), new ByteArrayOutputStream());
	}

	@Test(expected = RuntimeException.class)
	public void Mapをwriteする2() {
		XmlUtils.write(new HashMap<String, Object>());
	}

	@Test(expected = RuntimeException.class)
	public void Mapをwriteしてreadする1() {
		XmlUtils.read(new ByteArrayInputStream(XmlUtils.write(new Rectangle<Integer>(1, 2, 3, 4), new ByteArrayOutputStream()).toByteArray()), HashMap.class);
	}

	@Test(expected = RuntimeException.class)
	public void Mapをwriteしてreadする2() {
		XmlUtils.read(XmlUtils.write(new Rectangle<Integer>(1, 2, 3, 4)), HashMap.class);
	}

	@Test
	public void 自動的にcloseされる() throws Exception {
		final ByteArrayOutputStream output = spy(new ByteArrayOutputStream());
		XmlUtils.writeOrNull(new HashMap<String, Object>(), output);
		verify(output, atLeastOnce()).close();
		output.reset();
		XmlUtils.write(new Rectangle<Integer>(1, 2, 3, 4), output);
		verify(output, atLeastOnce()).close();
		final InputStream input = spy(new ByteArrayInputStream(output.toByteArray()));
		XmlUtils.readOrNull(input, MutableRectangle.class);
		verify(input, atLeastOnce()).close();
		input.reset();
		XmlUtils.read(input, MutableRectangle.class);
		verify(input, atLeastOnce()).close();
	}

	@Test
	public void nullになる() {
		assertThat(XmlUtils.readOrNull((InputStream) null, null), is(nullValue()));
		assertThat(XmlUtils.readOrNull((String) null, null), is(nullValue()));
		assertThat(XmlUtils.writeOrNull(null, null), is(nullValue()));
		assertThat(XmlUtils.writeOrNull(null), is(nullValue()));
	}

	@Test(expected = RuntimeException.class)
	public void nullをreadする1() {
		assertThat(XmlUtils.read((InputStream) null, null), is(nullValue()));
	}

	@Test(expected = RuntimeException.class)
	public void nullをreadする2() {
		assertThat(XmlUtils.read((String) null, null), is(nullValue()));
	}

	@Test(expected = RuntimeException.class)
	public void nullをwriteする1() {
		assertThat(XmlUtils.write(null, null), is(nullValue()));
	}

	@Test(expected = RuntimeException.class)
	public void nullをwriteする2() {
		assertThat(XmlUtils.write(null), is(nullValue()));
	}
}
