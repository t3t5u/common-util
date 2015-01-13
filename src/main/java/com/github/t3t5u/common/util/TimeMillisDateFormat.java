package com.github.t3t5u.common.util;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

@SuppressWarnings("serial")
public class TimeMillisDateFormat extends DateFormat {
	@Override
	public StringBuffer format(final Date date, final StringBuffer toAppendTo, final FieldPosition fieldPosition) {
		return toAppendTo.append(date.getTime());
	}

	@Override
	public Date parse(final String source, final ParsePosition pos) {
		return new Date(Long.valueOf(source));
	}
}
