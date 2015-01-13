package com.github.t3t5u.common.util;

public class NativeHandle {
	private final long rawHandle;

	public NativeHandle(final long rawHandle) {
		this.rawHandle = rawHandle;
	}

	public long getRawHandle() {
		return rawHandle;
	}
}
