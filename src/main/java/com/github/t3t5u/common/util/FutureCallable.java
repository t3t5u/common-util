package com.github.t3t5u.common.util;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public interface FutureCallable<V> extends Callable<Future<V>> {
}
