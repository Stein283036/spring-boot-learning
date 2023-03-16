package com.guhe.async;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author njl
 * @date 2023/3/16
 */
@Slf4j
@SpringBootTest
class AsyncTaskManagerTest {
	@Autowired
	private AsyncTaskManager asyncTaskManager;

	@Test
	void testRejectionPolicy() throws InterruptedException {
		CompletableFuture<Long> task4 = asyncTaskManager.task4();
		CompletableFuture<Long> task5 = asyncTaskManager.task5();
		CompletableFuture<Long> task42 = asyncTaskManager.task4();
		CompletableFuture<Long> task52 = asyncTaskManager.task5();
		CompletableFuture<Long> task53 = asyncTaskManager.task5();
		CompletableFuture.allOf(task4, task5, task42, task52, task53);
	}

	@Test
	void testAsyncTasks() throws InterruptedException, ExecutionException {
		CompletableFuture<Long> task1 = asyncTaskManager.task1();
		CompletableFuture<Long> task2 = asyncTaskManager.task2();
		CompletableFuture<Long> task3 = asyncTaskManager.task3();
		CompletableFuture<Long> task4 = asyncTaskManager.task4();
		CompletableFuture<Long> task5 = asyncTaskManager.task5();
		CompletableFuture.allOf(task1, task2, task3).join();
		Long task1Duration = task1.get();
		Long task2Duration = task2.get();
		Long task3Duration = task3.get();
		Long task4Duration = task4.get();
		Long task5Duration = task5.get();
		log.info(
				"执行五个任务所花费的时间总共是 {} ms",
				task1Duration + task2Duration + task3Duration + task4Duration + task5Duration
		);
	}
}