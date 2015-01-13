package com.github.t3t5u.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class EncodingUtils {
	private static final String DEFAULT_ENCODING = CharEncoding.UTF_8;
	private static final Logger LOGGER = LoggerFactory.getLogger(EncodingUtils.class);

	private EncodingUtils() {
	}

	public static String encodeUrl(final Object o) {
		return encodeUrl(o, DEFAULT_ENCODING);
	}

	public static String encodeUrl(final Object o, final Charset charset) {
		return charset != null ? encodeUrl(o, charset.name()) : "";
	}

	public static String encodeUrl(final Object o, final String encoding) {
		if ((o == null) || StringUtils.isBlank(encoding)) {
			return "";
		}
		try {
			return URLEncoder.encode(String.valueOf(o), encoding);
		} catch (final UnsupportedEncodingException e) {
			LOGGER.warn("encode", e);
			throw new RuntimeException(e);
		}
	}

	public static String decodeUrl(final Object o) {
		return decodeUrl(o, DEFAULT_ENCODING);
	}

	public static String decodeUrl(final Object o, final Charset charset) {
		return charset != null ? decodeUrl(o, charset.name()) : "";
	}

	public static String decodeUrl(final Object o, final String encoding) {
		if ((o == null) || StringUtils.isBlank(encoding)) {
			return "";
		}
		try {
			return URLDecoder.decode(String.valueOf(o), encoding);
		} catch (final UnsupportedEncodingException e) {
			LOGGER.warn("decode", e);
			throw new RuntimeException(e);
		}
	}

	public static byte[] encodeBase64(final String binaryData) {
		return encodeBase64(binaryData, DEFAULT_ENCODING);
	}

	public static byte[] encodeBase64(final String binaryData, final Charset charset) {
		return charset != null ? encodeBase64(binaryData, charset.name()) : null;
	}

	public static byte[] encodeBase64(final String binaryData, final String encoding) {
		return encodeBase64(getBytes(binaryData, encoding));
	}

	public static byte[] encodeBase64(final byte[] binaryData) {
		return ArrayUtils.isEmpty(binaryData) ? binaryData : Base64.encodeBase64(binaryData);
	}

	public static String encodeBase64AsString(final String binaryData) {
		return encodeBase64AsString(binaryData, DEFAULT_ENCODING);
	}

	public static String encodeBase64AsString(final String binaryData, final Charset charset) {
		return charset != null ? encodeBase64AsString(binaryData, charset.name()) : null;
	}

	public static String encodeBase64AsString(final String binaryData, final String encoding) {
		return encodeBase64AsString(getBytes(binaryData, encoding), encoding);
	}

	public static String encodeBase64AsString(final byte[] binaryData) {
		return encodeBase64AsString(binaryData, DEFAULT_ENCODING);
	}

	public static String encodeBase64AsString(final byte[] binaryData, final Charset charset) {
		return charset != null ? encodeBase64AsString(binaryData, charset.name()) : null;
	}

	public static String encodeBase64AsString(final byte[] binaryData, final String encoding) {
		return getString(encodeBase64(binaryData), encoding);
	}

	public static byte[] decodeBase64(final String base64Data) {
		return decodeBase64(base64Data, DEFAULT_ENCODING);
	}

	public static byte[] decodeBase64(final String base64Data, final Charset charset) {
		return charset != null ? decodeBase64(base64Data, charset.name()) : null;
	}

	public static byte[] decodeBase64(final String base64Data, final String encoding) {
		return decodeBase64(getBytes(base64Data, encoding));
	}

	public static byte[] decodeBase64(final byte[] base64Data) {
		return ArrayUtils.isEmpty(base64Data) ? base64Data : Base64.decodeBase64(base64Data);
	}

	public static String decodeBase64AsString(final String base64Data) {
		return decodeBase64AsString(base64Data, DEFAULT_ENCODING);
	}

	public static String decodeBase64AsString(final String base64Data, final Charset charset) {
		return charset != null ? decodeBase64AsString(base64Data, charset.name()) : null;
	}

	public static String decodeBase64AsString(final String base64Data, final String encoding) {
		return decodeBase64AsString(getBytes(base64Data, encoding), encoding);
	}

	public static String decodeBase64AsString(final byte[] base64Data) {
		return decodeBase64AsString(base64Data, DEFAULT_ENCODING);
	}

	public static String decodeBase64AsString(final byte[] base64Data, final Charset charset) {
		return charset != null ? decodeBase64AsString(base64Data, charset.name()) : null;
	}

	public static String decodeBase64AsString(final byte[] base64Data, final String encoding) {
		return getString(decodeBase64(base64Data), encoding);
	}

	public static String encodeHex(final byte[] binaryData) {
		return encodeHex(binaryData, DEFAULT_ENCODING);
	}

	public static String encodeHex(final byte[] binaryData, final Charset charset) {
		return charset != null ? encodeHex(binaryData, charset.name()) : null;
	}

	public static String encodeHex(final byte[] binaryData, final String encoding) {
		if ((binaryData == null) || StringUtils.isBlank(encoding)) {
			return null;
		}
		try {
			return new String(new Hex(/* encoding */).encode(binaryData), encoding);
		} catch (final UnsupportedEncodingException e) {
			LOGGER.warn("encodeHex", e);
			throw new RuntimeException(e);
		}
	}

	public static byte[] decodeHex(final String hexData) {
		return decodeHex(hexData, DEFAULT_ENCODING);
	}

	public static byte[] decodeHex(final String hexData, final Charset charset) {
		return charset != null ? decodeHex(hexData, charset.name()) : null;
	}

	public static byte[] decodeHex(final String hexData, final String encoding) {
		if ((hexData == null) || StringUtils.isBlank(encoding)) {
			return null;
		}
		try {
			return new Hex(/* encoding */).decode(hexData.getBytes(encoding));
		} catch (final UnsupportedEncodingException e) {
			LOGGER.warn("decodeHex", e);
			throw new RuntimeException(e);
		} catch (final DecoderException e) {
			LOGGER.warn("decodeHex", e);
			throw new RuntimeException(e);
		}
	}

	public static byte[] getBytes(final String s) {
		return getBytes(s, DEFAULT_ENCODING);
	}

	public static byte[] getBytes(final String s, final Charset charset) {
		return charset != null ? getBytes(s, charset.name()) : null;
	}

	public static byte[] getBytes(final String s, final String encoding) {
		if ((s == null) || StringUtils.isBlank(encoding)) {
			return null;
		}
		try {
			return s.getBytes(encoding);
		} catch (final UnsupportedEncodingException e) {
			LOGGER.warn("getBytes", e);
			throw new RuntimeException(e);
		}
	}

	public static String getString(final byte[] bs) {
		return getString(bs, DEFAULT_ENCODING);
	}

	public static String getString(final byte[] bs, final Charset charset) {
		return charset != null ? getString(bs, charset.name()) : null;
	}

	public static String getString(final byte[] bs, final String encoding) {
		if ((bs == null) || StringUtils.isBlank(encoding)) {
			return null;
		}
		try {
			return new String(bs, encoding);
		} catch (final UnsupportedEncodingException e) {
			LOGGER.warn("getString", e);
			throw new RuntimeException(e);
		}
	}
}
