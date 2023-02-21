package com.guhe.redis.config;

import com.guhe.redis.pojo.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;

/**
 * @author njl
 * @date 2023/2/7
 */
@Configuration
public class RedisConfig {
	@Bean
	public RedisTemplate<String, Book> redisTemplate1(RedisConnectionFactory factory) {
		RedisTemplate<String, Book> redisTemplate1 = new RedisTemplate<>();
		redisTemplate1.setConnectionFactory(factory);
		redisTemplate1.setKeySerializer(new StringRedisSerializer());
		redisTemplate1.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate1.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate1.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate1.afterPropertiesSet();
		return redisTemplate1;
	}

	@Bean
	public RedisTemplate<String, List<Book>> redisTemplate2(RedisConnectionFactory factory) {
		RedisTemplate<String, List<Book>> redisTemplate2 = new RedisTemplate<>();
		redisTemplate2.setConnectionFactory(factory);
		redisTemplate2.setKeySerializer(new StringRedisSerializer());
		redisTemplate2.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate2.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate2.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate2.afterPropertiesSet();
		return redisTemplate2;
	}
}
