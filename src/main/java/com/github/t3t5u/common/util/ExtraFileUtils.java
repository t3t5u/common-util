package com.github.t3t5u.common.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public final class ExtraFileUtils {
	private ExtraFileUtils() {
	}

	public static long length(final File file) {
		return exists(file) ? file.length() : 0;
	}

	public static long length(final String pathName) {
		return !StringUtils.isBlank(pathName) ? length(new File(pathName)) : 0;
	}

	public static boolean exists(final File file) {
		return file != null ? file.exists() : false;
	}

	public static boolean exists(final String pathName) {
		return !StringUtils.isBlank(pathName) ? new File(pathName).exists() : false;
	}

	public static boolean mkdirs(final File file) {
		return file != null ? file.mkdirs() : false;
	}

	public static boolean mkdirs(final String pathName) {
		return !StringUtils.isBlank(pathName) ? new File(pathName).mkdirs() : false;
	}

	public static boolean deleteQuietly(final String pathName) {
		return !StringUtils.isBlank(pathName) ? FileUtils.deleteQuietly(new File(pathName)) : false;
	}

	public static File getFile(final String pathName) {
		return !StringUtils.isBlank(pathName) ? new File(pathName) : null;
	}

	public static String getPath(final File file) {
		return file != null ? file.getPath() : null;
	}

	public static String getAbsolutePath(final File file) {
		return file != null ? file.getAbsolutePath() : null;
	}
}
