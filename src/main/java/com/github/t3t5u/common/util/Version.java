package com.github.t3t5u.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class Version implements Comparable<Version> {
	private static final Pattern SPLITTER = Pattern.compile("^(\\d*)(.*)$");
	private final String major;
	private final String minor;
	private final String revision;

	public Version(final String s) {
		final String[] ss = s != null ? s.split("\\.") : null;
		int index = 0;
		major = (ss != null) && (ss.length > index) ? ss[index++] : null;
		minor = (ss != null) && (ss.length > index) ? ss[index++] : null;
		revision = (ss != null) && (ss.length > index) ? ss[index++] : null;
	}

	public String getMajor() {
		return major;
	}

	public String getMinor() {
		return minor;
	}

	public String getRevision() {
		return revision;
	}

	public int getMajorAsInt() {
		return toInt(split(major)[0]);
	}

	public int getMinorAsInt() {
		return toInt(split(minor)[0]);
	}

	public int getRevisionAsInt() {
		return toInt(split(revision)[0]);
	}

	@Override
	public int compareTo(final Version o) {
		return isUpdated(this, o) ? -1 : isUpdated(o, this) ? 1 : 0;
	}

	@Override
	public String toString() {
		return (major != null ? major : "") + (minor != null ? "." + minor : "") + (revision != null ? "." + revision : "");
	}

	public static boolean isUpdated(final Version oldVersion, final Version newVersion) {
		return isMajorUpdated(oldVersion, newVersion) || isMinorUpdated(oldVersion, newVersion) || isRevisionUpdated(oldVersion, newVersion);
	}

	public static boolean isMajorUpdated(final Version oldVersion, final Version newVersion) {
		final String oldMajor = oldVersion != null ? oldVersion.major : null;
		final String newMajor = newVersion != null ? newVersion.major : null;
		return (oldMajor != null) && (newMajor != null) && (compare(oldMajor, newMajor) < 0);
	}

	public static boolean isMinorUpdated(final Version oldVersion, final Version newVersion) {
		final String oldMajor = oldVersion != null ? oldVersion.major : null;
		final String oldMinor = oldVersion != null ? oldVersion.minor : null;
		final String newMajor = newVersion != null ? newVersion.major : null;
		final String newMinor = newVersion != null ? newVersion.minor : null;
		return (oldMajor != null) && (newMajor != null) && (compare(oldMajor, newMajor) == 0) && (oldMinor != null) && (newMinor != null) && (compare(oldMinor, newMinor) < 0);
	}

	public static boolean isRevisionUpdated(final Version oldVersion, final Version newVersion) {
		final String oldMajor = oldVersion != null ? oldVersion.major : null;
		final String oldMinor = oldVersion != null ? oldVersion.minor : null;
		final String oldRevision = oldVersion != null ? oldVersion.revision : null;
		final String newMajor = newVersion != null ? newVersion.major : null;
		final String newMinor = newVersion != null ? newVersion.minor : null;
		final String newRevision = newVersion != null ? newVersion.revision : null;
		return (oldMajor != null) && (newMajor != null) && (compare(oldMajor, newMajor) == 0) && (oldMinor != null) && (newMinor != null) && (compare(oldMinor, newMinor) == 0) && (oldRevision != null) && (newRevision != null) && (compare(oldRevision, newRevision) < 0);
	}

	private static int compare(final String s1, final String s2) {
		final String[] ss1 = split(s1);
		final String[] ss2 = split(s2);
		final int i1 = NumberUtils.toInt(ss1[0]);
		final int i2 = NumberUtils.toInt(ss2[0]);
		return i1 != i2 ? i1 - i2 : ObjectUtils.compare(ss1[1], ss2[1]);
	}

	private static int toInt(final String s) {
		return NumberUtils.toInt(split(s)[0]);
	}

	private static String[] split(final String s) {
		final Matcher matcher = SPLITTER.matcher(s);
		return new String[] { matcher.replaceFirst("$1"), matcher.replaceFirst("$2") };
	}
}
