package com.guhe.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author njl
 * @date 2023/3/16
 */
@Configuration
public class ExecutorManager { // 配置多个线程池，隔离异步的线程任务
	@Bean("executorForTask1To3")
	public Executor executorForTask1To3() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(1);
		executor.setMaxPoolSize(3);
		executor.setQueueCapacity(1);
		executor.setKeepAliveSeconds(60);
		executor.setThreadNamePrefix("executorForTask1To3-");
		// A handler for rejected tasks that discards the oldest unhandled request and then retries execute,
		// unless the executor is shut down, in which case the task is discarded.
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
		return executor;
	}

	@Bean("executorForTask4To5")
	public Executor executorForTask4To5() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(0);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(2);
		executor.setKeepAliveSeconds(60);
		executor.setThreadNamePrefix("executorForTask4To5-");

		// CallerRunsPolicy - A handler for rejected tasks that runs the rejected task directly in the
		// calling thread of the execute method, unless the executor has been shut down,
		// in which case the task is discarded.

		// RejectedExecutionHandler - A handler for rejected tasks that silently discards the rejected task.

		// 默认的拒绝策略就是 AbortPolicy
		// AbortPolicy - A handler for rejected tasks that throws a RejectedExecutionException.
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
		return executor;
	}
}
