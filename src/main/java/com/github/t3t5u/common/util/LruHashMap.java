package com.github.t3t5u.common.util;

import java.util.LinkedHashMap;

@SuppressWarnings("serial")
public class LruHashMap<K, V> extends LinkedHashMap<K, V> {
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private final int maximumCapacity;

	public LruHashMap(final int maximumCapacity) {
		super(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, true);
		if (maximumCapacity < DEFAULT_INITIAL_CAPACITY) {
			throw new IllegalArgumentException("maximum capacity must be greater than or equal to default initial capacity.");
		}
		this.maximumCapacity = maximumCapacity;
	}

	public LruHashMap(final int maximumCapacity, final int initialCapacity) {
		super(initialCapacity, DEFAULT_LOAD_FACTOR, true);
		if (maximumCapacity < initialCapacity) {
			throw new IllegalArgumentException("maximum capacity must be greater than or equal to initial capacity.");
		}
		this.maximumCapacity = maximumCapacity;
	}

	public LruHashMap(final int maximumCapacity, final int initialCapacity, final float loadFactor) {
		super(initialCapacity, loadFactor, true);
		if (maximumCapacity < initialCapacity) {
			throw new IllegalArgumentException("maximum capacity must be greater than or equal to initial capacity.");
		}
		this.maximumCapacity = maximumCapacity;
	}

	@Override
	protected boolean removeEldestEntry(final java.util.Map.Entry<K, V> eldest) {
		return size() > maximumCapacity;
	}
}
