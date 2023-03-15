package com.guhe.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author njl
 * @date 2023/3/15
 */
@EnableScheduling // 开启 Spring 定时任务执行的能力
@SpringBootApplication
public class SpringBootScheduledApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootScheduledApp.class, args);
	}

	@Slf4j
	@Component
	static class MyScheduledTimeTask {

		private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

		// 标记一个要被定期执行的方法，cron 表达式类似 linux 上的定时任务，可以看看，生产应该通常是根据
		// cron 表达式配置定时任务的执行周期的
		@Scheduled(fixedRate = 5000L, initialDelay = 2000L)
		public void logCurrentTime() {
			log.info("当前时间是 {}", dtf.format(LocalDateTime.now()));
		}
	}
}
