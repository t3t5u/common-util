package com.github.t3t5u.common.util;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class Replacer implements Serializable {
	private final Pattern pattern;
	private final String replacement;

	public Replacer(final Pattern pattern, final String replacement) {
		this.pattern = pattern;
		this.replacement = replacement;
	}

	public String replaceAll(final CharSequence input) {
		return input != null ? matcher(input).replaceAll(replacement) : null;
	}

	public String replaceFirst(final CharSequence input) {
		return input != null ? matcher(input).replaceFirst(replacement) : null;
	}

	private Matcher matcher(final CharSequence input) {
		return pattern.matcher(input);
	}
}
