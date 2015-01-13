package com.github.t3t5u.common.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.commons.io.IOUtils;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class XmlUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(XmlUtils.class);

	private XmlUtils() {
	}

	public static <T> T readOrNull(final InputStream is, final Class<T> clazz) {
		try {
			return read(is, clazz);
		} catch (final Throwable t) {
			LOGGER.info("readOrNull", t);
			return null;
		}
	}

	public static <T> T read(final InputStream is, final Class<T> clazz) {
		final Serializer serializer = new Persister();
		try {
			return serializer.read(clazz, is);
		} catch (final Exception e) {
			LOGGER.warn("read", e);
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(is);
		}
	}

	public static <T extends OutputStream> T writeOrNull(final Object o, final T os) {
		try {
			return write(o, os);
		} catch (final Throwable t) {
			LOGGER.info("writeOrNull", t);
			return null;
		}
	}

	public static <T extends OutputStream> T write(final Object o, final T os) {
		final Serializer serializer = new Persister();
		try {
			serializer.write(o, os);
			return os;
		} catch (final Exception e) {
			LOGGER.warn("write", e);
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(os);
		}
	}

	public static <T> T readOrNull(final String s, final Class<T> clazz) {
		try {
			return read(s, clazz);
		} catch (final Throwable t) {
			LOGGER.info("readOrNull", t);
			return null;
		}
	}

	public static <T> T read(final String s, final Class<T> clazz) {
		final Serializer serializer = new Persister();
		try {
			return serializer.read(clazz, s);
		} catch (final Exception e) {
			LOGGER.warn("read", e);
			throw new RuntimeException(e);
		}
	}

	public static String writeOrNull(final Object o) {
		try {
			return write(o);
		} catch (final Throwable t) {
			LOGGER.info("writeOrNull", t);
			return null;
		}
	}

	public static String write(final Object o) {
		final Serializer serializer = new Persister();
		final Writer writer = new StringWriter();
		try {
			serializer.write(o, writer);
			return writer.toString();
		} catch (final Exception e) {
			LOGGER.warn("write", e);
			throw new RuntimeException(e);
		}
	}
}
