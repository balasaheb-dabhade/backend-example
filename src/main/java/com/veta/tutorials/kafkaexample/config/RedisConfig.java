package com.veta.tutorials.kafkaexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import com.veta.tutorials.kafkaexample.model.Rider;

@Configuration
public class RedisConfig {
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		return new LettuceConnectionFactory();
	}

	@Bean
	public HashOperations<String, String, Rider> hashOperation() {
		RedisTemplate<String, Rider> redisTemplate = new RedisTemplate<String, Rider>();
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		redisTemplate.afterPropertiesSet();	
		return redisTemplate.opsForHash();
	}
}

