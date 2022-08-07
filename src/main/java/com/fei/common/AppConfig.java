package com.fei.common;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class AppConfig {

    @Bean
    public LettuceClientConfigurationBuilderCustomizer lettuceClientConfigurationBuilderCustomizer() {
        return clientConfigurationBuilder -> {
            if (clientConfigurationBuilder.build().isUseSsl()) {
                clientConfigurationBuilder.useSsl().disablePeerVerification();
            }
        };
    }

    public static StatefulRedisConnection<String, String> connect() {
//        RedisURI redisURI = RedisURI.create(System.getenv("REDIS_URL"));
        RedisURI redisURI = RedisURI.create("redis://:p330b682b828e5234c8f003145a043b490c53485b82c18a8068c2a7512e1ae6d3@ec2-44-205-222-104.compute-1.amazonaws.com:10640");
        redisURI.setVerifyPeer(false);
        RedisClient redisClient = RedisClient.create(redisURI);
        return redisClient.connect();
    }
}
