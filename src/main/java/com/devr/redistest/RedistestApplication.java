package com.devr.redistest;

import com.devr.redistest.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class RedistestApplication {
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory(){
		return new JedisConnectionFactory();
		//if redis is hosted on different server provide hostanme and port number
		/*RedisStandaloneConfiguration rSConfig = new RedisStandaloneConfiguration("hostIp/Name", 1234);
		rSConfig.setUsername("");//if exists
		rSConfig.setPassword("");//if exists
		return new JedisConnectionFactory(rSConfig);*/
	}
	
	@Bean
	RedisTemplate<String, User>  redisTemplate(){
		RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(RedistestApplication.class, args);
	}

}
