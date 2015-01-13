package com.github.t3t5u.common.util;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class UriUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(UriUtils.class);

	private UriUtils() {
	}

	public static URI getUriOrNull(final String spec) {
		if (StringUtils.isBlank(spec)) {
			return null;
		}
		try {
			return getUri(spec);
		} catch (final Throwable t) {
			LOGGER.info("getUriOrNull", t);
			return null;
		}
	}

	public static URI getUri(final String spec) {
		try {
			return new URI(spec);
		} catch (final URISyntaxException e) {
			LOGGER.warn("getUri", e);
			throw new RuntimeException(e);
		}
	}
}
