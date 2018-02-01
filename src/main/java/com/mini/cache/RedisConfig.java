package com.mini.cache;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

/**
 * redis 配置
 * @author czk
 * @date 2018-02-01
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

	@Override
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... objects) {
				StringBuilder key = new StringBuilder();
				key.append(target.getClass().getName()).append(".");
				key.append(method.getName()).append(":");
				key.append(Arrays.toString(objects));
				String md5key = DigestUtils.md5Hex(key.toString()).substring(8, 24);
				return md5key;
			}
		};
	}

	@Bean(name = "redisTemplate")
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
		StringRedisTemplate template = new StringRedisTemplate(factory);
		// 定义key序列化方式
		// 定义value的序列化方式
		//JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
		GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
		template.setValueSerializer(genericJackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@Bean
	public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
		RedisCacheManager cacheManager = new ExtendedRedisCacheManager(redisTemplate);
		cacheManager.setDefaultExpiration(7200);
		cacheManager.setUsePrefix(true);
		return cacheManager;
	}
}
