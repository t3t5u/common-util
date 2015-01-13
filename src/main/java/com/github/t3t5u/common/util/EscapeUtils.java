package com.github.t3t5u.common.util;

public final class EscapeUtils {
	private EscapeUtils() {
	}

	public static String escape(final Character c, final Character target) {
		return escape(c, target, target);
	}

	public static String escape(final Character c, final Character target, final Character escape) {
		return c == null ? null : (target == null) || (escape == null) ? c.toString() : replace(c.toString(), target.toString(), escape.toString());
	}

	public static String escape(final CharSequence cs, final Character target) {
		return escape(cs, target, target);
	}

	public static String escape(final CharSequence cs, final Character target, final Character escape) {
		return cs == null ? null : (target == null) || (escape == null) ? cs.toString() : replace(cs.toString(), target.toString(), escape.toString());
	}

	private static String replace(final String s, final String target, final String escape) {
		return s.replace(target, escape + target);
	}
}
