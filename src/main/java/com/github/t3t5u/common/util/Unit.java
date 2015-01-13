package com.github.t3t5u.common.util;

public final class Unit {
	private Unit() {
	}

	public static final long K = 1024;
	public static final long M = K * K;
	public static final long G = M * K;
	public static final long T = G * K;

	public static String unitize(final long l) {
		return l < K ? l + "B" : l < M ? (l / K) + "KB" : l < G ? (l / M) + "MB" : (l / G) + "GB";
	}
}
