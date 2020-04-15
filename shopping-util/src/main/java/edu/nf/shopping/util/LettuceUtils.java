package edu.nf.shopping.util;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.reactive.RedisReactiveCommands;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.time.Duration;

/**
 * @author Bull fighters
 * @date 2020/4/6
 */
public class LettuceUtils {

    private static StatefulRedisConnection connection;

    static {
        RedisURI redisURI = RedisURI.Builder
                .redis("www.88k88.cn")
                .withPort(6379)
                .withPassword("qq520340")
                .withDatabase(1)
                .withTimeout(Duration.ofSeconds(5))
                .build();
        connection = RedisClient.create(redisURI).connect();
    }

    /**
     * 同步
     * @return
     */
    public static RedisCommands getCommands() {
        return connection.sync();
    }

    /**
     * 异步
     * @return
     */
    public static RedisAsyncCommands getAsyncCommands(){
        return connection.async();
    }

    /**
     * Reactive
     * @return
     */
    public static RedisReactiveCommands getReactiveCommands(){
        return connection.reactive();
    }
}