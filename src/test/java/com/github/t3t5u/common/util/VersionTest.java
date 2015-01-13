package com.github.t3t5u.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.google.common.collect.Range;

public class VersionTest {
	@Test
	public void testIsUpdated() {
		assertThat(Version.isUpdated(new Version("0.0.0"), new Version("0.0.0")), is(false));
		assertThat(Version.isUpdated(new Version("0.0.0"), new Version("0.0.1")), is(true));
		assertThat(Version.isUpdated(new Version("0.0.0"), new Version("0.1.0")), is(true));
		assertThat(Version.isUpdated(new Version("0.0.0"), new Version("1.0.0")), is(true));
		assertThat(Version.isUpdated(new Version("0.0.0"), new Version("0.1")), is(true));
		assertThat(Version.isUpdated(new Version("0.0.0"), new Version("1.0")), is(true));
		assertThat(Version.isUpdated(new Version("0.0.0"), new Version("1")), is(true));
		assertThat(Version.isUpdated(new Version("0.0"), new Version("0.0")), is(false));
		assertThat(Version.isUpdated(new Version("0.0"), new Version("0.1")), is(true));
		assertThat(Version.isUpdated(new Version("0.0"), new Version("1.0")), is(true));
		assertThat(Version.isUpdated(new Version("0.0"), new Version("1")), is(true));
		assertThat(Version.isUpdated(new Version("0"), new Version("0")), is(false));
		assertThat(Version.isUpdated(new Version("0"), new Version("1")), is(true));
		// 1 == 1
		assertThat(Version.isUpdated(new Version("1"), new Version("1")), is(false));
		// 1 == 01
		assertThat(Version.isUpdated(new Version("1"), new Version("01")), is(false));
		// 01 == 1
		assertThat(Version.isUpdated(new Version("01"), new Version("1")), is(false));
		// 01 == 01
		assertThat(Version.isUpdated(new Version("01"), new Version("01")), is(false));
		// 1 < 2
		assertThat(Version.isUpdated(new Version("1"), new Version("2")), is(true));
		// 1 < 02
		assertThat(Version.isUpdated(new Version("1"), new Version("02")), is(true));
		// 01 < 2
		assertThat(Version.isUpdated(new Version("01"), new Version("2")), is(true));
		// 01 < 02
		assertThat(Version.isUpdated(new Version("01"), new Version("02")), is(true));
		// 1 < 11
		assertThat(Version.isUpdated(new Version("1"), new Version("11")), is(true));
		// 01 < 11
		assertThat(Version.isUpdated(new Version("01"), new Version("11")), is(true));
		// 2 < 11
		assertThat(Version.isUpdated(new Version("2"), new Version("11")), is(true));
		// 02 < 11
		assertThat(Version.isUpdated(new Version("02"), new Version("11")), is(true));
		// 11 == 11
		assertThat(Version.isUpdated(new Version("11"), new Version("11")), is(false));
		// 1 < 1a
		assertThat(Version.isUpdated(new Version("1"), new Version("1a")), is(true));
		// 01 < 1a
		assertThat(Version.isUpdated(new Version("01"), new Version("1a")), is(true));
		// 2 > 1a
		assertThat(Version.isUpdated(new Version("2"), new Version("1a")), is(false));
		// 02 > 1a
		assertThat(Version.isUpdated(new Version("02"), new Version("1a")), is(false));
		// 1a == 1a
		assertThat(Version.isUpdated(new Version("1a"), new Version("1a")), is(false));
		// 1 > a1
		assertThat(Version.isUpdated(new Version("1"), new Version("a1")), is(false)); // 0a1として扱う
		// 01 > a1
		assertThat(Version.isUpdated(new Version("01"), new Version("a1")), is(false)); // 0a1として扱う
		// 2 > a1
		assertThat(Version.isUpdated(new Version("2"), new Version("a1")), is(false)); // 0a1として扱う
		// 02 > a1
		assertThat(Version.isUpdated(new Version("02"), new Version("a1")), is(false)); // 0a1として扱う
		// a1 == a1
		assertThat(Version.isUpdated(new Version("a1"), new Version("a1")), is(false));
		// 1 < 1-SNAPSHOT
		assertThat(Version.isUpdated(new Version("1"), new Version("1-SNAPSHOT")), is(true)); // TODO: SNAPSHOTの扱い
		// 01 < 1-SNAPSHOT
		assertThat(Version.isUpdated(new Version("01"), new Version("1-SNAPSHOT")), is(true)); // TODO: SNAPSHOTの扱い
		// 2 > 1-SNAPSHOT
		assertThat(Version.isUpdated(new Version("2"), new Version("1-SNAPSHOT")), is(false));
		// 02 > 1-SNAPSHOT
		assertThat(Version.isUpdated(new Version("02"), new Version("1-SNAPSHOT")), is(false));
		// 1-SNAPSHOT == 1-SNAPSHOT
		assertThat(Version.isUpdated(new Version("1-SNAPSHOT"), new Version("1-SNAPSHOT")), is(false));
		// 1 > SNAPSHOT-1
		assertThat(Version.isUpdated(new Version("1"), new Version("SNAPSHOT-1")), is(false)); // 0SNAPSHOT-1として扱う
		// 01 > SNAPSHOT-1
		assertThat(Version.isUpdated(new Version("01"), new Version("SNAPSHOT-1")), is(false)); // 0SNAPSHOT-1として扱う
		// 2 > SNAPSHOT-1
		assertThat(Version.isUpdated(new Version("2"), new Version("SNAPSHOT-1")), is(false)); // 0SNAPSHOT-1として扱う
		// 02 > SNAPSHOT-1
		assertThat(Version.isUpdated(new Version("02"), new Version("SNAPSHOT-1")), is(false)); // 0SNAPSHOT-1として扱う
		// SNAPSHOT-1 == SNAPSHOT-1
		assertThat(Version.isUpdated(new Version("SNAPSHOT-1"), new Version("SNAPSHOT-1")), is(false));
	}

	@Test
	public void testIsMajorUpdated() {
		assertThat(Version.isMajorUpdated(new Version("0.0.0"), new Version("0.0.0")), is(false));
		assertThat(Version.isMajorUpdated(new Version("0.0.0"), new Version("0.0.1")), is(false)); // majorしか見ない
		assertThat(Version.isMajorUpdated(new Version("0.0.0"), new Version("0.1.0")), is(false)); // majorしか見ない
		assertThat(Version.isMajorUpdated(new Version("0.0.0"), new Version("1.0.0")), is(true));
		assertThat(Version.isMajorUpdated(new Version("0.0.0"), new Version("0.1")), is(false)); // majorしか見ない
		assertThat(Version.isMajorUpdated(new Version("0.0.0"), new Version("1.0")), is(true));
		assertThat(Version.isMajorUpdated(new Version("0.0.0"), new Version("1")), is(true));
		assertThat(Version.isMajorUpdated(new Version("0.0"), new Version("0.0")), is(false));
		assertThat(Version.isMajorUpdated(new Version("0.0"), new Version("0.1")), is(false)); // majorしか見ない
		assertThat(Version.isMajorUpdated(new Version("0.0"), new Version("1.0")), is(true));
		assertThat(Version.isMajorUpdated(new Version("0.0"), new Version("1")), is(true));
		assertThat(Version.isMajorUpdated(new Version("0"), new Version("0")), is(false));
		assertThat(Version.isMajorUpdated(new Version("0"), new Version("1")), is(true));
	}

	@Test
	public void testIsMinorUpdated() {
		assertThat(Version.isMinorUpdated(new Version("0.0.0"), new Version("0.0.0")), is(false));
		assertThat(Version.isMinorUpdated(new Version("0.0.0"), new Version("0.0.1")), is(false)); // minorしか見ない
		assertThat(Version.isMinorUpdated(new Version("0.0.0"), new Version("0.1.0")), is(true));
		assertThat(Version.isMinorUpdated(new Version("0.0.0"), new Version("1.0.0")), is(false)); // minorしか見ない
		assertThat(Version.isMinorUpdated(new Version("0.0.0"), new Version("0.1")), is(true));
		assertThat(Version.isMinorUpdated(new Version("0.0.0"), new Version("1.0")), is(false)); // minorしか見ない
		assertThat(Version.isMinorUpdated(new Version("0.0.0"), new Version("1")), is(false)); // 省略は更新とみなさない
		assertThat(Version.isMinorUpdated(new Version("0.0"), new Version("0.0")), is(false));
		assertThat(Version.isMinorUpdated(new Version("0.0"), new Version("0.1")), is(true));
		assertThat(Version.isMinorUpdated(new Version("0.0"), new Version("1.0")), is(false)); // minorしか見ない
		assertThat(Version.isMinorUpdated(new Version("0.0"), new Version("1")), is(false)); // 省略は更新とみなさない
		assertThat(Version.isMinorUpdated(new Version("0"), new Version("0")), is(false));
		assertThat(Version.isMinorUpdated(new Version("0"), new Version("1")), is(false));
	}

	@Test
	public void testIsRevisionUpdated() {
		assertThat(Version.isRevisionUpdated(new Version("0.0.0"), new Version("0.0.0")), is(false));
		assertThat(Version.isRevisionUpdated(new Version("0.0.0"), new Version("0.0.1")), is(true));
		assertThat(Version.isRevisionUpdated(new Version("0.0.0"), new Version("0.1.0")), is(false)); // revisionしか見ない
		assertThat(Version.isRevisionUpdated(new Version("0.0.0"), new Version("1.0.0")), is(false)); // revisionしか見ない
		assertThat(Version.isRevisionUpdated(new Version("0.0.0"), new Version("0.1")), is(false)); // 省略は更新とみなさない
		assertThat(Version.isRevisionUpdated(new Version("0.0.0"), new Version("1.0")), is(false));
		assertThat(Version.isRevisionUpdated(new Version("0.0.0"), new Version("1")), is(false));
		assertThat(Version.isRevisionUpdated(new Version("0.0"), new Version("0.0")), is(false));
		assertThat(Version.isRevisionUpdated(new Version("0.0"), new Version("0.1")), is(false));
		assertThat(Version.isRevisionUpdated(new Version("0.0"), new Version("1.0")), is(false));
		assertThat(Version.isRevisionUpdated(new Version("0.0"), new Version("1")), is(false));
		assertThat(Version.isRevisionUpdated(new Version("0"), new Version("0")), is(false));
		assertThat(Version.isRevisionUpdated(new Version("0"), new Version("1")), is(false));
	}

	@Test
	public void testCompareTo() {
		assertThat(Range.closed(new Version("4.2"), new Version("4.2.1")).contains(new Version("4.1")), is(false));
		assertThat(Range.closed(new Version("4.2"), new Version("4.2.1")).contains(new Version("4.1.1")), is(false));
		assertThat(Range.closed(new Version("4.2"), new Version("4.2.1")).contains(new Version("4.2")), is(true));
		assertThat(Range.closed(new Version("4.2"), new Version("4.2.1")).contains(new Version("4.2.0")), is(true));
		assertThat(Range.closed(new Version("4.2"), new Version("4.2.1")).contains(new Version("4.2.1")), is(true));
		assertThat(Range.closed(new Version("4.2"), new Version("4.2.1")).contains(new Version("4.2.2")), is(false));
		assertThat(Range.closed(new Version("4.2"), new Version("4.2.1")).contains(new Version("4.3")), is(false));
	}

	@Test
	public void testToString() {
		assertThat(new Version("0.0.0").toString(), is("0.0.0"));
		assertThat(new Version("0.0.1").toString(), is("0.0.1"));
		assertThat(new Version("0.1.0").toString(), is("0.1.0"));
		assertThat(new Version("1.0.0").toString(), is("1.0.0"));
		assertThat(new Version("0.0").toString(), is("0.0"));
		assertThat(new Version("0.1").toString(), is("0.1"));
		assertThat(new Version("1.0").toString(), is("1.0"));
		assertThat(new Version("0").toString(), is("0"));
		assertThat(new Version("1").toString(), is("1"));
	}
}
