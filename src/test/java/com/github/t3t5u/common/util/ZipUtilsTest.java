package com.github.t3t5u.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.apache.commons.compress.archivers.zip.ZipFile;
import org.junit.Test;

public class ZipUtilsTest {
	@Test
	public void test() {
		ExtraFileUtils.deleteQuietly("bin/.test.zip");
		ExtraIOUtils.copy(getClass().getResourceAsStream("/test.zip"), ExtraIOUtils.openOutputStream("bin/.test.zip"));
		final ZipFile file = ZipUtils.createOrNull("bin/.test.zip");
		assertThat(ExtraIOUtils.readAsString(ZipUtils.getInputStreamOrNull(file, file.getEntry("test/test.txt"))), is("てすと\n"));
		assertThat(ZipUtils.closeQuietly(file), is(true));
		assertThat(ZipUtils.createOrNull(null), is(nullValue()));
		assertThat(ZipUtils.getInputStreamOrNull(null, null), is(nullValue()));
		assertThat(ZipUtils.closeQuietly(null), is(false));
	}
}
