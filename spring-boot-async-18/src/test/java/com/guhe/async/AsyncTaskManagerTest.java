package com.guhe.async;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

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
	void testAsyncTasks() throws InterruptedException, ExecutionException {
		CompletableFuture<Long> task1 = asyncTaskManager.task1();
		CompletableFuture<Long> task2 = asyncTaskManager.task2();
		CompletableFuture<Long> task3 = asyncTaskManager.task3();
		CompletableFuture.allOf(task1, task2, task3).join();
		Long task1Duration = task1.get();
		Long task2Duration = task2.get();
		Long task3Duration = task3.get();
		log.info("执行三个任务所花费的时间总共是 {} ms", task1Duration + task2Duration + task3Duration);
	}
}