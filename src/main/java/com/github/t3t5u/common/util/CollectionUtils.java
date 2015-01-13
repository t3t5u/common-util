package com.github.t3t5u.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.lang3.ObjectUtils;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

public final class CollectionUtils {
	private CollectionUtils() {
	}

	public static boolean isEmpty(final Collection<?> collection) {
		return (collection == null) || collection.isEmpty();
	}

	public static <E> E peekOrNull(final Stack<? extends E> stack) {
		return !isEmpty(stack) ? stack.peek() : null;
	}

	public static <E> E getIfInBounds(final List<? extends E> list, final int index) {
		return (list != null) && (index >= 0) && (index < list.size()) ? list.get(index) : null;
	}

	public static <E> E removeIfInBounds(final List<E> list, final int index) {
		return (list != null) && (index >= 0) && (index < list.size()) ? list.remove(index) : null;
	}

	public static <E> boolean removeIfNotNull(final Collection<? super E> collection, final E element) {
		return (collection != null) && (element != null) && collection.remove(element);
	}

	public static <E> boolean removeIfNotNull(final Collection<? super E> collection, final Callable<? extends E> callable) {
		return (collection != null) && (callable != null) && removeIfNotNull(collection, ConcurrentUtils.call(callable));
	}

	public static <E> boolean removeAllIfNotNull(final Collection<? super E> collection, final Collection<? extends E> c) {
		return (collection != null) && (c != null) && collection.removeAll(c);
	}

	public static <E> boolean addIfNotNull(final Collection<? super E> collection, final E element) {
		return (collection != null) && (element != null) && collection.add(element);
	}

	public static <E> boolean addIfNotNull(final Collection<? super E> collection, final Callable<? extends E> callable) {
		return (collection != null) && (callable != null) && addIfNotNull(collection, ConcurrentUtils.call(callable));
	}

	public static <E> boolean addAllIfNotNull(final Collection<? super E> collection, final Collection<? extends E> c) {
		return (collection != null) && (c != null) && collection.addAll(c);
	}

	public static <K, V> V getIfNotNull(final Map<? super K, ? extends V> map, final K key) {
		return (map != null) && (key != null) ? map.get(key) : null;
	}

	public static <K, V> V putIfNotNull(final Map<? super K, V> map, final Map.Entry<? extends K, ? extends V> entry) {
		return (map != null) && (entry != null) ? putIfNotNull(map, entry.getKey(), entry.getValue()) : null;
	}

	public static <K, V> V putIfNotNull(final Map<? super K, V> map, final K key, final V value) {
		return (map != null) && (key != null) && (value != null) ? map.put(key, value) : null;
	}

	public static <K, V> V putIfNotNull(final Map<? super K, V> map, final K key, final Callable<? extends V> callable) {
		return (map != null) && (key != null) && (callable != null) ? putIfNotNull(map, key, ConcurrentUtils.call(callable)) : null;
	}

	public static <K, V> V putIfNotNull(final Map<? super K, V> map, final K key, final Function<K, ? extends V> function) {
		return (map != null) && (key != null) && (function != null) ? putIfNotNull(map, key, function.apply(key)) : null;
	}

	public static <K, V> V putIfContainsKey(final Map<? super K, V> map, final Map.Entry<? extends K, ? extends V> entry) {
		return (map != null) && (entry != null) ? putIfContainsKey(map, entry.getKey(), entry.getValue()) : null;
	}

	public static <K, V> V putIfContainsKey(final Map<? super K, V> map, final K key, final V value) {
		return (map != null) && (key != null) && map.containsKey(key) ? map.put(key, value) : null;
	}

	public static <K, V> V putIfContainsKey(final Map<? super K, V> map, final K key, final Callable<? extends V> callable) {
		return (map != null) && (key != null) && (callable != null) && map.containsKey(key) ? map.put(key, ConcurrentUtils.call(callable)) : null;
	}

	public static <K, V> V putIfContainsKey(final Map<? super K, V> map, final K key, final Function<K, ? extends V> function) {
		return (map != null) && (key != null) && (function != null) && map.containsKey(key) ? map.put(key, function.apply(key)) : null;
	}

	public static <K, V> V putIfContainsKeyAndNotNull(final Map<? super K, V> map, final Map.Entry<? extends K, ? extends V> entry) {
		return (map != null) && (entry != null) ? putIfContainsKeyAndNotNull(map, entry.getKey(), entry.getValue()) : null;
	}

	public static <K, V> V putIfContainsKeyAndNotNull(final Map<? super K, V> map, final K key, final V value) {
		return (map != null) && (key != null) && (value != null) && map.containsKey(key) ? map.put(key, value) : null;
	}

	public static <K, V> V putIfContainsKeyAndNotNull(final Map<? super K, V> map, final K key, final Callable<? extends V> callable) {
		return (map != null) && (key != null) && (callable != null) && map.containsKey(key) ? putIfNotNull(map, key, ConcurrentUtils.call(callable)) : null;
	}

	public static <K, V> V putIfContainsKeyAndNotNull(final Map<? super K, V> map, final K key, final Function<K, ? extends V> function) {
		return (map != null) && (key != null) && (function != null) && map.containsKey(key) ? putIfNotNull(map, key, function.apply(key)) : null;
	}

	public static <K, V> V putIfNotContainsKey(final Map<? super K, V> map, final Map.Entry<? extends K, ? extends V> entry) {
		return (map != null) && (entry != null) ? putIfNotContainsKey(map, entry.getKey(), entry.getValue()) : null;
	}

	public static <K, V> V putIfNotContainsKey(final Map<? super K, V> map, final K key, final V value) {
		return (map != null) && (key != null) && !map.containsKey(key) ? map.put(key, value) : null;
	}

	public static <K, V> V putIfNotContainsKey(final Map<? super K, V> map, final K key, final Callable<? extends V> callable) {
		return (map != null) && (key != null) && (callable != null) && !map.containsKey(key) ? map.put(key, ConcurrentUtils.call(callable)) : null;
	}

	public static <K, V> V putIfNotContainsKey(final Map<? super K, V> map, final K key, final Function<K, ? extends V> function) {
		return (map != null) && (key != null) && (function != null) && !map.containsKey(key) ? map.put(key, function.apply(key)) : null;
	}

	public static <K, V> V putIfNotContainsKeyAndNotNull(final Map<? super K, V> map, final Map.Entry<? extends K, ? extends V> entry) {
		return (map != null) && (entry != null) ? putIfNotContainsKeyAndNotNull(map, entry.getKey(), entry.getValue()) : null;
	}

	public static <K, V> V putIfNotContainsKeyAndNotNull(final Map<? super K, V> map, final K key, final V value) {
		return (map != null) && (key != null) && (value != null) && !map.containsKey(key) ? map.put(key, value) : null;
	}

	public static <K, V> V putIfNotContainsKeyAndNotNull(final Map<? super K, V> map, final K key, final Callable<? extends V> callable) {
		return (map != null) && (key != null) && (callable != null) && !map.containsKey(key) ? putIfNotNull(map, key, ConcurrentUtils.call(callable)) : null;
	}

	public static <K, V> V putIfNotContainsKeyAndNotNull(final Map<? super K, V> map, final K key, final Function<K, ? extends V> function) {
		return (map != null) && (key != null) && (function != null) && !map.containsKey(key) ? putIfNotNull(map, key, function.apply(key)) : null;
	}

	public static <K, V> V putIfAbsent(final ConcurrentMap<? super K, V> map, final ConcurrentMap.Entry<? extends K, ? extends V> entry) {
		return (map != null) && (entry != null) ? putIfAbsent(map, entry.getKey(), entry.getValue()) : null;
	}

	public static <K, V> V putIfAbsent(final ConcurrentMap<? super K, V> map, final K key, final V value) {
		return (map != null) && (key != null) ? map.putIfAbsent(key, value) : null;
	}

	public static <K, V> V putIfAbsent(final ConcurrentMap<? super K, V> map, final K key, final Callable<? extends V> callable) {
		return (map != null) && (key != null) && (callable != null) ? map.putIfAbsent(key, ConcurrentUtils.call(callable)) : null;
	}

	public static <K, V> V putIfAbsent(final ConcurrentMap<? super K, V> map, final K key, final Function<K, ? extends V> function) {
		return (map != null) && (key != null) && (function != null) ? map.putIfAbsent(key, function.apply(key)) : null;
	}

	public static <K, V> V putIfAbsentAndNotNull(final ConcurrentMap<? super K, V> map, final ConcurrentMap.Entry<? extends K, ? extends V> entry) {
		return (map != null) && (entry != null) ? putIfAbsentAndNotNull(map, entry.getKey(), entry.getValue()) : null;
	}

	public static <K, V> V putIfAbsentAndNotNull(final ConcurrentMap<? super K, V> map, final K key, final V value) {
		return (map != null) && (key != null) && (value != null) ? map.putIfAbsent(key, value) : null;
	}

	public static <K, V> V putIfAbsentAndNotNull(final ConcurrentMap<? super K, V> map, final K key, final Callable<? extends V> callable) {
		return (map != null) && (key != null) && (callable != null) ? putIfAbsentAndNotNull(map, key, ConcurrentUtils.call(callable)) : null;
	}

	public static <K, V> V putIfAbsentAndNotNull(final ConcurrentMap<? super K, V> map, final K key, final Function<K, ? extends V> function) {
		return (map != null) && (key != null) && (function != null) ? putIfAbsentAndNotNull(map, key, function.apply(key)) : null;
	}

	public static <K, V> V replace(final ConcurrentMap<? super K, V> map, final ConcurrentMap.Entry<? extends K, ? extends V> entry) {
		return (map != null) && (entry != null) ? replace(map, entry.getKey(), entry.getValue()) : null;
	}

	public static <K, V> V replace(final ConcurrentMap<? super K, V> map, final K key, final V value) {
		return (map != null) && (key != null) ? map.replace(key, value) : null;
	}

	public static <K, V> V replace(final ConcurrentMap<? super K, V> map, final K key, final Callable<? extends V> callable) {
		return (map != null) && (key != null) && (callable != null) ? map.replace(key, ConcurrentUtils.call(callable)) : null;
	}

	public static <K, V> V replace(final ConcurrentMap<? super K, V> map, final K key, final Function<K, ? extends V> function) {
		return (map != null) && (key != null) && (function != null) ? map.replace(key, function.apply(key)) : null;
	}

	public static <K, V> V replaceNotNull(final ConcurrentMap<? super K, V> map, final ConcurrentMap.Entry<? extends K, ? extends V> entry) {
		return (map != null) && (entry != null) ? replaceNotNull(map, entry.getKey(), entry.getValue()) : null;
	}

	public static <K, V> V replaceNotNull(final ConcurrentMap<? super K, V> map, final K key, final V value) {
		return (map != null) && (key != null) && (value != null) ? map.replace(key, value) : null;
	}

	public static <K, V> V replaceNotNull(final ConcurrentMap<? super K, V> map, final K key, final Callable<? extends V> callable) {
		return (map != null) && (key != null) && (callable != null) ? replaceNotNull(map, key, ConcurrentUtils.call(callable)) : null;
	}

	public static <K, V> V replaceNotNull(final ConcurrentMap<? super K, V> map, final K key, final Function<K, ? extends V> function) {
		return (map != null) && (key != null) && (function != null) ? replaceNotNull(map, key, function.apply(key)) : null;
	}

	public static <K, V> boolean replace(final ConcurrentMap<? super K, V> map, final K key, final V oldValue, final V newValue) {
		return (map != null) && (key != null) && map.replace(key, oldValue, newValue);
	}

	public static <K, V> boolean replaceNotNull(final ConcurrentMap<? super K, V> map, final K key, final V oldValue, final V newValue) {
		return (map != null) && (key != null) && (oldValue != null) && (newValue != null) && map.replace(key, oldValue, newValue);
	}

	public static <K, V> boolean putAllIfNotNull(final Map<? super K, ? super V> map, final Map<? extends K, ? extends V> m) {
		if ((map == null) || (m == null)) {
			return false;
		}
		map.putAll(m);
		return true;
	}

	public static <T extends Comparable<? super T>> T min(final Collection<? extends T> collection) {
		return min(collection, true);
	}

	public static <T extends Comparable<? super T>> T min(final Collection<? extends T> collection, final boolean nullGreater) {
		return !isEmpty(collection) ? Collections.min(collection, new Comparator<T>() {
			@Override
			public int compare(final T lhs, final T rhs) {
				return ObjectUtils.compare(lhs, rhs, nullGreater);
			}
		}) : null;
	}

	public static <T extends Comparable<? super T>> T max(final Collection<? extends T> collection) {
		return max(collection, false);
	}

	public static <T extends Comparable<? super T>> T max(final Collection<? extends T> collection, final boolean nullGreater) {
		return !isEmpty(collection) ? Collections.max(collection, new Comparator<T>() {
			@Override
			public int compare(final T lhs, final T rhs) {
				return ObjectUtils.compare(lhs, rhs, nullGreater);
			}
		}) : null;
	}

	public static <T> int count(final Iterable<? extends T> iterable, final Predicate<? super T> predicate) {
		if ((iterable == null) || (predicate == null)) {
			return -1;
		}
		int count = 0;
		for (final T element : iterable) {
			if (!predicate.apply(element)) {
				continue;
			}
			count++;
		}
		return count;
	}

	public static <T, R> R fold(final Iterable<? extends T> iterable, final Function<? super R, ? extends Function<? super T, ? extends R>> function, final R init) {
		if ((iterable == null) || (function == null)) {
			return null;
		}
		R result = init;
		for (final T element : iterable) {
			result = function.apply(result).apply(element);
		}
		return result;
	}

	public static <T, R> R foldLeft(final T[] array, final Function<? super R, ? extends Function<? super Integer, ? extends R>> function, final R init) {
		if ((array == null) || (function == null)) {
			return null;
		}
		R result = init;
		for (int index = 0; index < array.length; index++) {
			result = function.apply(result).apply(index);
		}
		return result;
	}

	public static <T, R> R foldRight(final T[] array, final Function<? super R, ? extends Function<? super Integer, ? extends R>> function, final R init) {
		if ((array == null) || (function == null)) {
			return null;
		}
		R result = init;
		for (int index = array.length - 1; index >= 0; index--) {
			result = function.apply(result).apply(index);
		}
		return result;
	}

	public static <E, R> R foldLeft(final Collection<? extends E> collection, final Function<? super R, ? extends Function<? super Integer, ? extends R>> function, final R init) {
		if ((collection == null) || (function == null)) {
			return null;
		}
		R result = init;
		for (int index = 0; index < collection.size(); index++) {
			result = function.apply(result).apply(index);
		}
		return result;
	}

	public static <E, R> R foldRight(final Collection<? extends E> collection, final Function<? super R, ? extends Function<? super Integer, ? extends R>> function, final R init) {
		if ((collection == null) || (function == null)) {
			return null;
		}
		R result = init;
		for (int index = collection.size() - 1; index >= 0; index--) {
			result = function.apply(result).apply(index);
		}
		return result;
	}

	public static <T> void forEach(final T[] array, final Procedure<? super T> procedure) {
		if ((array == null) || (procedure == null)) {
			return;
		}
		for (final T element : array) {
			procedure.proceed(element);
		}
	}

	public static <T> void forEach(final Iterable<? extends T> iterable, final Procedure<? super T> procedure) {
		if ((iterable == null) || (procedure == null)) {
			return;
		}
		for (final T element : iterable) {
			procedure.proceed(element);
		}
	}

	public static void forEach(final int from, final int to, final int step, final Procedure<? super Integer> procedure) {
		if ((from > to) || (procedure == null)) {
			return;
		}
		for (int count = from; count <= to; count += step) {
			procedure.proceed(count);
		}
	}

	public static <C extends Comparable<?>> void forEach(final Range<C> range, final DiscreteDomain<C> domain, final Procedure<? super C> procedure) {
		if ((range == null) || (domain == null) || (procedure == null)) {
			return;
		}
		for (final C c : ContiguousSet.create(range, domain)) {
			procedure.proceed(c);
		}
	}

	public static <T, E> List<E> addForEach(final T[] array, final Function<? super T, ? extends E> function) {
		if ((array == null) || (function == null)) {
			return null;
		}
		final List<E> list = new ArrayList<E>();
		for (final T element : array) {
			addIfNotNull(list, function.apply(element));
		}
		return list;
	}

	public static <T, E> List<E> addForEach(final Iterable<? extends T> iterable, final Function<? super T, ? extends E> function) {
		if ((iterable == null) || (function == null)) {
			return null;
		}
		final List<E> list = new ArrayList<E>();
		for (final T element : iterable) {
			addIfNotNull(list, function.apply(element));
		}
		return list;
	}

	public static <E> List<E> addForEach(final int from, final int to, final int step, final Function<? super Integer, ? extends E> function) {
		if ((from > to) || (function == null)) {
			return null;
		}
		final List<E> list = new ArrayList<E>();
		for (int count = from; count <= to; count += step) {
			addIfNotNull(list, function.apply(count));
		}
		return list;
	}

	public static <E, C extends Comparable<?>> List<E> addForEach(final Range<C> range, final DiscreteDomain<C> domain, final Function<? super C, ? extends E> function) {
		if ((range == null) || (domain == null) || (function == null)) {
			return null;
		}
		final List<E> list = new ArrayList<E>();
		for (final C c : ContiguousSet.create(range, domain)) {
			addIfNotNull(list, function.apply(c));
		}
		return list;
	}

	public static <T, E> List<E> addAllForEach(final T[] array, final Function<? super T, ? extends Collection<? extends E>> function) {
		if ((array == null) || (function == null)) {
			return null;
		}
		final List<E> list = new ArrayList<E>();
		for (final T element : array) {
			addAllIfNotNull(list, function.apply(element));
		}
		return list;
	}

	public static <T, E> List<E> addAllForEach(final Iterable<? extends T> iterable, final Function<? super T, ? extends Collection<? extends E>> function) {
		if ((iterable == null) || (function == null)) {
			return null;
		}
		final List<E> list = new ArrayList<E>();
		for (final T element : iterable) {
			addAllIfNotNull(list, function.apply(element));
		}
		return list;
	}

	public static <E> List<E> addAllForEach(final int from, final int to, final int step, final Function<? super Integer, ? extends Collection<? extends E>> function) {
		if ((from > to) || (function == null)) {
			return null;
		}
		final List<E> list = new ArrayList<E>();
		for (int count = from; count <= to; count += step) {
			addAllIfNotNull(list, function.apply(count));
		}
		return list;
	}

	public static <E, C extends Comparable<?>> List<E> addAllForEach(final Range<C> range, final DiscreteDomain<C> domain, final Function<? super C, ? extends Collection<? extends E>> function) {
		if ((range == null) || (domain == null) || (function == null)) {
			return null;
		}
		final List<E> list = new ArrayList<E>();
		for (final C c : ContiguousSet.create(range, domain)) {
			addAllIfNotNull(list, function.apply(c));
		}
		return list;
	}

	public static <T, K, V> Map<K, V> putForEach(final Iterable<? extends T> iterable, final Function<? super T, ? extends Map.Entry<? extends K, ? extends V>> function) {
		if ((iterable == null) || (function == null)) {
			return null;
		}
		final Map<K, V> map = new LinkedHashMap<K, V>();
		for (final T element : iterable) {
			putIfNotNull(map, function.apply(element));
		}
		return map;
	}

	public static <K, V> Map<K, V> putForEachKey(final Iterable<? extends K> keys, final Function<? super K, ? extends V> function) {
		if ((keys == null) || (function == null)) {
			return null;
		}
		final Map<K, V> map = new LinkedHashMap<K, V>();
		for (final K key : keys) {
			putIfNotNull(map, key, function.apply(key));
		}
		return map;
	}

	public static <K, V> Map<K, V> putForEachValue(final Iterable<? extends V> values, final Function<? super V, ? extends K> function) {
		if ((values == null) || (function == null)) {
			return null;
		}
		final Map<K, V> map = new LinkedHashMap<K, V>();
		for (final V value : values) {
			putIfNotNull(map, function.apply(value), value);
		}
		return map;
	}

	public static <T, K, V> Map<K, V> putAllForEach(final Iterable<? extends T> iterable, final Function<? super T, ? extends Map<? extends K, ? extends V>> function) {
		if ((iterable == null) || (function == null)) {
			return null;
		}
		final Map<K, V> map = new LinkedHashMap<K, V>();
		for (final T element : iterable) {
			putAllIfNotNull(map, function.apply(element));
		}
		return map;
	}
}
