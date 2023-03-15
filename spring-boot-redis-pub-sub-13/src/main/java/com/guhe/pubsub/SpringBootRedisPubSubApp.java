package com.guhe.pubsub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author njl
 * @date 2023/3/15
 */
@SpringBootApplication
public class SpringBootRedisPubSubApp {
	private static final String CHANNEL = "my-channel";

	private static final List<String> messageCache = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisPubSubApp.class, args);
	}

	@RequestMapping("/pub")
	@RestController
	static class PubController {
		@Autowired
		private RedisTemplate<String, String> redisTemplate;

		@GetMapping
		public void pub(@RequestParam("message") String message) {
			redisTemplate.convertAndSend(CHANNEL, message);
		}
	}

	@Slf4j
	@RestController
	@RequestMapping("/sub")
	static class SubController {
		public SubController(RedisTemplate<String, String> redisTemplate) {
			RedisConnection redisConnection = Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection();
			redisConnection.subscribe(((message, pattern) -> {
				log.info("收到了订阅主题的信息 - {}", message);
				byte[] body = message.getBody();
				messageCache.add(new String(body));
			}), CHANNEL.getBytes(StandardCharsets.UTF_8));
		}

		@GetMapping
		public List<String> sub() {
			return messageCache;
		}
	}
}
