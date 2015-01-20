package com.github.t3t5u.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipException;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ZipUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(ZipUtils.class);

	private ZipUtils() {
	}

	public static ZipFile createOrNull(final String name) {
		if (StringUtils.isBlank(name)) {
			return null;
		}
		try {
			return create(name);
		} catch (final Throwable t) {
			LOGGER.info("createOrNull", t);
			return null;
		}
	}

	public static ZipFile create(final String name) {
		try {
			return new ZipFile(name);
		} catch (final IOException e) {
			LOGGER.warn("create", e);
			throw new RuntimeException(e);
		}
	}

	public static ZipFile createOrNull(final String name, final String encoding) {
		if (StringUtils.isBlank(name) || StringUtils.isBlank(encoding)) {
			return null;
		}
		try {
			return create(name, encoding);
		} catch (final Throwable t) {
			LOGGER.info("createOrNull", t);
			return null;
		}
	}

	public static ZipFile create(final String name, final String encoding) {
		try {
			return new ZipFile(name, encoding);
		} catch (final IOException e) {
			LOGGER.warn("create", e);
			throw new RuntimeException(e);
		}
	}

	public static InputStream getInputStreamOrNull(final ZipFile file, final ZipArchiveEntry entry) {
		if ((file == null) || (entry == null)) {
			return null;
		}
		try {
			return getInputStream(file, entry);
		} catch (final Throwable t) {
			LOGGER.info("getInputStreamOrNull", t);
			return null;
		}
	}

	public static InputStream getInputStream(final ZipFile file, final ZipArchiveEntry entry) {
		try {
			return file.getInputStream(entry);
		} catch (final ZipException e) {
			LOGGER.warn("getInputStream", e);
			throw new RuntimeException(e);
		} catch (final IOException e) {
			LOGGER.warn("getInputStream", e);
			throw new RuntimeException(e);
		}
	}

	public static boolean closeQuietly(final ZipFile file) {
		if (file == null) {
			return false;
		}
		try {
			close(file);
			return true;
		} catch (final Throwable t) {
			LOGGER.info("closeQuietly", t);
			return false;
		}
	}

	public static void close(final ZipFile file) {
		try {
			file.close();
		} catch (final IOException e) {
			LOGGER.warn("close", e);
			throw new RuntimeException(e);
		}
	}
}
