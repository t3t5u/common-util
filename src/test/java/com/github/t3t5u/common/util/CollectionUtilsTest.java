package com.github.t3t5u.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CollectionUtilsTest {
	@Test
	public void putしてgetする() {
		final Map<String, String> map = new HashMap<String, String>();
		// putする
		assertThat(CollectionUtils.putIfNotNull(null, null, (String) null), is(nullValue()));
		assertThat(CollectionUtils.putIfNotNull(map, null, (String) null), is(nullValue()));
		assertThat(CollectionUtils.putIfNotNull(map, "foo", (String) null), is(nullValue()));
		assertThat(CollectionUtils.putIfNotNull(map, null, "abc"), is(nullValue()));
		assertThat(CollectionUtils.putIfNotNull(map, "foo", "abc"), is(nullValue())); // 以前の内容が返る
		assertThat(CollectionUtils.putIfNotNull(map, "foo", "def"), is("abc")); // 以前の内容が返る
		assertThat(map.size(), is(1));
		// getする
		assertThat(CollectionUtils.getIfNotNull(null, null), is(nullValue()));
		assertThat(CollectionUtils.getIfNotNull(map, null), is(nullValue()));
		assertThat(CollectionUtils.getIfNotNull(map, "foo"), is("def"));
	}
}
