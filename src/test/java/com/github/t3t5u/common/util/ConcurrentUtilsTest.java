package com.github.t3t5u.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConcurrentUtilsTest {
	private ExecutorService fixedThreadPool;
	private ExecutorService cachedThreadPool;
	private ScheduledExecutorService scheduledThreadPool;
	private ExecutorService singleThreadExecutor;
	private ScheduledExecutorService singleThreadScheduledExecutor;

	@Before
	public void before() {
		fixedThreadPool = Executors.newFixedThreadPool(2);
		cachedThreadPool = Executors.newCachedThreadPool();
		scheduledThreadPool = Executors.newScheduledThreadPool(2);
		singleThreadExecutor = Executors.newSingleThreadExecutor();
		singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
	}

	@After
	public void after() {
		fixedThreadPool.shutdownNow();
		cachedThreadPool.shutdownNow();
		scheduledThreadPool.shutdownNow();
		singleThreadExecutor.shutdownNow();
		singleThreadScheduledExecutor.shutdownNow();
	}

	@Test
	public void nullの場合() {
		assertThat(ConcurrentUtils.executeOrNull((RunnableFuture<?>) null), is(nullValue()));
		assertThat(ConcurrentUtils.executeOrNull((Callable<?>) null), is(nullValue()));
		assertThat(ConcurrentUtils.executeOrNull((Runnable) null, null), is(nullValue()));
		assertThat(ConcurrentUtils.executeOrNull((Executor) null, (RunnableFuture<?>) null), is(nullValue()));
		assertThat(ConcurrentUtils.executeOrNull((Executor) null, (Callable<?>) null), is(nullValue()));
		assertThat(ConcurrentUtils.executeOrNull((Executor) null, (Runnable) null, null), is(nullValue()));
		assertThat(ConcurrentUtils.getOrNull(null), is(nullValue()));
		assertThat(ConcurrentUtils.cancel(null, true), is(false));
		assertThat(ConcurrentUtils.isCancelled(null), is(false));
		assertThat(ConcurrentUtils.isDone(null), is(false));
	}

	@Test(timeout = 10000)
	public void testExecuteOrNullRunnableFutureOfV() throws Exception {
		final Callable<Integer> callable = getCallable();
		final List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		futureList.add(ConcurrentUtils.executeOrNull(getRunnableFuture(callable)));
		futureList.add(ConcurrentUtils.executeOrNull(getRunnableFuture(callable)));
		futureList.add(ConcurrentUtils.executeOrNull(getRunnableFuture(callable)));
		assertThat(futureList.get(0).get(), is(0));
		assertThat(futureList.get(1).get(), is(1));
		assertThat(futureList.get(2).get(), is(2));
	}

	@Test(timeout = 10000)
	public void testExecuteRunnableFutureOfV() throws Exception {
		final Callable<Integer> callable = getCallable();
		final List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		futureList.add(ConcurrentUtils.execute(getRunnableFuture(callable)));
		futureList.add(ConcurrentUtils.execute(getRunnableFuture(callable)));
		futureList.add(ConcurrentUtils.execute(getRunnableFuture(callable)));
		assertThat(futureList.get(0).get(), is(0));
		assertThat(futureList.get(1).get(), is(1));
		assertThat(futureList.get(2).get(), is(2));
	}

	@Test(timeout = 10000)
	public void testExecuteOrNullCallableOfV() throws Exception {
		final Callable<Integer> callable = getCallable();
		final List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		futureList.add(ConcurrentUtils.executeOrNull(callable));
		futureList.add(ConcurrentUtils.executeOrNull(callable));
		futureList.add(ConcurrentUtils.executeOrNull(callable));
		assertThat(futureList.get(0).get(), is(0));
		assertThat(futureList.get(1).get(), is(1));
		assertThat(futureList.get(2).get(), is(2));
	}

	@Test(timeout = 10000)
	public void testExecuteCallableOfV() throws Exception {
		final Callable<Integer> callable = getCallable();
		final List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		futureList.add(ConcurrentUtils.execute(callable));
		futureList.add(ConcurrentUtils.execute(callable));
		futureList.add(ConcurrentUtils.execute(callable));
		assertThat(futureList.get(0).get(), is(0));
		assertThat(futureList.get(1).get(), is(1));
		assertThat(futureList.get(2).get(), is(2));
	}

	@Test(timeout = 10000)
	public void testExecuteOrNullRunnableV() throws Exception {
		final List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		futureList.add(ConcurrentUtils.executeOrNull(getRunnable(), 0));
		futureList.add(ConcurrentUtils.executeOrNull(getRunnable(), 1));
		futureList.add(ConcurrentUtils.executeOrNull(getRunnable(), 2));
		assertThat(futureList.get(0).get(), is(0));
		assertThat(futureList.get(1).get(), is(1));
		assertThat(futureList.get(2).get(), is(2));
	}

	@Test(timeout = 10000)
	public void testExecuteRunnableV() throws Exception {
		final List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		futureList.add(ConcurrentUtils.execute(getRunnable(), 0));
		futureList.add(ConcurrentUtils.execute(getRunnable(), 1));
		futureList.add(ConcurrentUtils.execute(getRunnable(), 2));
		assertThat(futureList.get(0).get(), is(0));
		assertThat(futureList.get(1).get(), is(1));
		assertThat(futureList.get(2).get(), is(2));
	}

	@Test(timeout = 10000)
	public void testExecuteOrNullExecutorRunnableFutureOfV() throws Exception {
		final Callable<Integer> callable = getCallable();
		final List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		futureList.add(ConcurrentUtils.executeOrNull(cachedThreadPool, getRunnableFuture(callable)));
		futureList.add(ConcurrentUtils.executeOrNull(cachedThreadPool, getRunnableFuture(callable)));
		futureList.add(ConcurrentUtils.executeOrNull(cachedThreadPool, getRunnableFuture(callable)));
		assertThat(futureList.get(0).get(), anyOf(is(0), is(1), is(2))); // 0か1か2
		assertThat(futureList.get(1).get(), anyOf(is(0), is(1), is(2))); // 0か1か2
		assertThat(futureList.get(2).get(), anyOf(is(0), is(1), is(2))); // 0か1か2
	}

	@Test(timeout = 10000)
	public void testExecuteExecutorRunnableFutureOfV() throws Exception {
		final Callable<Integer> callable = getCallable();
		final List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		futureList.add(ConcurrentUtils.execute(cachedThreadPool, getRunnableFuture(callable)));
		futureList.add(ConcurrentUtils.execute(cachedThreadPool, getRunnableFuture(callable)));
		futureList.add(ConcurrentUtils.execute(cachedThreadPool, getRunnableFuture(callable)));
		assertThat(futureList.get(0).get(), anyOf(is(0), is(1), is(2))); // 0か1か2
		assertThat(futureList.get(1).get(), anyOf(is(0), is(1), is(2))); // 0か1か2
		assertThat(futureList.get(2).get(), anyOf(is(0), is(1), is(2))); // 0か1か2
	}

	@Test(timeout = 10000)
	public void testExecuteOrNullExecutorCallableOfV() throws Exception {
		final Callable<Integer> callable = getCallable();
		final List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		futureList.add(ConcurrentUtils.executeOrNull(cachedThreadPool, callable));
		futureList.add(ConcurrentUtils.executeOrNull(cachedThreadPool, callable));
		futureList.add(ConcurrentUtils.executeOrNull(cachedThreadPool, callable));
		assertThat(futureList.get(0).get(), anyOf(is(0), is(1), is(2))); // 0か1か2
		assertThat(futureList.get(1).get(), anyOf(is(0), is(1), is(2))); // 0か1か2
		assertThat(futureList.get(2).get(), anyOf(is(0), is(1), is(2))); // 0か1か2
	}

	@Test(timeout = 10000)
	public void testExecuteExecutorCallableOfV() throws Exception {
		final Callable<Integer> callable = getCallable();
		final List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		futureList.add(ConcurrentUtils.execute(cachedThreadPool, callable));
		futureList.add(ConcurrentUtils.execute(cachedThreadPool, callable));
		futureList.add(ConcurrentUtils.execute(cachedThreadPool, callable));
		assertThat(futureList.get(0).get(), anyOf(is(0), is(1), is(2))); // 0か1か2
		assertThat(futureList.get(1).get(), anyOf(is(0), is(1), is(2))); // 0か1か2
		assertThat(futureList.get(2).get(), anyOf(is(0), is(1), is(2))); // 0か1か2
	}

	@Test(timeout = 10000)
	public void testExecuteOrNullExecutorRunnableV() throws Exception {
		final List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		futureList.add(ConcurrentUtils.executeOrNull(cachedThreadPool, getRunnable(), 0));
		futureList.add(ConcurrentUtils.executeOrNull(cachedThreadPool, getRunnable(), 1));
		futureList.add(ConcurrentUtils.executeOrNull(cachedThreadPool, getRunnable(), 2));
		assertThat(futureList.get(0).get(), anyOf(is(0), is(1), is(2))); // 0か1か2
		assertThat(futureList.get(1).get(), anyOf(is(0), is(1), is(2))); // 0か1か2
		assertThat(futureList.get(2).get(), anyOf(is(0), is(1), is(2))); // 0か1か2
	}

	@Test(timeout = 10000)
	public void testExecuteExecutorRunnableV() throws Exception {
		final List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		futureList.add(ConcurrentUtils.execute(cachedThreadPool, getRunnable(), 0));
		futureList.add(ConcurrentUtils.execute(cachedThreadPool, getRunnable(), 1));
		futureList.add(ConcurrentUtils.execute(cachedThreadPool, getRunnable(), 2));
		assertThat(futureList.get(0).get(), anyOf(is(0), is(1), is(2))); // 0か1か2
		assertThat(futureList.get(1).get(), anyOf(is(0), is(1), is(2))); // 0か1か2
		assertThat(futureList.get(2).get(), anyOf(is(0), is(1), is(2))); // 0か1か2
	}

	@Test(timeout = 10000)
	public void testGetOrNullFutureOfV() {
		assertThat(ConcurrentUtils.getOrNull(ConcurrentUtils.execute(getRunnableFuture())), is(0));
		assertThat(ConcurrentUtils.getOrNull(ConcurrentUtils.execute(getRunnableFuture(10, TimeUnit.MILLISECONDS))), is(0));
		assertThat(ConcurrentUtils.getOrNull(ConcurrentUtils.execute(fixedThreadPool, getRunnableFuture())), is(0));
		assertThat(ConcurrentUtils.getOrNull(ConcurrentUtils.execute(fixedThreadPool, getRunnableFuture(10, TimeUnit.MILLISECONDS))), is(0));
		assertThat(ConcurrentUtils.getOrNull(ConcurrentUtils.execute(cachedThreadPool, getRunnableFuture())), is(0));
		assertThat(ConcurrentUtils.getOrNull(ConcurrentUtils.execute(cachedThreadPool, getRunnableFuture(10, TimeUnit.MILLISECONDS))), is(0));
		assertThat(ConcurrentUtils.getOrNull(ConcurrentUtils.execute(scheduledThreadPool, getRunnableFuture())), is(0));
		assertThat(ConcurrentUtils.getOrNull(ConcurrentUtils.execute(scheduledThreadPool, getRunnableFuture(10, TimeUnit.MILLISECONDS))), is(0));
		assertThat(ConcurrentUtils.getOrNull(ConcurrentUtils.execute(singleThreadExecutor, getRunnableFuture())), is(0));
		assertThat(ConcurrentUtils.getOrNull(ConcurrentUtils.execute(singleThreadExecutor, getRunnableFuture(10, TimeUnit.MILLISECONDS))), is(0));
		assertThat(ConcurrentUtils.getOrNull(ConcurrentUtils.execute(singleThreadScheduledExecutor, getRunnableFuture())), is(0));
		assertThat(ConcurrentUtils.getOrNull(ConcurrentUtils.execute(singleThreadScheduledExecutor, getRunnableFuture(10, TimeUnit.MILLISECONDS))), is(0));
		final Future<Integer> future = ConcurrentUtils.execute(cachedThreadPool, getRunnableFuture(10, TimeUnit.MILLISECONDS));
		assertThat(ConcurrentUtils.isDone(future), is(false));
		assertThat(ConcurrentUtils.getOrNull(future), is(0));
		assertThat(ConcurrentUtils.isDone(future), is(true));
	}

	@Test(timeout = 10000)
	public void testGetFutureOfV() {
		assertThat(ConcurrentUtils.get(ConcurrentUtils.execute(getRunnableFuture())), is(0));
		assertThat(ConcurrentUtils.get(ConcurrentUtils.execute(getRunnableFuture(10, TimeUnit.MILLISECONDS))), is(0));
		assertThat(ConcurrentUtils.get(ConcurrentUtils.execute(fixedThreadPool, getRunnableFuture())), is(0));
		assertThat(ConcurrentUtils.get(ConcurrentUtils.execute(fixedThreadPool, getRunnableFuture(10, TimeUnit.MILLISECONDS))), is(0));
		assertThat(ConcurrentUtils.get(ConcurrentUtils.execute(cachedThreadPool, getRunnableFuture())), is(0));
		assertThat(ConcurrentUtils.get(ConcurrentUtils.execute(cachedThreadPool, getRunnableFuture(10, TimeUnit.MILLISECONDS))), is(0));
		assertThat(ConcurrentUtils.get(ConcurrentUtils.execute(scheduledThreadPool, getRunnableFuture())), is(0));
		assertThat(ConcurrentUtils.get(ConcurrentUtils.execute(scheduledThreadPool, getRunnableFuture(10, TimeUnit.MILLISECONDS))), is(0));
		assertThat(ConcurrentUtils.get(ConcurrentUtils.execute(singleThreadExecutor, getRunnableFuture())), is(0));
		assertThat(ConcurrentUtils.get(ConcurrentUtils.execute(singleThreadExecutor, getRunnableFuture(10, TimeUnit.MILLISECONDS))), is(0));
		assertThat(ConcurrentUtils.get(ConcurrentUtils.execute(singleThreadScheduledExecutor, getRunnableFuture())), is(0));
		assertThat(ConcurrentUtils.get(ConcurrentUtils.execute(singleThreadScheduledExecutor, getRunnableFuture(10, TimeUnit.MILLISECONDS))), is(0));
		final Future<Integer> future = ConcurrentUtils.execute(cachedThreadPool, getRunnableFuture(10, TimeUnit.MILLISECONDS));
		assertThat(ConcurrentUtils.isDone(future), is(false));
		assertThat(ConcurrentUtils.get(future), is(0));
		assertThat(ConcurrentUtils.isDone(future), is(true));
	}

	@Test(timeout = 10000)
	public void testGetOrNullFutureOfVLongTimeUnit() {
		assertThat(ConcurrentUtils.getOrNull(ConcurrentUtils.execute(cachedThreadPool, getRunnableFuture(10, TimeUnit.MILLISECONDS)), 1000, TimeUnit.MILLISECONDS), is(0));
		assertThat(ConcurrentUtils.getOrNull(ConcurrentUtils.execute(cachedThreadPool, getRunnableFuture(1000, TimeUnit.MILLISECONDS)), 10, TimeUnit.MILLISECONDS), is(nullValue())); // タイムアウト
	}

	@Test(timeout = 10000, expected = RuntimeException.class)
	public void testGetFutureOfVLongTimeUnit() {
		assertThat(ConcurrentUtils.get(ConcurrentUtils.execute(cachedThreadPool, getRunnableFuture(10, TimeUnit.MILLISECONDS)), 1000, TimeUnit.MILLISECONDS), is(0));
		ConcurrentUtils.get(ConcurrentUtils.execute(cachedThreadPool, getRunnableFuture(1000, TimeUnit.MILLISECONDS)), 10, TimeUnit.MILLISECONDS); // タイムアウト
	}

	@Test(timeout = 10000)
	public void testCancel() {
		final Future<Integer> future = ConcurrentUtils.execute(cachedThreadPool, getRunnableFuture(1000, TimeUnit.MILLISECONDS));
		assertThat(ConcurrentUtils.isCancelled(future), is(false));
		assertThat(ConcurrentUtils.cancel(future, true), is(true));
		assertThat(ConcurrentUtils.isCancelled(future), is(true));
	}

	@Test(timeout = 10000)
	public void testSleepInterruptibly() {
		assertThat(ConcurrentUtils.sleepInterruptibly(1000, TimeUnit.MILLISECONDS), is(true));
		interrupt(500, TimeUnit.MILLISECONDS);
		assertThat(ConcurrentUtils.sleepInterruptibly(1000, TimeUnit.MILLISECONDS), is(false)); // 割り込まれた場合
	}

	@Test(timeout = 10000)
	public void testWaitObject() {
		final Object monitor = new Object();
		notifyAll(monitor, 500, TimeUnit.MILLISECONDS);
		assertThat(ConcurrentUtils.wait(monitor), is(true));
		interrupt(500, TimeUnit.MILLISECONDS);
		assertThat(ConcurrentUtils.wait(monitor), is(true)); // 割り込まれた場合
		assertThat(ConcurrentUtils.wait(null), is(false)); // nullの場合
	}

	@Test(timeout = 10000)
	public void testWaitObjectCallableOfV() {
		final Object monitor = new Object();
		final Callable<Integer> callable = getCallable();
		notifyAll(monitor, 500, TimeUnit.MILLISECONDS, callable);
		assertThat(ConcurrentUtils.wait(monitor, callable), is(1));
		interrupt(500, TimeUnit.MILLISECONDS);
		assertThat(ConcurrentUtils.wait(monitor, callable), is(2)); // 割り込まれた場合
		assertThat(ConcurrentUtils.wait(null, callable), is(nullValue())); // nullの場合
	}

	@Test(timeout = 10000)
	public void testWaitObjectLongTimeUnit() {
		final Object monitor = new Object();
		notifyAll(monitor, 500, TimeUnit.MILLISECONDS);
		assertThat(ConcurrentUtils.wait(monitor, 1000, TimeUnit.MILLISECONDS), is(true));
		interrupt(500, TimeUnit.MILLISECONDS);
		assertThat(ConcurrentUtils.wait(monitor, 1000, TimeUnit.MILLISECONDS), is(true)); // 割り込まれた場合
		notifyAll(monitor, 1500, TimeUnit.MILLISECONDS);
		assertThat(ConcurrentUtils.wait(monitor, 1000, TimeUnit.MILLISECONDS), is(true)); // タイムアウトした場合
		assertThat(ConcurrentUtils.wait(null, 0, TimeUnit.MILLISECONDS), is(false)); // nullの場合
	}

	@Test(timeout = 10000)
	public void testWaitObjectLongTimeUnitCallableOfV() {
		final Object monitor = new Object();
		final Callable<Integer> callable = getCallable();
		notifyAll(monitor, 500, TimeUnit.MILLISECONDS, callable);
		assertThat(ConcurrentUtils.wait(monitor, 1000, TimeUnit.MILLISECONDS, callable), is(1));
		interrupt(500, TimeUnit.MILLISECONDS);
		assertThat(ConcurrentUtils.wait(monitor, 1000, TimeUnit.MILLISECONDS, callable), is(2)); // 割り込まれた場合
		notifyAll(monitor, 1500, TimeUnit.MILLISECONDS, callable);
		assertThat(ConcurrentUtils.wait(monitor, 1000, TimeUnit.MILLISECONDS, callable), is(3)); // タイムアウトした場合
		assertThat(ConcurrentUtils.wait(null, 0, TimeUnit.MILLISECONDS, callable), is(nullValue())); // nullの場合
	}

	@Test(timeout = 10000)
	public void testNotifyObject() throws Exception {
		final Object monitor = new Object();
		final Future<Boolean> future = wait(monitor);
		assertThat(ConcurrentUtils.sleepInterruptibly(500, TimeUnit.MILLISECONDS), is(true)); // Thread#yieldだとうまくwaitに処理が移らないので
		assertThat(ConcurrentUtils.notify(monitor), is(true));
		assertThat(future.get(), is(true));
		assertThat(ConcurrentUtils.notify(null), is(false)); // nullの場合
	}

	@Test(timeout = 10000)
	public void testNotifyObjectCallableOfV() throws Exception {
		final Object monitor = new Object();
		final Callable<Integer> callable = getCallable();
		final Future<Integer> future = wait(monitor, callable);
		assertThat(ConcurrentUtils.sleepInterruptibly(500, TimeUnit.MILLISECONDS), is(true)); // Thread#yieldだとうまくwaitに処理が移らないので
		assertThat(ConcurrentUtils.notify(monitor, callable), is(0));
		assertThat(future.get(), is(1));
		assertThat(ConcurrentUtils.notify(null, callable), is(nullValue())); // nullの場合
	}

	@Test(timeout = 10000)
	@SuppressWarnings("unchecked")
	public void testNotifyAllObject() throws Exception {
		final Object monitor = new Object();
		final Future<Boolean>[] futures = new Future[] { wait(monitor), wait(monitor) };
		assertThat(ConcurrentUtils.sleepInterruptibly(500, TimeUnit.MILLISECONDS), is(true)); // Thread#yieldだとうまくwaitに処理が移らないので
		assertThat(ConcurrentUtils.notifyAll(monitor), is(true));
		assertThat(futures[0].get(), is(true));
		assertThat(futures[1].get(), is(true));
		assertThat(ConcurrentUtils.notifyAll(null), is(false)); // nullの場合
	}

	@Test(timeout = 10000)
	@SuppressWarnings("unchecked")
	public void testNotifyAllObjectCallableOfV() throws Exception {
		final Object monitor = new Object();
		final Callable<Integer> callable = getCallable();
		final Future<Integer>[] futures = new Future[] { wait(monitor, callable), wait(monitor, callable) };
		assertThat(ConcurrentUtils.sleepInterruptibly(500, TimeUnit.MILLISECONDS), is(true)); // Thread#yieldだとうまくwaitに処理が移らないので
		assertThat(ConcurrentUtils.notifyAll(monitor, callable), is(0));
		assertThat(futures[0].get(), anyOf(is(1), is(2))); // 1か2
		assertThat(futures[1].get(), anyOf(is(1), is(2))); // 1か2
		assertThat(futures[0].get().equals(futures[1].get()), is(false)); // ひとつは1で、もうひとつは2
		assertThat(ConcurrentUtils.notifyAll(null, callable), is(nullValue())); // nullの場合
	}

	private static RunnableFuture<Integer> getRunnableFuture() {
		return getRunnableFuture(0, TimeUnit.MILLISECONDS);
	}

	private static RunnableFuture<Integer> getRunnableFuture(final long timeout, final TimeUnit unit) {
		return getRunnableFuture(getCallable(timeout, unit));
	}

	private static <V> RunnableFuture<V> getRunnableFuture(final Callable<V> callable) {
		return new FutureTask<V>(callable);
	}

	private static Callable<Integer> getCallable() {
		return getCallable(0, TimeUnit.MILLISECONDS);
	}

	private static Callable<Integer> getCallable(final long timeout, final TimeUnit unit) {
		return new Callable<Integer>() {
			private int count;

			@Override
			public Integer call() throws Exception {
				ConcurrentUtils.sleepInterruptibly(timeout, unit);
				return count++;
			}
		};
	}

	private static Runnable getRunnable() {
		return getRunnable(0, TimeUnit.MILLISECONDS);
	}

	private static Runnable getRunnable(final long timeout, final TimeUnit unit) {
		return new Runnable() {
			@Override
			public void run() {
				ConcurrentUtils.sleepInterruptibly(timeout, unit);
			}
		};
	}

	private void interrupt(final long delay, final TimeUnit unit) {
		final Thread thread = Thread.currentThread();
		scheduledThreadPool.schedule(new Runnable() {
			@Override
			public void run() {
				thread.interrupt();
			}
		}, delay, unit);
	}

	private ScheduledFuture<Boolean> notifyAll(final Object monitor, final long delay, final TimeUnit unit) {
		return scheduledThreadPool.schedule(new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				return ConcurrentUtils.notifyAll(monitor);
			}
		}, delay, unit);
	}

	private <V> ScheduledFuture<V> notifyAll(final Object monitor, final long delay, final TimeUnit unit, final Callable<V> callable) {
		return scheduledThreadPool.schedule(new Callable<V>() {
			@Override
			public V call() throws Exception {
				return ConcurrentUtils.notifyAll(monitor, callable);
			}
		}, delay, unit);
	}

	private Future<Boolean> wait(final Object monitor) {
		return cachedThreadPool.submit(new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				return ConcurrentUtils.wait(monitor);
			}
		});
	}

	private <V> Future<V> wait(final Object monitor, final Callable<V> callable) {
		return cachedThreadPool.submit(new Callable<V>() {
			@Override
			public V call() throws Exception {
				return ConcurrentUtils.wait(monitor, callable);
			}
		});
	}
}
