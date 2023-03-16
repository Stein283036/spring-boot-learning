package com.guhe.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @author njl
 * @date 2023/3/16
 */
@EnableAsync
@Slf4j
@Component
public class AsyncTaskManager {
	private static final Random random = new Random();

	@Async("executorForTask1To3")
	public CompletableFuture<Long> task1() throws InterruptedException {
		log.info("任务一开始");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		log.info("任务一执行结束，耗时 {} ms", end - start);
		return CompletableFuture.completedFuture(end - start);
	}

	@Async("executorForTask1To3")
	public CompletableFuture<Long> task2() throws InterruptedException {
		log.info("任务二开始");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		log.info("任务二执行结束，耗时 {} ms", end - start);
		return CompletableFuture.completedFuture(end - start);
	}

	@Async("executorForTask1To3")
	public CompletableFuture<Long> task3() throws InterruptedException {
		log.info("任务三开始");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		log.info("任务三执行结束，耗时 {} ms", end - start);
		return CompletableFuture.completedFuture(end - start);
	}

	@Async("executorForTask4To5")
	public CompletableFuture<Long> task4() throws InterruptedException {
		log.info("任务四开始");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		log.info("任务四执行结束，耗时 {} ms", end - start);
		return CompletableFuture.completedFuture(end - start);
	}

	@Async("executorForTask4To5")
	public CompletableFuture<Long> task5() throws InterruptedException {
		log.info("任务五开始");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		log.info("任务五执行结束，耗时 {} ms", end - start);
		return CompletableFuture.completedFuture(end - start);
	}
}
