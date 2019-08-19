package com.cmssystem.useradmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnection;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisConfig {

    @Autowired
    private RedisProperties redisProperties;


    @Bean
    public LettuceConnectionFactory redisConnectionFactory()
    {
        RedisStandaloneConfiguration clientConfig = new RedisStandaloneConfiguration(

                redisProperties.getHost(),
                redisProperties.getPort()
        );

        return new LettuceConnectionFactory(clientConfig);
    }

    @Bean
    public LettuceConnection lettuceConnection(LettuceConnectionFactory redisConnectionFactory)
    {
        return (LettuceConnection) redisConnectionFactory.getConnection();
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory)
    {
        RedisTemplate redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

}
