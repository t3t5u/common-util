package com.github.t3t5u.common.util;

import static com.github.t3t5u.common.util.EncodingUtils.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class EncodingUtilsTest {
	@Test
	public void パーセントエンコーディングでencodeしてdecodeする() {
		assertThat(decodeUrl(encodeUrl(null)), is(""));
		assertThat(decodeUrl(encodeUrl(12345)), is("12345"));
		assertThat(decodeUrl(encodeUrl("a b c d e")), is("a b c d e"));
		assertThat(decodeUrl(encodeUrl("あ い う え お")), is("あ い う え お"));
	}

	@Test
	public void 文字列をBase64の文字列にencodeして文字列にdecodeする() {
		assertThat(decodeBase64AsString(encodeBase64AsString((String) null)), is(nullValue()));
		assertThat(decodeBase64AsString(encodeBase64AsString("12345")), is("12345"));
		assertThat(decodeBase64AsString(encodeBase64AsString("a b c d e")), is("a b c d e"));
		assertThat(decodeBase64AsString(encodeBase64AsString("あ い う え お")), is("あ い う え お"));
	}

	@Test
	public void 文字列をBase64の文字列にencodeしてバイト配列にdecodeする() {
		assertThat(getString(decodeBase64(encodeBase64AsString((String) null))), is(nullValue()));
		assertThat(getString(decodeBase64(encodeBase64AsString("12345"))), is("12345"));
		assertThat(getString(decodeBase64(encodeBase64AsString("a b c d e"))), is("a b c d e"));
		assertThat(getString(decodeBase64(encodeBase64AsString("あ い う え お"))), is("あ い う え お"));
	}

	@Test
	public void 文字列をBase64のバイト配列にencodeして文字列にdecodeする() {
		assertThat(decodeBase64AsString(encodeBase64((String) null)), is(nullValue()));
		assertThat(decodeBase64AsString(encodeBase64("12345")), is("12345"));
		assertThat(decodeBase64AsString(encodeBase64("a b c d e")), is("a b c d e"));
		assertThat(decodeBase64AsString(encodeBase64("あ い う え お")), is("あ い う え お"));
	}

	@Test
	public void 文字列をBase64のバイト配列にencodeしてバイト配列にdecodeする() {
		assertThat(getString(decodeBase64(encodeBase64((String) null))), is(nullValue()));
		assertThat(getString(decodeBase64(encodeBase64("12345"))), is("12345"));
		assertThat(getString(decodeBase64(encodeBase64("a b c d e"))), is("a b c d e"));
		assertThat(getString(decodeBase64(encodeBase64("あ い う え お"))), is("あ い う え お"));
	}

	@Test
	public void バイト配列をBase64の文字列にencodeして文字列にdecodeする() {
		assertThat(decodeBase64AsString(encodeBase64AsString(getBytes(null))), is(nullValue()));
		assertThat(decodeBase64AsString(encodeBase64AsString(getBytes("12345"))), is("12345"));
		assertThat(decodeBase64AsString(encodeBase64AsString(getBytes("a b c d e"))), is("a b c d e"));
		assertThat(decodeBase64AsString(encodeBase64AsString(getBytes("あ い う え お"))), is("あ い う え お"));
	}

	@Test
	public void バイト配列をBase64の文字列にencodeしてバイト配列にdecodeする() {
		assertThat(getString(decodeBase64(encodeBase64AsString(getBytes(null)))), is(nullValue()));
		assertThat(getString(decodeBase64(encodeBase64AsString(getBytes("12345")))), is("12345"));
		assertThat(getString(decodeBase64(encodeBase64AsString(getBytes("a b c d e")))), is("a b c d e"));
		assertThat(getString(decodeBase64(encodeBase64AsString(getBytes("あ い う え お")))), is("あ い う え お"));
	}

	@Test
	public void バイト配列をBase64のバイト配列にencodeして文字列にdecodeする() {
		assertThat(decodeBase64AsString(encodeBase64(getBytes(null))), is(nullValue()));
		assertThat(decodeBase64AsString(encodeBase64(getBytes("12345"))), is("12345"));
		assertThat(decodeBase64AsString(encodeBase64(getBytes("a b c d e"))), is("a b c d e"));
		assertThat(decodeBase64AsString(encodeBase64(getBytes("あ い う え お"))), is("あ い う え お"));
	}

	@Test
	public void バイト配列をBase64のバイト配列にencodeしてバイト配列にdecodeする() {
		assertThat(getString(decodeBase64(encodeBase64(getBytes(null)))), is(nullValue()));
		assertThat(getString(decodeBase64(encodeBase64(getBytes("12345")))), is("12345"));
		assertThat(getString(decodeBase64(encodeBase64(getBytes("a b c d e")))), is("a b c d e"));
		assertThat(getString(decodeBase64(encodeBase64(getBytes("あ い う え お")))), is("あ い う え お"));
	}

	@Test
	public void 十六進エンコーディングでencodeしてdecodeする() {
		assertThat(getString(decodeHex(encodeHex(getBytes(null)))), is(nullValue()));
		assertThat(getString(decodeHex(encodeHex(getBytes("12345")))), is("12345"));
		assertThat(getString(decodeHex(encodeHex(getBytes("a b c d e")))), is("a b c d e"));
		assertThat(getString(decodeHex(encodeHex(getBytes("あ い う え お")))), is("あ い う え お"));
	}
}
