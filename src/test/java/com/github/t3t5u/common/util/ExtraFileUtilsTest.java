package com.github.t3t5u.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class ExtraFileUtilsTest {
	@Test
	public void test() throws Exception {
		final File file = new File("bin/.test.tmp");
		FileUtils.touch(file);
		assertThat(ExtraFileUtils.exists(file), is(true));
		assertThat(ExtraFileUtils.exists(file.getPath()), is(true));
		assertThat(ExtraFileUtils.deleteQuietly(file.getPath()), is(true));
		// ファイルが存在しない場合
		assertThat(ExtraFileUtils.exists(file), is(false));
		assertThat(ExtraFileUtils.exists(file.getPath()), is(false));
		assertThat(ExtraFileUtils.deleteQuietly(file.getPath()), is(false));
		// nullの場合
		assertThat(ExtraFileUtils.exists((File) null), is(false));
		assertThat(ExtraFileUtils.exists((String) null), is(false));
		assertThat(ExtraFileUtils.deleteQuietly(null), is(false));
	}
}
