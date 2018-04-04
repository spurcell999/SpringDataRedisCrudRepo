package com.purcell.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@ComponentScan("com.purcell")
@EnableRedisRepositories
public class ApplicationConfig {

    @Bean
    public RedisConnectionFactory getConnectionFactory() {

        JedisConnectionFactory jRedisConnectionFactory = new JedisConnectionFactory(new JedisPoolConfig());
        jRedisConnectionFactory.setPort(6379);
        jRedisConnectionFactory.setHostName("10.157.138.26");
        return jRedisConnectionFactory;
    }


    @Bean
    public RedisTemplate<?, ?> redisTemplate() {

        RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
        template.setConnectionFactory(getConnectionFactory());
        return template;
    }

}
