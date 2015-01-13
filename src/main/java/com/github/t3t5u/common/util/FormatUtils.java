package com.github.t3t5u.common.util;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FormatUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(FormatUtils.class);

	private FormatUtils() {
	}

	public static String format(final Number number) {
		return NumberFormat.getNumberInstance().format(number);
	}

	public static Date parse(final String date, final String pattern) {
		return parse(new SimpleDateFormat(pattern), date);
	}

	public static String format(final Date date, final String pattern) {
		return new SimpleDateFormat(pattern).format(date);
	}

	private static Date parse(final DateFormat format, final String date) {
		try {
			return format.parse(date);
		} catch (final ParseException e) {
			LOGGER.info("parse", e);
			return null;
		}
	}
}
