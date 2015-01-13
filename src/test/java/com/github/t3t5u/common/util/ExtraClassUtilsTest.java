package com.github.t3t5u.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ExtraClassUtilsTest {
	@Test
	public void 名前でクラスを取得する() {
		assertThat(ExtraClassUtils.forName(Rectangle.class.getName()).getName(), is(Rectangle.class.getName()));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void インスタンスを生成する1() {
		final MutableRectangle<Integer> mr = ExtraClassUtils.newInstance(MutableRectangle.class);
		assertThat(mr.getTop(), is(nullValue()));
		assertThat(mr.getLeft(), is(nullValue()));
		assertThat(mr.getRight(), is(nullValue()));
		assertThat(mr.getBottom(), is(nullValue()));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void インスタンスを生成する2() {
		final Rectangle<Integer> r = ExtraClassUtils.newInstance(Rectangle.class, new Class<?>[] { Object.class, Object.class, Object.class, Object.class }, 1, 2, 3, 4);
		assertThat(r.getTop(), is(1));
		assertThat(r.getLeft(), is(2));
		assertThat(r.getRight(), is(3));
		assertThat(r.getBottom(), is(4));
	}

	@Test
	public void nullになる() {
		assertThat(ExtraClassUtils.forNameOrNull(null), is(nullValue()));
		assertThat(ExtraClassUtils.forNameOrNull("hoge"), is(nullValue()));
		assertThat(ExtraClassUtils.newInstanceOrNull(null), is(nullValue()));
		assertThat(ExtraClassUtils.newInstanceOrNull(null, null), is(nullValue()));
	}
}
