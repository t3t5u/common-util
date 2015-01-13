package com.github.t3t5u.common.util;

import static com.github.t3t5u.common.util.EncodingUtils.*;
import static com.github.t3t5u.common.util.ExtraIOUtils.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.Charsets;
import org.junit.Test;

public class ExtraIOUtilsTest {
	private static final String PATH_NAME = "bin/.test.txt";
	private static final File FILE = new File(PATH_NAME);

	@Test
	public void writeしてreadする1() {
		write(getBytes("てすと1"), openOutputStream(PATH_NAME));
		assertThat(getString(read(openInputStream(PATH_NAME))), is("てすと1"));
	}

	@Test
	public void writeしてreadする2() {
		write("てすと2", openOutputStream(PATH_NAME));
		assertThat(readAsString(openInputStream(PATH_NAME)), is("てすと2"));
	}

	@Test
	public void writeしてreadする3() {
		write("てすと3", openOutputStream(PATH_NAME), Charsets.UTF_8);
		assertThat(readAsString(openInputStream(PATH_NAME), Charsets.UTF_8), is("てすと3"));
	}

	@Test
	public void writeしてreadする4() {
		write(getBytes("てすと4"), PATH_NAME);
		assertThat(getString(read(PATH_NAME)), is("てすと4"));
	}

	@Test
	public void writeしてreadする5() {
		write("てすと5", PATH_NAME);
		assertThat(readAsString(PATH_NAME), is("てすと5"));
	}

	@Test
	public void writeしてreadする6() {
		write("てすと6", PATH_NAME, Charsets.UTF_8);
		assertThat(readAsString(PATH_NAME, Charsets.UTF_8), is("てすと6"));
	}

	@Test
	public void writeしてreadする7() {
		write(getBytes("てすと7"), FILE);
		assertThat(getString(read(FILE)), is("てすと7"));
	}

	@Test
	public void writeしてreadする8() {
		write("てすと8", FILE);
		assertThat(readAsString(FILE), is("てすと8"));
	}

	@Test
	public void writeしてreadする9() {
		write("てすと9", FILE, Charsets.UTF_8);
		assertThat(readAsString(FILE, Charsets.UTF_8), is("てすと9"));
	}

	@Test
	public void copyする1() {
		final ByteArrayInputStream bais = new ByteArrayInputStream(getBytes("てすと"));
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		copy(bais, baos);
		bais.reset();
		assertThat(getString(baos.toByteArray()), is(readAsString(bais)));
		assertThat(getString(baos.toByteArray()), is("てすと"));
	}

	@Test
	public void copyする2() {
		final ByteArrayInputStream bais = new ByteArrayInputStream(getBytes("てすと"));
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		final CopyProgressListener copyProgressListener = spy(new CopyProgressListener() {
			@Override
			public boolean onProgress(final long totalCopied, final boolean finished) {
				return true;
			}

			@Override
			public void onFailure(final IOException e) {
			}
		});
		// 0バイトずつ
		copy(bais, baos, copyProgressListener, 0);
		verify(copyProgressListener, never()).onProgress(eq(0L), anyBoolean());
		verify(copyProgressListener, never()).onProgress(eq(1L), anyBoolean());
		verify(copyProgressListener, never()).onProgress(eq(2L), anyBoolean());
		verify(copyProgressListener, never()).onProgress(eq(3L), anyBoolean());
		verify(copyProgressListener, never()).onProgress(eq(4L), anyBoolean());
		verify(copyProgressListener, never()).onProgress(eq(5L), anyBoolean());
		verify(copyProgressListener, never()).onProgress(eq(6L), anyBoolean());
		verify(copyProgressListener, never()).onProgress(eq(7L), anyBoolean());
		verify(copyProgressListener, never()).onProgress(eq(8L), anyBoolean());
		verify(copyProgressListener, times(1)).onProgress(eq(9L), eq(true));
		verify(copyProgressListener, never()).onProgress(eq(10L), anyBoolean());
		bais.reset();
		assertThat(getString(baos.toByteArray()), is(readAsString(bais)));
		assertThat(getString(baos.toByteArray()), is("てすと"));
		bais.reset();
		baos.reset();
		reset(copyProgressListener);
		// 1バイトずつ
		copy(bais, baos, copyProgressListener, 1);
		verify(copyProgressListener, never()).onProgress(eq(0L), anyBoolean());
		verify(copyProgressListener, times(1)).onProgress(eq(1L), eq(false));
		verify(copyProgressListener, times(1)).onProgress(eq(2L), eq(false));
		verify(copyProgressListener, times(1)).onProgress(eq(3L), eq(false));
		verify(copyProgressListener, times(1)).onProgress(eq(4L), eq(false));
		verify(copyProgressListener, times(1)).onProgress(eq(5L), eq(false));
		verify(copyProgressListener, times(1)).onProgress(eq(6L), eq(false));
		verify(copyProgressListener, times(1)).onProgress(eq(7L), eq(false));
		verify(copyProgressListener, times(1)).onProgress(eq(8L), eq(false));
		verify(copyProgressListener, times(1)).onProgress(eq(9L), eq(true));
		verify(copyProgressListener, never()).onProgress(eq(10L), anyBoolean());
		bais.reset();
		assertThat(getString(baos.toByteArray()), is(readAsString(bais)));
		assertThat(getString(baos.toByteArray()), is("てすと"));
		bais.reset();
		baos.reset();
		reset(copyProgressListener);
		// 2バイトずつ
		copy(bais, baos, copyProgressListener, 2);
		verify(copyProgressListener, never()).onProgress(eq(0L), anyBoolean());
		verify(copyProgressListener, never()).onProgress(eq(1L), anyBoolean());
		verify(copyProgressListener, times(1)).onProgress(eq(2L), eq(false));
		verify(copyProgressListener, never()).onProgress(eq(3L), anyBoolean());
		verify(copyProgressListener, times(1)).onProgress(eq(4L), eq(false));
		verify(copyProgressListener, never()).onProgress(eq(5L), anyBoolean());
		verify(copyProgressListener, times(1)).onProgress(eq(6L), eq(false));
		verify(copyProgressListener, never()).onProgress(eq(7L), anyBoolean());
		verify(copyProgressListener, times(1)).onProgress(eq(8L), eq(false));
		verify(copyProgressListener, times(1)).onProgress(eq(9L), eq(true));
		verify(copyProgressListener, never()).onProgress(eq(10L), anyBoolean());
		bais.reset();
		assertThat(getString(baos.toByteArray()), is(readAsString(bais)));
		assertThat(getString(baos.toByteArray()), is("てすと"));
		bais.reset();
		baos.reset();
		reset(copyProgressListener);
		// 途中でキャンセルする
		when(copyProgressListener.onProgress(eq(6L), eq(false))).thenReturn(false);
		copy(bais, baos, copyProgressListener, 2);
		verify(copyProgressListener, never()).onProgress(eq(0L), anyBoolean());
		verify(copyProgressListener, never()).onProgress(eq(1L), anyBoolean());
		verify(copyProgressListener, times(1)).onProgress(eq(2L), eq(false));
		verify(copyProgressListener, never()).onProgress(eq(3L), anyBoolean());
		verify(copyProgressListener, times(1)).onProgress(eq(4L), eq(false));
		verify(copyProgressListener, never()).onProgress(eq(5L), anyBoolean());
		verify(copyProgressListener, times(1)).onProgress(eq(6L), eq(false));
		verify(copyProgressListener, never()).onProgress(eq(7L), anyBoolean());
		verify(copyProgressListener, never()).onProgress(eq(8L), anyBoolean());
		verify(copyProgressListener, never()).onProgress(eq(9L), anyBoolean());
		verify(copyProgressListener, never()).onProgress(eq(10L), anyBoolean());
		bais.reset();
		assertThat(getString(baos.toByteArray()), is(not(readAsString(bais))));
		assertThat(getString(baos.toByteArray()), is(not("てすと")));
	}

	@Test
	public void readで自動的にcloseされる1() throws Exception {
		final InputStream input = spy(new ByteArrayInputStream(new byte[] {}));
		readOrNull(input);
		verify(input, atLeastOnce()).close();
	}

	@Test
	public void readで自動的にcloseされる2() throws Exception {
		final InputStream input = spy(new ByteArrayInputStream(new byte[] {}));
		read(input);
		verify(input, atLeastOnce()).close();
	}

	@Test
	public void readで自動的にcloseされる3() throws Exception {
		final InputStream input = spy(new ByteArrayInputStream(new byte[] {}));
		readAsStringOrNull(input);
		verify(input, atLeastOnce()).close();
	}

	@Test
	public void readで自動的にcloseされる4() throws Exception {
		final InputStream input = spy(new ByteArrayInputStream(new byte[] {}));
		readAsString(input);
		verify(input, atLeastOnce()).close();
	}

	@Test
	public void readで自動的にcloseされる5() throws Exception {
		final InputStream input = spy(new ByteArrayInputStream(new byte[] {}));
		readAsStringOrNull(input, Charsets.UTF_8);
		verify(input, atLeastOnce()).close();
	}

	@Test
	public void readで自動的にcloseされる6() throws Exception {
		final InputStream input = spy(new ByteArrayInputStream(new byte[] {}));
		readAsString(input, Charsets.UTF_8);
		verify(input, atLeastOnce()).close();
	}

	@Test
	public void readで自動的にcloseされる7() throws Exception {
		final InputStream input = spy(new ByteArrayInputStream(new byte[] {}));
		readAsStringOrNull(input, null);
		verify(input, atLeastOnce()).close();
	}

	@Test
	public void readで自動的にcloseされる8() throws Exception {
		final InputStream input = spy(new ByteArrayInputStream(new byte[] {}));
		readAsString(input, null);
		verify(input, atLeastOnce()).close();
	}

	@Test
	public void writeで自動的にcloseされる1() throws Exception {
		final OutputStream output = spy(new ByteArrayOutputStream());
		writeOrNull(new byte[] {}, output);
		verify(output, atLeastOnce()).close();
	}

	@Test
	public void writeで自動的にcloseされる2() throws Exception {
		final OutputStream output = spy(new ByteArrayOutputStream());
		write(new byte[] {}, output);
		verify(output, atLeastOnce()).close();
	}

	@Test
	public void writeで自動的にcloseされる3() throws Exception {
		final OutputStream output = spy(new ByteArrayOutputStream());
		writeOrNull("", output);
		verify(output, atLeastOnce()).close();
	}

	@Test
	public void writeで自動的にcloseされる4() throws Exception {
		final OutputStream output = spy(new ByteArrayOutputStream());
		write("", output);
		verify(output, atLeastOnce()).close();
	}

	@Test
	public void writeで自動的にcloseされる5() throws Exception {
		final OutputStream output = spy(new ByteArrayOutputStream());
		writeOrNull("", output, Charsets.UTF_8);
		verify(output, atLeastOnce()).close();
	}

	@Test
	public void writeで自動的にcloseされる6() throws Exception {
		final OutputStream output = spy(new ByteArrayOutputStream());
		write("", output, Charsets.UTF_8);
		verify(output, atLeastOnce()).close();
	}

	@Test
	public void writeで自動的にcloseされる7() throws Exception {
		final OutputStream output = spy(new ByteArrayOutputStream());
		writeOrNull("", output, null);
		verify(output, atLeastOnce()).close();
	}

	@Test
	public void writeで自動的にcloseされる8() throws Exception {
		final OutputStream output = spy(new ByteArrayOutputStream());
		write("", output, null);
		verify(output, atLeastOnce()).close();
	}

	@Test
	public void copyで自動的にcloseされる1() throws Exception {
		final InputStream input = spy(new ByteArrayInputStream(new byte[] {}));
		final OutputStream output = spy(new ByteArrayOutputStream());
		copyOrNull(input, output);
		verify(input, atLeastOnce()).close();
		verify(output, atLeastOnce()).close();
	}

	@Test
	public void copyで自動的にcloseされる2() throws Exception {
		final InputStream input = spy(new ByteArrayInputStream(new byte[] {}));
		final OutputStream output = spy(new ByteArrayOutputStream());
		copy(input, output);
		verify(input, atLeastOnce()).close();
		verify(output, atLeastOnce()).close();
	}

	@Test
	public void copyで自動的にcloseされる3() throws Exception {
		final InputStream input = spy(new ByteArrayInputStream(new byte[] {}));
		final OutputStream output = spy(new ByteArrayOutputStream());
		copyOrNull(input, output, new CopyProgressListener() {
			@Override
			public boolean onProgress(final long totalCopied, final boolean finished) {
				return true;
			}

			@Override
			public void onFailure(final IOException e) {
			}
		}, 1);
		verify(input, atLeastOnce()).close();
		verify(output, atLeastOnce()).close();
	}

	@Test
	public void copyで自動的にcloseされる4() throws Exception {
		final InputStream input = spy(new ByteArrayInputStream(new byte[] {}));
		final OutputStream output = spy(new ByteArrayOutputStream());
		copy(input, output, new CopyProgressListener() {
			@Override
			public boolean onProgress(final long totalCopied, final boolean finished) {
				return true;
			}

			@Override
			public void onFailure(final IOException e) {
			}
		}, 1);
		verify(input, atLeastOnce()).close();
		verify(output, atLeastOnce()).close();
	}

	@Test
	public void nullになる() {
		assertThat(openInputStreamOrNull((String) null), is(nullValue()));
		assertThat(openInputStreamOrNull((File) null), is(nullValue()));
		assertThat(readOrNull((String) null), is(nullValue()));
		assertThat(readOrNull((File) null), is(nullValue()));
		assertThat(readOrNull((InputStream) null), is(nullValue()));
		assertThat(readAsStringOrNull((String) null), is(nullValue()));
		assertThat(readAsStringOrNull((File) null), is(nullValue()));
		assertThat(readAsStringOrNull((InputStream) null), is(nullValue()));
		assertThat(readAsStringOrNull((String) null, null), is(nullValue()));
		assertThat(readAsStringOrNull((File) null, null), is(nullValue()));
		assertThat(readAsStringOrNull((InputStream) null, null), is(nullValue()));
		assertThat(openOutputStreamOrNull((String) null), is(nullValue()));
		assertThat(openOutputStreamOrNull((File) null), is(nullValue()));
		assertThat(writeOrNull((byte[]) null, (String) null), is(nullValue()));
		assertThat(writeOrNull((byte[]) null, (File) null), is(nullValue()));
		assertThat(writeOrNull((byte[]) null, (OutputStream) null), is(nullValue()));
		assertThat(writeOrNull((String) null, (String) null), is(nullValue()));
		assertThat(writeOrNull((String) null, (File) null), is(nullValue()));
		assertThat(writeOrNull((String) null, (OutputStream) null), is(nullValue()));
		assertThat(writeOrNull((String) null, (String) null, null), is(nullValue()));
		assertThat(writeOrNull((String) null, (File) null, null), is(nullValue()));
		assertThat(writeOrNull((String) null, (OutputStream) null, null), is(nullValue()));
		assertThat(copyOrNull(null, null), is(-1L));
		assertThat(copyOrNull(null, null, null, 0), is(-1L));
	}
}
