package com.guhe.elasticjob;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author njl
 * @date 2023/3/15
 */
@Slf4j
@Service
public class MySimpleJob implements SimpleJob {
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Override
	public void execute(ShardingContext shardingContext) {
		log.info("shardingContext = {}", shardingContext);
		log.info("当前时间是：{}", dtf.format(LocalDateTime.now()));
	}
}
