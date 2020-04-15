package edu.nf.shopping.config;

import edu.nf.shopping.config.listener.KeyExpiredListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Achine
 * @date 2020/3/5
 */
@Configuration
@EnableCaching
public class RedisConfig {
    /**
     * 装配RedisCacheManager，并存入Map中,
     * 后续在使用时可以指定操作哪一个缓存。
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        Map<String, RedisCacheConfiguration> map = new HashMap<>(2);
        map.put("commentCache", initRedisCacheConfiguration(1800L));
        //map.put("chat_record_cache", initRedisCacheConfiguration(1800L));
        map.put("pageCache", initRedisCacheConfiguration(9000L));
        map.put("goodsCache", initRedisCacheConfiguration(1800L));
        map.put("skuInfoCache", initRedisCacheConfiguration(1800L));
        map.put("userInfoCache", initRedisCacheConfiguration(1800L));
        map.put("shopcartInfoCache", initRedisCacheConfiguration(1800L));
        map.put("messageCache", initRedisCacheConfiguration(1800L));
        map.put("warehouseCache", initRedisCacheConfiguration(1800L));
        RedisCacheManager cacheManager = RedisCacheManager.builder(redisConnectionFactory)
                .withInitialCacheConfigurations(map)
                .build();
        return cacheManager;
    }

    /**
     * Redis缓存配置，配置相关的key和value序列化器以及缓存过期时间
     * serializeKeysWith()方法用于设置key的序列化器
     * serializeValuesWith()方法用于设置value的序列化器
     * entryTtl()方法用于设置过期时间
     * @param ttl
     * @return
     */
    private RedisCacheConfiguration initRedisCacheConfiguration(Long ttl) {
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        return cacheConfiguration
                //设置key的序列化器
                .serializeKeysWith(
                        RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                //设置value的序列化器
                .serializeValuesWith(
                        RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()))
                //设置缓存过期时间
                .entryTtl(Duration.ofSeconds(ttl));
    }

    /**
     * 自定义RedisTemplate,指定key和value的序列化器
     * @param connectionFactory
     * @return
     */
    @Bean
    public static RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory){
        //创建RedisTemplate实例
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

        //使用StringRedisSerializer作为key的序列化器
        StringRedisSerializer keySerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(keySerializer);
        redisTemplate.setHashKeySerializer(keySerializer);

        //使用Jackson2JsonRedisSerializer作为value的序列化器
        GenericJackson2JsonRedisSerializer valueSerializer = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setValueSerializer(valueSerializer);
        redisTemplate.setHashValueSerializer(valueSerializer);

        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer() {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        return redisMessageListenerContainer;
    }

//    @Bean
//    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.addMessageListener(new KeyExpiredListener(container),
//                new PatternTopic("assignmentCache"));
//        return container;
//    }
}
