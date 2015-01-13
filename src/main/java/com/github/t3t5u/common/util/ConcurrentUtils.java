package com.github.t3t5u.common.util;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.MoreExecutors;

public final class ConcurrentUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConcurrentUtils.class);

	private ConcurrentUtils() {
	}

	public static <V> ListenableFutureTask<V> executeOrNull(final ListenableFutureTask<V> listenableFutureTask, final FutureCallback<V> callback) {
		return executeOrNull(MoreExecutors.directExecutor(), listenableFutureTask, callback);
	}

	public static <V> ListenableFutureTask<V> execute(final ListenableFutureTask<V> listenableFutureTask, final FutureCallback<V> callback) {
		return execute(MoreExecutors.directExecutor(), listenableFutureTask, callback);
	}

	public static <V> ListenableFutureTask<V> executeOrNull(final ListenableFutureTask<V> listenableFutureTask) {
		return executeOrNull(MoreExecutors.directExecutor(), listenableFutureTask);
	}

	public static <V> ListenableFutureTask<V> execute(final ListenableFutureTask<V> listenableFutureTask) {
		return execute(MoreExecutors.directExecutor(), listenableFutureTask);
	}

	public static <V> RunnableFuture<V> executeOrNull(final RunnableFuture<V> runnableFuture) {
		return executeOrNull(MoreExecutors.directExecutor(), runnableFuture);
	}

	public static <V> RunnableFuture<V> execute(final RunnableFuture<V> runnableFuture) {
		return execute(MoreExecutors.directExecutor(), runnableFuture);
	}

	public static <V> RunnableFuture<V> executeOrNull(final Callable<V> callable) {
		return executeOrNull(MoreExecutors.directExecutor(), callable);
	}

	public static <V> RunnableFuture<V> execute(final Callable<V> callable) {
		return execute(MoreExecutors.directExecutor(), callable);
	}

	public static <V> RunnableFuture<V> executeOrNull(final Runnable runnable, final V result) {
		return executeOrNull(MoreExecutors.directExecutor(), runnable, result);
	}

	public static <V> RunnableFuture<V> execute(final Runnable runnable, final V result) {
		return execute(MoreExecutors.directExecutor(), runnable, result);
	}

	public static <V> ListenableFutureTask<V> executeOrNull(final Executor executor, final ListenableFutureTask<V> listenableFutureTask, final FutureCallback<V> callback) {
		if ((executor == null) || (listenableFutureTask == null) || (callback == null)) {
			return null;
		}
		try {
			return execute(executor, listenableFutureTask, callback);
		} catch (final Throwable t) {
			LOGGER.info("executeOrNull", t);
			return null;
		}
	}

	public static <V> ListenableFutureTask<V> execute(final Executor executor, final ListenableFutureTask<V> listenableFutureTask, final FutureCallback<V> callback) {
		Futures.addCallback(listenableFutureTask, callback);
		executor.execute(listenableFutureTask);
		return listenableFutureTask;
	}

	public static <V> ListenableFutureTask<V> executeOrNull(final Executor executor, final ListenableFutureTask<V> listenableFutureTask) {
		if ((executor == null) || (listenableFutureTask == null)) {
			return null;
		}
		try {
			return execute(executor, listenableFutureTask);
		} catch (final Throwable t) {
			LOGGER.info("executeOrNull", t);
			return null;
		}
	}

	public static <V> ListenableFutureTask<V> execute(final Executor executor, final ListenableFutureTask<V> listenableFutureTask) {
		executor.execute(listenableFutureTask);
		return listenableFutureTask;
	}

	public static <V> RunnableFuture<V> executeOrNull(final Executor executor, final RunnableFuture<V> runnableFuture) {
		if ((executor == null) || (runnableFuture == null)) {
			return null;
		}
		try {
			return execute(executor, runnableFuture);
		} catch (final Throwable t) {
			LOGGER.info("executeOrNull", t);
			return null;
		}
	}

	public static <V> RunnableFuture<V> execute(final Executor executor, final RunnableFuture<V> runnableFuture) {
		executor.execute(runnableFuture);
		return runnableFuture;
	}

	public static <V> RunnableFuture<V> executeOrNull(final Executor executor, final Callable<V> callable) {
		if ((executor == null) || (callable == null)) {
			return null;
		}
		try {
			return execute(executor, callable);
		} catch (final Throwable t) {
			LOGGER.info("executeOrNull", t);
			return null;
		}
	}

	public static <V> RunnableFuture<V> execute(final Executor executor, final Callable<V> callable) {
		final RunnableFuture<V> runnableFuture = new FutureTask<V>(callable);
		executor.execute(runnableFuture);
		return runnableFuture;
	}

	public static <V> RunnableFuture<V> executeOrNull(final Executor executor, final Runnable runnable, final V result) {
		if ((executor == null) || (runnable == null)) {
			return null;
		}
		try {
			return execute(executor, runnable, result);
		} catch (final Throwable t) {
			LOGGER.info("executeOrNull", t);
			return null;
		}
	}

	public static <V> RunnableFuture<V> execute(final Executor executor, final Runnable runnable, final V result) {
		final RunnableFuture<V> runnableFuture = new FutureTask<V>(runnable, result);
		executor.execute(runnableFuture);
		return runnableFuture;
	}

	public static <V> V getOrNull(final ListenableFuture<V> future, final FutureCallback<V> callback) {
		if ((future == null) || (callback == null)) {
			return null;
		}
		try {
			return get(future, callback);
		} catch (final Throwable t) {
			LOGGER.info("getOrNull", t);
			return null;
		}
	}

	public static <V> V get(final ListenableFuture<V> future, final FutureCallback<V> callback) {
		final CountDownLatch latch = new CountDownLatch(1);
		Futures.addCallback(future, callback);
		Futures.addCallback(future, callback(latch));
		V result;
		try {
			result = future.get();
		} catch (final InterruptedException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} catch (final ExecutionException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} finally {
			cancel(future);
			awaitInterruptibly(latch);
		}
		return latch.getCount() < 1 ? result : null;
	}

	public static <V> V getOrNull(final Executor executor, final ListenableFuture<V> future, final FutureCallback<V> callback) {
		if ((executor == null) || (future == null) || (callback == null)) {
			return null;
		}
		try {
			return get(executor, future, callback);
		} catch (final Throwable t) {
			LOGGER.info("getOrNull", t);
			return null;
		}
	}

	public static <V> V get(final Executor executor, final ListenableFuture<V> future, final FutureCallback<V> callback) {
		final RunnableFuture<V> runnableFuture = execute(executor, future);
		final CountDownLatch latch = new CountDownLatch(1);
		Futures.addCallback(future, callback);
		Futures.addCallback(future, callback(latch));
		V result;
		try {
			result = runnableFuture.get();
		} catch (final InterruptedException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} catch (final ExecutionException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} finally {
			cancel(runnableFuture);
			awaitInterruptibly(latch);
		}
		return latch.getCount() < 1 ? result : null;
	}

	public static <V> V getOrNull(final ListenableFuture<V> future, final FutureCallback<V> callback, final long timeout, final TimeUnit unit) {
		if ((future == null) || (callback == null) || (unit == null)) {
			return null;
		}
		try {
			return get(future, callback, timeout, unit);
		} catch (final Throwable t) {
			LOGGER.info("getOrNull", t);
			return null;
		}
	}

	public static <V> V get(final ListenableFuture<V> future, final FutureCallback<V> callback, final long timeout, final TimeUnit unit) {
		final CountDownLatch latch = new CountDownLatch(1);
		Futures.addCallback(future, callback);
		Futures.addCallback(future, callback(latch));
		V result;
		try {
			result = future.get(timeout, unit);
		} catch (final InterruptedException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} catch (final ExecutionException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} catch (final TimeoutException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} finally {
			cancel(future);
			awaitInterruptibly(latch, timeout, unit);
		}
		return latch.getCount() < 1 ? result : null;
	}

	public static <V> V getOrNull(final Executor executor, final ListenableFuture<V> future, final FutureCallback<V> callback, final long timeout, final TimeUnit unit) {
		if ((executor == null) || (future == null) || (callback == null) || (unit == null)) {
			return null;
		}
		try {
			return get(executor, future, callback, timeout, unit);
		} catch (final Throwable t) {
			LOGGER.info("getOrNull", t);
			return null;
		}
	}

	public static <V> V get(final Executor executor, final ListenableFuture<V> future, final FutureCallback<V> callback, final long timeout, final TimeUnit unit) {
		final RunnableFuture<V> runnableFuture = execute(executor, future);
		final CountDownLatch latch = new CountDownLatch(1);
		Futures.addCallback(future, callback);
		Futures.addCallback(future, callback(latch));
		V result;
		try {
			result = runnableFuture.get(timeout, unit);
		} catch (final InterruptedException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} catch (final ExecutionException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} catch (final TimeoutException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} finally {
			cancel(runnableFuture);
			awaitInterruptibly(latch, timeout, unit);
		}
		return latch.getCount() < 1 ? result : null;
	}

	private static <V> FutureCallback<V> callback(final CountDownLatch latch) {
		return new FutureCallback<V>() {
			@Override
			public void onSuccess(final V result) {
				latch.countDown();
			}

			@Override
			public void onFailure(final Throwable t) {
				latch.countDown();
			}
		};
	}

	private static boolean awaitInterruptibly(final CountDownLatch latch) {
		try {
			latch.await();
			return true;
		} catch (final InterruptedException e) {
			LOGGER.info("awaitInterruptibly", e);
			return false;
		}
	}

	private static boolean awaitInterruptibly(final CountDownLatch latch, final long timeout, final TimeUnit unit) {
		try {
			return latch.await(timeout, unit);
		} catch (final InterruptedException e) {
			LOGGER.info("awaitInterruptibly", e);
			return false;
		}
	}

	public static <V> V getOrNull(final Future<V> future) {
		if (future == null) {
			return null;
		}
		try {
			return get(future);
		} catch (final Throwable t) {
			LOGGER.info("getOrNull", t);
			return null;
		}
	}

	public static <V> V get(final Future<V> future) {
		try {
			return future.get();
		} catch (final InterruptedException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} catch (final ExecutionException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} finally {
			cancel(future);
		}
	}

	public static <V> V getOrNull(final Executor executor, final Future<V> future) {
		if ((executor == null) || (future == null)) {
			return null;
		}
		try {
			return get(executor, future);
		} catch (final Throwable t) {
			LOGGER.info("getOrNull", t);
			return null;
		}
	}

	public static <V> V get(final Executor executor, final Future<V> future) {
		final RunnableFuture<V> runnableFuture = execute(executor, future);
		try {
			return runnableFuture.get();
		} catch (final InterruptedException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} catch (final ExecutionException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} finally {
			cancel(runnableFuture);
		}
	}

	public static <V> V getOrNull(final Future<V> future, final long timeout, final TimeUnit unit) {
		if ((future == null) || (unit == null)) {
			return null;
		}
		try {
			return get(future, timeout, unit);
		} catch (final Throwable t) {
			LOGGER.info("getOrNull", t);
			return null;
		}
	}

	public static <V> V get(final Future<V> future, final long timeout, final TimeUnit unit) {
		try {
			return future.get(timeout, unit);
		} catch (final InterruptedException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} catch (final ExecutionException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} catch (final TimeoutException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} finally {
			cancel(future);
		}
	}

	public static <V> V getOrNull(final Executor executor, final Future<V> future, final long timeout, final TimeUnit unit) {
		if ((executor == null) || (future == null) || (unit == null)) {
			return null;
		}
		try {
			return get(executor, future, timeout, unit);
		} catch (final Throwable t) {
			LOGGER.info("getOrNull", t);
			return null;
		}
	}

	public static <V> V get(final Executor executor, final Future<V> future, final long timeout, final TimeUnit unit) {
		final RunnableFuture<V> runnableFuture = execute(executor, future);
		try {
			return runnableFuture.get(timeout, unit);
		} catch (final InterruptedException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} catch (final ExecutionException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} catch (final TimeoutException e) {
			LOGGER.warn("get", e);
			throw new RuntimeException(e);
		} finally {
			cancel(runnableFuture);
		}
	}

	private static <V> RunnableFuture<V> execute(final Executor executor, final Future<V> future) {
		return execute(executor, new FutureTask<V>(new Callable<V>() {
			@Override
			public V call() throws Exception {
				return future.get();
			}
		}) {
			@Override
			public boolean cancel(final boolean mayInterruptIfRunning) {
				future.cancel(mayInterruptIfRunning);
				return super.cancel(mayInterruptIfRunning);
			}
		});
	}

	private static boolean cancel(final Future<?> future) {
		return future.isDone() || future.isCancelled() || future.cancel(true);
	}

	public static boolean cancel(final Future<?> future, final boolean mayInterruptIfRunning) {
		return (future != null) && future.cancel(mayInterruptIfRunning);
	}

	public static boolean isCancelled(final Future<?> future) {
		return (future != null) && future.isCancelled();
	}

	public static boolean isDone(final Future<?> future) {
		return (future != null) && future.isDone();
	}

	public static boolean isInterrupted(final AtomicBoolean atomic) {
		if (atomic == null) {
			return false;
		}
		atomic.compareAndSet(false, Thread.interrupted());
		return atomic.get();
	}

	public static boolean acquireInterruptibly(final Semaphore semaphore) {
		if (semaphore == null) {
			return false;
		}
		try {
			semaphore.acquire();
			return true;
		} catch (final InterruptedException e) {
			LOGGER.info("acquireInterruptibly", e);
			return false;
		}
	}

	public static boolean acquireInterruptibly(final Semaphore semaphore, final int permits) {
		if (semaphore == null) {
			return false;
		}
		try {
			semaphore.acquire(permits);
			return true;
		} catch (final InterruptedException e) {
			LOGGER.info("acquireInterruptibly", e);
			return false;
		}
	}

	public static boolean acquireInterruptibly(final Semaphore semaphore, final long timeout, final TimeUnit unit) {
		if ((semaphore == null) || (unit == null)) {
			return false;
		}
		try {
			return semaphore.tryAcquire(timeout, unit);
		} catch (final InterruptedException e) {
			LOGGER.info("acquireInterruptibly", e);
			return false;
		}
	}

	public static boolean acquireInterruptibly(final Semaphore semaphore, final int permits, final long timeout, final TimeUnit unit) {
		if ((semaphore == null) || (unit == null)) {
			return false;
		}
		try {
			return semaphore.tryAcquire(permits, timeout, unit);
		} catch (final InterruptedException e) {
			LOGGER.info("acquireInterruptibly", e);
			return false;
		}
	}

	public static <V> V callOrNull(final Callable<V> callable) {
		if (callable == null) {
			return null;
		}
		try {
			return call(callable);
		} catch (final Throwable t) {
			LOGGER.info("callOrNull", t);
			return null;
		}
	}

	public static <V> V call(final Callable<V> callable) {
		try {
			return callable.call();
		} catch (final Exception e) {
			LOGGER.warn("call", e);
			throw new RuntimeException(e);
		}
	}

	public static boolean sleepInterruptibly(final long timeout, final TimeUnit unit) {
		if (unit == null) {
			return false;
		}
		try {
			Thread.sleep(unit.toMillis(timeout));
			return true;
		} catch (final InterruptedException e) {
			LOGGER.info("sleepInterruptibly", e);
			return false;
		}
	}

	public static boolean wait(final Object monitor) {
		return (monitor != null) && (monitor == wait(monitor, new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				return monitor;
			}
		}));
	}

	public static <V> V wait(final Object monitor, final Callable<V> callable) {
		if ((monitor == null) || (callable == null)) {
			return null;
		}
		try {
			return synchronizedWait(monitor, 0, null, callable);
		} catch (final Exception e) {
			LOGGER.info("wait", e);
			return null;
		}
	}

	public static boolean wait(final Object monitor, final long timeout, final TimeUnit unit) {
		return (monitor != null) && (unit != null) && (monitor == wait(monitor, timeout, unit, new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				return monitor;
			}
		}));
	}

	public static <V> V wait(final Object monitor, final long timeout, final TimeUnit unit, final Callable<V> callable) {
		if ((monitor == null) || (unit == null) || (callable == null)) {
			return null;
		}
		try {
			return synchronizedWait(monitor, timeout, unit, callable);
		} catch (final Exception e) {
			LOGGER.info("wait", e);
			return null;
		}
	}

	private static <V> V synchronizedWait(final Object monitor, final long timeout, final TimeUnit unit, final Callable<V> callable) throws Exception {
		V result = null;
		synchronized (monitor) {
			waitInterruptibly(monitor, timeout, unit);
			result = callable.call();
		}
		return result;
	}

	private static boolean waitInterruptibly(final Object monitor, final long timeout, final TimeUnit unit) {
		try {
			monitor.wait(timeout);
			return true;
		} catch (final InterruptedException e) {
			LOGGER.info("waitInterruptibly", e);
			return false;
		}
	}

	public static boolean notify(final Object monitor) {
		return (monitor != null) && (monitor == notify(monitor, new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				return monitor;
			}
		}));
	}

	public static <V> V notify(final Object monitor, final Callable<V> callable) {
		if ((monitor == null) || (callable == null)) {
			return null;
		}
		try {
			return synchronizedNotify(monitor, callable);
		} catch (final Exception e) {
			LOGGER.info("notify", e);
			return null;
		}
	}

	private static <V> V synchronizedNotify(final Object monitor, final Callable<V> callable) throws Exception {
		V result = null;
		synchronized (monitor) {
			result = callable.call();
			monitor.notify();
		}
		return result;
	}

	public static boolean notifyAll(final Object monitor) {
		return (monitor != null) && (monitor == notifyAll(monitor, new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				return monitor;
			}
		}));
	}

	public static <V> V notifyAll(final Object monitor, final Callable<V> callable) {
		if ((monitor == null) || (callable == null)) {
			return null;
		}
		try {
			return synchronizedNotifyAll(monitor, callable);
		} catch (final Exception e) {
			LOGGER.info("notifyAll", e);
			return null;
		}
	}

	private static <V> V synchronizedNotifyAll(final Object monitor, final Callable<V> callable) throws Exception {
		V result = null;
		synchronized (monitor) {
			result = callable.call();
			monitor.notifyAll();
		}
		return result;
	}
}
