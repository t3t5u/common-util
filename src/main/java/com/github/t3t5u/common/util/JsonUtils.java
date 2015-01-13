package com.github.t3t5u.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;

import net.arnx.jsonic.JSON;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class JsonUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);

	private JsonUtils() {
	}

	public static <T> T decodeOrNull(final InputStream is, final Class<T> clazz) {
		try {
			return decode(is, clazz);
		} catch (final Throwable t) {
			LOGGER.info("decodeOrNull", t);
			return null;
		}
	}

	public static <T> T decode(final InputStream is, final Class<T> clazz) {
		try {
			return JSON.decode(is, clazz);
		} catch (final IOException e) {
			LOGGER.warn("decode", e);
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(is);
		}
	}

	public static <T> T decodeOrNull(final InputStream is, final Type type) {
		try {
			return decode(is, type);
		} catch (final Throwable t) {
			LOGGER.info("decodeOrNull", t);
			return null;
		}
	}

	public static <T> T decode(final InputStream is, final Type type) {
		try {
			return JSON.decode(is, type);
		} catch (final IOException e) {
			LOGGER.warn("decode", e);
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(is);
		}
	}

	public static <T extends OutputStream> T encodeOrNull(final Object o, final T os, final boolean prettyPrint, final boolean suppressNull) {
		try {
			return encode(o, os, prettyPrint, suppressNull);
		} catch (final Throwable t) {
			LOGGER.info("encodeOrNull", t);
			return null;
		}
	}

	public static <T extends OutputStream> T encode(final Object o, final T os, final boolean prettyPrint, final boolean suppressNull) {
		if (o == null) {
			throw new NullPointerException();
		}
		try {
			json(prettyPrint, suppressNull).format(o, os);
			return os;
		} catch (final IOException e) {
			LOGGER.warn("encode", e);
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(os);
		}
	}

	public static <T> T decodeOrNull(final String s, final Class<T> clazz) {
		try {
			return decode(s, clazz);
		} catch (final Throwable t) {
			LOGGER.info("decodeOrNull", t);
			return null;
		}
	}

	public static <T> T decode(final String s, final Class<T> clazz) {
		return JSON.decode(s, clazz);
	}

	public static <T> T decodeOrNull(final String s, final Type type) {
		try {
			return decode(s, type);
		} catch (final Throwable t) {
			LOGGER.info("decodeOrNull", t);
			return null;
		}
	}

	public static <T> T decode(final String s, final Type type) {
		return JSON.decode(s, type);
	}

	public static String encodeOrNull(final Object o, final boolean prettyPrint, final boolean suppressNull) {
		try {
			return encode(o, prettyPrint, suppressNull);
		} catch (final Throwable t) {
			LOGGER.info("encodeOrNull", t);
			return null;
		}
	}

	public static String encode(final Object o, final boolean prettyPrint, final boolean suppressNull) {
		if (o == null) {
			throw new NullPointerException();
		}
		return json(prettyPrint, suppressNull).format(o);
	}

	private static JSON json(final boolean prettyPrint, final boolean suppressNull) {
		final JSON json = new JSON();
		json.setPrettyPrint(prettyPrint);
		json.setSuppressNull(suppressNull);
		return json;
	}
}
