package com.github.t3t5u.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;

public final class ExtraIOUtils {
	private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;
	private static final Charset DEFAULT_CHARSET = Charsets.UTF_8;
	private static final Logger LOGGER = LoggerFactory.getLogger(ExtraIOUtils.class);

	private ExtraIOUtils() {
	}

	public static InputStream openInputStreamOrNull(final String pathName) {
		return StringUtils.isBlank(pathName) ? null : openInputStreamOrNull(new File(pathName));
	}

	public static InputStream openInputStream(final String pathName) {
		return openInputStream(new File(pathName));
	}

	public static InputStream openInputStreamOrNull(final File file) {
		if (file == null) {
			return null;
		}
		try {
			return openInputStream(file);
		} catch (final Throwable t) {
			LOGGER.info("openInputStreamOrNull", t);
			return null;
		}
	}

	public static InputStream openInputStream(final File file) {
		try {
			return new FileInputStream(file);
		} catch (final FileNotFoundException e) {
			LOGGER.warn("openInputStream: " + ExtraFileUtils.getAbsolutePath(file), e);
			throw new RuntimeException(e);
		}
	}

	public static <R> R drainOrNull(final String pathName, final Function<? super R, ? extends Function<byte[], ? extends R>> function, final R init, final byte[] buffer) {
		return StringUtils.isBlank(pathName) || (function == null) ? null : drainOrNull(new File(pathName), function, init, buffer);
	}

	public static <R> R drain(final String pathName, final Function<? super R, ? extends Function<byte[], ? extends R>> function, final R init, final byte[] buffer) {
		return drain(new File(pathName), function, init, buffer);
	}

	public static <R> R drainOrNull(final File file, final Function<? super R, ? extends Function<byte[], ? extends R>> function, final R init, final byte[] buffer) {
		if ((file == null) || (function == null)) {
			return null;
		}
		try {
			return drain(file, function, init, buffer);
		} catch (final Throwable t) {
			LOGGER.info("drainOrNull", t);
			return null;
		}
	}

	public static <R> R drain(final File file, final Function<? super R, ? extends Function<byte[], ? extends R>> function, final R init, final byte[] buffer) {
		return drain(openInputStream(file), function, init, buffer);
	}

	public static <R> R drainOrNull(final InputStream is, final Function<? super R, ? extends Function<byte[], ? extends R>> function, final R init, final byte[] buffer) {
		if ((is == null) || (function == null)) {
			IOUtils.closeQuietly(is);
			return null;
		}
		try {
			return drain(is, function, init, buffer);
		} catch (final Throwable t) {
			LOGGER.info("drainOrNull", t);
			return null;
		}
	}

	public static <R> R drain(final InputStream is, final Function<? super R, ? extends Function<byte[], ? extends R>> function, final R init, final byte[] buffer) {
		try {
			return read(is, function, init, buffer);
		} catch (final IOException e) {
			LOGGER.warn("drain", e);
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(is);
		}
	}

	private static <R> R read(final InputStream is, final Function<? super R, ? extends Function<byte[], ? extends R>> function, final R init, final byte[] buffer) throws IOException {
		R result = init;
		final byte[] bytes = buffer != null ? buffer : new byte[DEFAULT_BUFFER_SIZE];
		while (true) {
			final int read = is.read(bytes);
			if (read < 0) {
				break;
			}
			result = function.apply(result).apply(read == bytes.length ? bytes : Arrays.copyOf(bytes, read));
		}
		return result;
	}

	public static byte[] readOrNull(final String pathName) {
		return StringUtils.isBlank(pathName) ? null : readOrNull(new File(pathName));
	}

	public static byte[] read(final String pathName) {
		return read(new File(pathName));
	}

	public static byte[] readOrNull(final File file) {
		if (file == null) {
			return null;
		}
		try {
			return read(file);
		} catch (final Throwable t) {
			LOGGER.info("readOrNull", t);
			return null;
		}
	}

	public static byte[] read(final File file) {
		return read(openInputStream(file));
	}

	public static byte[] readOrNull(final InputStream is) {
		if (is == null) {
			IOUtils.closeQuietly(is);
			return null;
		}
		try {
			return read(is);
		} catch (final Throwable t) {
			LOGGER.info("readOrNull", t);
			return null;
		}
	}

	public static byte[] read(final InputStream is) {
		byte[] bytes = null;
		try {
			bytes = IOUtils.toByteArray(is);
		} catch (final IOException e) {
			LOGGER.warn("read", e);
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(is);
		}
		return bytes;
	}

	public static String readAsStringOrNull(final String pathName) {
		return StringUtils.isBlank(pathName) ? null : readAsStringOrNull(new File(pathName));
	}

	public static String readAsString(final String pathName) {
		return readAsString(new File(pathName));
	}

	public static String readAsStringOrNull(final File file) {
		if (file == null) {
			return null;
		}
		try {
			return readAsString(file);
		} catch (final Throwable t) {
			LOGGER.info("readAsStringOrNull", t);
			return null;
		}
	}

	public static String readAsString(final File file) {
		return readAsString(openInputStream(file));
	}

	public static String readAsStringOrNull(final InputStream is) {
		if (is == null) {
			IOUtils.closeQuietly(is);
			return null;
		}
		try {
			return readAsString(is);
		} catch (final Throwable t) {
			LOGGER.info("readAsStringOrNull", t);
			return null;
		}
	}

	public static String readAsString(final InputStream is) {
		return readAsString(is, DEFAULT_CHARSET);
	}

	public static String readAsStringOrNull(final String pathName, final Charset charset) {
		return StringUtils.isBlank(pathName) ? null : readAsStringOrNull(new File(pathName), charset);
	}

	public static String readAsString(final String pathName, final Charset charset) {
		return readAsString(new File(pathName), charset);
	}

	public static String readAsStringOrNull(final File file, final Charset charset) {
		if ((file == null) || (charset == null)) {
			return null;
		}
		try {
			return readAsString(file, charset);
		} catch (final Throwable t) {
			LOGGER.info("readAsStringOrNull", t);
			return null;
		}
	}

	public static String readAsString(final File file, final Charset charset) {
		return readAsString(openInputStream(file), charset);
	}

	public static String readAsStringOrNull(final InputStream is, final Charset charset) {
		if ((is == null) || (charset == null)) {
			IOUtils.closeQuietly(is);
			return null;
		}
		try {
			return readAsString(is, charset);
		} catch (final Throwable t) {
			LOGGER.info("readAsStringOrNull", t);
			return null;
		}
	}

	public static String readAsString(final InputStream is, final Charset charset) {
		String s = null;
		try {
			s = IOUtils.toString(is, charset);
		} catch (final IOException e) {
			LOGGER.warn("readAsString", e);
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(is);
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("readAsString: " + s);
		}
		return s;
	}

	public static OutputStream openOutputStreamOrNull(final String pathName) {
		return StringUtils.isBlank(pathName) ? null : openOutputStreamOrNull(new File(pathName));
	}

	public static OutputStream openOutputStream(final String pathName) {
		return openOutputStream(new File(pathName));
	}

	public static OutputStream openOutputStreamOrNull(final File file) {
		if (file == null) {
			return null;
		}
		try {
			return openOutputStream(file);
		} catch (final Throwable t) {
			LOGGER.info("openOutputStreamOrNull", t);
			return null;
		}
	}

	public static OutputStream openOutputStream(final File file) {
		try {
			return new FileOutputStream(file);
		} catch (final FileNotFoundException e) {
			LOGGER.warn("openOutputStream: " + ExtraFileUtils.getAbsolutePath(file), e);
			throw new RuntimeException(e);
		}
	}

	public static String writeOrNull(final byte[] bytes, final String pathName) {
		final File file = StringUtils.isBlank(pathName) ? null : writeOrNull(bytes, new File(pathName));
		return file != null ? file.getPath() : null;
	}

	public static String write(final byte[] bytes, final String pathName) {
		final File file = write(bytes, new File(pathName));
		return file != null ? file.getPath() : null;
	}

	public static File writeOrNull(final byte[] bytes, final File file) {
		if ((bytes == null) || (file == null)) {
			return null;
		}
		try {
			return write(bytes, file);
		} catch (final Throwable t) {
			LOGGER.info("writeOrNull", t);
			return null;
		}
	}

	public static File write(final byte[] bytes, final File file) {
		final OutputStream os = write(bytes, openOutputStream(file));
		return os != null ? file : null;
	}

	public static <T extends OutputStream> T writeOrNull(final byte[] bytes, final T os) {
		if ((bytes == null) || (os == null)) {
			IOUtils.closeQuietly(os);
			return null;
		}
		try {
			return write(bytes, os);
		} catch (final Throwable t) {
			LOGGER.info("writeOrNull", t);
			return null;
		}
	}

	public static <T extends OutputStream> T write(final byte[] bytes, final T os) {
		try {
			IOUtils.write(bytes, os);
			return os;
		} catch (final IOException e) {
			LOGGER.warn("write", e);
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(os);
		}
	}

	public static String writeOrNull(final String s, final String pathName) {
		final File file = StringUtils.isBlank(pathName) ? null : writeOrNull(s, new File(pathName));
		return file != null ? file.getPath() : null;
	}

	public static String write(final String s, final String pathName) {
		final File file = write(s, new File(pathName));
		return file != null ? file.getPath() : null;
	}

	public static File writeOrNull(final String s, final File file) {
		if (StringUtils.isBlank(s) || (file == null)) {
			return null;
		}
		try {
			return write(s, file);
		} catch (final Throwable t) {
			LOGGER.info("writeOrNull", t);
			return null;
		}
	}

	public static File write(final String s, final File file) {
		final OutputStream os = write(s, openOutputStream(file));
		return os != null ? file : null;
	}

	public static <T extends OutputStream> T writeOrNull(final String s, final T os) {
		if (StringUtils.isBlank(s) || (os == null)) {
			IOUtils.closeQuietly(os);
			return null;
		}
		try {
			return write(s, os);
		} catch (final Throwable t) {
			LOGGER.info("writeOrNull", t);
			return null;
		}
	}

	public static <T extends OutputStream> T write(final String s, final T os) {
		return write(s, os, DEFAULT_CHARSET);
	}

	public static String writeOrNull(final String s, final String pathName, final Charset charset) {
		final File file = StringUtils.isBlank(pathName) ? null : writeOrNull(s, new File(pathName), charset);
		return file != null ? file.getPath() : null;
	}

	public static String write(final String s, final String pathName, final Charset charset) {
		final File file = write(s, new File(pathName), charset);
		return file != null ? file.getPath() : null;
	}

	public static File writeOrNull(final String s, final File file, final Charset charset) {
		if (StringUtils.isBlank(s) || (file == null) || (charset == null)) {
			return null;
		}
		try {
			return write(s, file, charset);
		} catch (final Throwable t) {
			LOGGER.info("writeOrNull", t);
			return null;
		}
	}

	public static File write(final String s, final File file, final Charset charset) {
		final OutputStream os = write(s, openOutputStream(file), charset);
		return os != null ? file : null;
	}

	public static <T extends OutputStream> T writeOrNull(final String s, final T os, final Charset charset) {
		if (StringUtils.isBlank(s) || (os == null) || (charset == null)) {
			IOUtils.closeQuietly(os);
			return null;
		}
		try {
			return write(s, os, charset);
		} catch (final Throwable t) {
			LOGGER.info("writeOrNull", t);
			return null;
		}
	}

	public static <T extends OutputStream> T write(final String s, final T os, final Charset charset) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("write: " + s);
		}
		try {
			IOUtils.write(s, os, charset);
			return os;
		} catch (final IOException e) {
			LOGGER.warn("write", e);
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(os);
		}
	}

	public static Long copyOrNull(final InputStream is, final OutputStream os) {
		if ((is == null) || (os == null)) {
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
			return -1L;
		}
		try {
			return copy(is, os);
		} catch (final Throwable t) {
			LOGGER.info("copyOrNull", t);
			return -1L;
		}
	}

	public static long copy(final InputStream is, final OutputStream os) {
		try {
			return IOUtils.copyLarge(is, os);
		} catch (final IOException e) {
			LOGGER.warn("copy", e);
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
	}

	public static Long copyOrNull(final InputStream is, final OutputStream os, final CopyProgressListener copyProgressListener, final long progress) {
		if ((is == null) || (os == null)) {
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
			return -1L;
		}
		try {
			return copy(is, os, copyProgressListener, progress);
		} catch (final Throwable t) {
			LOGGER.info("copyOrNull", t);
			return -1L;
		}
	}

	public static long copy(final InputStream is, final OutputStream os, final CopyProgressListener copyProgressListener, final long progress) {
		try {
			return copyProgressListener != null ? copyLarge(is, os, copyProgressListener, progress) : IOUtils.copyLarge(is, os);
		} catch (final IOException e) {
			LOGGER.warn("copy", e);
			failed(copyProgressListener, e);
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
	}

	private static long copyLarge(final InputStream is, final OutputStream os, final CopyProgressListener copyProgressListener, final long progress) throws IOException {
		long totalCopied = 0;
		while (true) {
			final long copied = progress > 0 ? IOUtils.copyLarge(is, os, 0, progress) : IOUtils.copyLarge(is, os);
			totalCopied += copied;
			final boolean finished = copied <= 0;
			if (!copyProgressListener.onProgress(totalCopied, finished) || finished) {
				break;
			}
		}
		return totalCopied;
	}

	private static void failed(final CopyProgressListener copyProgressListener, final IOException e) {
		if (copyProgressListener != null) {
			copyProgressListener.onFailure(e);
		}
	}
}
